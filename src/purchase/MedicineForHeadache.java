package purchase;

import java.util.ArrayList;
import java.util.Scanner;

public class MedicineForHeadache extends Medicine {
    ArrayList<Medicine> medicine = new ArrayList();
    Scanner input = new Scanner(System.in);
    Scanner input1 = new Scanner(System.in);
    Scanner input2 = new Scanner(System.in);
    Scanner input3 = new Scanner(System.in);
    Scanner input4 = new Scanner(System.in);
    Scanner input5 = new Scanner(System.in);
    Scanner input6 = new Scanner(System.in);

    public MedicineForHeadache() {
    }

    public MedicineForHeadache(int iD, String genericName, String brandName, String description, double price, int quantity) {
        super(iD, genericName, brandName, description, price, quantity);
    }

    public void populate() {
        medicine.add(new Medicine(0, "Paracetamol", "Biogesic", "Relief of minor aches such as headache", 4, 25));
        medicine.add(new Medicine(1, "Paracetamol", "Neozep Forte", "Used for the relief of headache", 5, 40));
        medicine.add(new Medicine(2, "Ibuprofen", "Advil", "Used for the relief of headache", 8.50, 10));
    }

    public void display(Medicine med) {
        System.out.printf("%10s %5s %35s %5s %30s %5s %50s %5s %10s %5s %10s", "ID", "|", "GENERIC NAME", "|", "BRAND NAME", "|", "DESCRIPTION", "|", "PRICE", "|", "QUANTITY\n");
        System.out.printf("%s", "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        for (int i = 0; i < medicine.size(); i++) {
            System.out.printf("%10s %5s %35s %5s %30s %5s %50s %5s %10s %5s %10s\n", medicine.get(i).getiD(), "|", medicine.get(i).getGenericName(), "|", medicine.get(i).getBrandName(), "|", medicine.get(i).getDescription(), "|", medicine.get(i).getPrice(), "|", medicine.get(i).getQuantity());
        }

    }
    public Medicine getMedicine(int index) {
        return medicine.get(index);
    }

    public void addMedicine() {
        System.out.println("--- ADD MEDICINE FOR HEADACHE ---");
        System.out.print("GENERIC NAME: ");
        String gname = input1.nextLine();
        System.out.print("BRAND NAME: ");
        String bname = input2.nextLine();
        System.out.print("DESCRIPTION: ");
        String description = input3.nextLine();
        System.out.print("PRICE: ");
        double price = input4.nextDouble();
        System.out.print("QUANTITY:");
        int quantity = input5.nextInt();
        medicine.add(new Medicine(medicine.get(medicine.size() - 1).getiD() + 1, gname, bname, description, price, quantity));
    }

    public void removeMedicine() {
        System.out.println("\n--- REMOVE MEDICINE FOR HEADACHE ---");
        System.out.print("Enter Medicine ID : ");
        int id = input6.nextInt();
        for (int i = 0; i < medicine.size(); i++) {
            if (medicine.get(i).getiD() == id) {
                System.out.println(medicine.get(i).getGenericName() + " is removed.");
                medicine.remove(i);
                break;
            }
        }
    }
}
