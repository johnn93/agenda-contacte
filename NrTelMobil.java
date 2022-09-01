/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contact;

/**
 *
 * @author ionut
 */
public class NrTelMobil extends NrTel {
    private String NrTelMobil;

    public NrTelMobil(String NrTelMobil) {
        super(NrTelMobil);
    }

    @Override
    public boolean validareNumar() {
        return true;
    }
    
}
