package com.example.demo;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {
                            "com.example.demo.FESCO.BOOKING_ENTRY.repository",
                            // "com.example.demo.realgrid.repository"
        },
        entityManagerFactoryRef = "fescoEntityManagerFactory",
        transactionManagerRef = "fescoTransactionManager"
)
@EntityScan(
    basePackages = {
                        "com.example.demo.FESCO.BOOKING_ENTRY.entity",
                        // "com.example.demo.realgrid.entity"
    }
)
public class FescoDatabaseConfig {

    @Bean(name = "fescoDataSource", destroyMethod = "close")
    @ConfigurationProperties(prefix = "spring.fesco.datasource")
    public DataSource fescoDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "fescoEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean fescoEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("fescoDataSource") DataSource fescoDataSource) {
        return builder
                .dataSource(fescoDataSource)
                .packages("com.example.demo.FESCO.BOOKING_ENTRY.entity")
                .persistenceUnit("fesco")
                .build();
    }

    @Bean(name = "fescoTransactionManager")
    @Primary
    public JpaTransactionManager fescoTransactionManager(
            @Qualifier("fescoEntityManagerFactory") EntityManagerFactory fescoEntityManagerFactory) {
        return new JpaTransactionManager(fescoEntityManagerFactory);
    }
}

