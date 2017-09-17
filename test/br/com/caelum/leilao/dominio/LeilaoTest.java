package br.com.caelum.leilao.dominio;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeilaoTest {


    private Leilao leilao;
    private Usuario steveJobs;
    private Usuario steveWozniak;

    @Before
    public void setUp() throws Exception {
        this.leilao = new Leilao("Macbook pro");
        this.steveJobs = new Usuario("Steve Jobs");
        this.steveWozniak = new Usuario("Steve Wozniak");
    }

    @Test
    public void propoeLancesSeguidosDoMesmoUsuario(){
        this.leilao.propoe(new Lance(steveJobs, 3000));
        this.leilao.propoe(new Lance(steveJobs, 2000));
        assertEquals(1, this.leilao.getLances().size());
        assertEquals(3000, this.leilao.getLances().get(0).getValor(), 0.00001);
    }

    @Test
    public void propoe5LanceDoMesmoUsuario(){

        this.leilao.propoe(new Lance(steveJobs, 2000));
        this.leilao.propoe(new Lance(steveWozniak, 3000));

        this.leilao.propoe(new Lance(steveJobs, 4000));
        this.leilao.propoe(new Lance(steveWozniak, 5000));

        this.leilao.propoe(new Lance(steveJobs, 6000));
        this.leilao.propoe(new Lance(steveWozniak, 7000));

        this.leilao.propoe(new Lance(steveJobs, 8000));
        this.leilao.propoe(new Lance(steveWozniak, 9000));

        this.leilao.propoe(new Lance(steveJobs, 10000));
        this.leilao.propoe(new Lance(steveWozniak, 11000));

        this.leilao.propoe(new Lance(steveJobs, 12000));

        assertEquals(10, this.leilao.getLances().size());
        assertEquals(11000, this.leilao.getLances().get(this.leilao.getLances().size()-1).getValor(), 0.0001);
    }

    @Test
    public void dobraLanceDoUsuario(){
        this.leilao.propoe(new Lance(steveJobs, 6000));
        this.leilao.propoe(new Lance(steveWozniak, 7000));

        this.leilao.dobraLance(steveJobs);

        assertEquals(3, this.leilao.getLances().size());
        assertEquals(12000, this.leilao.getLances().get(this.leilao.getLances().size()-1).getValor(), 0.0001);
    }
}