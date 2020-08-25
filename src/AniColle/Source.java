/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AniColle;


public class Source {

    private int sourceid;							//identifying city id
    private String sourcename;					//identifying city name

    
    public Source (){}								
    
    public Source(int Id, String Name){				//method with two parameters
    
        this.sourceid = Id;
        this.sourcename = Name;
       
        
       
    }
    
    public int getID(){					//getting id and returning id
      return sourceid;
    }
    
    public void setID(int ID){			//setting id
        this.sourceid = ID;
    }
    
    public String getName(){				//getting name and returning name
        return sourcename;
    }
    
    public void setName(String Name){			//setting name
        this.sourcename = Name;
    }
    
 
    
   

}

