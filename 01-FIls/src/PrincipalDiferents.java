public class PrincipalDiferents {
    public static void main(String[] args) {
        Fil juan = new Fil("Juan", Thread.MAX_PRIORITY);
        Fil pepe = new Fil("Pepe", Thread.MIN_PRIORITY);

        pepe.start();
        juan.start();

        System.out.println("Acaba thread main");
    }
}
