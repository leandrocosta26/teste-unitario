package br.com.caelum.filtros;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Usuario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FiltrosDeLancesTest {

    private FiltrosDeLances filtro;
    private List<Lance> lances;
    private Usuario leandro;

    @Before
    public void setUp() throws Exception {
        this.leandro = new Usuario("leandro");
        this.filtro = new FiltrosDeLances();
        this.lances = new ArrayList<>();
    }

    @Test
    public void filtroAcimaDe500(){
        lances.add(new Lance(leandro, 600));
        lances.add(new Lance(leandro, 900));
        lances.add(new Lance(leandro, 200));
        List<Lance> resultado = this.filtro.filtra(lances);
        Assert.assertTrue(resultado.size() == 2);
    }
}