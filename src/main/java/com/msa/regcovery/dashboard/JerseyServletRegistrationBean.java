package com.msa.regcovery.dashboard;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Jersey servlet registration bean.
 */
@Configuration
public class JerseyServletRegistrationBean {

    /**
     * Jersey servlet servlet registration bean.
     *
     * @return the servlet registration bean
     */
    @Bean
    @ConditionalOnClass(ServletRegistrationBean.class)
    public ServletRegistrationBean jerseyServlet() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/api/v1/*");
        registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyAutoConfiguration.class.getName());
        return registration;
    }

    /**
     * Object mapper object mapper.
     *
     * @return the object mapper
     */
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }
}
