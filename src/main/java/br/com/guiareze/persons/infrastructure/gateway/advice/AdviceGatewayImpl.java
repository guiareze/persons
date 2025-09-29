package br.com.guiareze.persons.infrastructure.gateway.advice;

import br.com.guiareze.persons.gateway.AdviceGateway;
import br.com.guiareze.persons.infrastructure.exception.GatewayException;
import br.com.guiareze.persons.infrastructure.exception.InternalException;
import br.com.guiareze.persons.infrastructure.gateway.advice.dto.SlipResponse;
import br.com.guiareze.persons.infrastructure.util.ParseResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class AdviceGatewayImpl implements AdviceGateway {

    @Value("${api.advice.url}")
    private String apiAdviceUrl;

    private final RestClient restClient;

    @Override
    public String getRandomAdvice() {

        log.info("Fetching random advice");
        String slipResponse;

        try {
            slipResponse = restClient.get()
                    .uri(apiAdviceUrl)
                    .retrieve()
                    .body(String.class);
        } catch (Exception exception) {
            log.error("Error fetching random advice", exception);
            throw new GatewayException("Error fetching random advice", exception);
        }
        return Optional.ofNullable(slipResponse)
                .map(response -> ParseResponse.parseResponse(response, SlipResponse.class))
                .map(r -> r.slip().advice())
                .orElseThrow(() -> new GatewayException("No advice found", null));
    }

}
