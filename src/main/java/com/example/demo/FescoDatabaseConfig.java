package com.example.demo;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
// @MapperScan(basePackages = {
//                              "com.example.demo.FESCO.BOOKING_ENTRY.mapper"
//                            , "com.example.demo.FESCO.LOGIN.mapper"
//                            }
//                            , annotationClass = FescoConnMapper.class
//                            , sqlSessionFactoryRef = "fescoSqlSessionFactory")
@EntityScan(basePackages = {
    // "com.example.demo.realgrid.entity",
    "com.example.demo.FESCO.BOOKING_ENTRY.entity"

})
// @ComponentScan(basePackages = "com.example.demo.FESCO.BOOKING_ENTRY.repository")
@EnableJpaRepositories(basePackages = "com.example.demo.FESCO.BOOKING_ENTRY.repository")

// @EnableTransactionManagement
public class FescoDatabaseConfig {

    @Bean(name = "fescoDataSource", destroyMethod = "close")
    @ConfigurationProperties(prefix = "spring.fesco.datasource")
    public DataSource fescoDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "fescoSqlSessionFactory")
    public SqlSessionFactory fescoSqlSessionFactory(
        @Qualifier("fescoDataSource") DataSource fescoDataSource, ApplicationContext applicationContext)
        throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(fescoDataSource);
        sqlSessionFactoryBean.setMapperLocations(
        applicationContext.getResources("classpath*:f_mappers/FESCO/*Mapper.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "fescoSqlSessionTemplate")
    public SqlSessionTemplate fescoSqlSessionTemplate(SqlSessionFactory fescoSqlSessionFactory) {
        return new SqlSessionTemplate(fescoSqlSessionFactory);
    }
}
