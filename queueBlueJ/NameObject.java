public abstract class NameObject
{
    protected String name;
    
    public NameObject(){
        name = "";
    }
    
    public NameObject(String pName){
        name = pName;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String pName){
        name = pName;
    }
}
