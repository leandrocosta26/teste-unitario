package br.com.caelum.leilao.dominio;

import java.util.*;
import java.util.stream.Collectors;

public class Leilao {

    private String descricao;
    private List<Lance> lances;

    public Leilao(String descricao) {
        this.descricao = descricao;
        this.lances = new ArrayList<Lance>();
    }

    private static int compare(Lance o1, Lance o2) {
        if (o1.getValor() > o2.getValor()) return 1;
        if (o1.getValor() < o2.getValor()) return -1;
        return 0;
    }

    public void propoe(Lance lance) {
        if (this.lances.isEmpty() || usuarioPodeDarUmLance(lance)) {
            lances.add(lance);
        }
    }

    private boolean usuarioPodeDarUmLance(Lance lance) {
        return !getUltimoLance().getUsuario().equals(lance.getUsuario()) && getTotalLancesPorUsuario(lance.getUsuario()) < 5;
    }

    private int getTotalLancesPorUsuario(Usuario usuario) {
        return this.lances.stream().filter(p -> p.getUsuario().equals(usuario)).collect(Collectors.toList()).size();
    }

    private Lance getUltimoLance() {
        return this.lances.get(this.lances.size() - 1);
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Lance> getLances() {
        return Collections.unmodifiableList(lances);
    }


    public void dobraLance(Usuario usuario) {
        Lance lastLance = getUltimoLanceDoUsuario(usuario);
        propoe(new Lance(usuario, lastLance.getValor() * 2));
    }

    private Lance getUltimoLanceDoUsuario(Usuario usuario) {
        return this.lances.stream().filter(p -> p.getUsuario().equals(usuario)).sorted(Leilao::compare).findFirst().get();
    }
}
