package hello.container;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import hello.spring.HelloConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;

public class AppInitV2Spring implements AppInit{
	@Override
	public void onStartup(ServletContext servletContext) {
		System.out.println("AppInitV2Spring.onStartup");

		//스프링 컨테이너 생성
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(HelloConfig.class);

		//스프링 MVC 디스패처 서블릿 생성, 스프링 컨테이너 연결
		DispatcherServlet dispatcher = new DispatcherServlet(appContext);
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcherV2", dispatcher);

		servlet.addMapping("/spring/*");
	}
}
