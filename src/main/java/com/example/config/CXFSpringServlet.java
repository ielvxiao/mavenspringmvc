package com.example.config;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.support.XmlWebApplicationContext;

import javax.servlet.ServletConfig;
import javax.xml.ws.Endpoint;
import java.lang.reflect.Field;
import java.util.Collection;

/**
 * Created by lvxiao on 2018/8/26.
 */
public class CXFSpringServlet extends CXFServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void loadBus(ServletConfig servletConfig) {
        super.loadBus(servletConfig);

        XmlWebApplicationContext ctx = getContext();
        AutowireCapableBeanFactory beanFactory = ctx.getParent().getAutowireCapableBeanFactory();

        Collection<Endpoint> endpoints = ctx.getBeansOfType(Endpoint.class).values();
        for (Endpoint endpoint: endpoints
             ) {
            beanFactory.autowireBean(endpoint.getImplementor());
        }
    }

    private XmlWebApplicationContext getContext() {
        try {
            Field field = CXFServlet.class.getDeclaredField("createdContext");
            field.setAccessible(true);
            return (XmlWebApplicationContext) field.get(this);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            throw new RuntimeException("不能通过CXFServlet自动注入endpoint。", e);
        }
    }
}
