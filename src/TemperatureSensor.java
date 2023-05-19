package src;

import java.util.ArrayList;
import java.util.List;

public class TemperatureSensor {
  private List<Observer> observers = new ArrayList<>();
  private int state;

  public void setState(int state) {
    this.state = state;
    notifyAllObservers();
  }

  public int getState() {
    return state;
  }

  public void attach(Observer observer) {
    observers.add(observer);
  }

  public void notifyAllObservers() {
    for (Observer observer : observers) {
      observer.update();
    }
  }
}

abstract class Observer {
  protected TemperatureSensor temperatureSensor;

  public abstract void update();
}

class BaseObserver extends Observer {
  public BaseObserver(TemperatureSensor temperatureSensor) {
    this.temperatureSensor = temperatureSensor;
    this.temperatureSensor.attach(this);
  }

  @Override
  public void update() {
    System.out.println("Base: " + temperatureSensor.getState());
  }
}

class DoubledObserver extends Observer {
  public DoubledObserver(TemperatureSensor temperatureSensor) {
    this.temperatureSensor = temperatureSensor;
    this.temperatureSensor.attach(this);
  }

  @Override
  public void update() {
    System.out.println("Base: " + temperatureSensor.getState() * 2);
  }
}

class TripledObserver extends Observer {
  public TripledObserver(TemperatureSensor temperatureSensor) {
    this.temperatureSensor = temperatureSensor;
    this.temperatureSensor.attach(this);
  }

  @Override
  public void update() {
    System.out.println("Base: " + temperatureSensor.getState() * 3);
  }
}
