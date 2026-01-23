import java.util.Random;

public class Treballador extends Thread{
    
    private float sou_anual_brut;
    private int edat_inici_treball;
    private int edat_fi_treball;
    private int edat_actual;
    private float cobrat;
    private Random rnd;

    public Treballador(int sou_anual_brut, int edat_inici_treball, int edat_fi_treball, String nom){
        this.sou_anual_brut = sou_anual_brut;
        this.edat_inici_treball = edat_inici_treball;
        this.edat_fi_treball = edat_fi_treball;
        this.edat_actual = 0;
        this.cobrat = 0.0f;
        this.setName(nom);
    }

    public float getCobrat(){return this.cobrat;}
    public int getEdat(){return this.edat_actual;}

    public void cobra(){
        cobrat += sou_anual_brut/12;
    }

    public void pagaImpostos(){
        cobrat -= (sou_anual_brut/12)*24/100;
    }

    @Override
    public void run(){
        while (edat_actual < edat_inici_treball) {
            edat_actual++;
        }
        while (edat_actual < edat_fi_treball) {
            for (int i = 0; i < 12; i++){
                cobra();
                pagaImpostos();
            }
            edat_actual++;
        }
    }
}
