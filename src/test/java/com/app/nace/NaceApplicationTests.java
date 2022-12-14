package com.app.nace;

import com.app.nace.controller.NaceController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@RunWith(SpringRunner.class)
class NaceApplicationTests {
	@Autowired
	private NaceController naceController;
	@Test
	void contextLoads() {
		assertThat(naceController).isNotNull();
	}

}
