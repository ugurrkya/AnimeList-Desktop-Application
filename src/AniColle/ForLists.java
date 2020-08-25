package AniColle;

public class ForLists {
    
    private byte[] animephoto;
    private int animeid;
    private String animename;
    private int plannedep;
    private int watchedep;

    
    public ForLists(){}
    
    public ForLists(byte[] image,String name, int watch,int plan){
        
        this.animephoto= image;
       
        this.animename = name;
        this.watchedep = watch;
        this.plannedep = plan;
        
        
    }

   
    
    
    public byte[] getMyImage(){
        return animephoto;
    
    }
  /* public int getID(){
      return animeid;
    }
    
    public void setID(int ID){
        this.animeid = ID;
    }*/
    
    public String getName(){
        return animename;
    }
    
    public void setName(String Name){
        this.animename = Name;
    }
    
    public int getPlannedep(){
        return plannedep;
    }
    
    public void setPlannedep(int Plannedep){
        this.plannedep = Plannedep;
    }
    public int getWatchedep(){
        return watchedep;
    }
    
    public void setWatchedep(int Watchedep){
        this.watchedep = Watchedep;
    }
   
     
    
}