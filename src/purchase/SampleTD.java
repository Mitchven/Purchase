package purchase;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

// create a users class
class Users {

    private int id;
    private String genericName;
    private String brandName;
    private String description;
    private int price;
    private int quantity;

    public Users(int id, String gname, String bname, String description, int price, int quantity) {
        this.id = id;
        this.genericName = gname;
        this.brandName = bname;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return this.id;
    }

    public String getGenericName() {
        return this.genericName;
    }

    public String getBrandName() {
        return this.brandName;
    }

    public String getDescription() {
        return this.description;
    }

    public int getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }
}

public class SampleTD extends JFrame {

    public SampleTD() {

        super("Bind JTable From MySQL DataBase");

        setLocationRelativeTo(null);

        setSize(600, 400);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    // create a Function to get the connection
    static Connection getConnection() {
        Connection con = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/mmgspharmacy", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(SampleTD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;
    }

    // create a function to fill the an arraylist from database
    static ArrayList<Users> getUsers() {

        ArrayList<Users> users = new ArrayList<>();

        Connection con = getConnection();

        Statement st;

        ResultSet rs;

        Users u;

        try {

            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM medicine");

            while (rs.next()) {

                u = new Users(
                        rs.getInt("id"),
                        rs.getString("gname"),
                        rs.getString("bname"),
                        rs.getString("description"),
                        rs.getInt("price"),
                        rs.getInt("quantity")
                );

                users.add(u);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SampleTD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return users;
    }

    public static void main(String[] args) {

        /*
   now we are gonna create and populate a jtable from the arraylist who is populated from mysql database
         */
        JTable table = new JTable();

        DefaultTableModel model = new DefaultTableModel();

        Object[] columnsName = new Object[6];

        columnsName[0] = "ID";
        columnsName[1] = "Generic Name";
        columnsName[2] = "Brand Name";
        columnsName[3] = "Description";
        columnsName[4] = "Price";
        columnsName[5] = "Quantity";

        model.setColumnIdentifiers(columnsName);

        Object[] rowData = new Object[4];

        for (int i = 0; i < getUsers().size(); i++) {

            rowData[0] = getUsers().get(i).getId();
            rowData[1] = getUsers().get(i).getGenericName();
            rowData[1] = getUsers().get(i).getBrandName();
            rowData[2] = getUsers().get(i).getDescription();
            rowData[3] = getUsers().get(i).getPrice();
            rowData[1] = getUsers().get(i).getQuantity();

            model.addRow(rowData);
        }

        table.setModel(model);

//        System.out.println(getUsers().size());
        SampleTD window = new SampleTD();

        JPanel panel = new JPanel();

        panel.setLayout(new BorderLayout());

        JScrollPane pane = new JScrollPane(table);

        panel.add(pane, BorderLayout.CENTER);

        window.setContentPane(panel);
    }
}
