public class GUITest extends GUIManager<Test>{
    public GUITest(){
        super(Test.class);
    }
    
    public void create(String pName){
        add(new Test());
    }
}