import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
class Project
{
    boolean login()
    {
        Scanner input=new Scanner(System.in);
        int tries = 0;
        while (tries < 3)
        {
            System.out.println("\nInsert Your Card Here");
            System.out.print("Enter Your Secret Code:= ");
            String password = input.next();
            if (password.equals("1234"))
            {
                System.out.println("Login successful!");
                return true;
            }
            else
            {
                tries++;
                System.out.println("Invalid login credentials. Please try again.");
            }
        }

        System.out.println("\nMaximum number of tries exceeded. Please try again later.");
        System.exit(0);
        return false;
    }
    void QR() throws IOException
    {
        File file = new File("C:\\Users\\ANUBHAV PANDYA\\Desktop\\QR.jpg");
        BufferedImage bufferedImage = ImageIO.read(file);


        ImageIcon imageIcon = new ImageIcon(bufferedImage);
        JFrame jFrame = new JFrame();


        jFrame.setLayout(new FlowLayout());

        jFrame.setSize(600, 600);
        Toolkit toolkit=Toolkit.getDefaultToolkit();
        Dimension size=toolkit.getScreenSize();
        jFrame.setLocation(size.width/2 - bufferedImage.getWidth()/2 , size.height/2 - bufferedImage.getHeight()/2 );
        jFrame.setContentPane(new Panel());
        JLabel jLabel = new JLabel();

        jLabel.setIcon(imageIcon);
        jFrame.add(jLabel);
        jFrame.setVisible(true);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    void options() throws IOException {
        Scanner input = new Scanner(System.in);
        double balance = 25000.00;
        int choice = 0;
        System.out.println("\nPlease select an option:");
        System.out.println("1. Check balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. QR Deposit");
        System.out.println("5. Exit");
        System.out.print("\nSelect Options From Menu:=");
        choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println("\nYour balance is: " + balance);
                options();
                break;

            case 2:
                float amount;
                System.out.print("\nEnter amount to withdraw:= ");
                amount = input.nextFloat();
                if (balance < amount)
                {
                    System.out.println("Insufficient balance.");
                }
                else if (amount>20000)
                {
                    System.out.println("You Exceeded Your Daily Limit!");
                    System.out.println("Please Try Again.");
                }
                else
                {
                    balance -= amount;
                    System.out.println("Transaction successful.");
                    System.out.println("Your new balance is:=" + String.format("%.2f",balance));
                }
                options();
                break;

            case 3:
                float depositAmount;
                System.out.print("\nEnter amount to deposit:= ");
                depositAmount = input.nextFloat();
                balance += depositAmount;
                System.out.println("Transaction successful.");
                System.out.println("Your new balance is:= " + String.format("%.2f",balance));
                options();
                break;

            case 4:

                Project P=new Project();
                P.QR();
                options();
                break;
            case 5:
                System.out.println(" \nThank You For Choosing Us ");
                return;

            default:
                System.out.println("Invalid choice. Please try again.");
                options();
                break;
        }
    }
}
class ATM
{
    public static void main(String om[]) throws IOException
    {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tWelcome to APATAD BANK ");
        Project P=new Project();
        P.login();
        P.options();
    }
}