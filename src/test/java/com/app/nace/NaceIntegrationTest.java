package com.app.nace;

import com.app.nace.domain.Nace;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NaceIntegrationTest {
    @Autowired
    public TestRestTemplate restTemplate;

    @Test
    public void getNace_returnNaceDetails() throws Exception {
        ResponseEntity<Nace> response = restTemplate.getForEntity("/nace/398481", Nace.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

    }
}
