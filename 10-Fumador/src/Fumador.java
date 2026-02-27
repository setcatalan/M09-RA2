public class Fumador extends Thread{
 
    private Estanc estanc;
    private int id;

    private Tabac tabac;
    private Paper paper;
    private Llumi llumi;

    private int fumades;

    public Fumador(int id, Estanc estanc){
        this.id = id;
        this.estanc = estanc;
        setName("Fumador " + this.id);
    }

    public void fuma(){
        if(tabac != null && paper != null && llumi != null){
            System.out.println(getName() + " fumant");
            try {
                sleep(Math.round((Math.random() * 500) + 500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fumades++;
            System.out.println(getName() + " ha fumat " + fumades + " vegades");
        }
    }

    public void compraTabac(){
        System.out.println(getName() + " comprant Tabac");
        tabac = estanc.venTabac();
    }

    public void compraPaper(){
        System.out.println(getName() + " comprant Paper");
        paper = estanc.venPaper();
    }

    public void compraLlumi(){
        System.out.println(getName() + " comprant Llumi");
        llumi = estanc.venLlumi();
    }

    @Override
    public void run(){
        while(fumades < 3){
            compraTabac();
            compraPaper();
            compraLlumi();
            fuma();
        }
    }
}