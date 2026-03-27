public class Dona extends Thread{
    
    private BanyUnisex banyUnisex;

    public Dona(String nom, BanyUnisex banyUnisex){
        setName(nom);
        this.banyUnisex = banyUnisex;
    }

    @Override
    public void run(){

    }
}