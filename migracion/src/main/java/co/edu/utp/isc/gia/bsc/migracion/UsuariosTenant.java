package co.edu.utp.isc.gia.bsc.migracion;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "solarEntityManagerFactory",
    transactionManagerRef = "solarTransactionManager", basePackages = {"co.edu.utp.isc.gia.bsc.migracion.repository.usuariosTenant"})
public class UsuariosTenant {

  @Bean(name = "solarDataSource")
  @ConfigurationProperties(prefix = "solar.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean(name = "solarEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean SolarEntityManagerFactory(
      EntityManagerFactoryBuilder builder, @Qualifier("solarDataSource") DataSource dataSource) {
    return builder.dataSource(dataSource).packages("co.edu.utp.isc.gia.bsc.migracion.entity.usuariosTenant").persistenceUnit("solar")
        .build();
  }

  @Bean(name = "solarTransactionManager")
  public PlatformTransactionManager SolarTransactionManager(
      @Qualifier("solarEntityManagerFactory") EntityManagerFactory SolarEntityManagerFactory) {
    return new JpaTransactionManager(SolarEntityManagerFactory);
  }

}
