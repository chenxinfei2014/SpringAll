package com.springboot.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = Mysql2DatasourceConfig.PACKAGE, sqlSessionFactoryRef = "mysql2SqlSessionFactory")
public class Mysql2DatasourceConfig {

	// mysqldao扫描路径
	static final String PACKAGE = "com.springboot.mysql2dao";
	// mybatis mapper扫描路径
	static final String MAPPER_LOCATION = "classpath:mapper/mysql2/*.xml";

	@Bean(name = "mysql2DataSource")
	@ConfigurationProperties("spring.datasource.druid.mysql2")
	public DataSource mysql2DataSource() {
		return DruidDataSourceBuilder.create().build();
	}

	@Bean(name = "mysql2TransactionManager")
	public DataSourceTransactionManager mysql2TransactionManager() {
		return new DataSourceTransactionManager(mysql2DataSource());
	}

	@Bean(name = "mysql2SqlSessionFactory")
	public SqlSessionFactory mysql2SqlSessionFactory(@Qualifier("mysql2DataSource") DataSource dataSource)
			throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		//如果不使用xml的方式配置mapper，则可以省去下面这行mapper location的配置。
		sessionFactory.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources(Mysql2DatasourceConfig.MAPPER_LOCATION));
		return sessionFactory.getObject();
	}
}
