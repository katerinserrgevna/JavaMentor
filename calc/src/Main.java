import java.util.Scanner;

public class Main {
    public static void main(String argv[]){
        Scanner in = new Scanner(System.in);
        Parser pars = new Parser(in.nextLine());
        pars.pars();
    }
}
