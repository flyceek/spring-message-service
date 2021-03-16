package org.paranora.sms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoReactiveDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoReactiveRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.groovy.template.GroovyTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.jersey.JerseyAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication(
        exclude = {HibernateJpaAutoConfiguration.class
                , JerseyAutoConfiguration.class
                , GroovyTemplateAutoConfiguration.class
                , DataSourceAutoConfiguration.class
                , DataSourceTransactionManagerAutoConfiguration.class
                , RedisAutoConfiguration.class
                , RedisRepositoriesAutoConfiguration.class
                , JpaRepositoriesAutoConfiguration.class
//                , DispatcherServletAutoConfiguration.class
                , JdbcTemplateAutoConfiguration.class
                , JmxAutoConfiguration.class
                , ThymeleafAutoConfiguration.class
                , JmsAutoConfiguration.class
                , ErrorMvcAutoConfiguration.class
                , ElasticsearchDataAutoConfiguration.class
                , ElasticsearchRepositoriesAutoConfiguration.class
                , MongoDataAutoConfiguration.class
                , MongoReactiveDataAutoConfiguration.class
                , MongoReactiveRepositoriesAutoConfiguration.class
                , MongoRepositoriesAutoConfiguration.class
        })
public class Application {

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
