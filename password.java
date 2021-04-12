import javax.swing.AbstractAction;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.io.*;

import static javax.swing.LayoutStyle.ComponentPlacement.UNRELATED;

public class password extends JFrame {

    private JTextField websiteName;
    private JTextField loginField;
    private JPasswordField passField;

    public password() {

        initUI();
    }

    private void initUI() {

        var lbl3 = new JLabel("Website Name");
        var lbl1 = new JLabel("Login");
        var lbl2 = new JLabel("Password");

        websiteName = new JTextField(10);
        loginField = new JTextField(10);
        passField = new JPasswordField(15);

        SubmitAction act = new SubmitAction();

        var submitButton = new JButton("Save");
        submitButton.addActionListener(new SubmitAction());

        var passwordList = new JButton("Password List");
        submitButton.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent a){
                passwordlist list = new passwordlist();
                list.setVisible(true);
            }
        });

        createLayout(lbl3, websiteName, lbl1, loginField, lbl2, passField, submitButton, passwordList);

        setTitle("Password");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class SubmitAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {

            doSubmitAction();
        }

        private void doSubmitAction() {

            var login = loginField.getText();
            var passwd = passField.getPassword();
            var website = websiteName.getText();

            if (!login.isEmpty() && passwd.length != 0) {
                try {
                    FileWriter myWriter = new FileWriter("filename.txt");
                    myWriter.write("Website Name: " + website);
                    myWriter.write(" Login: " + login);
                    myWriter.write(" Password: " + String.valueOf(passwd));
                    myWriter.close();
                    System.out.println("Wrote to file");
                } catch (IOException e) {
                    System.out.println("An error occured");
                    e.printStackTrace();
                }
            }

            Arrays.fill(passwd, '0');
        }
    }

    private void createLayout(Component... arg) {

        var pane = getContentPane();
        var gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addGap(50)
                .addGroup(gl.createParallelGroup()
                        .addComponent(arg[0])
                        .addComponent(arg[1])
                        .addComponent(arg[2])
                        .addComponent(arg[3])
                        .addComponent(arg[4])
                        .addComponent(arg[5])
                        .addComponent(arg[6])
                        .addComponent(arg[7]))
                .addGap(50)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGap(50)
                .addGroup(gl.createSequentialGroup()
                        .addComponent(arg[0])
                        .addComponent(arg[1], GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(arg[2])
                        .addComponent(arg[3], GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(UNRELATED)
                        .addComponent(arg[4])
                        .addComponent(arg[5], GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(UNRELATED)
                        .addComponent(arg[6])
                        .addComponent(arg[7], GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(UNRELATED))
                .addGap(50)
        );

        pack();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var ex = new password();
            ex.setVisible(true);
        });
    }
}