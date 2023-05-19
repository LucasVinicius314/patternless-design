package src;

public class App {

  public static void main(String[] args) {

    final var airConditioner = AirConditioner.getInstance();

    airConditioner.toString();

    final var subject = new TemperatureSensor();

    new BaseObserver(subject);
    new DoubledObserver(subject);
    new TripledObserver(subject);

    System.out.println("First state change: 15.");
    subject.setState(15);
    System.out.println("Second state change: 10.");
    subject.setState(10);

    final var heater = new Heater();

    System.out.println(heater.getTemp(Temperature.FAHRENHEIT, 49));
    System.out.println(heater.getTemp(Temperature.KELVIN, 49));
  }
}
