package com.stepsoft.better.data;

import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import static org.hibernate.cfg.AvailableSettings.DIALECT;
import static org.hibernate.cfg.AvailableSettings.FORMAT_SQL;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;
import static org.hibernate.cfg.AvailableSettings.USE_NEW_ID_GENERATOR_MAPPINGS;

/**
 * @author Eugene Stepanenkov
 */
@Configuration
@PropertySource("classpath:data.properties")
@EnableTransactionManagement
public class DataContext {

    @Value("${db.connection.driverClassName}")
    private String driverClassName;

    @Value("${db.connection.url}")
    private String url;

    @Value("${db.hibernate.dialect}")
    private String dialect;

    @Value("${db.hibernate.showSql}")
    private String showSql;

    @Value("${db.hibernate.formatSql}")
    private String formatSql;

    @Value("${db.hibernate.useNewIdGeneratorMappings}")
    private String useNewIdGenerator;


    @Value("${db.connection.username}")
    private String username;

    @Value("${db.connection.password}")
    private String password;

    @Bean
    public Properties hibernateProperties() {

        Properties properties = new Properties();
        properties.setProperty(DIALECT, dialect);
        properties.setProperty(SHOW_SQL, showSql);
        properties.setProperty(FORMAT_SQL, formatSql);
        properties.setProperty(USE_NEW_ID_GENERATOR_MAPPINGS, useNewIdGenerator);

        return properties;
    }

    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        JpaVendorAdapter hibernateAdapter = new HibernateJpaVendorAdapter();

        factory.setDataSource(dataSource());
        factory.setPackagesToScan("com.stepsoft.better.model");
        factory.setJpaProperties(hibernateProperties());
        factory.setJpaVendorAdapter(hibernateAdapter);

        return factory;
    }

    @Bean
    @Autowired
    public JpaTransactionManager transactionManager(EntityManagerFactory factory) {

        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(factory);

        return transactionManager;
    }
}
