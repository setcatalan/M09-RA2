import java.util.Scanner;

public class Coet {

    private static Motor motor0 = new Motor(0);
    private static Motor motor1 = new Motor(1);
    private static Motor motor2 = new Motor(2);
    private static Motor motor3 = new Motor(3);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        motor0.start();
        motor1.start();
        motor2.start();
        motor3.start();

        int p = scanner.nextInt();
        while (p != 0) {
            passaAPotencia(p);
            p = scanner.nextInt();
        }
        
        passaAPotencia(p);
        scanner.close();
    }

    public static void passaAPotencia(int p){
        if (p > 10){
            System.out.println("La potència no pot ser superior a 10");
        } else if (p < 0){
            System.out.println("La potència no pot ser menor que 0");
        } else {
            System.out.println("Passant a pòtencia " + p);
            motor0.setPotencia(p);
            motor1.setPotencia(p);
            motor2.setPotencia(p);
            motor3.setPotencia(p);
        }
    }
}
