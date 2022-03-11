package lab5.general;

public class EventQueue extends FIFO {
    private FIFO eventQueue;
    private Event event;

    public EventQueue() {
        eventQueue = new FIFO();
    }


    public void addEvent(Event newEvent) {
        eventQueue.add(newEvent);
    }


    public FIFO First(){
        return (FIFO) eventQueue.first();
    }

    public Event getNext(){
        Event newest = null;

        for (int i = 0; i < eventQueue.size(); i++) {
            Event temp = (Event) eventQueue.getIndex(i);
            if (newest == null){
                newest = (Event) eventQueue.first();
            }
            else if (newest.EventTime() > temp.EventTime()){
                newest = temp;
            }
        }

        return newest;
    }

    public boolean nextEventExist() {
        if (eventQueue.isEmpty() == true){
            return false;
        } else{
            return true;
        }
    }
}
