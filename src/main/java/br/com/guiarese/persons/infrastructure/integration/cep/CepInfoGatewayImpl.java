package br.com.guiarese.persons.infrastructure.integration.cep;

import br.com.guiarese.persons.domain.CepInfo;
import br.com.guiarese.persons.gateways.CepInfoGateway;
import br.com.guiarese.persons.infrastructure.integration.cep.dto.CepResponse;
import br.com.guiarese.persons.infrastructure.integration.cep.mapper.CepInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@RequiredArgsConstructor
public class CepInfoGatewayImpl implements CepInfoGateway {

    @Value("${api.cep.url}")
    private String apiCepUrl;

    private final RestClient restClient;
    private final CepInfoMapper mapper;

    @Override
    public CepInfo getCepInfo(String cep) {
        var response = restClient.get()
                .uri(String.format(apiCepUrl, cep))
                .retrieve()
                .body(CepResponse.class);
        return mapper.toDomain(response);
    }

}
