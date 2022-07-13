public class Main {
    public static void main(String[] args){
        Jackass jax = new Jackass();
        jax.Q();
        Leeshin blind = new Leeshin();

        Attack(jax);
        Attack(blind);
    }

    public static void Attack(Champion camp)
    {
        camp.Q();
    }
}
