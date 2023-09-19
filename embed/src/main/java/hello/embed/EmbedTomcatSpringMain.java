package hello.embed;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import hello.spring.HelloConfig;

public class EmbedTomcatSpringMain {

	public static void main(String[] args) throws LifecycleException {
		System.out.println("EmbedTomcatSpringMain.main");

		Tomcat tomcat = new Tomcat();
		Connector connector = new Connector();
		connector.setPort(8089);
		tomcat.setConnector(connector);

		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(HelloConfig.class);

		DispatcherServlet dispatcher = new DispatcherServlet(appContext);

		Context context = tomcat.addContext("", "/");
		tomcat.addServlet("", "dispatcher", dispatcher);
		context.addServletMappingDecoded("/", "dispatcher");

		tomcat.start();

	}
}
