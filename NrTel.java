package Contact;

/* @author ionut */
public abstract class NrTel implements Comparable {
    private String NrTel;
    
    public NrTel(String NrTel){
        if(validareNumar())
        this.NrTel=NrTel;
    }
    
    public abstract boolean validareNumar();
    
    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString(){
       return NrTel; 
    }
    
}
