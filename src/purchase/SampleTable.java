package purchase;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SampleTable {

    public static void main(String[] args) {

        // create JFrame and JTable
        JFrame frame = new JFrame();
        JTable table = new JTable();

        // create a table model and set a Column Identifiers to this model 
        Object[] columns = {"ID", "Generic Name", "Brand Name", "Description", "Price","Quantity"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        // set the model to the table
        table.setModel(model);

        // Change A JTable Background Color, Font Size, Font Color, Row Height
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        Font font = new Font("", 1, 22);
        table.setFont(font);
        table.setRowHeight(30);

        // create JTextFields
        JTextField iD = new JTextField();
        JTextField generic_Name = new JTextField();
        JTextField brand_Name = new JTextField();
        JTextField description = new JTextField();
        JTextField price = new JTextField();
        JTextField quantity = new JTextField();

        // create JButtons
        JButton btnAdd = new JButton("Add");
        JButton btnDelete = new JButton("Delete");
        JButton btnUpdate = new JButton("Update");

        iD.setBounds(20, 220, 100, 25);
        generic_Name.setBounds(20, 250, 100, 25);
        brand_Name.setBounds(20, 280, 100, 25);
        description.setBounds(20, 310, 100, 25);
        price.setBounds(20, 340, 100, 25);
        quantity.setBounds(20, 370, 100, 25);

        btnAdd.setBounds(150, 220, 100, 25);
        btnUpdate.setBounds(150, 265, 100, 25);
        btnDelete.setBounds(150, 310, 100, 25);

        // create JScrollPane
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0, 880, 200);

        frame.setLayout(null);

        frame.add(pane);

        // add JTextFields to the jframe
        frame.add(iD);
        frame.add(generic_Name);
        frame.add(brand_Name);
        frame.add(description);
        frame.add(price);
        frame.add(quantity);

        // add JButtons to the jframe
        frame.add(btnAdd);
        frame.add(btnDelete);
        frame.add(btnUpdate);

        // create an array of objects to set the row data
        Object[] row = new Object[6];

        // button add row
        btnAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                row[0] = iD.getText();
                row[1] = generic_Name.getText();
                row[2] = brand_Name.getText();
                row[3] = description.getText();
                row[4] = price.getText();
                row[5] = quantity.getText();
                

                // add row to the model
                model.addRow(row);
            }
        });

        // button remove row
        btnDelete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // i = the index of the selected row
                int i = table.getSelectedRow();
                if (i >= 0) {
                    // remove a row from jtable
                    model.removeRow(i);
                } else {
                    System.out.println("Delete Error");
                }
            }
        });

        // get selected row data From table to textfields 
        table.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                // i = the index of the selected row
                int i = table.getSelectedRow();

                iD.setText(model.getValueAt(i, 0).toString());
                generic_Name.setText(model.getValueAt(i, 1).toString());
                brand_Name.setText(model.getValueAt(i, 2).toString());
                description.setText(model.getValueAt(i, 3).toString());
                price.setText(model.getValueAt(i, 4).toString());
                quantity.setText(model.getValueAt(i, 5).toString());
            }
        });

        // button update row
        btnUpdate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // i = the index of the selected row
                int i = table.getSelectedRow();

                if (i >= 0) {
                    model.setValueAt(iD.getText(), i, 0);
                    model.setValueAt(generic_Name.getText(), i, 1);
                    model.setValueAt(brand_Name.getText(), i, 2);
                    model.setValueAt(description.getText(), i, 3);
                    model.setValueAt(price.getText(), i, 4);
                    model.setValueAt(quantity.getText(), i, 5);
                } else {
                    System.out.println("Update Error");
                }
            }
        });

        frame.setSize(900, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
