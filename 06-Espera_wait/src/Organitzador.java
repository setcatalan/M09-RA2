public class Organitzador {
    public static void main(String[] args) {
        Esdeveniment esdeveniment = new Esdeveniment(5);

        Assistent[] assistents = new Assistent[10];

        for(int i = 0; i < assistents.length; i++){
            Assistent assistent = new Assistent("Assistent-" + i, esdeveniment);
            assistents[i] = assistent;
        }

        for(Assistent assistent: assistents){
            assistent.start();
        }
    }
}