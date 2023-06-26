package com.onesoft.employee;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeApplicationTests {
@Autowired
EmployeeController ec;
	@Test
	void contextLoads() {
	}
	@Test
	public void testAge() {
		ec.getbyage(31);
	}

}
