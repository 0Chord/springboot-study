package hello.boot;

import java.util.List;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MySpringApplication {

	public static void run(Class configClass, String[] args) {
		System.out.println("MySpringApplication.run args= " + List.of(args));

		Tomcat tomcat = new Tomcat();
		Connector connector = new Connector();
		connector.setPort(8089);
		tomcat.setConnector(connector);

		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(configClass);

		DispatcherServlet dispatcher = new DispatcherServlet(appContext);

		Context context = tomcat.addContext("", "/");
		tomcat.addServlet("", "dispatcher", dispatcher);
		context.addServletMappingDecoded("/", "dispatcher");

		try {
			tomcat.start();
		} catch (LifecycleException e) {
			throw new RuntimeException(e);
		}
	}
}