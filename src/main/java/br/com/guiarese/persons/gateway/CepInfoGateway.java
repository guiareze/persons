package br.com.guiarese.persons.gateway;

import br.com.guiarese.persons.domain.CepInfo;

public interface CepInfoGateway {

    CepInfo getCepInfo(String cep);

}
