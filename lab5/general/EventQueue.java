package lab5.general;

import lab5.general.store.StartEvent;

public class EventQueue extends FIFO {
    private FIFO eventQueue;
    private Event event;

    public EventQueue() {
        eventQueue = new FIFO();
    }

    public void addEvent(Event newEvent) {
        if(eventQueue.size() == 0) {
            eventQueue.add(newEvent);
        } else {
            for(int i = 0; i < eventQueue.size(); i++) {
                Event temp = (Event) eventQueue.getIndexValue(i);
                if(temp.EventTime() > event.EventTime()) {
                    eventQueue.add(newEvent);
                    break;
                }
                else if(i == eventQueue.size() - 1) {
                    eventQueue.add(newEvent);
                    break;
                }
            }
        }
    }

    public FIFO.Node getFirst(){
        return eventQueue.getFirst();
    }

    public Event getNext(){
        if (eventQueue.isEmpty() == true){
            return null;
        } else {
            Event next = (Event) eventQueue.first();
            eventQueue.removeFirst();;
            return next;
        }
    }

    public boolean nextEventExist() {
        if (eventQueue.isEmpty() == true){
            return false;
        } else{
            return true;
        }
    }
}
