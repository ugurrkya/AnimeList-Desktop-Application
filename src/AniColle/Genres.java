/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AniColle;


public class Genres {

    private int genres_id;							//identifying city id
    private String genre_name;					//identifying city name

    
    public Genres (){}								
    
    public Genres(int Id, String Name){				//method with two parameters
    
        this.genres_id = Id;
        this.genre_name = Name;
       
        
       
    }
    
    public int getID(){					//getting id and returning id
      return genres_id;
    }
    
    public void setID(int ID){			//setting id
        this.genres_id = ID;
    }
    
    public String getName(){				//getting name and returning name
        return genre_name;
    }
    
    public void setName(String Name){			//setting name
        this.genre_name = Name;
    }
    
 
    
   

}

