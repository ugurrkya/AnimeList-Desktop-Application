package AniColle;

public class ForUsers {
    
    private byte[] userpic;
    private String userid;
    private String password;
    private String nickname;
    private int age;
    private String email;

    
    public ForUsers(){}
    
    public ForUsers(byte[] image,String usid, String pass, String nick, int aged,String mail){
        
        this.userpic= image;
       
        this.userid = usid;
        this.password= pass;
        this.nickname = nick;
        this.age = aged;
        this.email = mail;
        
    }

   
    
    
    public byte[] getMyImage(){
        return userpic;
    
    }
  public String getID(){
      return userid;
    }
    
    public void setID(String ID){
        this.userid = ID;
    }
    
    public String getPass(){
        return password;
    }
    public void setPass(String Pass){
        this.password=Pass;
    }
    public String getNick(){
        return nickname;
    }
    
    public void setNick(String Nick){
        this.nickname = Nick;
    }
    
    public int getAged(){
        return age;
    }
    
    public void setAged(int Aged){
        this.age= Aged;
    }
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String Email){
        this.email = Email;
    }
   
     
    
}