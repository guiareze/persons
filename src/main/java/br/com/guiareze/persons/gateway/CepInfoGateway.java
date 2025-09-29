package br.com.guiareze.persons.gateway;

import br.com.guiareze.persons.domain.CepInfo;

public interface CepInfoGateway {

    CepInfo getCepInfo(String cep);

}
