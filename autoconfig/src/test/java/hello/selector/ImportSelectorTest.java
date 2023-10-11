package hello.selector;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class ImportSelectorTest {

	@Test
	void staticConfig() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(StaticConfig.class);
	}

	@Configuration
	@Import(HelloConfig.class)
	public static class StaticConfig {

	}
}
