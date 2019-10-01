public class QueueElement<T>
{
    
    private QueueElement<T> nachfolger;
    private T object;
    
    public QueueElement(T pObject){
        nachfolger = null;
        object = pObject;
    }
    
    public QueueElement getNachfolger(){
        return nachfolger;
    }
    
    public void setNachfolger(QueueElement pNachfolger){
        nachfolger = pNachfolger;
    }
    
    public T get(){
        return object;
    }
}
