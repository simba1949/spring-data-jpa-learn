package vip.openpark.java.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.cj.jdbc.Driver;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


/**
 * 注解 {@link EnableTransactionManagement} 开启事务管理
 *
 * @author anthony
 * @version 2023/3/29
 */
@Configuration
@EnableJpaRepositories(basePackages = "vip.openpark.java.repository") // 扫描包
@EnableTransactionManagement
public class SpringDataJpaConfig {
	/**
	 * 数据源配置
	 *
	 * @return 数据源
	 */
	@Bean
	public DataSource dataSource() {
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setDriverClassName(Driver.class.getName());
		druidDataSource.setUrl("jdbc:mysql://172.17.35.120/example?characterEncoding=UTF-8&serverTimezone=Asia/Shanghai");
		druidDataSource.setUsername("root");
		druidDataSource.setPassword("123456");
		
		return druidDataSource;
	}
	
	/**
	 * 实体管理工厂
	 *
	 * @return 实体管理工厂
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		vendorAdapter.setShowSql(true);
		
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("vip.openpark.java.domain");
		factory.setDataSource(this.dataSource());
		return factory;
	}
	
	/**
	 * 事务管理器
	 *
	 * @return 事务管理器
	 */
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory);
		return txManager;
	}
}