public class Associacio {
    
    private int numSocis = 1000;
    private Soci[] socis = new Soci[numSocis];

    public Associacio(){
        for (int i = 0; i < numSocis; i++){
            socis[i] = new Soci();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Associacio associacio = new Associacio();

        iniciaTempsCompteSocis(associacio);
        esperaPeriodeSocis(associacio);
        System.out.println(Compte.getSaldo());
    }

    public static void iniciaTempsCompteSocis(Associacio associacio){
        for (Soci soci: associacio.socis){
            soci.start();
        }
    }

    public static void esperaPeriodeSocis(Associacio associacio) throws InterruptedException{
        for (Soci soci: associacio.socis){
            soci.join();
        }
    }
}
