package br.com.caelum.filtros;

import br.com.caelum.leilao.dominio.Lance;

import java.util.ArrayList;
import java.util.List;

public class FiltrosDeLances {
    private List<Lance> resultado = new ArrayList<>();

    public List<Lance> filtra(List<Lance> lances) {
        for(Lance lance : lances) {
            if(lance.getValor() > 500){
                resultado.add(lance);
            }
        }
        return resultado;
    }
}
