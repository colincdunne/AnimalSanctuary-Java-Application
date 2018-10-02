import java.util.Date;
import java.time.LocalDate;
import java.io.Serializable;

public class Category implements Serializable {
    private LocalDate date;
    private Person contact;
    
    public Category(LocalDate date, Person person) {
        setDate(date);
        setContact(person);
    }
    
    public Category(LocalDate date) {
        setDate(date);
    }
    
    public void setDate(LocalDate d) {
        date = d;
    }
    
    public void setContact(Person c) {
        contact = c;
    }
    
    public LocalDate getDate() {
       return date; 
    }
    
    public Person getContact() {
       return contact; 
    }
}
