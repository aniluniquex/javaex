import java.util.*;

class AccountDetails {
    private String cid;
    private int ano;
    private double inibal;

    void readAccountDetails() {
        Scanner s = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter CustomerId:");
                cid = s.next();
                if (!(Character.isLetter(cid.charAt(0)) &&
                      Character.isDigit(cid.charAt(1)) &&
                      Character.isDigit(cid.charAt(2)) &&
                      Character.isDigit(cid.charAt(3)))) {
                    throw new Exception("Customer ID must start with a letter and should be followed by three digits");
                }
            } catch (Exception e) {
                System.out.println(e);
                continue;
            }
            try {
                System.out.println("Enter accountNumber:");
                ano = s.nextInt();
                if (String.valueOf(ano).length() != 5) {
                    throw new Exception("Account number must be of five digits");
                }
            } catch (Exception e) {
                System.out.println(e);
                continue;
            }
            try {
                System.out.println("Enter InitialBalance:");
                inibal = s.nextDouble();
                if (inibal <= 1000) {
                    throw new Exception("Initial balance must be above $1000");
                }
                break;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    void displayAccountDetails() {
        System.out.println("------- ACCOUNTDETAILS ----------");
        System.out.println("CUSTOMER ID  :" + cid +
                           "\nACCOUNT NUMBER  :" + ano +
                           "\nINITIAL BALANCE  :" + inibal);
        System.out.println("-----------DONE-------");
    }
}

public class ExceptionHandling {
    public static void main(String[] args) {
        AccountDetails ad = new AccountDetails();
        ad.readAccountDetails();
        ad.displayAccountDetails();
    }
}

