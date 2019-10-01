public class GUIAuto extends GUIManager<Auto>{
    public GUIAuto(){
        super(Auto.class);
    }
    
    public void create(String pName){
        add(new Auto(pName));
    }
}