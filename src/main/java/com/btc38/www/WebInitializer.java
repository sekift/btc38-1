package com.btc38.www;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

//WebApplicationInitializer是spring提供用来配置Servlet3.0+配置的接口，从而实现
//取代web.xml的位置。实现此接口自动被SpringServletContainerInitializer（用来启动
//Servlet3.0容器）获取到。
public class WebInitializer implements WebApplicationInitializer {
	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(MyMvcConfig.class);
		//新建WebApplicationContext 注册配置类，并将其和当期servletContext关联。
		ctx.setServletContext(servletContext);

		//注册spring mvc的DispatcherServlet
		Dynamic servlet = servletContext.addServlet("dispatcher",
				new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}

}
