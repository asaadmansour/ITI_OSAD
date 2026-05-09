import java.util.ArrayList;
import java.util.List;

public class BookObserver implements Subject{
    private List<Observer> users;
    private boolean isAvailable;
    public BookObserver(List<Observer> users) {
        this.users = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer user) {
        users.add(user);
    }

    @Override
    public void removeObserver(Observer user) {
        users.remove(user);
    }


    public void setAvailability(boolean isAvailable) {
        this.isAvailable = isAvailable;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (Observer user : users) {
            user.update(this.isAvailable);
        }
    }
}
