package br.com.guiarese.persons.infrastructure.integration.cep.mapper;

import br.com.guiarese.persons.domain.CepInfo;
import br.com.guiarese.persons.infrastructure.integration.cep.dto.CepResponse;

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
