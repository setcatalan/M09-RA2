import java.util.LinkedList;

public class Barberia extends Thread {
    
    public LinkedList<Client> salaEspera = new LinkedList<Client>();
    private int numMaxCadires;
    private Object condBarber = new Object();
    public static Barberia barberia;

    public Barberia(int numMaxCadires){
        this.numMaxCadires = numMaxCadires;
    }

    public Object getCondBarber(){return this.condBarber;}

    public Client seguentClient(){
        synchronized(condBarber){
            while (salaEspera.isEmpty()) {
                try {
                    condBarber.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
            return salaEspera.getFirst();
        }
    }

    public void entrarClient(Client client){
        synchronized(condBarber){
            if (salaEspera.size() == numMaxCadires){
                System.out.println("No queden cadires, " + client.getNom() + " se'n va");
            } else {
                System.out.println(client.getNom() + " en espera");
                salaEspera.add(client);
                condBarber.notifyAll();
            }
        }
    }

    @Override
    public void run(){
        for (int i = 1; i <= 10; i++){
            Client client = new Client(i);
            entrarClient(client);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 11; i <= 20; i++){
            Client client = new Client(i);
            entrarClient(client);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        barberia = new Barberia(3);
        Barber barber = new Barber("Pepe");
        
        barber.start();
        barberia.start();
    }
}