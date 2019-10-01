public class Queue<T>
{
    private QueueElement<T> head;
    private QueueElement<T> tail;
    
    public Queue()
    {
        head = null;
        tail = null;
    }

    public QueueElement<T> getHead(){
        return head;
    }
    
    public void setHead(QueueElement<T> pHead){
        head = pHead;
    }
    
    public QueueElement<T> getTail(){
        return tail;
    }
    
    public void setTail(QueueElement<T> pTail){
        tail = pTail;
    }
    
    public T front(){
        return head.get();
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public void enqueue(T pElement){
        QueueElement<T> queueElement = new QueueElement<T>(pElement);
        if(isEmpty()){
            head = queueElement;
            tail = queueElement;
            return;
        }
        tail.setNachfolger(queueElement);
        tail = queueElement;
    }
    
    public void dequeue(){
        if(!isEmpty()){
            head = head.getNachfolger();
            if(isEmpty()){
                tail = null;
            }
        }
    }
    
    public boolean containsQueueElement(String pName){
        QueueElement<T> currentQueueElement = getHead();
        while(currentQueueElement != null){
            if(currentQueueElement.get() instanceof NameObject){
                NameObject no = (NameObject)currentQueueElement.get();
                if(no.getName().equals(pName)){
                    return true;
                }
            }
            currentQueueElement = currentQueueElement.getNachfolger();
        }
        return false;
    }
}
