import java.util.Date;
import java.time.LocalDate;
import java.io.Serializable;

public class Found extends Category implements Serializable{
    
    private Person owner;
    private String location;
    
    public Found(LocalDate date, String location, Person person) {
        super(date, person);
        setLocation(location);
    }
    
    public void setLocation(String l) {
        location = l;
    }
    
    public void setOwner(Person o) {
        owner = o;
    }
    
    public String getLocation() {
        return location;
    }
    
    public Person getOwner() {
        return owner;
    }
}
