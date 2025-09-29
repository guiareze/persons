package br.com.guiareze.persons.infrastructure.gateway.cep;

import br.com.guiareze.persons.domain.CepInfo;
import br.com.guiareze.persons.gateway.CepInfoGateway;
import br.com.guiareze.persons.infrastructure.gateway.cep.dto.CepResponse;
import br.com.guiareze.persons.infrastructure.exception.IntegrationException;
import br.com.guiareze.persons.infrastructure.gateway.cep.mapper.CepInfoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class CepInfoGatewayImpl implements CepInfoGateway {

    @Value("${api.cep.url}")
    private String apiCepUrl;

    private final RestClient restClient;
    private final CepInfoMapper mapper;

    @Override
    @Cacheable(value = "cepInfoCache", key = "#cep", unless = "#result == null")
    public CepInfo getCepInfo(String cep) {

        log.info("Fetching CEP info for: {}", cep);
        Optional<CepResponse> response;

        try {
            response = Optional.ofNullable(restClient.get()
                    .uri(String.format(apiCepUrl, cep))
                    .retrieve()
                    .body(CepResponse.class));
        } catch (RestClientException exception) {
            log.error("Error fetching CEP info for {}", cep, exception);
            throw new IntegrationException("Error on CPF API integration.", exception);
        }

        CepResponse cepResponse = response
                .filter(r -> !r.erro())
                .orElseThrow(() -> new IntegrationException("CEP not found or invalid: " + cep, null));

        return mapper.toDomain(cepResponse);
    }

}
