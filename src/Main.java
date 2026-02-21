/**
 * Runnable entry point. Run this from IntelliJ (Run 'Main.main()') or: mvn exec:java -Dexec.mainClass="Main"
 */
public class Main {
    public static void main(String[] args) {
        ArraySolutions arraySolutions = new ArraySolutions();
        MathSolutions mathSolutions = new MathSolutions();

        System.out.println("Single Number [2,2,1]: " + arraySolutions.singleNumber(new int[]{2, 2, 1}));
        System.out.println("Fizz Buzz n=5: " + mathSolutions.fizzBuzz(5));
    }
}
