public class DormAleatori extends Thread{

    private Long inici;
    private int num_iteració;

    public DormAleatori(String nom){
        super(nom);
        inici = System.currentTimeMillis();
        num_iteració = 0;
    }

    @Override
    public void run(){
        while (num_iteració < 10) {
            Long interval_aleatori = Math.round(Math.random() * 1000);
            System.out.println(String.format("%-4s(%d) a dormir %4dms total %5dms", this.getName(), num_iteració, interval_aleatori, (System.currentTimeMillis() - inici)));
            try {
                sleep(interval_aleatori);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num_iteració++;
        }
    
    }

    public static void main(String[] args) {
        DormAleatori joan = new DormAleatori("Joan");
        DormAleatori pep = new DormAleatori("Pep");

        joan.start();
        pep.start();

        System.out.println("---- Fi de main -----------------");
    }
}