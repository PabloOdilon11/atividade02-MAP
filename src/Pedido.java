import java.util.ArrayList;
import java.util.List;

public class Pedido implements Subject {

    private List<Observer> observers;
    private StatusPedido status;

    public Pedido() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
        notifyObservers();
    }

    public StatusPedido getStatus() {
        return status;
    }
}
