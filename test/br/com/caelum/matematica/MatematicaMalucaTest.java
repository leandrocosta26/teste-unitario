package br.com.caelum.matematica;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatematicaMalucaTest {

    private MatematicaMaluca matematica;

    @Before
    public void setUp() throws Exception {
        this.matematica = new MatematicaMaluca();
    }

    @Test
    public void contaMalucaMaiorQueTrinta(){
        int resultado = matematica.contaMaluca(40);
        Assert.assertEquals(160, resultado);
    }

    @Test
    public void contaMalucaMaiorQueDez(){
        int resultado = matematica.contaMaluca(15);
        Assert.assertEquals(45, resultado);
    }

    @Test
    public void contaMalucaMenorQueDez(){
        int resultado = matematica.contaMaluca(6);
        Assert.assertEquals(12, resultado);
    }

    @Test
    public void contaMalucaZero(){
        int resultado = matematica.contaMaluca(0);
        Assert.assertEquals(0, resultado);
    }
}