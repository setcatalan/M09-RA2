public class Home extends Thread{
    
    private BanyUnisex banyUnisex;

    public Home(String nom, BanyUnisex banyUnisex){
        setName(nom);
        this.banyUnisex = banyUnisex;
    }

    @Override
    public void run(){

    }
}