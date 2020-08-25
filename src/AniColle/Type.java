/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AniColle;


public class Type {

    private int typeid;							//identifying city id
    private String typename;					//identifying city name

    
    public Type (){}								
    
    public Type(int Id, String Name){				//method with two parameters
    
        this.typeid = Id;
        this.typename = Name;
       
        
       
    }
    
    public int getID(){					//getting id and returning id
      return typeid;
    }
    
    public void setID(int ID){			//setting id
        this.typeid = ID;
    }
    
    public String getName(){				//getting name and returning name
        return typename;
    }
    
    public void setName(String Name){			//setting name
        this.typename = Name;
    }
    
 
    
   

}
