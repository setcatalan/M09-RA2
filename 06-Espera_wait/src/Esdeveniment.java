import java.util.ArrayList;
import java.util.List;

public class Esdeveniment {
    
    private List<Assistent> assistents = new ArrayList<>();
    private int placesDisponibles;

    public Esdeveniment(int numPlacesMax){
        this.placesDisponibles = numPlacesMax;
    }

    public synchronized void ferReserva(Assistent assistent){
        while (placesDisponibles <= 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        assistents.add(assistent);
        placesDisponibles--;
        System.out.print(assistent.getName() + " ha fet una reserva. ");
        System.out.println("Places disponibles: " + placesDisponibles);
    }

    public synchronized void cancelaReserva(Assistent assistent){
        if (assistents.contains(assistent)){
            assistents.remove(assistent);
            placesDisponibles++;
            System.out.print(assistent.getName() + " ha cancel·lat una reserva. ");
            System.out.println("Places disponibles: " + placesDisponibles);
            notifyAll();
        } else {
            System.out.print(assistent.getName() + " no ha pogut cancel·lar una reserva inexistent. ");
            System.out.println("Places disponibles: " + placesDisponibles);
        }
    }
}