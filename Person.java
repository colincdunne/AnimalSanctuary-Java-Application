import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private String address;
    private String phone;
    private String email;
    
    public Person(String oName, String address, String phone, String email) {
        setName(oName);
        setAddress(address);
        setPhone(phone);
        setEmail(email);
    }
    
    public void setName(String n) {
        name = n;
    }
    
    public void setAddress(String a) {
        address = a;
    }
    
    public void setPhone(String p) {
        phone = p;
    }
    
    public void setEmail(String e) {
        email = e;
    }
    
    public String getName() {
        return name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String toString() {
        return "Name: " + getName() + " Address: " + getAddress() + " Phone: " + getPhone() + " Email: " + getEmail();
    }
    
    public void print() {
        System.out.println(toString());
    }
}
