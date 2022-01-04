package Project4;

import Project4.Address;
import Project4.Property;

import java.util.Scanner;

public class RealState {
    static Scanner scanner = new Scanner(System.in);

    private Address[] array;
    private User[] users;

    private Property[] properties;
    private Address[] addresses;
    private String numberPhone;

    public RealState() {
        this.users = new User[0];
        this.properties = new Property[0];
        this.addresses = new Address[10];
        this.array[0] = new Address("tel aviv", "ben guryon");
        this.array[1] = new Address("Bat yam", " Big street");
        this.array[2] = new Address("Haifa", " Herzel");
        this.array[3] = new Address("Ashkelon", " BenTzvi");
        this.array[4] = new Address("Beer sheva", " Ramot");
        this.array[5] = new Address("Jerusalem", " Old city");
        this.array[6] = new Address("Bat yam", " Big street");
        this.array[7] = new Address("Netivot", " Waizman");
        this.array[8] = new Address("Sderot", " Begin");
        this.array[9] = new Address("holon", " small street");

    }

    public void createUser() {
        String username = null;
        do {
            System.out.println("Enter username: ");
            //  username = "yossi";
            username = scanner.nextLine();
        } while (isUsernameExist(username));
        String password = null;

        do {
            System.out.println("Enter password: ");
          // password = " 1235%vg";
            password = scanner.nextLine();
        } while (!isPasswordStrong(password));

        System.out.println("Enter phone number ");
       String num = scanner.nextLine();
        //String num = "0504987232";

        while (!numberPhone(num)) {
            System.out.println("Wrong num enter again");
            num = scanner.nextLine();

           // num = "0504987232";
        }
        boolean isRealEstate;
        int choose;
        do {
            System.out.println("1.i am a RealEstate");
            System.out.println("2.i am not a RealEstate");
            choose = scanner.nextInt();
            if (choose == 1) {
                isRealEstate = true;
            } else {
                isRealEstate = false;
            }
        } while (choose == 1 || choose == 2);
        addUserToArray(username, password, numberPhone, isRealEstate);

    }

    public User login() {
        System.out.println("Enter your user name and password");
        String userName = scanner.next();
        String pass = scanner.next();

        for (int i = 0; i < this.users.length; i++) {
            User currentUser = this.users[i];
            if (currentUser.getUsername().equals(userName)
                    && currentUser.getPassword().equals(pass)) {
                return currentUser;
            }
        }
        return null;
    }

    public boolean postNewProperty(User user) {
        int count = 0;
        for (int i = 0; i < this.properties.length; i++) {
            User currentUser = this.properties[i].getUser();
            if (currentUser.getUsername().equals(user.getUsername()))
                count++;
        }
        if ((user.isMeditor() && count >= 10) || (!user.isMeditor() && count >= 3)) {
            System.out.println("You can't publish");
            return false;
        }
        printCities();
        System.out.println("Choose city");
        String city = scanner.next();
        for (int i = 0; i < this.addresses.length; i++) {
            if (this.addresses[i].getCity().equals(city))
                System.out.println(this.addresses[i]);
        }
        System.out.println("Choose street");
        String street = scanner.next();
        boolean exist = false;
        for (int i = 0; i < this.addresses.length; i++) {
            if (this.addresses[i].getCity().equals(city)) {
                if (this.addresses[i].getStreet().equals(street)) {
                    exist = true;
                }
            }
        }
        if (!exist)
            return false;
        System.out.println("What type: 1- regularApartment, 2-penthous, 3- private");
        int type = scanner.nextInt();
        int cost = 0;
        int rooms = 0;
        int numHome = 0;
        int numFloor = 0;
        String rent = null;
        if (type == 1) {
            System.out.println("What floor");
            numFloor = scanner.nextInt();

            System.out.println("How many rooms");
            rooms = scanner.nextInt();
            System.out.println("number of property");
            numHome = scanner.nextInt();
            System.out.println(" Is property for rent  or for sell");
            rent = scanner.next();
            System.out.println("What cost of property");
            cost = scanner.nextInt();

        }


        Address ad = new Address(city, street);
        Property pro = new Property(ad, rooms, cost, type, rent, numHome, numFloor, user);
        addPropertyArray(pro);
        return true;
    }

    private void addPropertyArray(Property pro) {
        Property[] addPropertyTArray = new Property[users.length];
        for (int i = 0; i < this.properties.length; i++) {
            addPropertyTArray[i] = pro;
        }
    }

    public void removeProperty(User user) {
        boolean isPublish = false;
        for (int i = 0; i < this.properties.length; i++) {
            User currentUser = this.properties[i].getUser();
            if (currentUser.getUsername().equals(user.getUsername())) {
                isPublish = true;
                printProperty();
            }
            isPublish = false;
            System.out.println(" Not publish at all");
        }
    }

    public void printAllProperties() {
        for (int i = 0; i < this.properties.length; i++) {
            System.out.println(properties[i]);
        }
    }

    public void printUserProperties(User user) {
        int i = 0;
        User currentUser = this.properties[i].getUser();

        for (i = 0; i < this.properties.length; i++) {
            if (currentUser.getUsername().equals(properties[i].getUser()))
                System.out.println(currentUser);
        }
    }

    public Property[] search() {
        System.out.println("For rent or sell?");
        int firstChoose = scanner.nextInt();
        while (firstChoose == -999) {
            for (int i = 0; i < properties.length; i++)
                System.out.println(properties[i]);
        }
        System.out.println("Type of property");
        String type = scanner.nextLine();
        System.out.println("Number of rooms?");
        int number = scanner.nextInt();
        System.out.println("For rent or sell?");
        String choise = scanner.nextLine();
        System.out.println("price range");
        int price = scanner.nextInt();

        return new Property[1];
    }


    private void printCities() {
        boolean first;
        for (int i = 0; i < this.addresses.length; i++) {
            first = true;
            for (int j = 0; j < i; j++) {
                if (this.addresses[i].getCity().equals(this.addresses[j].getCity()))
                    first = false;
            }
            if (first)
                System.out.println(this.addresses[i].getCity());
        }
    }


    private boolean isUsernameExist(String usernameToCheck) {
        for (int i = 0; i < this.users.length; i++) {
            User currentUser = this.users[i];
            if (currentUser.getUsername().equals(usernameToCheck)) {
                return true;
            }
        }
        return false;
    }

    private boolean isPasswordStrong(String passwordToCheck) {
        Scanner scanner = new Scanner(System.in);
        boolean isUniqe = false;
        boolean isDigit = false;
        boolean strong = false;
        char precent = '%';
        char dolar = 's';
        char bottomDash = '_';
        for (int i = 0; i < passwordToCheck.length(); i++) {
            char currentChar = passwordToCheck.charAt(i);
            if (Character.isDigit(currentChar)) {
                isDigit = true;

            } else if (passwordToCheck.charAt(i) == precent || passwordToCheck.charAt(i) == dolar || passwordToCheck.charAt(i) == bottomDash) {
                isUniqe = true;

            }
        }

        if (isDigit && isUniqe) {
            // System.out.println("Enter password again");
            //passwordToCheck = scanner.nextLine();
            strong = true;
        }
        return strong;
    }

    private boolean numberPhone(String num) {
        Scanner scanner = new Scanner(System.in);
        boolean correctLength = false;
        boolean correctprefix = false;
        boolean normalNum = true;
        boolean proper = false;
        //num = "0509676739";
        char prefix = '0';
        char pre = '5';

        if (num.length() == 10) {
            correctLength = true;
            if (num.charAt(0) == prefix && num.charAt(1) == pre)
                correctprefix = true;
            for (int i = 2; i < num.length(); i++) {
                char digit = num.charAt(i);
                if (!Character.isDigit(digit)) {
                    normalNum = false;
                    break;
                }
            }
        }
        if (correctLength && correctprefix && normalNum) {
            proper = true;
            return proper;
        }
        return proper;
    }


    private void addUserToArray(String username, String password, String phoneNumber, boolean isRealEstate) {
        User[] newArray = new User[this.users.length + 1];
        for (int i = 0; i < this.users.length; i++) {
            newArray[i] = this.users[i];
        }
        User userToAdd = new User(username, password, phoneNumber, isRealEstate);
        newArray[this.users.length] = userToAdd;
        this.users = newArray;
    }

    private void printProperty() {
        boolean publish;
        for (int i = 0; i < this.properties.length; i++) {

            if (this.properties[i].equals(this.properties[i].getUser())) {


                System.out.println(this.addresses[i]);
            }
        }
    }
}



