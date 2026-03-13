public class Barber extends Thread {

    public Barber(String nom){
        setName("Barber " + nom);
    }

    @Override
    public void run(){
        while(true){
            while (Barberia.barberia.seguentClient(getName()) != null) {
                Client client = Barberia.barberia.seguentClient(getName());
                System.out.println("Li toca al " + client.getNom());
                client.tallarseElCabell();
                try {
                    sleep(Math.round(Math.random() * 100) + 900);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}