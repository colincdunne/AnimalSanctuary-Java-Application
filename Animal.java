import javafx.scene.image.Image;
import java.util.Date;
import java.time.LocalDate;
import java.io.Serializable;

public class Animal implements Serializable {
    
    private static int counter = 1;
    private int ID;
    private String aType, description, breed, name, age;
    private boolean gender;
    private Image picture;
    private Category animalCat;
    private Category adoption;
    
    public Animal(String aType, boolean gender, String desc, String breed)
    {
        setID();
        setAType(aType);
        setGender(gender);
        setBreed(breed);
        setDescription(name);
    }
    
    public Animal(String age, String aType, boolean gender, String desc, String breed)
    {
        this(aType, gender, desc, breed);
        setAge(age);
    }
    
    public Animal(String age, String aType, boolean gender, String desc, String breed, String name)
    {
        this(age, aType, gender, desc, breed);
        setName(name);
    }
    
    public void setID()
    {
        this.ID = ID;
        counter += 1;
    }
    
    public int getID()
    {
        return ID;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    
     public void setAType(String aType)
    {
        this.aType = aType;
    }
    
    public String getAType()
    {
        return aType;
    }
    
    public void setBreed(String breed)
    {
        this.breed = breed;
    }
    
    public String getBreed()
    {
        return breed;
    }
    
     public void setDescription(String description)
    {
        this.description = description;
    }
    
    public String getDescription()
    {
        return description;
    }
    
     public void setAge(String age)
    {
        this.age = age;
    }
    
    public String getAge()
    {
        return age;
    }
    
     public void setGender(boolean gender)
    {
        this.gender = gender;
    }
    
    public String getGender()
    {
        if(gender == false) {
            return "Female";
        }
        else {
            return "Male";
        }
    }
    
     public void setAnimalCat(Category animalCat)
    {
        this.animalCat = animalCat;
    }
    
    public Category getAnimalCat()
    {
        return animalCat;
    }
    
      public void setImage(Image picture)
    {
        this.picture = picture;
    }
    
    public Image getImage()
    {
        return picture;
    }

    public LocalDate getDate() {
        return animalCat.getDate();
    }
    
    public String toString()
    {
        return(" Name: " + getName() + " Type: " + getAType() + " Gender: " + getGender() + " Breed: " + getBreed() + " Age: " + getAge() + " Description: " + getDescription());
    }
    
    public void print()
    {
        System.out.println(toString());
    }
}
