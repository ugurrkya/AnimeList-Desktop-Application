package AniColle;

public class ForAnimes {
    
    private byte[] animephoto;
    private int animeid;
    private String animename;
    private String studio;
    private String genre;
    private String season;
    private String type;
    private String producer;
    private String source;
    private int plannedep;
    private int currentep;
    private String country;
    private String duration;
    
    
    
    
    public ForAnimes(){}
    
    public ForAnimes(byte[] image,int id, String animename, String studio, String genre, String season, String type, String producer, String source, int plannedep, int currentep, String country, String duration){
        
        this.animephoto=image;
        this.animeid = id;
        this.animename = animename;
        this.studio = studio;
        this.genre = genre;
        this.season = season;
        this.type = type;
        this.producer = producer;
        this.source = source;
        this.plannedep = plannedep;
        this.currentep = currentep;
        this.country = country;
        this.duration = duration;
            
    }

  

    
    
    public byte[] getMyImage(){
        return animephoto;
    
    }
    public int getID(){
      return animeid;
    }
    
    public void setID(int ID){
        this.animeid = ID;
    }
    
    public String getName(){
        return animename;
    }
    
    public void setName(String Name){
        this.animename = Name;
    }
    public String getStudio(){
        return studio;
    }
    
    public void setStudio(String Studio){
        this.studio = Studio;
    }
    public String getGenre(){
        return genre;
    }
    
    public void setGenre(String Genre){
        this.genre = Genre;
    }
    public String getSeason(){
        return season;
    }
    
    public void setSeason(String Season){
        this.season = Season;
    }
    
    public String getType(){
        return type;
    }
    
    public void setType(String Type){
        this.type = Type;
    }
    public String getProducer(){
        return producer;
    }
    
    public void setProducer(String Producer){
        this.producer = Producer;
    }
    public String getSource(){
        return source;
    }
    
    public void setSource(String Source){
        this.source = Source;
    }
    
    
    public int getPlannedep(){
        return plannedep;
    }
    
    public void setPlannedep(int Plannedep){
        this.plannedep = Plannedep;
    }
    public int getCurrentep(){
        return currentep;
    }
    
    public void setCurrentep(int Currentep){
        this.currentep = Currentep;
    }
   
     public String getCountry(){
        return country;
    }
    
    public void setCountry(String Country){
        this.country = Country;
    }
    
    
    public String getDuration(){
        return duration;
    }
    
    public void setDuration(String Duration){
        this.duration = Duration;
    }
    
}