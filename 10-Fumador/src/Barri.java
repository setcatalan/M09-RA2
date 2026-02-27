public class Barri {

    private Estanc estanc;
    private Fumador[] fumadors = new Fumador[3];

    public Barri(){
        estanc = new Estanc();
        for (int i = 0; i < fumadors.length; i++){
            fumadors[i] = new Fumador(i, estanc);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Barri barri = new Barri();

        for(Fumador fumador: barri.fumadors){
            fumador.start();
        }

        barri.estanc.start();

        for(Fumador fumador: barri.fumadors){
            fumador.join();
        }

        barri.estanc.tancarEstanc();
    }
}