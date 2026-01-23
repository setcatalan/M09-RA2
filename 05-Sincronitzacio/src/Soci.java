public class Soci extends Thread{

    private Compte compte;
    private float aportacio;
    private int esperaMax;
    private double random;
    private int maxAnys;

    public Soci(){
        this.compte = Compte.getInstancia();
        this.aportacio = 10f;
        this.esperaMax = 100;
        this.random = Math.random();
        this.maxAnys = 10;
    }

    public Compte getCompte(){return compte;}

    @Override
    public void run(){
        for (int i = 0; i < maxAnys; i++){
            for (int j = 1; j <= 12; j++){
                synchronized(compte){
                if (j%2 == 1){
                    Compte.setSaldo(Compte.getSaldo() + aportacio); 
                } else {
                    Compte.setSaldo(Compte.getSaldo() - aportacio);
                }}
                try {
                    sleep(Math.round(random * esperaMax));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
