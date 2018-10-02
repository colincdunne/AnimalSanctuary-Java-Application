import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.io.Serializable;

public class Adoption extends Category implements Serializable{
   
    private boolean neutered;
    private boolean chipped;
    private boolean vaccinated;
    private String status;
    private boolean reserved;
    private ArrayList<Person> person = new ArrayList<Person>();
    
    public Adoption(LocalDate date) {
        super(date);
    }
    
    public void setNeutered(boolean n) {
        neutered = n;
    }
    
    public void setChipped(boolean c) {
        chipped = c;
    }
    
    public void setVaccinated(boolean v) {
        vaccinated = v;
    }
    
    public void setStatus(String s) {
        status = s;
    }
    
    public void setReserved(boolean r) {
        reserved = r;
    }
    
    public boolean getNeutered() {
        return neutered; 
    }
    
    public boolean getChipped() {
        return chipped;
    }
    
    public boolean getVaccinated() {
        return vaccinated;
    }
    
     public String getStatus() {
        return status;
    }
    
    public boolean getReserved() {
        return reserved;
    }
    
    public String toString() {
        return "Neutered: " + getNeutered() + " Chipped: " + getChipped() + " Vaccinated: " + getVaccinated() + " Status: " + getStatus() + " Reserved: " + getReserved();
    }
    
    public void print() {
        System.out.println(toString());
    }
}
