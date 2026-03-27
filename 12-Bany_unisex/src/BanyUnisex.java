import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class BanyUnisex {

    private final int BANY_BUIT = 1;
    private final int BANY_AMB_HOMES = 2;
    private final int BANY_AMB_DONES = 3;

    private int estatActual = BANY_BUIT;
    private int ocupants = 0;

    private final int CAPACITAT_MAX = 3;

    private Semaphore capacitat = new Semaphore(CAPACITAT_MAX, true);

    private ReentrantLock lockEstat = new ReentrantLock(true);

    public void entraHome(){
        lockEstat.lock();
        if (estatActual != BANY_AMB_DONES){
            capacitat.tryAcquire();
            estatActual = BANY_AMB_HOMES;
            ocupants++;
        }
        lockEstat.unlock();
    }

    public void entraDona(){
        lockEstat.lock();
        if (estatActual != BANY_AMB_HOMES){
            capacitat.tryAcquire();
            estatActual = BANY_AMB_DONES;
            ocupants++;
        }
        lockEstat.unlock();
    }

    public void surtHome(){
        lockEstat.lock();
        ocupants--;
        if (ocupants == 0) {
            estatActual = BANY_BUIT;
        }
        lockEstat.unlock();
    }

    public void surtDona(){
        lockEstat.lock();
        ocupants--;
        if (ocupants == 0) {
            estatActual = BANY_BUIT;
        }
        lockEstat.unlock();
    }

    public static void main(String[] args) {

        Home[] homes = new Home[5];
        Dona[] dones = new Dona[5];

        BanyUnisex banyUnisex = new BanyUnisex();
  
        for(int i = 0; i < homes.length; i++){
            homes[i] = new Home("Home" + i, banyUnisex);
            dones[i] = new Dona("Dona" + i, banyUnisex);
        }

        for(int i = 0; i < homes.length; i++){
            homes[i].start();
            dones[i].start();
        }
    }
}