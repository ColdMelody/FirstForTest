package headfirst;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Bill on 2016/8/12.
 */
public class WeatherData extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;
    public WeatherData(){
    }
    public void measurementsChanged(){
        setChanged();
        notifyObservers();
    }
    public void setMeasurements(float temperature,float humidity,float pressure){
        this.temperature=temperature;
        this.humidity=humidity;
        this.pressure=pressure;
        measurementsChanged();
    }
    public float getTemperature(){
        return temperature;
    }
    public float getHumidity(){
        return humidity;
    }
    public float getPressure(){
        return pressure;
    }
    public static void main(String[] args){
        WeatherData observable=new WeatherData();
        Observer observer=new CurrentConditionsDisplay(observable);
        observable.setMeasurements(5.5f,106.0f,5.0f);
    }
}
class CurrentConditionsDisplay implements Observer{
    Observable observable;
    private float temperature;
    private float humidity;
    public CurrentConditionsDisplay(Observable observable){
        this.observable=observable;
        observable.addObserver(this);
    }
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData){
            WeatherData weatherData= (WeatherData) o;
            this.temperature=weatherData.getTemperature();
            this.humidity=weatherData.getHumidity();
            display();
        }
    }
    private void display(){
        System.out.println("Current Conditions: "+temperature+"F degresss and "+humidity+"% humidity");
    }
}
