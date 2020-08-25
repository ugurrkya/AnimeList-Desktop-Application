/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AniColle;


public class Country {

    private int countryid;							//identifying city id
    private String countryname;					//identifying city name

    
    public Country (){}								
    
    public Country(int Id, String Name){				//method with two parameters
    
        this.countryid = Id;
        this.countryname = Name;
       
        
       
    }
    
    public int getID(){					//getting id and returning id
      return countryid;
    }
    
    public void setID(int ID){			//setting id
        this.countryid = ID;
    }
    
    public String getName(){				//getting name and returning name
        return countryname;
    }
    
    public void setName(String Name){			//setting name
        this.countryname = Name;
    }
    
    }