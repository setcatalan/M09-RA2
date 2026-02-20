public class Filosof extends Thread{
    
    private Forquilla forquillaDreta;
    private Forquilla forquillaEsquerra;
    
    private double iniciGana = System.currentTimeMillis();
    private double fiGana;
    private int gana;

    public Filosof(int numComensal, Forquilla forquillaEsquerra, Forquilla forquillaDreta){
        this.setName("Filosof-" + numComensal);
        this.forquillaDreta = forquillaDreta;
        this.forquillaEsquerra = forquillaEsquerra;
    }

    public int numForquillaD(){return forquillaDreta.getNum();}
    public int numForquillaE(){return forquillaEsquerra.getNum();}

    private void menjar(){
        agafarForquilles();
        fiGana = System.currentTimeMillis();
        System.out.println(getName() + ": menja amb gana " + calcularGana());
        try {
            sleep(Math.round((Math.random() * 1000) + 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + ": ha acabat de menjar");
        System.out.println(getName() + ": deixa les forquilles");
        deixarForquilles();
    }

    private void agafarForquilles(){
        agafarForquillaEsquerra();
        agafarForquillaDreta();
        System.out.println(getName() + ": té forquilles esq(" + numForquillaE() +") dreta(" + numForquillaD() +")");
    }

    private void agafarForquillaEsquerra(){
        forquillaEsquerra.agafar();
    }

    private void agafarForquillaDreta(){
        forquillaDreta.agafar();
    }
    
    private void deixarForquilles(){
        forquillaDreta.deixar();
        forquillaEsquerra.deixar();
    }

    private void pensar(){
        resetGana();
        System.out.println(getName() + ": pensant");
        try {
            sleep(Math.round((Math.random() * 1000) + 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int calcularGana(){
        gana = Math.toIntExact(Math.round((fiGana - iniciGana) / 1000));
        return gana;
    }

    private void resetGana(){
        iniciGana = System.currentTimeMillis();
    }

    @Override
    public void run(){
        while (true) {
            menjar();
            pensar();
        }
    }
}
