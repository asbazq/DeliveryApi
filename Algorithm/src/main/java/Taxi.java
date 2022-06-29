enum taxiState {
    operating, // 운행중
    waiting // 일반
}

public class Taxi extends Vehicle {
    int taxiNum;
    int oil;
    float speed = 0;
    String destination = "";
    int norDistance = 1000; // 1000m
    int destDisttance;
    int rate = 2500;
    int disRate = 100;
    int totalRate = 0;
    public taxiState state;
    int curPassenger = 0;

    public void setState(taxiState nextState) { //default의 값을 쓰기 위한 접근 함수.
        state = nextState;
    }

    public boolean checkOil() {
        return oil < 10 ? false : true;
    }

    public Taxi(int num) {
        taxiNum = num;
        if (!checkOil())
            return; // 탑승 불가
        setState(taxiState.waiting);
    }

    public void take(int passenger) {
        if (state == taxiState.operating)
            return;
        curPassenger += passenger;
        setState(taxiState.operating);
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void accelerate(float speed)
    {
        if(!checkOil())
            return;
        this.speed += speed;
    }

    public void decelerate(float speed)
    {
        if(!checkOil())
            return;
        this.speed -= speed;
    }

    public void charge() {
        if (norDistance <= destDisttance) {
            totalRate = rate + (destDisttance - norDistance) * disRate;
        }
    }

    public void getTotalRate() {
        System.out.println(totalRate);
    }

}

