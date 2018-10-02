import java.util.Date;
import java.time.LocalDate;
import java.io.Serializable;

public class Lost extends Category implements Serializable {
    
    private String location;
    
    public Lost(LocalDate date, String location, Person person) {
        super(date, person);
        setLocation(location);
    }
    
    public void setLocation(String l) {
        location = l;
    }
    
    public String getLocation() {
        return location;
    }
}
