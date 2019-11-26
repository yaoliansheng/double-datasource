package com.example.doubledatasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
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
@MapperScan(basePackages = "com.example.doubledatasource.mapper.two", sqlSessionTemplateRef = "twoSqlSessionTemplate")
public class DbTwoConfig {

  @Bean(name = "twoDataSource")
  @Primary
  @ConfigurationProperties(prefix = "spring.datasource.druid.two")
  public DataSource druidDataSource() {
    return new DruidDataSource();
  }

  @Bean(name = "twoSqlSessionFactory")
  @Primary
  public SqlSessionFactory sqlSessionFactory(@Qualifier("twoDataSource") DataSource dataSource) throws Exception {
    SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    bean.setDataSource(dataSource);
    bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/two/*.xml"));
    return bean.getObject();
  }

  @Bean(name = "twoSqlSessionTemplate")
  @Primary
  public SqlSessionTemplate sqlSessionTemplate(@Qualifier("twoSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
    return new SqlSessionTemplate(sqlSessionFactory);
  }

  @Bean(name = "twoTransactionManager")
  @Primary
  public DataSourceTransactionManager transactionManager(@Qualifier("twoDataSource") DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

}
