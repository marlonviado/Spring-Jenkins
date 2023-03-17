package com.marlonviado;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringJenkinsApplicationTests {
	
	//public static Logger logger = (Logger) LoggerFactory.getLogger(SpringJenkinsApplicationTests.class);

	@Test
	void contextLoads() {
		//logger.info("Test Case Executing!");
		Assertions.assertEquals(true, true);
	}

}
