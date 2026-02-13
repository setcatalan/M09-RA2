public class Taula {
    
    private Filosof[] comensals;
    private Forquilla[] forquilles;

    public Taula(int numFil){
        forquilles = new Forquilla[numFil];
        for (int i = 0; i < numFil; i++){
            forquilles[i] = new Forquilla(i);
        }

        comensals = new Filosof[numFil];
        for (int i = 0; i < numFil; i++){
            if (i+1 == numFil){
                comensals[i] = new Filosof(i, forquilles[i], forquilles[0]);
            } else {
                comensals[i] = new Filosof(i, forquilles[i], forquilles[i+1]);
            }
        }
    }

    public void showTaula(){
        for (Filosof comensal: comensals){
            System.out.println(String.format("Comensal: %s esq:%d dret:%d", 
                comensal.getName(), comensal.numForquillaE(), comensal.numForquillaD())
            );
        }
    }

    public void cridarATaula(){
        for (Filosof filosof: comensals){
            filosof.start();
        }
    }

    public static void main(String[] args) {
        Taula taula = new Taula(4);
        taula.showTaula();
        System.out.println("------------------");
        taula.cridarATaula();
    }
}