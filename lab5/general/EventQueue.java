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

    public void sort() {
        int x = eventQueue.size();
        for (int i = 1; i < x; i++) {
            int temp = event.eventID(eventQueue.getIndexValue(i));
            int y = i - 1;
            while (y >= 0 && event.eventID(eventQueue.getIndexValue(y)) > temp) {
                eventQueue.getIndex(y + 1) = eventQueue.getIndex(y);
                y--;
            }
            event.eventID(eventQueue.getIndex(y + 1)) = temp;
        }
    }
}
