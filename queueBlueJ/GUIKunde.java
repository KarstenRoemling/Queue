public class GUIKunde extends GUIManager<Kunde>{
    public GUIKunde(){
        super(Kunde.class);
    }
    
    public void create(String pName){
        add(new Kunde(pName));
    }
}