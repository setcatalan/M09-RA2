public class Forquilla {

    private int num;
    private boolean enUs = false;
    
    public Forquilla(int num){
        this.num = num;
    }

    public void setNum(int num){this.num = num;}
    public int getNum(){return num;}

    public void setEnUs(boolean enUs){this.enUs = enUs;}
    public boolean isEnUS(){return enUs;}
}