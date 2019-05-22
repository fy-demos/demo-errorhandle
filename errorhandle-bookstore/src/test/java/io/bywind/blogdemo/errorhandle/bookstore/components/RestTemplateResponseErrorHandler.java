package io.bywind.blogdemo.errorhandle.bookstore.components;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.client.ResponseErrorHandler;

/**
 * Created on Oct 10, 2018
 *
 * @author Chuan Qin
 */
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return (
                response.getStatusCode().series() == CLIENT_ERROR
                        || response.getStatusCode().series() == SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {

        if (response.getStatusCode()
                .series() == HttpStatus.Series.SERVER_ERROR) {
            // handle SERVER_ERROR
            System.out.println();
        } else if (response.getStatusCode()
                .series() == HttpStatus.Series.CLIENT_ERROR) {
            // handle CLIENT_ERROR

            FileCopyUtils.copyToByteArray(response.getBody());
            Optional<String> optional = new BufferedReader(new InputStreamReader(response.getBody())).lines()
                    .reduce((s, s2) -> s + s2);
            String result = "";
            if (optional.isPresent()) {
                result = optional.get();
            }
            System.out.println(result);

        }

    }
}
