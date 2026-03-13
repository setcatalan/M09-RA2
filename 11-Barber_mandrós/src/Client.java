public class Client {
    
    private String nom;

    public Client(int id){
        this.nom = "Client-" + id;
    }

    public void tallarseElCabell(){
        System.out.println("Tallant cabell a " + nom);
        Barberia.barberia.salaEspera.remove(this);
    }

    public String getNom(){return this.nom;}
}