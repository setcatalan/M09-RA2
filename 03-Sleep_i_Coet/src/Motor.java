public class Motor extends Thread{
    
    private int pObjectiu;
    private int pActual;
    private boolean actiu;

    public Motor(int motor){
        super("Motor " + motor);
        pObjectiu = 0;
        pActual = 0;
        actiu = true;
    }

    public void setPotencia(int p){
        pObjectiu = p;
        if (p == 0){
            actiu = false;
        }
    }

    public void decrementaPotencia(){
        while (pActual > pObjectiu) {
            Long interval_aleatori = Math.round((Math.random() * 1000) + 1000);
            try {
                sleep(interval_aleatori);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("%s: Decre. Objectiu: %d Actual: %d", this.getName(), pObjectiu, pActual));
            pActual--;
        }
        System.out.println(String.format("%s: FerRes Objectiu: %d Actual: %d", this.getName(), pObjectiu, pActual));
    }

    public void incrementaPotencia(){
        while (pActual < pObjectiu) {
            Long interval_aleatori = Math.round((Math.random() * 1000) + 1000);
            System.out.println(String.format("%s: Incre. Objectiu: %d Actual: %d", this.getName(), pObjectiu, pActual));
            pActual++;
            try {
                sleep(interval_aleatori);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(String.format("%s: FerRes Objectiu: %d Actual: %d", this.getName(), pObjectiu, pActual));
    }

    @Override
    public void run(){
        while(actiu || pActual != pObjectiu){
            if (pObjectiu < pActual){
                pActual--;
                decrementaPotencia();
            } else if (pObjectiu > pActual){
                pActual++;
                incrementaPotencia();
            }
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
