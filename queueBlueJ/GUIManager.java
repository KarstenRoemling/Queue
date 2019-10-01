public class GUIManager<T>{
    
    private final Class<T> type;
    
    public Queue<T> queue;
    public GUI gui;
    
    public GUIManager(Class<T> pType){
        queue = new Queue<T>();
        type = pType;
        gui = new GUI(this);
    }
    
    public void create(String pName){}
    
    public void add(T pElement){
        queue.enqueue(pElement);
    }
    
    public Queue<T> getQueue(){
        return queue;
    }
    
    public String getName(){
        return type.getSimpleName();
    }
}
