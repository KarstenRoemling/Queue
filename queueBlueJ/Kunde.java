public class Kunde
{
    private int alter;
    private double geld;
    private String name;
    private Kunde nachfolger;
    
    public Kunde()
    {
        alter = 0;
        geld = 0.0;
        name = "";
        nachfolger = null;
    }
    
    public Kunde(String pName){
        alter = 0;
        geld = 0.0;
        name = pName;
        nachfolger = null;
    }
    
    public Kunde(int pAlter, double pGeld, String pName){
        alter = pAlter;
        geld = pGeld;
        name = pName;
        nachfolger = null;
    }

    public int getAlter(){
        return alter;
    }
    
    public void setAlter(int pAlter){
        alter = pAlter;
    }
    
    public double getGeld(){
        return geld;
    }
    
    public void setGeld(double pGeld){
        geld = pGeld;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String pName){
        name = pName;
    }
    
    public Kunde getNachfolger(){
        return nachfolger;
    }
    
    public void setNachfolger(Kunde pNachfolger){
        nachfolger = pNachfolger;
    }
}
