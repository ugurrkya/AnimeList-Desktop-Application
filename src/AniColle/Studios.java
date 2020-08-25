/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AniColle;


public class Studios {

    private int studios_id;							//identifying city id
    private String studios_name;					//identifying city name

    
    public Studios(){}								
    
    public Studios(int Id, String Name){				//method with two parameters
    
        this.studios_id = Id;
        this.studios_name = Name;
       
        
       
    }
    
    public int getID(){					//getting id and returning id
      return studios_id;
    }
    
    public void setID(int ID){			//setting id
        this.studios_id = ID;
    }
    
    public String getName(){				//getting name and returning name
        return studios_name;
    }
    
    public void setName(String Name){			//setting name
        this.studios_name = Name;
    }
    
 
    
   

}

