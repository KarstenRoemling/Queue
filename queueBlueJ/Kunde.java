public class Kunde extends NameObject
{
    private int alter;
    private double geld;
    private String name;
    
    public Kunde()
    {
        super("");
        alter = 0;
        geld = 0.0;
    }
    
    public Kunde(String pName){
        super(pName);
        alter = 0;
        geld = 0.0;
    }
    
    public Kunde(int pAlter, double pGeld, String pName){
        super(pName);
        alter = pAlter;
        geld = pGeld;
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
}
