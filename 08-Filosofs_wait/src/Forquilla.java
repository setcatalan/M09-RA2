public class Forquilla {

    private int num;
    private final int LLIURE = -1;
    private int propietari = LLIURE;
    
    public Forquilla(int num){
        this.num = num;
    }

    public void setNum(int num){this.num = num;}
    public int getNum(){return num;}

    public synchronized void setPropietari(int propietari){this.propietari = propietari;}
    public synchronized int getPropietari(){return propietari;}

    public synchronized void setLliure(){
        this.propietari = LLIURE;
        notifyAll();
    }
    public synchronized boolean isLliure(){return propietari == LLIURE;}
}
