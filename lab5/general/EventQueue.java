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

    public void Sort(EventQueue[] a) {
        boolean sorted = false;
        EventQueue temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < eventQueue.size() - 1; i++) {
                if (a[i].event.EventID() > a[i+1].event.EventID()) {
                    temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }
}
