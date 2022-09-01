/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contact;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ionut
 */
public class Data {
    private List<Contact> contacte = new ArrayList<>();
    
   
    
    public List<Contact> getAllContact() {
        return contacte;
    }
    
    public boolean modificaContact(Contact cSelectat, Contact cEditat) {
        if (!cSelectat.getNume().equals(cEditat.getNume())) {
            return false;
        }
    int idxContact = getIdxContact(cSelectat);
        if(idxContact >=0 ){
            contacte.set(idxContact, cEditat);
            return true;
        }
        return false;
    }
    
    public boolean stergeContact(Contact contact) {
        return contacte.remove(contact);
    }
    
    public int getIdxContact(Contact c) {
        for (int i = 0; i < contacte.size(); i++) {
            if (contacte.get(i).getNume() == c.getNume()) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean adaugaContact(Contact cAdd) {
        contacte.add(cAdd);
        return true;
    }
}
