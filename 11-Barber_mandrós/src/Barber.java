public class Barber extends Thread {

    public Barber(String nom){
        setName("Barber " + nom);
    }

    @Override
    public void run(){
        while(true){
            System.out.println("Ningú en espera\n" + getName() + " dormint");

            while (Barberia.barberia.seguentClient() != null) {
                Client client = Barberia.barberia.seguentClient();
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