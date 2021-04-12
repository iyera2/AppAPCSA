import javax.swing.AbstractAction;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.io.*;
import static javax.swing.LayoutStyle.ComponentPlacement.UNRELATED;


public class passwordlist extends JFrame{
    JFrame f;
    JTable j;
    public passwordlist(){

        initUI();
    }

    private void initUI() {
        f = new JFrame();
        f.setTitle("Password List");
        String[][] data = {
            {"Google", "johndoe@gmail.com", "password"},
            {"AOL", "johndoe@aol.com", "password"}
        };

        String[] columnNames = {"Website Name", "Username/Email", "Password"};

        j = new JTable(data, columnNames);
        j.setBounds(30, 40, 200, 300);

        JScrollPane sp = new JScrollPane(j);
        f.add(sp);
        f.setSize(500, 200);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var ex = new passwordlist();
            ex.setVisible(true);
        });
    }
}