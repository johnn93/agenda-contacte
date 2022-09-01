package Contact;


/*@author ionut */
public class Contact {
    private String nume;
    private String prenume;
   private String dataNasterii;
   private String NrTel;
  
   
    private Contact(String nume, String prenume,String NrTel,String dataNasterii){
        this.nume=nume;
        this.prenume=prenume;
        this.NrTel=NrTel;
        this.dataNasterii = dataNasterii;
        
    }
    
    public static Contact getInstance(String nume,String prenume,String NrTel, String dataNasterii){
       if(!valideazaNume(nume)){
           return null;
       }
       if(!valideazaPrenume(prenume)){
           return null;
       }
       if(!valideazaData(dataNasterii)){
           return null;
       } 
       
         return new Contact(nume,prenume,NrTel,dataNasterii);
    }
    
    private static boolean valideazaNume(String n){
       if (n == null || n.length() < 3) {
           return false;
        }
        return true;
    }
    
    private static boolean valideazaPrenume(String m){
       if (m == null || m.length() < 3) {
         return false;
        }
        return true;
    }
    
     private static boolean valideazaData(String data){
      
            
        if(data==null || data.length()!=10 || data.indexOf(".")!=2 || data.lastIndexOf(".")!=5){
            return false;
        }
                             
        String[] elemente = data.split("\\.");
         
        if(elemente.length!=3){
            return false;
        }
        
        int zi = Integer.parseInt(elemente[0]),
            luna = Integer.parseInt(elemente[1]),
            an = Integer.parseInt(elemente[2]);
        if(an<0){
            return false;
        }
        if(luna<1 || luna >12){
            return false;
        }
        
        if(zi<1 || zi>31){
             return false;
        }
        
        return true;
}
    
    
     
    public String getNume(){
        return nume;
    }
    
    public String getdataNasterii(){
        return dataNasterii;
    }
    
    public String getPrenume(){
        return prenume;
    }
    
    public String getNrTel(){
        return NrTel;
    }
    
    private void setNume(){
        this.nume="";
        
    }
    
     private void setNrTel(){
        this.NrTel="";
        
    }
    
    private void setPrenume(){
        this.prenume="";
    }
    
     private void setdataNasterii(){
        this.dataNasterii="";
    }
    
    
   
    
    @Override
    public String toString(){
        return nume + "," + prenume + "," + NrTel + "," + dataNasterii;
    }
}
