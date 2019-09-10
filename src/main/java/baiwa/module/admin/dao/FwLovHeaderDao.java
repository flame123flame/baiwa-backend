package baiwa.module.admin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import baiwa.module.admin.model.FwLovHeader;
import baiwa.module.admin.vo.request.FwLovHReq;

@Repository
public class FwLovHeaderDao {
	
	@Autowired
	private  JdbcTemplate jdbcTemplate;
	
	
	public List<FwLovHeader> list(FwLovHReq form) {
		List<FwLovHeader> target = new ArrayList<FwLovHeader>();
		StringBuilder sqlBuilder = new StringBuilder();
		List<Object> params = new ArrayList<>();
		sqlBuilder.append(" SELECT * FROM fw_lov_header WHERE is_delete = 'N' ");

		if (StringUtils.isNotBlank(form.getLovKey())) {
		sqlBuilder.append(" AND lov_key LIKE ? ");
		params.add("%" +  form.getLovKey().replaceAll(" ", "%") + "%");
		}
		sqlBuilder.append(" ORDER BY lov_header_id DESC ");
		target = jdbcTemplate.query(sqlBuilder.toString(), params.toArray(), listRowmapper);
		return target;
	}
	
	private RowMapper<FwLovHeader> listRowmapper = new RowMapper<FwLovHeader>() {
		@Override
		public FwLovHeader mapRow(ResultSet rs, int arg1) throws SQLException {
			FwLovHeader vo = new FwLovHeader();
			vo.setLovHeaderId(rs.getLong("lov_header_id"));
			vo.setLovKey(rs.getString("lov_key"));
			vo.setDescripton(rs.getString("descripton"));
			return vo;
		}
	};

}
