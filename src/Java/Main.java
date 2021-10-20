
public class Main {
  public static void main(String[] args) {
        CSV csv = new CSV();
     AppData data = csv.load("in.csv");
        csv.save(data, "out.csv");
  }
}