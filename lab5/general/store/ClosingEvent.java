package lab5.general.store;

import lab5.general.Event;

public class ClosingEvent extends Event {
    private Event event;

    @Override
    public void performEvent() {
        event.isOpen(false);
    }
}
