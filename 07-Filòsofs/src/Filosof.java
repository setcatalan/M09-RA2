public class Filosof extends Thread{
    
    private Forquilla forquillaDreta;
    private Forquilla forquillaEsquerra;
    private int gana = 0;

    public Filosof(String nom, Forquilla forquillaEsquerra, Forquilla forquillaDreta){
        this.setName(nom);
        this.forquillaDreta = forquillaDreta;
        this.forquillaEsquerra = forquillaEsquerra;
    }

    public int numForquillaD(){return forquillaDreta.getNum();}
    public int numForquillaE(){return forquillaEsquerra.getNum();}

    private void menjar(){
        if (!forquillaEsquerra.isEnUS()){
            System.out.println("Filòsof: " + getName() + " agafa la forquilla esquerra " + forquillaEsquerra.getNum());
            forquillaEsquerra.setEnUs(true);
            if (!forquillaDreta.isEnUS()){
                System.out.println("Filòsof: " + getName() + " agafa la forquilla dreta " + forquillaDreta.getNum());
                forquillaDreta.setEnUs(true);
                System.out.println("Filòsof: " + getName() + " menja");
                gana = 0;
                try {
                    sleep(Math.round((Math.random() * 1000) + 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                System.out.println("Filòsof: " + getName() + " ha acabat de menjar");
                forquillaEsquerra.setEnUs(false);
                forquillaDreta.setEnUs(false);
                }
            } else {
                System.out.println("Filòsof: " + getName() + " deixa l'esquerra (" + forquillaEsquerra.getNum() + ") i espera (dreta ocupada)");
                forquillaEsquerra.setEnUs(false);
                gana++;
                System.out.println("Filòsof: " + getName() + " gana=" + gana);
                try {
                    sleep(Math.round(((Math.random() / 2)*1000) + 500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                menjar();
            }
        }
    }

    private void pensar(){
        System.out.println("Filòsof: " + getName() + " pensant");
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