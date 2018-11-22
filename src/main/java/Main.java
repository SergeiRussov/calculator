import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите номер операции:");
        System.out.println("1.Сложить");
        System.out.println("2.Вычесть");
        System.out.println("2.Умножить");
        System.out.println("2.Разделить");
        System.out.println("5.Вычислить процент");

        int n = Integer.parseInt(bufferedReader.readLine());

        System.out.print("Введите число x: ");
        double x = Double.parseDouble(bufferedReader.readLine());

        System.out.print("Введите число y: ");
        double y = Double.parseDouble(bufferedReader.readLine());

        switch (n) {
            case 1:
                System.out.println(Calculations.toAdd(x, y));
                break;
            case 2:
                System.out.println(Calculations.toSubstract(x, y));
                break;
            case 3:
                System.out.println(Calculations.toMultiply(x, y));
                break;
            case 4:
                System.out.println(Calculations.toSplit(x, y));
                break;
            case 5:
                System.out.println(Calculations.calculatePercentage(x, y));
                break;
            default:
                System.out.println("Такой комманды нет! Введите номер команды.");
        }

        bufferedReader.close();*/

        new App().start(args);

    }
}
