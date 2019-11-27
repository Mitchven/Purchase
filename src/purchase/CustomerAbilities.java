package purchase;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerAbilities extends Medicine {
    ArrayList<Medicine> medicine = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    ArrayList<Adult_SeniorCitizen> adults;
    private String name;
    private String password;
    private int age;
    private double total;
    Scanner inputName = new Scanner(System.in);
    Scanner inputPass = new Scanner(System.in);
    Scanner inputAge = new Scanner(System.in);
    MedicineForHeadache mh = new MedicineForHeadache();
    MedicineForCough mc = new MedicineForCough();
    MedicineForBPain mp = new MedicineForBPain();
    MedicineForAllergies ma = new MedicineForAllergies();
    int payable = 0;
    double discount = 0;
    double amount = 0;

    public CustomerAbilities() {
        adults = new ArrayList();
        adults.add(new Adult_SeniorCitizen("Mars", 20, "marimars", 0.0));
    }

    public void register() {
        System.out.println("\n☻☻☻☻☻☻ REGISTER ☻☻☻☻☻☻");
        System.out.print("Enter username : ");
        name = inputName.nextLine();
        System.out.print("Enter password : ");
        password = inputPass.nextLine();
        System.out.print("Enter age : ");
        age = inputAge.nextInt();
        if (age < 18) {
            System.out.println("►►►►► You are under age! ◄◄◄◄◄");
        } else if(age <= 80){
            adults.add(new Adult_SeniorCitizen(name, age, password, total));
            System.out.println("☺☺☺☺☺☺ You are Registered Now! ☺☺☺☺☺☺");
        } else {
            System.out.println("►►►►► You can't register ◄◄◄◄◄");
        }
    }

    public boolean login() {
        System.out.println("\n♦♦♦♦♦♦ LOG IN ♦♦♦♦♦♦");
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

    public void order() {
        boolean order = false;
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        while (order == false) {
            System.out.println("    1 ---- View Available Medicine\n    2 ---- Order/Purchase Medicine\n    3 ---- Payment\n    4 ---- Logout\n");
            int choice1 = input2.nextInt();
            switch (choice1) {
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
                    System.out.println("What kind of illness you would like to be cured? Choose from the following:\n1.Cough\n2.Body Pain\n3.Headache\n4.Allergies");
                    int input3 = input1.nextInt();
                    switch (input3) {
                        case 1:
                            System.out.println("   ♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦ |: THIS MEDICINES IS FOR COUGH :| ♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦");

                            mc.display(mc);
                            System.out.print("Input medicine ID to purchase: ");
                            int in = input.nextInt();
                            if (in == 0 || in == 1 || in == 2) {
                                Medicine purchase = mc.getMedicine(in);
                                System.out.println("You purchase " + purchase);
                                System.out.println("Quantity: ");
                                int quan = input1.nextInt();
                                if (quan > mc.getMedicine(in).getQuantity()) {
                                    System.out.println("It's impossible to purchase " + quan + ". You only have " + mc.getMedicine(in).getQuantity() + " in your list.");
                                } else {
                                    double price = quan * mc.getMedicine(in).getPrice();
                                    System.out.println(price);
                                    payable += price;
                                    mc.getMedicine(in).setQuantity(mc.getMedicine(in).getQuantity() - quan);
                                }
                            }
                            break;
                        case 2:
                            System.out.println("    ♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣ o: THIS MEDICINES IS FOR BODY PAINS :o ♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣");
                            mp.display(mp);
                            System.out.print("Input medicine ID to purchase: ");
                            int ind = input2.nextInt();
                            if (ind == 0 || ind == 1 || ind == 2) {
                                Medicine purchase = mp.getMedicine(ind);
                                System.out.println("You purchase " + purchase);
                                System.out.println("Quantity: ");
                                int quan = input1.nextInt();
                                if (quan > mp.getMedicine(ind).getQuantity()) {
                                    System.out.println("It's impossible to purchase " + quan + ". You only have " + mp.getMedicine(ind).getQuantity() + " in your list.");
                                } else {
                                    double price = quan * mp.getMedicine(ind).getPrice();
                                    System.out.println(price);
                                    payable += price;
                                    mp.getMedicine(ind).setQuantity(mp.getMedicine(ind).getQuantity() - quan);
                                }
                            }
                            break;
                        case 3:
                            System.out.println("    ♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠ <: THIS MEDICINES IS FOR HEADACHE :> ♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠");
                            mh.display(mh);
                            System.out.print("Input medicine ID to purchase: ");
                            int index = input2.nextInt();
                            if (index == 0 || index == 1 || index == 2) {
                                Medicine purchase = mh.getMedicine(index);
                                System.out.println("You purchase " + purchase);
                                System.out.println("Quantity: ");
                                int quan = input1.nextInt();
                                if (quan > mh.getMedicine(index).getQuantity()) {
                                    System.out.println("It's impossible to purchase " + quan + ". You only have " + mh.getMedicine(index).getQuantity() + " in your list.");
                                } else {
                                    double price = quan * mh.getMedicine(index).getPrice();
                                    payable += price;
                                    System.out.println(price);
                                    mh.getMedicine(index).setQuantity(mh.getMedicine(index).getQuantity() - quan);
                                }
                            }
                        case 4:
                            System.out.println("    ☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻ (: THIS MEDICINES IS FOR ALLERGIES :) ☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻");
                            ma.display(ma);
                            System.out.print("Input medicine ID to purchase: ");
                            int index1 = input2.nextInt();
                            if (index1 == 0 || index1 == 1 || index1 == 2) {
                                Medicine purchase = ma.getMedicine(index1);
                                System.out.println("You purchase " + purchase);
                                System.out.println("Quantity: ");
                                int quan = input1.nextInt();
                                if (quan > ma.getMedicine(index1).getQuantity()) {
                                    System.out.println("It's impossible to purchase " + quan + ". You only have " + ma.getMedicine(index1).getQuantity() + " in your list.");
                                } else {
                                    double price = quan * ma.getMedicine(index1).getPrice();
                                    payable += price;
                                    System.out.println(price);
                                    ma.getMedicine(index1).setQuantity(ma.getMedicine(index1).getQuantity() - quan);
                                }
                                break;
                            }
                    }
                    break;
                case 3:
                    if (age >= 55) {
                        discount = payable * .2;
                        amount = payable - discount;
                        System.out.println("You have 20% discount, therefore you will just pay = " + amount);
                        payBillWD();
                    } else {
                        System.out.println("You will pay = " + payable);
                        payBillND();
                    }
                    break;
                case 4:
                    System.out.println("☺☺☺☺ Thank you " + name + " for using MMG's Pharmacy System. Hope you find this system useful and hope that you enjoy the accompany of the system. COME AGAIN!! ☺☺☺☺");
                    order = true;
                    break;
            }
        }

    }

    public void payBillWD() {
        System.out.println(" ►►►►► You will pay through: ◄◄◄◄◄\n 1 --- Cash\n2 --- Credit Card");
        int opt = input.nextInt();
        if (opt == 1) {
            System.out.print("Amount: ");
            double money = input.nextDouble();
            if (money > amount) {
                total = money - amount;
                System.out.println("You successfully purchase the medicine.\nYour change is " + total + " pesos.\n☺☺☺ THANK YOU " + name + " for purchasing ☺☺☺");
            } else if (money < amount) {
                double lack = amount - money;
                System.out.println("Your money is lacking " + lack + " pesos.\n");
                System.out.println("Kindly add " + lack + "so that you can successfully purchase the medicine. THANK YOU " + name);
            }
        } else if (opt == 2) {
            System.out.print("Input your credit card number: ");
            int creditCard = input.nextInt();
            System.out.println("Thank you! " + name);
        }
    }

    public void payBillND() {
        System.out.println(" ►►►►► You will pay through: ◄◄◄◄◄ \n 1 --- Cash\n2 --- Credit Card\n");
        int opt = input.nextInt();
        if (opt == 1) {
            System.out.print("Amount: ");
            double money = input.nextDouble();
            if (money > payable) {
                total = money - payable;
                System.out.println("You successfully purchase the medicine.\nYour change is " + total + " pesos.\n☺☺☺ THANK YOU " + name + " for purchasing ☺☺☺");
            } else if (money < payable) {
                double lack = payable - money;
                System.out.println("Your money is lacking " + lack + "pesos.\n");
                System.out.println("Kindly add " + lack + "so that you can successfully purchase the medicine. THANK YOU " + name);
            }
        } else if (opt == 2) {
            System.out.print("Input your credit card number: ");
            int creditCard = input.nextInt();
            System.out.println(" ☺☺☺ Thank you! " + name+" ☺☺☺");
        }
    }
}
