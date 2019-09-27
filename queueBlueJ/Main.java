public abstract class Main{
    
    public static Queue queue;
    public static GUI gui;
    
    public Main(){
    
    }
    
    public static void main(String[] args){
        queue = new Queue();
        gui = new GUI(queue);
    }
    
}
