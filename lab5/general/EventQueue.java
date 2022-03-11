package lab5.general;

public class EventQueue extends FIFO {


    public void addEvent(Event newEvent) {
        this.add(newEvent);
    }


    public Event getNext(){
        Event newest = null;

        if (this.size() > 1){
            for (int i = 0; i < this.size(); i++) {
                Event temp = (Event) this.getIndex(i);
                if (newest == null){
                    newest = (Event) this.first();
                }
                else if (newest.EventTime() > temp.EventTime()){
                    newest = temp;
                }
            }
        } else{
            newest = (Event) this.first();
            this.removeFirst();
        }


        return newest;
    }

    public boolean nextEventExist() {
        if (this.isEmpty() == true){
            return false;
        } else{
            return true;
        }
    }
}
