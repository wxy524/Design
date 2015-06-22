import java.util.ArrayList;

public class WeatherData implements Subject {
    private ArrayList<Observer> _observers;
    private float _temperature;
    private float _humidity;
    private float _pressure;

    public WeatherData() {
        _observers = new ArrayList<Observer>();
    }

    public void registerObserver(Observer o) {
        _observers.add(o);
    }

    public void removeObserver(Observer o) {
        int pos = _observers.indexOf(o);
        if(pos >= 0) {
            _observers.remove(pos);
        }
    }

    public void notifyObservers() {
        for(int i = 0; i < _observers.size(); i++) {
            Observer observer = _observers.get(i);
            observer.update(_temperature, _humidity, _pressure);
        }
    }


    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidiy, float pressure) {
        _temperature = temperature;
        _humidity = humidiy;
        _pressure = pressure;
        measurementsChanged();
    }

}