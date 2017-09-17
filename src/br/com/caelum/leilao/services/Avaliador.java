package br.com.caelum.leilao.services;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Avaliador {

    private Leilao leilao;
    private Double maiorLance = Double.NEGATIVE_INFINITY;
    private Double menorLance = Double.POSITIVE_INFINITY;

    private List<Lance> tresMaioresLances;

    public Avaliador(Leilao leilao) {
        this.leilao = leilao;
        tresMaioresLances = new ArrayList<>(leilao.getLances());
    }

    public void avalia() {
        for (Lance lance : this.leilao.getLances()) {
            if (lance.getValor() > maiorLance) {
                this.maiorLance = lance.getValor();
            }
            if (menorLance > lance.getValor()) {
                this.menorLance = lance.getValor();
            }
        }

        Collections.sort(tresMaioresLances, (o1, o2) -> {
            if (o1.getValor() > o2.getValor()) return 1;
            if (o1.getValor() < o2.getValor()) return -1;
            return 0;
        });
        if (tresMaioresLances.size() > 2) {
            tresMaioresLances = tresMaioresLances.subList(0, 3);
        }
    }

    public double getMaiorLance() {
        return maiorLance;
    }

    public Double getMenorLance() {
        return menorLance;
    }

    public double getMediaDosLances() {
        return this.leilao.getLances().stream().mapToDouble(Lance::getValor).sum() / this.leilao.getLances().size();
    }

    public List<Lance> getTresMaioresLances() {
        return tresMaioresLances;
    }
}
