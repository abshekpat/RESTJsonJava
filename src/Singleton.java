
public class Singleton {

    private static Singleton instance = null;
    public String s;
    private Singleton() {
        s = "Hello I am a string part of Singleton class";
    }

    public static Singleton method() {
        if(instance == null)
            instance = new Singleton();
        return instance;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Singleton x = Singleton.method();
        Singleton y = Singleton.method();
        Singleton z = Singleton.method();


        System.out.println("String from x is " + x.s);
        System.out.println("String from y is " + y.s);
        System.out.println("String from z is " + z.s);
        System.out.println("\n");

        x.s = (x.s).toUpperCase();

        System.out.println("String from x is " + x.s);
        System.out.println("String from y is " + y.s);
        System.out.println("String from z is " + z.s);
        System.out.println("\n");
    }

}
