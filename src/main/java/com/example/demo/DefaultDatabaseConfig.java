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
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = { 
                             "com.example.demo.video.mapper"
                           , "com.example.demo.login.mapper"
                           , "com.example.demo.mypage.mapper"
                           , "com.example.demo.like.mapper" 
                           , "com.example.demo.comment.mapper" 
                           , "com.example.demo.community.mapper"
                           , "com.example.demo.chat.mapper"
}
                           , sqlSessionFactoryRef = "defaultSqlSessionFactory")
@EnableJpaRepositories(
        basePackages = "com.example.demo.realgrid.repository",
        entityManagerFactoryRef = "defaultEntityManagerFactory",
        transactionManagerRef = "defaultTransactionManagerJpa"
)
@EntityScan(
    basePackages =  "com.example.demo.realgrid.entity"
)
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
        new PathMatchingResourcePatternResolver().getResources("classpath*:mappers/**/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "defaultTransactionManager")
    @Primary
    public PlatformTransactionManager defaultTransactionManager(
            @Qualifier("defaultDataSource") DataSource defaultDataSource) {
        return new DataSourceTransactionManager(defaultDataSource);
    }

    
    // JPA 설정
    @Bean(name = "defaultEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean defaultEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("defaultDataSource") DataSource defaultDataSource) {
        return builder
                .dataSource(defaultDataSource)
                .packages("com.example.demo.realgrid.entity")
                .persistenceUnit("default")
                .build();
    }

    @Bean(name = "defaultTransactionManagerJpa")
    public JpaTransactionManager defaultTransactionManagerJpa(
            @Qualifier("defaultEntityManagerFactory") EntityManagerFactory defaultEntityManagerFactory) {
        return new JpaTransactionManager(defaultEntityManagerFactory);
    }

}
