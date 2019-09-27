public class Queue
{
    private Kunde head;
    private Kunde tail;
    
    public Queue()
    {
        head = null;
        tail = null;
    }

    public Kunde getHead(){
        return head;
    }
    
    public void setHead(Kunde pHead){
        head = pHead;
    }
    
    public Kunde getTail(){
        return tail;
    }
    
    public void setTail(Kunde pTail){
        tail = pTail;
    }
    
    public Kunde front(){
        return head;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public void enqueue(Kunde pKunde){
        if(isEmpty()){
            head = pKunde;
            tail = pKunde;
            return;
        }
        tail.setNachfolger(pKunde);
        tail = pKunde;
    }
    
    public void dequeue(){
        if(!isEmpty()){
            head = head.getNachfolger();
        }
    }
}
