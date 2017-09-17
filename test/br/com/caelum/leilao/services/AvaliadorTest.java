package br.com.caelum.leilao.services;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class AvaliadorTest {

    static final double DELTA = 0.00001;
    private Usuario leandro;
    private Usuario juliana;
    private Usuario gabriel;
    private Leilao leilao;

    @Before
    public void init(){
        this.leandro = new Usuario("leandro");
        this.juliana = new Usuario("juliana");
        this.gabriel = new Usuario("gabriel");
        this.leilao = new Leilao("Playstation 4");
    }

    @Test
    public void avalia(){
        this.leilao.propoe(new Lance(leandro, 200));
        this.leilao.propoe(new Lance(juliana, 300));
        this.leilao.propoe(new Lance(gabriel, 400));

        Avaliador avaliador = new Avaliador(this.leilao);

        avaliador.avalia();

        Assert.assertEquals(400, avaliador.getMaiorLance(), DELTA);
        Assert.assertEquals(200,avaliador.getMenorLance(), DELTA);
        Assert.assertEquals(300,avaliador.getMediaDosLances(), DELTA);
    }

    @Test
    public void avaliaComUmUnicoLance(){
        this.leilao.propoe(new Lance(leandro, 200));

        Avaliador avaliador = new Avaliador(this.leilao);
        avaliador.avalia();
        Assert.assertEquals(200, avaliador.getMaiorLance(), DELTA);
        Assert.assertEquals(200,avaliador.getMenorLance(), DELTA);
        Assert.assertEquals(200,avaliador.getMediaDosLances(), DELTA);
    }

    @Test
    public void avaliaTresMaioresLance(){
        this.leilao.propoe(new Lance(leandro, 200));
        this.leilao.propoe(new Lance(juliana, 300));
        this.leilao.propoe(new Lance(leandro, 400));
        this.leilao.propoe(new Lance(juliana, 450));

        Avaliador avaliador = new Avaliador(this.leilao);
        avaliador.avalia();
        Assert.assertEquals(450, avaliador.getMaiorLance(), DELTA);
        Assert.assertEquals(200,avaliador.getMenorLance(), DELTA);
        Assert.assertEquals(3,avaliador.getTresMaioresLances().size());
    }

    @Test
    public void avaliaRadomLances(){
        Random random = new Random();
        random.setSeed(700);
        this.leilao.propoe(new Lance(leandro, random.nextDouble()));
        this.leilao.propoe(new Lance(juliana, random.nextDouble()));
        this.leilao.propoe(new Lance(leandro, random.nextDouble()));
        this.leilao.propoe(new Lance(juliana, random.nextDouble()));

        Avaliador avaliador = new Avaliador(this.leilao);
        avaliador.avalia();
        Assert.assertEquals(3,avaliador.getTresMaioresLances().size());
    }

    @Test(expected = RuntimeException.class)
    public void avaliaSemLances(){
        Avaliador avaliador = new Avaliador(this.leilao);
        avaliador.avalia();
    }
}
