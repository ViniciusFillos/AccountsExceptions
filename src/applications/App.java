package applications;

import model.entities.Account;
import model.exceptions.BusinessException;

import java.util.Locale;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        try(Scanner sc = new Scanner(System.in)) {

            System.out.println("Enter account data");
            System.out.print("Number: ");
            int number = sc.nextInt();
            System.out.print("Holder: ");
            sc.nextLine();
            String holder = sc.nextLine();
            System.out.print("Initial balance: ");
            double initialBalance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdrawLimit = sc.nextDouble();
            Account acc = new Account(number, holder, initialBalance, withdrawLimit);

            System.out.println();
            System.out.print("Enter the amount for withdraw: ");
            acc.withdraw(sc.nextDouble());
            System.out.printf("New balance: $ %.2f",acc.getBalance());
        } catch(BusinessException e){
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }
    }
}
