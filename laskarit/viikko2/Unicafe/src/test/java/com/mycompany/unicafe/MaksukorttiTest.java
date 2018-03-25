package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void saldoAlussaOikein() {
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void saldonKasvattaminenToimiiOikein() {
        kortti.lataaRahaa(120);
        assertEquals("saldo: 1.30", kortti.toString());
    }
    
    @Test
    public void saldoVaheneeOikein() {
        kortti.otaRahaa(3);
        assertEquals("saldo: 0.07", kortti.toString());
    }
    
    @Test
    public void saldoEiMuutuJosEiTarpeeksiRahaa() {
        kortti.otaRahaa(15);
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void saldoVaheneeOikeinBooleanTrue() {
        assertEquals(kortti.otaRahaa(5),true);
    }
    
    @Test
    public void saldoVaheneeOikeinBooleanFalse() {
        assertEquals(kortti.otaRahaa(11),false);
    }
}
