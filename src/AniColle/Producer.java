/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AniColle;


public class Producer {

    private int producerid;							//identifying city id
    private String producername;					//identifying city name

    
    public Producer(){}								
    
    public Producer(int Id, String Name){				//method with two parameters
    
        this.producerid = Id;
        this.producername = Name;
       
        
       
    }
    
    public int getID(){					//getting id and returning id
      return producerid;
    }
    
    public void setID(int ID){			//setting id
        this.producerid = ID;
    }
    
    public String getName(){				//getting name and returning name
        return producername;
    }
    
    public void setName(String Name){			//setting name
        this.producername = Name;
    }
    
 
    
   

}

