package purchase;


import java.awt.Color;
import java.util.Scanner;
import javax.swing.BorderFactory;


public class Purchase {

    public static void main(String[] args) {
        LoginasCP frameTabel = new LoginasCP();
    
//        mmg.setBorder(BorderFactory.createLineBorder(Color.black));
        Medicine med = new Medicine();
        boolean exit = false;
        boolean loggedIn = false;
        int age;
        CustomerAbilities users = new CustomerAbilities();
        int payable = 0;
        Pharmacists pharm = new Pharmacists();
        MedicineForCough mc = new MedicineForCough();
        MedicineForAllergies ma = new MedicineForAllergies();
        MedicineForHeadache mh = new MedicineForHeadache();
        MedicineForBPain mp = new MedicineForBPain();

        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        System.out.println("   ☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺ Welcome to the MMG's Pharmacy!! ☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺\n");
        System.out.println("\n♥♥♥♥ 1 ---- Register as customer ♥♥♥♥\n\n♥♥♥♥ 2 ---- Register as pharmacists ♥♥♥♥\n");
        int choice = input.nextInt();
        OUTER:
        if (choice == 1) {
            while (exit == false) {
                System.out.println("\n -----C H O I C E S----- \n1.Register\n2.Log in\n3.Exit");
                System.out.print("Enter choice : ");
                String choice1 = input1.nextLine();
                switch (choice1) {
                    case "1":
                        users.register();
                        break;
                    case "2":
                        loggedIn = users.login();
                        if (loggedIn == true) {
                            exit = true;
                            mc.populate();
                            mh.populate();
                            ma.populate();
                            mp.populate();
                        }
                        break;
                    case "3":
                        System.exit(0);
                        exit = true;
                        break;
                }

            }
            if (loggedIn == true) {
                users.order();
            }
        } else if (choice == 2) {
            while (exit == false) {
                System.out.println("\n -----C H O I C E S----- \n1.Register\n2.Log in\n3.Exit");
                System.out.print("Enter choice : ");
                String choice1 = input1.nextLine();
                    switch (choice1) {
                        case "1":
                            pharm.register();
                            break;
                        case "2":
                            loggedIn = pharm.login();
                            if (loggedIn == true) {
                                exit = true;
                                mc.populate();
                                mh.populate();
                                ma.populate();
                                mp.populate();
                            }
                            break;
                        case "3":
                            System.exit(0);
                            exit = true;
                            break;
                    }
                }
                if (loggedIn == true) {
                    pharm.update();
            }
        }
    }

   
}


