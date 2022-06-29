

public class Main {
    public static void main(String[] args) {
        Bus mybus = new Bus(127);
//        mybus.setSpeed(1000);
        mybus.oil += 1000;
        mybus.accelerate(10);
        System.out.println(mybus.speed);
        mybus.accelerate(120);
        System.out.println(mybus.speed);


    }
}
