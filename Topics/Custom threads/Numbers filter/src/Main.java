import java.util.Scanner;

class NumbersFilter extends Thread {

    private final Scanner scanner = new Scanner(System.in);


    @Override
    public void run() {
        int n = scanner.nextInt();
        while (n != 0) {
            if (n % 2 == 0) {
                System.out.println(n);
            }
            n = scanner.nextInt();
        }



    }
}