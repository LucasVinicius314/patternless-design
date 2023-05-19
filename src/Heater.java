package src;

interface IHeater {

  public double getTemp(Temperature temperature, double celsiusTemp);
}

interface IConverterHeater {

  public double getFahrenheitTemp(double celsiusTemp);

  public double getKelvinTemp(double celsiusTemp);
}

class FahrenheitHeater implements IConverterHeater {

  public double getFahrenheitTemp(double celsiusTemp) {
    return celsiusTemp * 1.8 + 32;
  }

  public double getKelvinTemp(double celsiusTemp) {
    return 0;
  }
}

class KelvinHeater implements IConverterHeater {

  public double getFahrenheitTemp(double celsiusTemp) {
    return 0;
  }

  public double getKelvinTemp(double celsiusTemp) {
    return celsiusTemp + 273.15;
  }
}

class HeaterAdapter implements IHeater {

  IConverterHeater converterHeater;

  public HeaterAdapter(Temperature temperature) {
    switch (temperature) {
      case FAHRENHEIT:
        converterHeater = new FahrenheitHeater();
        break;
      case KELVIN:
        converterHeater = new KelvinHeater();
        break;
      default:
        break;
    }
  }

  public double getTemp(Temperature temperature, double celsiusTemp) {
    switch (temperature) {
      case FAHRENHEIT:
        return converterHeater.getFahrenheitTemp(celsiusTemp);
      case KELVIN:
        return converterHeater.getKelvinTemp(celsiusTemp);
      default:
        return 0;
    }
  }
}

enum Temperature {
  FAHRENHEIT,
  KELVIN,
}

public class Heater implements IHeater {

  public double getTemp(Temperature temperature, double celsiusTemp) {
    return new HeaterAdapter(temperature).getTemp(temperature, celsiusTemp);
  }
}
