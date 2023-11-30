package com.example.demo;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import java.util.Properties;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan(basePackages = { "com.example.demo.video.mapper"
                           , "com.example.demo.login.mapper"
                           , "com.example.demo.mypage.mapper"
                           , "com.example.demo.like.mapper" 
                           , "com.example.demo.comment.mapper" 
                           , "com.example.demo.community.mapper"
                           , "com.example.demo.realgrid.mapper"
                           }
                           , sqlSessionFactoryRef = "defaultSqlSessionFactory")
@EnableJpaRepositories(
    basePackages = { "com.example.demo.realgrid.repository" },
    entityManagerFactoryRef = "defaultEntityManagerFactory",
    transactionManagerRef = "defaultTransactionManager"
)
@EntityScan(basePackages = "com.example.demo.realgrid.entity")     // 엔터티 클래스
@EnableTransactionManagement
public class DefaultDatabaseConfig {

    @Bean(name = "defaultDataSource", destroyMethod = "close")
    @ConfigurationProperties(prefix = "spring.datasource")
    @Primary
    public DataSource defaultDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "defaultSqlSessionFactory")
    @Primary
    public SqlSessionFactory defaultSqlSessionFactory(
        @Qualifier("defaultDataSource") DataSource defaultDataSource,
        ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(defaultDataSource);
        sqlSessionFactoryBean.setMapperLocations(
        applicationContext.getResources("classpath*:mappers/**/*Mapper.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    // @Bean(name = "defaultSqlSessionTemplate")
    // @Primary
    // public SqlSessionTemplate defaultSqlSessionTemplate(SqlSessionFactory defaultSqlSessionFactory) {
    //     return new SqlSessionTemplate(defaultSqlSessionFactory);
    // }

    @Bean(name = "defaultEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean defaultEntityManagerFactory(
        @Qualifier("defaultDataSource") DataSource defaultDataSource) {

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(defaultDataSource);
        em.setPackagesToScan("com.example.demo.realgrid.entity");

         // Hibernate JPA Vendor Adapter 추가
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        // JPA 속성 추가
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        jpaProperties.put("hibernate.show_sql", "true"); // 쿼리 출력 여부
        jpaProperties.put("hibernate.format_sql", "true"); // 포맷팅된 쿼리 출력 여부

        em.setJpaProperties(jpaProperties);

    return em;
    }

    @Bean(name = "defaultTransactionManager")
    @Primary
    public JpaTransactionManager defaultTransactionManager(
            @Qualifier("defaultEntityManagerFactory") EntityManagerFactory defaultEntityManagerFactory) {
        return new JpaTransactionManager(defaultEntityManagerFactory);
    }
}
