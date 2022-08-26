package com.ben;

import com.ben.controller.StudentController;
import com.ben.service.StudentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SampleApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleApplicationTests {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

	private  StudentService service;
	private StudentController victim;

	@Before
	public void setup() {
		service = mock(StudentService.class);
		victim = new StudentController(service);
	}

    @Test
    public void contextLoads() {
        log.info("test");
        assertThat(true);
    }

    @Test
    public void testTriggerException() throws Exception {
        assertEquals(victim.getAll().size(), 0);
    }

}


