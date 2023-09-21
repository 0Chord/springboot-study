package hello.config;

import static org.junit.jupiter.api.Assertions.*;

import javax.sql.DataSource;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionManager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class DbConfigTest {

	@Autowired
	DataSource dataSource;

	@Autowired
	TransactionManager transactionManager;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Test
	void checkBean() {
		log.info("datasource Bean = {}",dataSource);
		log.info("transactionManager Bean = {}",transactionManager);
		log.info("jdbcTemplate Bean = {}",jdbcTemplate);

		Assertions.assertThat(dataSource).isNotNull();
		Assertions.assertThat(transactionManager).isNotNull();
		Assertions.assertThat(jdbcTemplate).isNotNull();
	}
}