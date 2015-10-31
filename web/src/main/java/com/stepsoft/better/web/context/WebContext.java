package com.stepsoft.better.web.context;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stepsoft.better.core.context.CoreContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Eugene Stepanenkov
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
        "com.stepsoft.better.web.service",
        "com.stepsoft.better.web.controller"
})
@Import(CoreContext.class)
public class WebContext extends WebMvcConfigurerAdapter {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void extendMessageConverters(final List<HttpMessageConverter<?>> converters) {

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper);
        converters.add(converter);
    }
}
