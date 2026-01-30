public class Assistent extends Thread{

    private Esdeveniment esdeveniment;

    public Assistent(String nom, Esdeveniment esdeveniment){
        setName(nom);
        this.esdeveniment = esdeveniment;
    }

    @Override
    public void run(){
        while (true) {
            double aleatori = Math.random();

            if (aleatori > 0.7){
                esdeveniment.ferReserva(this);
            } else {
                esdeveniment.cancelaReserva(this);
            }

            try {
                sleep(Math.round(aleatori * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }   
        }
    }
}