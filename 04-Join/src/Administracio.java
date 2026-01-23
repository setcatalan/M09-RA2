public class Administracio {
    
    private int num_poblacio_activa = 50;
    private Treballador[] poblacio_activa = new Treballador[num_poblacio_activa];

    public Administracio(){
        for (int i = 0; i < num_poblacio_activa; i++){
            poblacio_activa[i] = new Treballador(
                25000, 
                20, 
                65, 
                "Ciutadà-" + i
            );
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Administracio administracio = new Administracio();
        for(Treballador treballador: administracio.poblacio_activa){
            treballador.start();
            treballador.join();
            System.out.println(String.format("%-10s -> edat: %d / total: %3.2f", treballador.getName(), treballador.getEdat(), treballador.getCobrat()));
        }
    }
}
