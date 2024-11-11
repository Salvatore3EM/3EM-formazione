//package laboratorio.config.databaseConfiguration;
//
//import jakarta.persistence.EntityManagerFactory;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        basePackages = "laboratorio.repository", // Pacchetto dei repository per laboratorio
//        entityManagerFactoryRef = "laboratorioEntityManagerFactory",
//        transactionManagerRef = "laboratorioTransactionManager"
//)
//public class LaboratorioDbConfig {
//
//    @Primary
//    @Bean(name = "laboratorioDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource laboratorioDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Primary
//    @Bean(name = "laboratorioEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean laboratorioEntityManagerFactory(
//            @Qualifier("laboratorioDataSource") DataSource dataSource) {
//
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSource);
//        em.setPackagesToScan("laboratorio.model"); // Pacchetto delle entità per laboratorio
//        em.setPersistenceUnitName("laboratorio");
//
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//
//        // Imposta esplicitamente le proprietà JPA
//        em.getJpaPropertyMap().put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
//
//        return em;
//    }
//
//    @Primary
//    @Bean(name = "laboratorioTransactionManager")
//    public PlatformTransactionManager laboratorioTransactionManager(
//            @Qualifier("laboratorioEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
//        return new JpaTransactionManager(entityManagerFactory);
//    }
//}