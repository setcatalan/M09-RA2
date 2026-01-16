public class Motor extends Thread{
    
    private int pObjectiu;
    private int pActual;

    public Motor(int motor){
        super("Motor " + motor);
        pObjectiu = 0;
        pActual = 0;
    }

    public void setPotencia(int p){
        pObjectiu = p;
        run();
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
    }

    public void incrementaPotencia(){
        while (pActual < pObjectiu) {
            Long interval_aleatori = Math.round((Math.random() * 1000) + 1000);
            try {
                sleep(interval_aleatori);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("%s: Incre. Objectiu: %d Actual: %d", this.getName(), pObjectiu, pActual));
            pActual++;
        }
    }

    @Override
    public void run(){
        if (pObjectiu < pActual){
            pActual--;
            decrementaPotencia();
        } else if (pObjectiu > pActual){
            pActual++;
            incrementaPotencia();
        }
        System.out.println(String.format("%s: FerRes Objectiu: %d Actual: %d", this.getName(), pObjectiu, pActual));
    }

    public static void main(String[] args) throws InterruptedException {
        Motor motor = new Motor(1);
        Motor motor2 = new Motor(2);

        motor.setPotencia(3);
        motor2.setPotencia(3);

        while (motor.isAlive() || motor2.isAlive()) {
        }

        motor.setPotencia(0);
        motor2.setPotencia(0);
    }
}
