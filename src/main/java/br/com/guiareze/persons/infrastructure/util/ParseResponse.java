package br.com.guiareze.persons.infrastructure.util;

import br.com.guiareze.persons.infrastructure.exception.InternalException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ParseResponse {

    public static <T> T parseResponse(String response, Class<T> clazz) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(response, clazz);
        } catch (Exception e) {
            log.error("Error parsing response received on integration", e);
            throw new InternalException("Error parsing response received on integration", e);
        }
    }

}
