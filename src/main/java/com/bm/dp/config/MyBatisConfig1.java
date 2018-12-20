package com.bm.dp.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.support.http.StatViewServlet;
import org.apache.ibatis.session.LocalCacheScope;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiao liang
 * @version V1.0
 * @Package com.bm.dp.config
 * @Title: MyBatisConfig1
 * @Description: TODO
 * @date 2018/9/25 9:28
 */
@Configuration
@MapperScan(basePackages = { "com.bm.dp.dao" }, sqlSessionFactoryRef = "sqlSessionFactory1")
public class MyBatisConfig1 {


    @Value("${spring.druid.url}")
    String dbUrl;
    @Value("${spring.druid.username}")
    String userName;
    @Value("${spring.druid.password}")
    String password;
    @Value("${spring.druid.driverClassName}")
    String driverClassName;
    @Value("${spring.druid.maxWait}")
    String maxWait;
    @Value("${spring.druid.initialSize}")
    String initialSize;
    @Value("${spring.druid.minIdle}")
    String minIdle;
    @Value("${spring.druid.maxIdle}")
    String maxIdle;
    @Value("${spring.druid.testOnBorrow}")
    String testOnBorrow;
    @Value("${spring.druid.validationQuery}")
    String validationQuery;
    @Value("${spring.druid.testWhileIdle}")
    String testWhileIdle;
    @Value("${spring.druid.timeBetweenEvictionRunsMillis}")
    String timeBetweenEvictionRunsMillis;
    @Value("${spring.druid.minEvictableIdleTimeMillis}")
    String minEvictableIdleTimeMillis;
    @Value("${spring.druid.numTestsPerEvictionRun}")
    String numTestsPerEvictionRun;
    @Value("${spring.druid.removeAbandoned}")
    String removeAbandoned;
    @Value("${spring.druid.removeAbandonedTimeout}")
    String removeAbandonedTimeout;
    @Value("${spring.druid.poolPreparedStatements}")
    String poolPreparedStatements;
    @Value("${spring.druid.maxPoolPreparedStatementPerConnectionSize}")
    String maxPoolPreparedStatementPerConnectionSize;
    @Value("${spring.druid.filters}")
    String filters;
    @Value("${spring.druid.connectionProperties}")
    String connectionProperties;



    /**
     * MAPPER_LOCATION
     */
    static final String MAPPER_LOCATION = "classpath:com/bm/dp/dao/*.xml";

    /**
     * Title: sqlSessionFactory1
     * Description: 配置sqlSessionFactory
     * @return
     * @throws Exception
     * SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory1() throws Exception {

        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();

        DataSource build = DataSourceBuilder.create().build();

        factoryBean.setDataSource(dataSource1());
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setLocalCacheScope(LocalCacheScope.SESSION);
        configuration.setMapUnderscoreToCamelCase(true);
        factoryBean.setConfiguration(configuration);
        factoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources(MyBatisConfig1.MAPPER_LOCATION));
        factoryBean.setConfiguration(configuration);
        return factoryBean.getObject();
    }

    /**
     * Title: sqlSessionTemplate1
     * Description: 配置SqlSessionTemplate
     * @return
     * @throws Exception
     * SqlSessionTemplate
     */
    @Bean
    public SqlSessionTemplate sqlSessionTemplate1() throws Exception {
        // 使用上面配置的Factory
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory1());
        return template;
    }

    @Bean(name = "db1")
    @ConfigurationProperties(prefix = "spring.druid")
    @Primary
    public DataSource dataSource1() {
        Map<String,Object> properties=new HashMap<>(20);
        //DRUID配置
        properties.put(DruidDataSourceFactory.PROP_DRIVERCLASSNAME,driverClassName);
        properties.put(DruidDataSourceFactory.PROP_URL,dbUrl);
        properties.put(DruidDataSourceFactory.PROP_USERNAME,userName);
        properties.put(DruidDataSourceFactory.PROP_PASSWORD,password);
        properties.put(DruidDataSourceFactory.PROP_FILTERS,filters);
        properties.put(DruidDataSourceFactory.PROP_MAXWAIT, maxWait);
        properties.put(DruidDataSourceFactory.PROP_INITIALSIZE, initialSize);
        properties.put(DruidDataSourceFactory.PROP_MINIDLE, minIdle);
        properties.put(DruidDataSourceFactory.PROP_MAXWAIT, maxWait);
        properties.put(DruidDataSourceFactory.PROP_MAXIDLE, maxIdle);
        properties.put(DruidDataSourceFactory.PROP_TESTONBORROW, testOnBorrow);
        properties.put(DruidDataSourceFactory.PROP_VALIDATIONQUERY, validationQuery);
        properties.put(DruidDataSourceFactory.PROP_TESTWHILEIDLE, testWhileIdle);
        properties.put(DruidDataSourceFactory.PROP_TIMEBETWEENEVICTIONRUNSMILLIS, timeBetweenEvictionRunsMillis);
        properties.put(DruidDataSourceFactory.PROP_MINEVICTABLEIDLETIMEMILLIS, minEvictableIdleTimeMillis);
        properties.put(DruidDataSourceFactory.PROP_NUMTESTSPEREVICTIONRUN, numTestsPerEvictionRun);
        properties.put(DruidDataSourceFactory.PROP_REMOVEABANDONED, removeAbandoned);
        properties.put(DruidDataSourceFactory.PROP_POOLPREPAREDSTATEMENTS, poolPreparedStatements);
        properties.put(DruidDataSourceFactory.PROP_MAXOPENPREPAREDSTATEMENTS, maxPoolPreparedStatementPerConnectionSize);
        properties.put(DruidDataSourceFactory.PROP_CONNECTIONPROPERTIES, connectionProperties);
        try {
            DataSource dataSource1 = DruidDataSourceFactory.createDataSource(properties);
            return dataSource1;
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("数据源配置错误");
        }

    }

    @Bean
    public Filter statFilter(){
        StatFilter statFilter = new StatFilter();
        statFilter.setSlowSqlMillis(5000);
        statFilter.setLogSlowSql(true);
        statFilter.setMergeSql(true);
        return statFilter;
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, String> properties = new HashMap<>(10);
        properties.put("loginUsername","admin");
        properties.put("loginPassword","admin");
        properties.put("resetEnable","true");
        servletRegistrationBean.setInitParameters(properties);
        return servletRegistrationBean;
    }


}