public class MainDemoFil {
    public static void main(String[] args) {
        Thread main = Thread.currentThread();

        System.out.println("MainDemoFil.main:");
        System.out.print("Prioritat -> " + main.getPriority());
        System.out.println(", Nom -> " + main.getName());
        System.out.println("toString() -> " + main.toString());
    }
}
