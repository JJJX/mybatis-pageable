package org.buzheng.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-jdbc.xml"})
public class BaseTestCase {
protected Log logger = LogFactory.getLog(this.getClass());
	
	@Before
	public void before() {
		logger.debug("-------------------------------" + this.getClass() + "----------------------------------");
	}
	
	@After
	public void after() {
		logger.debug("-------------------------------" + this.getClass() + "----------------------------------");
	}
}
