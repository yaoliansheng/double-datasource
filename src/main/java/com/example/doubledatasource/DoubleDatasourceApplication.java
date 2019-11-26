package com.example.doubledatasource;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import java.util.Properties;

@EnableTransactionManagement
@SpringBootApplication
public class DoubleDatasourceApplication {
    @Autowired
    SqlSessionFactory sqlSessionFactory;

    public static void main(String[] args) {
        SpringApplication.run(DoubleDatasourceApplication.class, args);
    }

    @PostConstruct
    private void init() {
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.put("dialect", "mysql");
        properties.put("reasonable", "true");
        properties.put("pageSizeZero", "true");
        pageHelper.setProperties(properties);
        sqlSessionFactory.getConfiguration().addInterceptor(pageHelper);
    }
}
