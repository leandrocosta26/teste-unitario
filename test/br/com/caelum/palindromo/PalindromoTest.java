package br.com.caelum.palindromo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PalindromoTest {

    private Palindromo palindromo;

    private final static String PHASE_1 = "Socorram-me subi no onibus em Marrocos";
    private final static String PHASE_2 = "Anotaram a data da maratona";
    private final static String PHASE_IMPCOMPATIVEL = "Hoje andei de bicicleta";

    @Before
    public void init(){
        this.palindromo = new Palindromo();
    }

    @Test
    public void testEhPalindromo(){
        Boolean resultado = this.palindromo.ehPalindromo(PHASE_1);
        Boolean resultado1 = this.palindromo.ehPalindromo(PHASE_1);
        Assert.assertTrue(resultado);
        Assert.assertTrue(resultado1);
    }

    @Test
    public void testNaoEPalindromo(){
        Boolean resultado = this.palindromo.ehPalindromo(PHASE_IMPCOMPATIVEL);
        Assert.assertFalse(resultado);
    }
}
