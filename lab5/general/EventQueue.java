package lab5.general;

public class EventQueue {
    private FIFO eventQueue;
    private Event event;

    public EventQueue() {
        eventQueue = new FIFO();
    }

    public void addEvent() {
        eventQueue.add(event);
    }

    public boolean size(){
        if (eventQueue.size()>0){
            return true;
        }
        else{
            return false;
        }
    }


    public void Sort(EventQueue[] eventPlace) {
        boolean sorted = false;
        EventQueue temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < eventQueue.size() - 1; i++) {
                if (eventPlace[i].event.EventID() > eventPlace[i+1].event.EventID()) {
                    temp = eventPlace[i];
                    eventPlace[i] = eventPlace[i+1];
                    eventPlace[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }
}
