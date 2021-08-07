package case_study;

import java.util.Scanner;

public class displayMainMenu {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Menu:");
            System.out.println("Enter 1:Employee Management");
            System.out.println("Enter 2:Customer Management");
            System.out.println("Enter 3:Facility Management");
            System.out.println("Enter 4:Booking Managerment");
            System.out.println("Enter 5:Promotion Management");
            System.out.println("Enter 6:Exit");
            String line = scanner.nextLine();
            switch (line) {
                case "1":
                    System.out.println("Enter a:Display list employees");
                    System.out.println("Enter b:Add new employee");
                    System.out.println("Enter c:Edit employee");
                    System.out.println("Enter d:Return main menu");
                    String type = scanner.nextLine();
                    switch (type) {
                        case "a":
                        case "b":
                        case "c":
                        case "d":
                    }
                case "2":
                    System.out.println("Enter a:Display list customers ");
                    System.out.println("Enter b:Add new customer ");
                    System.out.println("Enter c:Edit customer ");
                    System.out.println("Enter d:Return main menu ");
                    String type2 = scanner.nextLine();
                    switch (type2) {
                        case "a":
                        case "b":
                        case "c":
                        case "d":
                    }
                case "3":
                    System.out.println("Enter a:Display list facility");
                    System.out.println("Enter b:Add new facility");
                    System.out.println("Enter c:Display list facility maintenance");
                    System.out.println("Enter d:Return main menu");
                    String type3 = scanner.nextLine();
                    switch (type3) {
                        case "a":
                        case "b":
                        case "c":
                        case "d":
                    }
                case "4":
                    System.out.println("Enter a:Add new booking");
                    System.out.println("Enter b:Display list booking");
                    System.out.println("Enter c:Create new constracts");
                    System.out.println("Enter d:Display list contracts");
                    System.out.println("Enter e:Edit contracts");
                    System.out.println("Enter f:Return main menu");
                    String type4 = scanner.nextLine();
                    switch (type4) {
                        case "a":
                        case "b":
                        case "c":
                        case "d":
                        case "e":
                        case "f":
                    }
                case "5":
                    System.out.println("Enter a:Display list customers use service");
                    System.out.println("Enter b:Display list customers get voucher");
                    System.out.println("Enter c:Return main menu");
                    String type5 = scanner.nextLine();
                    switch (type5) {
                        case "a":
                        case "b":
                        case "c":
                        
                    }
            }
        }
    }
}
