package br.com.guiarese.persons.gateways;

import br.com.guiarese.persons.domain.CepInfo;

public interface CepInfoGateway {

    CepInfo getCepInfo(String cep);

}
