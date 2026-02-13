public class Filosof extends Thread{
    
    private Forquilla forquillaDreta;
    private Forquilla forquillaEsquerra;
    private int numComensal;
    private int gana = 0;

    public Filosof(int numComensal, Forquilla forquillaEsquerra, Forquilla forquillaDreta){
        this.setName("Filosof-" + numComensal);
        this.numComensal = numComensal;
        this.forquillaDreta = forquillaDreta;
        this.forquillaEsquerra = forquillaEsquerra;
    }

    public int numForquillaD(){return forquillaDreta.getNum();}
    public int numForquillaE(){return forquillaEsquerra.getNum();}

    private void menjar(){
        agafarForquilles();
        System.out.println(getName() + ": menja");
        try {
            sleep(Math.round((Math.random() * 1000) + 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gana = 0;
        System.out.println(getName() + ": ha acabat de menjar");
        deixarForquilles();
    }

    private void agafarForquilles(){
        boolean teLesDues = false;
        
        while(!teLesDues){

            if(!teLesDues){
                try {
                    sleep(Math.round((Math.random() * 500) + 500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            synchronized(forquillaEsquerra){
                while(!forquillaEsquerra.isLliure()){
                    try {
                        forquillaEsquerra.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                agafarForquillaEsquerra();
                
                synchronized(forquillaDreta){
                    if(forquillaDreta.isLliure()){
                        agafarForquillaDreta();
                        teLesDues = true;
                    } else {
                        deixarForquilles();
                        System.out.println(getName() + ": deixa l'esquerra(" + forquillaEsquerra.getNum() + ") i espera (dreta ocupada)");
                        gana++;
                        System.out.println(getName() + ": gana=" + gana);
                    }
                }
            }
        }
    }

    private void agafarForquillaEsquerra(){
        forquillaEsquerra.setPropietari(numComensal);
        System.out.println(getName() + ": agafa la forquilla esquerra " + forquillaEsquerra.getNum());
    }

    private void agafarForquillaDreta(){
        forquillaDreta.setPropietari(numComensal);
        System.out.println(getName() + ": agafa la forquilla dreta " + forquillaDreta.getNum());
    }
    
    private void deixarForquilles(){
        synchronized(forquillaEsquerra){
            if(forquillaEsquerra.getPropietari() == numComensal){
                forquillaEsquerra.setLliure();
            }
        }

        synchronized(forquillaDreta){
            if(forquillaDreta.getPropietari() == numComensal){
                forquillaDreta.setLliure();
            }
        }
    }

    private void pensar(){
        System.out.println(getName() + ": pensant");
        try {
            sleep(Math.round((Math.random() * 1000) + 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        while (true) {
            menjar();
            pensar();
        }
    }
}
