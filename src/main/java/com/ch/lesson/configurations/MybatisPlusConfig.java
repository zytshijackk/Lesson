/**
 * @Description TODO
 * @Author zytshijack
 * @Date 2019-04-22 22:12
 * @Version 1.0
 */
package com.ch.lesson.configurations;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Description TODO
 * @Author zytshijack
 * @Date 2019-04-22 22:12
 * @Version 1.0
 */
@Configuration
@MapperScan("com.ch.lesson.dao")
public class MybatisPlusConfig {
    /*
     * 分页插件，自动识别数据库类型
     * 多租户，请参考官网【插件扩展】
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
    /**
     * 打印 sql
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        //格式化sql语句
        Properties properties = new Properties();
        properties.setProperty("format", "true");
        performanceInterceptor.setProperties(properties);
        return performanceInterceptor;
    }
   /*
    * oracle数据库配置JdbcTypeForNull
    * 参考：https://gitee.com/baomidou/mybatisplus-boot-starter/issues/IHS8X
    不需要这样配置了，参考 yml:
    mybatis-plus:
      confuguration
        dbc-type-for-null: 'null'
   @Bean
   public ConfigurationCustomizer configurationCustomizer(){
       return new MybatisPlusCustomizers();
   }

   class MybatisPlusCustomizers implements ConfigurationCustomizer {

       @Override
       public void customize(org.apache.ibatis.session.Configuration configuration) {
           configuration.setJdbcTypeForNull(JdbcType.NULL);
       }
   }
   */
}