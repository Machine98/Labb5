package lab5.general;

import lab5.general.store.StartEvent;

public class EventQueue extends FIFO {
    private FIFO eventQueue;
    private Event event;

    public EventQueue() {
        eventQueue = new FIFO();
    }

    public void addEvent(StartEvent startEvent) {
        eventQueue.add(event);
    }

    public FIFO.Node getFirst(){
        return eventQueue.getFirst();
    }

    public Event getNext(){
        Event next = (Event) eventQueue.first();
        eventQueue.removeFirst();;
        return next;
    }

    public void Sort(EventQueue[] eventPlace) {
        boolean sorted = false;
        EventQueue temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < eventQueue.size() - 1; i++) {
                if (eventPlace[i].event.EventTime() > eventPlace[i+1].event.EventTime()) {
                    temp = eventPlace[i];
                    eventPlace[i] = eventPlace[i+1];
                    eventPlace[i+1] = temp;
                    sorted = false;
                }
            }
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
