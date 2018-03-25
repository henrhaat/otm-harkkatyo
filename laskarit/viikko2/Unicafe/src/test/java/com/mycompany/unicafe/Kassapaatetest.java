package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class Kassapaatetest {
    
    Kassapaate paate;
    Maksukortti kortti1;
    Maksukortti kortti2;

    @Before
    public void setUp() {
        paate = new Kassapaate();
        kortti1 = new Maksukortti(500);
        kortti2 = new Maksukortti(200);
    }
    
    @Test
    public void rahamaaraOikein() {
        assertEquals(paate.kassassaRahaa(),100000);
    }
    
    @Test
    public void myydytMaukkaatOikein() {
        assertEquals(paate.maukkaitaLounaitaMyyty(),0);
    }
    
    @Test
    public void myydytEdullisetOikein() {
        assertEquals(paate.edullisiaLounaitaMyyty(),0);
    }
    
    @Test
    public void KateinenMaksuRiittavaMaukasLkm() {
        paate.syoMaukkaasti(500);
        assertEquals(paate.maukkaitaLounaitaMyyty(), 1);
    }
    
    @Test
    public void KateinenMaksuRiittavaEdullinenLkm() {
        paate.syoEdullisesti(500);
        assertEquals(paate.edullisiaLounaitaMyyty(), 1);
    }

    @Test
    public void KateinenMaksuRiittavaMaukasRahamaara() {
        paate.syoMaukkaasti(500);
        assertEquals(paate.kassassaRahaa(),100400);
    }

    @Test
    public void KateinenMaksuRiittavaEdullinenRahamaara() {
        paate.syoEdullisesti(500);
        assertEquals(paate.kassassaRahaa(),100240);
    }
    
    @Test
    public void KateinenMaksuRiittavaMaukasVaihtoraha() {
        assertEquals(paate.syoMaukkaasti(500),100);
    }
    
    @Test
    public void KateinenMaksuRiittavaEdullinenVaihtoraha() {
        assertEquals(paate.syoEdullisesti(500),260);
    }
    
    @Test
    public void KateinenMaksuEiRiittavaMaukasLkm() {
        paate.syoMaukkaasti(200);
        assertEquals(paate.maukkaitaLounaitaMyyty(), 0);
    }
    
    @Test
    public void KateinenMaksuEiRiittavaEdullinenLkm() {
        paate.syoEdullisesti(200);
        assertEquals(paate.edullisiaLounaitaMyyty(), 0);
    }
    
    @Test
    public void KateinenMaksuEiRiittavaMaukasRahamaara() {
        paate.syoMaukkaasti(200);
        assertEquals(paate.kassassaRahaa(),100000);
    }

    @Test
    public void KateinenMaksuEiRiittavaEdullinenRahamaara() {
        paate.syoEdullisesti(200);
        assertEquals(paate.kassassaRahaa(),100000);
    }
    
    @Test
    public void KateinenMaksuEiRiittavaMaukasVaihtoraha() {
        assertEquals(paate.syoMaukkaasti(200),200);
    }
    
    @Test
    public void KateinenMaksuEiRiittavaEdullinenVaihtoraha() {
        assertEquals(paate.syoEdullisesti(200),200);
    }
    
    @Test
    public void KorttiMaksuRiittavaMaukas() {
        paate.syoMaukkaasti(kortti1);
        assertEquals(kortti1.saldo(),100);
    }
    
    @Test
    public void KorttiMaksuRiittavaEdullinen() {
        paate.syoEdullisesti(kortti1);
        assertEquals(kortti1.saldo(),260);
    }
    @Test
    public void KorttiMaksuRiittavaMaukasBoolean() {
        assertEquals(paate.syoMaukkaasti(kortti1),true);
    }
    
    @Test
    public void KorttiMaksuRiittavaEdullinenBoolean() {
        assertEquals(paate.syoEdullisesti(kortti1),true);
    }
    
    @Test
    public void KorttiMaksuRiittavaMaukasLounasLkm() {
        paate.syoMaukkaasti(kortti1);
        assertEquals(paate.maukkaitaLounaitaMyyty(),1);
    }
    
    @Test
    public void KorttiMaksuRiittavaEdullinenLounasLkm() {
        paate.syoEdullisesti(kortti1);
        assertEquals(paate.edullisiaLounaitaMyyty(),1);
    }
    @Test
    public void KorttiMaksuEiRiittavaMaukas() {
        paate.syoMaukkaasti(kortti2);
        assertEquals(kortti2.saldo(),200);
    }
    
    @Test
    public void KorttiMaksuEiRiittavaEdullinen() {
        paate.syoEdullisesti(kortti2);
        assertEquals(kortti2.saldo(),200);
    }
    @Test
    public void KorttiMaksuEiRiittavaMaukasLounasLkm() {
        paate.syoMaukkaasti(kortti2);
        assertEquals(paate.maukkaitaLounaitaMyyty(),0);
    }
    
    @Test
    public void KorttiMaksuEiRiittavaEdullinenLounasLkm() {
        paate.syoEdullisesti(kortti2);
        assertEquals(paate.edullisiaLounaitaMyyty(),0);
    }
    
    @Test
    public void KorttiMaksuEiRiittavaMaukasBoolean() {
        assertEquals(paate.syoMaukkaasti(kortti2),false);
    }
    
    @Test
    public void KorttiMaksuEiRiittavaEdullinenBoolean() {
        assertEquals(paate.syoEdullisesti(kortti2),false);
    }
    
    @Test
    public void KorttiMaksuMaukasKassanRahamaara() {
        paate.syoMaukkaasti(kortti1);
        assertEquals(paate.kassassaRahaa(),100000);
    }
    
    @Test
    public void KorttiMaksuEdullinenKassanRahamaara() {
        paate.syoEdullisesti(kortti1);
        assertEquals(paate.kassassaRahaa(),100000);
    }
    
    
    
    
    
    
    
    
    


    // public void hello() {}
}
