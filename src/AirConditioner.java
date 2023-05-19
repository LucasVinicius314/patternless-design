package src;

public class AirConditioner {

  private AirConditioner() {
    if (instance != null) {
      throw new IllegalStateException("AirConditioner already instantiated.");
    }
  }

  static AirConditioner instance;

  public static AirConditioner getInstance() {
    if (instance == null) {
      instance = new AirConditioner();
    }

    return instance;
  }
}
