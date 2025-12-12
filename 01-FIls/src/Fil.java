public class Fil extends Thread{

    private String nom;
    private int delay;
    
    public Fil(String nom, int priority){
        this(nom, priority, 0);
    }

    public Fil(String nom, int priority, int delay){
        this.nom = nom;
        setPriority(priority);
        this.delay = delay;
    }

    @Override
    public void run(){
        if (delay == 0){
            for (int i = 0; i < 1000; i++){}
        }
        for (int i = 1; i < 10; i++){
            System.out.println("" + nom + " " + i);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Acaba el fil " + nom);
    }
}
