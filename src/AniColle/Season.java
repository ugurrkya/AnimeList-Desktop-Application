/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AniColle;


public class Season {

    private int seasonid;							//identifying city id
    private String seasonname;					//identifying city name

    
    public Season (){}								
    
    public Season(int Id, String Name){				//method with two parameters
    
        this.seasonid = Id;
        this.seasonname = Name;
       
        
       
    }
    
    public int getID(){					//getting id and returning id
      return seasonid;
    }
    
    public void setID(int ID){			//setting id
        this.seasonid = ID;
    }
    
    public String getName(){				//getting name and returning name
        return seasonname;
    }
    
    public void setName(String Name){			//setting name
        this.seasonname = Name;
    }
    
 
    
   

}

