package purchase;

import java.util.ArrayList;
import java.util.Scanner;

public class Pharmacists extends Medicine {

    Scanner input = new Scanner(System.in);
    private String name;
    private String password;
    private int age;
    private double total;
    ArrayList<Adult_SeniorCitizen> adults;
    Scanner inputName = new Scanner(System.in);
    Scanner inputPass = new Scanner(System.in);
    Scanner inputAge = new Scanner(System.in);
    MedicineForHeadache mh = new MedicineForHeadache();
    MedicineForCough mc = new MedicineForCough();
    MedicineForBPain mp = new MedicineForBPain();
    MedicineForAllergies ma = new MedicineForAllergies();

    public Pharmacists() {
        adults = new ArrayList();
        adults.add(new Adult_SeniorCitizen("Mars", 20, "marimars", 0.0));
    }

    public void register() {
        System.out.println("\n♀♀♀♀♀♀ REGISTER ♀♀♀♀♀♀");
        System.out.print("Enter username : ");
        name = inputName.nextLine();
        System.out.print("Enter password : ");
        password = inputPass.nextLine();
        System.out.print("Enter age : ");
        age = inputAge.nextInt();

        if (age < 18) {
            System.out.println("You are under age!");
        } else if(age <= 65) {
            adults.add(new Adult_SeniorCitizen(name, age, password, total));
            System.out.println("☺☺☺☺☺☺ You are Registered Now! ☺☺☺☺☺☺");
        } else{
            System.out.println("Can't register!");
        }
    }

    public boolean login() {
        System.out.println("\n☼☼☼☼☼☼☼☼ LOG IN ☼☼☼☼☼☼☼☼");
        System.out.print("Enter username : ");
        name = inputName.nextLine();

        for (int i = 0; i < adults.size(); i++) {
            if (adults.get(i).getName().equals(name)) {
                while (true) {
                    System.out.print("Enter password : ");
                    password = inputPass.nextLine();
                    if (adults.get(i).getPassword().equals(password)) {
                        System.out.println("☺☺☺☺☺☺ Successfully Login! ☺☺☺☺☺☺");
                        mh.populate();
                        ma.populate();
                        mc.populate();
                        mp.populate();
                        return true;
                    } else {
                        System.out.println("Incorrect password!");
                    }
                }
            } else if (i == adults.size() - 1) {
                System.out.println("☺☺☺☺☺☺ You are not yet registered! ☺☺☺☺☺☺");
            }
        }
        return false;
    }

    public void update() {
        while (true) {
            System.out.println("    1 ---- View Medicine\n    2 ---- Add Medicine\n   3 ---- Delete Medicine\n   4 ---- Logout");
            int choices = input.nextInt();
            switch (choices) {
                case 1:
                    System.out.println("    ♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦ |: THIS MEDICINES IS FOR COUGH :| ♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦");
                    mc.display(mc);
                    System.out.println("    ♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣ o: THIS MEDICINES IS FOR BODY PAINS :o ♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣");
                    mp.display(mp);
                    System.out.println("    ♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠ <: THIS MEDICINES IS FOR HEADACHE :> ♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠");
                    mh.display(mh);
                    System.out.println("    ☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻ (: THIS MEDICINES IS FOR ALLERGIES :) ☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻");
                    ma.display(ma);
                    break;
                case 2:
                    {
                        System.out.println("Add Medicine in: \n1 ---- Medicine For Cough\n2 ---- Medicine For Body Pain\n3 ---- Medicine For Headache\n4 ---- Medicine For Allergies");
                        int choice = input.nextInt();
                        if (choice == 1) {
                            mc.addMedicine();
                            mc.display(mc);
                        } else if (choice == 2) {
                            mp.addMedicine();
                            mp.display(mp);
                        } else if (choice == 3) {
                            mh.addMedicine();
                            mh.display(mh);
                        } else if (choice == 4) {
                            ma.addMedicine();
                            ma.display(ma);
                        }       break;
                    }
                case 3:
                    {
                        System.out.println("Delete Medicine in: \n1 ---- Medicine For Cough\n2 ---- Medicine For Body Pain\n3 ---- Medicine For Headache\n4 ---- Medicine For Allergies");
                        int choice = input.nextInt();
                        if (choice == 1) {
                            mc.display(mc);
                            mc.removeMedicine();
                        } else if (choice == 2) {
                            mp.display(mp);
                            mp.removeMedicine();
                        } else if (choice == 3) {
                            mh.display(mh);
                            mh.removeMedicine();
                        } else if (choice == 4) {
                            ma.display(ma);
                            ma.removeMedicine();
                        }       break;
                    }
                case 4:
                    System.out.println("☺☺☺☺ Thank you "+name+" for monitoring MMG's Pharmacy! ☺☺☺☺");
                    System.exit(0);
                default:
                    break;
            }
        }
    }

}
