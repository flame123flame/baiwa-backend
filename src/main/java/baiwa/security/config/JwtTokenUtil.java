package baiwa.security.config;

import static baiwa.security.config.Constants.ACCESS_TOKEN_VALIDITY_SECONDS;
import static baiwa.security.config.Constants.AUTHORITIES_KEY;
import static baiwa.security.config.Constants.OGANIZATION_KEY;
import static baiwa.security.config.Constants.SIGNING_KEY;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import baiwa.security.model.AuthToken;
import baiwa.security.model.UserInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {

	private static final long serialVersionUID = -2550185165626007488L;

	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
	
	
	@Autowired
	private JdbcTemplate  jdbcTemplate;
	
	

	@Value("${jwt.secret}")
	private String secret;

	//retrieve username from jwt token
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	//retrieve expiration date from jwt token
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}
    //for retrieveing any information from token we will need the secret key
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	//check if the token has expired
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	//generate token for user
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, userDetails.getUsername());
	}
	
	
    public AuthToken generateToken2(Authentication authentication) {
        final String authorities = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority) .collect(Collectors.joining(","));
        AuthToken returnToken = new AuthToken();
        System.out.println(" In  TokenProvider.generateToken2  authorities:"+authorities);
        String tokenStr= Jwts.builder()
                .setSubject(authentication.getName())
                .claim(AUTHORITIES_KEY, authorities)
                .claim(OGANIZATION_KEY, "Chaingmai")
                .signWith(SignatureAlgorithm.HS256, SIGNING_KEY)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_VALIDITY_SECONDS*1000))
                .compact();
        returnToken.setToken(tokenStr);
        
        returnToken.setUsername(authentication.getName());
        returnToken.setAuthorities(authorities);
        //test
        
        
        UserInfo userInfo = getUserInfo(authentication.getName());
        
        
        returnToken.setOrganizeCode(userInfo.getOrganizeCode());
        returnToken.setOrganizeDesc(userInfo.getOrganizeDesc());
        returnToken.setFullName(userInfo.getFullName());
        
        return returnToken;
    }
	
    
    
    public UserInfo getUserInfo(String username){
    	String sql = "SELECT u.airport_code airport_code, u.airport_des airport_des ,u.name name, u.surname surname from fw_users u   WHERE "+
    			     "  u.user_name = '"+username+"' ";
    	System.out.println("   SQL get Organize:"+sql);
    	UserInfo userInfo = (UserInfo)jdbcTemplate.queryForObject(sql,
    		new RowMapper<UserInfo>() {
	            public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
	                UserInfo user = new UserInfo();
	                user.setOrganizeCode(rs.getString("airport_code"));
	                user.setOrganizeDesc(rs.getString("airport_des"));
	                user.setFullName(rs.getString("name")+" "+rs.getString("surname"));
	                return user;
	            }
        });
    	return userInfo;
    }
	

	//while creating the token -
	//1. Define  claims of the token, like Issuer, Expiration, Subject, and the ID
	//2. Sign the JWT using the HS512 algorithm and secret key.
	//3. According to JWS Compact Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
	//   compaction of the JWT to a URL-safe string 
	private String doGenerateToken(Map<String, Object> claims, String subject) {

		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	//validate token
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
}