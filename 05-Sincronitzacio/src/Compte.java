public class Compte{

    private static Compte instancia;
    public float saldo;

    private Compte(){
        this.saldo = 0;
    }

    public static float getSaldo(){return instancia.saldo;}
    public static void setSaldo(float saldo){instancia.saldo = saldo;}

    public static Compte getInstancia(){
        if(instancia == null){
            instancia = new Compte();
        }
        return instancia;
    }
}