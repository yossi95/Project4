package Project4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        RealState rs=new RealState();
        User user;
        Scanner scanner=new Scanner(System.in);
        rs.createUser();
        System.out.println("Enter 1-creat account ,2-Log in to an existing account,3-Finish the program");
        int choose = scanner.nextInt();
        if (choose == 1) {
            rs.createUser();
        } else if (choose == 2) {
            user = rs.login();
            if (user == null)
                System.out.println("user no exist");
            else {

                System.out.println("1-Publish new property ");
                int chooseAgain = scanner.nextInt();
                if (chooseAgain == 1) {
                    rs.postNewProperty(user);

                }
                System.out.println("2-Remove publish property ");
                if (chooseAgain == 2) {
                    rs.removeProperty(user);
                }
                System.out.println("3-Presnt all property in system ");
                if (chooseAgain == 3) {

                    rs.printAllProperties();
                }
                System.out.println("4-Presnt all property that publish by user ");
                if (chooseAgain == 4) {
                    rs.printUserProperties(user);
                }
                System.out.println("5-find property by parameter ");
                if (chooseAgain == 5) {
                    rs.search();
                }
                System.out.println("6-Logout and back to menu ");
                if (chooseAgain == 6) {

                }

            }
        }

    }


}

