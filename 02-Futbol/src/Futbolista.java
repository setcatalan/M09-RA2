public class Futbolista extends Thread {

    private int ngols;
    private int ntirades;
    
    static int NUM_JUGADORS = 11;
    static int NUM_TIRADES = 20;
    static float PROBABILITAT = 0.5f;

    public Futbolista(String name){
        super(name);
        ngols = 0;
        ntirades = 0;
    }

    @Override
    public void run(){
        while(ntirades < NUM_TIRADES) {
            if (Math.random() <= PROBABILITAT){
                ngols++;
            }
            ntirades++;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        String[] noms = {"Piqué", "Vinicius", "Torres", "Ramos", "Ronaldo", 
                        "Lewan", "Belli", "Arnau", "Aspas", "Messi", "MBapé"};
        Futbolista[] futbolistas = new Futbolista[NUM_JUGADORS];

        for (int i = 0; i < NUM_JUGADORS; i++){
            Futbolista futbolista = new Futbolista(noms[i]);
            futbolistas[i] = futbolista;
        }

        System.out.println("Inici dels xuts ---------------");

        for (Futbolista futbolista: futbolistas){
            futbolista.start();
            futbolista.join();
        }

        System.out.println("Fi dels xuts -------------------");
        System.out.println("--- Estadístiques --------------");

        for (Futbolista futbolista: futbolistas){
            System.out.println(String.format("%-8s -> %2d gols", futbolista.getName(), futbolista.ngols));
        }
    }
}
