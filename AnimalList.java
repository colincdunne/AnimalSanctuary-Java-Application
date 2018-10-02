import java.util.ArrayList;
import java.io.Serializable;

public class AnimalList implements Serializable {
    private ArrayList<Animal> animalList;
    public AnimalList()
    {
        this.animalList = new ArrayList<Animal>();
    }

    public boolean add(Animal a)
    {
        return animalList.add(a);
    }

    public boolean remove(Animal a)
    {
        return animalList.remove(a);
    }
    
    public ArrayList<Animal> getAnimalList()
    {
        return animalList;
    }
    
     public ArrayList<Animal> getLostAnimalList()
    {
        ArrayList<Animal> lostList = new ArrayList<Animal>();
        for(Animal a: animalList)
        {
            if(a.getAnimalCat() instanceof Lost)
            {
                lostList.add(a);
            }
        }
        
        return lostList;
    }
    
    
     public ArrayList<Animal> getFoundAnimalList()
    {
        ArrayList<Animal> foundList = new ArrayList<Animal>();
        for(Animal a: animalList)
        {
            if(a.getAnimalCat() instanceof Found)
            {
                foundList.add(a);
            }
        }
        
        return foundList;
    }
    
     public ArrayList<Animal> getAdoptionAnimalList()
    {
        ArrayList<Animal> adoptionList = new ArrayList<Animal>();
        for(Animal a: animalList)
        {
            if(a.getAnimalCat() instanceof Adoption)
            {
                adoptionList.add(a);
            }
        }
        
        return adoptionList;
    }

    public void printList()
    {
        for(int i = 0;i < animalList.size();i++)
        {
            System.out.println(this.animalList.get(i));
        }
    }
}