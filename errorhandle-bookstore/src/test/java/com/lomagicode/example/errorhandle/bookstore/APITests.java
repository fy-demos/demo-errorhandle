package com.lomagicode.example.errorhandle.bookstore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * Created on Oct 10, 2018
 *
 * @author Chuan Qin
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class APITests {
    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void test() {
        System.out.println("+++ResponseErrorHandler=" + restTemplate.getErrorHandler().getClass());
        ResponseEntity responseEntity = restTemplate.getForEntity("http://localhost:8080/books/1", Object.class);
        System.out.println(responseEntity.getStatusCode());
        System.out.println(responseEntity.getBody());
    }

}
