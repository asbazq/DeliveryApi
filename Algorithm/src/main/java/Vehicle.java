public abstract class Vehicle { // 추상클래스 > 오버라이딩 필수
    public float oil;
    public float speed;

    public boolean CheckOil( ) {
        if(oil < 10)
        {
            System.out.println("주유량을 확인해라.");
            return false;
        }
        return true;
    }

    public void accelerate(float speed)
    {
        if(!CheckOil())
            return;
        this.speed += speed;
    }

    public void decelerate(float speed)
    {
        if(!CheckOil())
            return;
        this.speed -= speed;
    }

}
