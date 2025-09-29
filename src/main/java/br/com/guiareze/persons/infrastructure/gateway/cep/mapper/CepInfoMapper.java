package br.com.guiareze.persons.infrastructure.gateway.cep.mapper;

import br.com.guiareze.persons.domain.CepInfo;
import br.com.guiareze.persons.infrastructure.gateway.cep.dto.CepResponse;

public class CepInfoMapper {

    public CepInfo toDomain(CepResponse response) {
        return new CepInfo(
                response.cep(),
                response.logradouro(),
                response.complemento(),
                response.unidade(),
                response.bairro(),
                response.localidade(),
                response.uf(),
                response.estado(),
                response.regiao(),
                response.ibge(),
                response.gia(),
                response.ddd(),
                response.siafi()
        );
    }

}
