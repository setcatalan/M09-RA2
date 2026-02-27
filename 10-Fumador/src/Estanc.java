import java.util.ArrayList;
import java.util.List;

public class Estanc extends Thread{

    private List<Tabac> tabac;
    private List<Paper> paper;
    private List<Llumi> llumi;
    private boolean obert;

    public Estanc(){
        tabac = new ArrayList<Tabac>();
        paper = new ArrayList<Paper>();
        llumi = new ArrayList<Llumi>();
    }

    public void nouSubministrament(){
        double rnd = Math.random();

        if (rnd > 0.66){
            addTabac();
        } else if (rnd < 0.33){
            addPaper();
        } else {
            addLlumi();
        }
    }

    private synchronized void addTabac(){
        System.out.println("Afegint tabac");
        tabac.add(new Tabac());
        notifyAll();
    }
    public synchronized Tabac venTabac(){
        while(tabac.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Tabac t = tabac.get(tabac.size() - 1);
        tabac.remove(t);
        return t;
    }

    private synchronized void addPaper(){
        System.out.println("Afegint paper");
        paper.add(new Paper());
        notifyAll();
    }
    public synchronized Paper venPaper(){
        while(paper.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Paper p = paper.get(paper.size() - 1);
        paper.remove(p);
        return p;
    }

    private synchronized void addLlumi(){
        System.out.println("Afegint llumi");
        llumi.add(new Llumi());
        notifyAll();
    }
    public synchronized Llumi venLlumi(){
        while(llumi.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Llumi l = llumi.get(llumi.size() - 1);
        llumi.remove(l);
        return l;
    }

    public void tancarEstanc(){
        this.obert = false;
        System.out.println("Estanc tancat");
    }

    @Override
    public void run(){
        obert = true;
        System.out.println("Estanc obert");
        while(obert){
            nouSubministrament();
            try {
                sleep(Math.round((Math.random() * 1000) + 500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}