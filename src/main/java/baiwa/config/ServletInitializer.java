package baiwa.config; 
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import baiwa.BaiwaApplication; 
public class ServletInitializer extends SpringBootServletInitializer { 
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BaiwaApplication.class);
    } 
}