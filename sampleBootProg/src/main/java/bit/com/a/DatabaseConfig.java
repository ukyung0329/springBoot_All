package bit.com.a;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class DatabaseConfig {

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource ds)throws Exception {
		System.out.println("DatabaseConfig sqlSessionFactory()");
		
		SqlSessionFactoryBean sqlSFB = new SqlSessionFactoryBean();
		sqlSFB.setDataSource(ds);
		
		Resource[] arrRes = new PathMatchingResourcePatternResolver().getResources("classpath:sqls/*.xml");
		sqlSFB.setMapperLocations(arrRes);
		sqlSFB.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
		
		return (SqlSessionFactory)sqlSFB.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSF) {
		return new SqlSessionTemplate(sqlSF);
	}
}
