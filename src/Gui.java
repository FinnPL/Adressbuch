import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;

public class Gui extends JFrame implements ActionListener {
    private JButton button;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    Adressbuch adressbuch = new Adressbuch();

    public void menu() {
        JFrame frame = new JFrame("Adress Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();

        button = new JButton("Add Adress");
        button2 = new JButton("Show all Adresses");
        button3 = new JButton("Save Adresses");
        button4 = new JButton("Load Adresses");

        button.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);

        panel.add(button);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private void addAdress() throws ParseException {
        JFrame frame = new JFrame("Add Adress");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();

        // Create 3 RadioButtons
        JRadioButton radioButton = new JRadioButton("Germany");
        JRadioButton radioButton2 = new JRadioButton("UK");
        JRadioButton radioButton3 = new JRadioButton("USA");

        radioButton.setSelected(true);

        // Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton);
        group.add(radioButton2);
        group.add(radioButton3);

        // Add a label to the panel.
        panel.add(new JLabel("Select a country layout:"));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Add the radio buttons to the panel.
        panel.add(radioButton);
        panel.add(radioButton2);
        panel.add(radioButton3);

        // Add a button to the panel.
        button5 = new JButton("Add Adress");
        button6 = new JButton("Cancel");

        JTextField firstname = new JTextField(10);

        JTextField name = new JTextField(10);
        JTextField street = new JTextField(10);
        JTextField houseNumber = new JTextField(10);
        JTextField zipCode = new JTextField(10);
        JTextField city = new JTextField(10);
        JTextField country = new JTextField(10);
        JTextField houseName = new JTextField(10);
        JTextField state = new JTextField(10);

        panel.add(new JLabel("Firstname:"));
        panel.add(firstname);
        panel.add(new JLabel("Name:"));
        panel.add(name);

        JLabel hn = new JLabel("House Name:");
        panel.add(hn);
        panel.add(houseName);

        panel.add(new JLabel("Street:"));
        panel.add(street);
        panel.add(new JLabel("House Number:"));
        panel.add(houseNumber);

        JLabel st = new JLabel("State:");
        panel.add(st);
        panel.add(state);

        panel.add(new JLabel("Zip Code:"));
        panel.add(zipCode);
        panel.add(new JLabel("City:"));
        panel.add(city);
        panel.add(new JLabel("Country:"));
        panel.add(country);

        hn.setVisible(false);
        st.setVisible(false);
        houseName.setVisible(false);
        state.setVisible(false);

        // close the window if the button6 is clicked:
        button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        // add adress if the button5 is clicked:
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (radioButton.isSelected()) {
                    adressbuch.add(new AdresseDE(firstname.getText(), name.getText(), street.getText(),
                            Integer.valueOf(houseNumber.getText()), city.getText(), country.getText(),
                            zipCode.getText()));

                } else if (radioButton2.isSelected()) {
                    adressbuch.add(new AdresseUK(firstname.getText(), name.getText(), street.getText(),
                            Integer.valueOf(houseNumber.getText()), city.getText(), country.getText(),
                            zipCode.getText(), houseName.getText()));

                } else if (radioButton3.isSelected()) {
                    adressbuch.add(new AdresseUS(firstname.getText(), name.getText(), street.getText(),
                            Integer.valueOf(houseNumber.getText()), city.getText(), country.getText(),
                            zipCode.getText(), state.getText()));

                }
                frame.dispose();
            }
        });

        // Show text panel if radio button is selected.
        radioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hn.setVisible(false);
                st.setVisible(false);
                houseName.setVisible(false);
                state.setVisible(false);

                frame.pack();
                frame.repaint();
                frame.setVisible(true);
            }
        });
        radioButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                st.setVisible(false);
                hn.setVisible(true);
                houseName.setVisible(true);
                state.setVisible(false);
                frame.pack();
                frame.repaint();
                frame.setVisible(true);
            }
        });

        radioButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hn.setVisible(false);
                st.setVisible(true);
                houseName.setVisible(false);
                state.setVisible(true);
                frame.pack();
                frame.repaint();
                frame.setVisible(true);
            }
        });

        panel.add(button5);
        panel.add(button6);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private void showAllAdresses() {
        JFrame frame = new JFrame("Adressbuch");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JTextArea textArea = new JTextArea(20, 40);
        textArea.setEditable(false);
        panel.add(textArea);
        for (int i = 0; i < adressbuch.getIndex(); i++) {
            textArea.append(adressbuch.getAdressString(i) + "\n");
        }
        // add close button:
        JButton button = new JButton("Close");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        panel.add(button);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private File csvChooser() {
        // Get path to save file:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileChooser.setSelectedFile(new File("adressbook.csv"));
        fileChooser.setFileFilter(new FileNameExtensionFilter("CSV files", "csv"));
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            return selectedFile;
        }
        return null;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == button) {
            System.out.println("Add Adress");
            try {
                addAdress();
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
        } else if (obj == button2) {
            System.out.println("Show all Adresses");
            showAllAdresses();
        } else if (obj == button3) {
            System.out.println("Save Adresses");
            try {
                adressbuch.save(csvChooser().getAbsolutePath());
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        } else if (obj == button4) {
            System.out.println("Load Adresses");
            try {
                adressbuch.load(csvChooser().getAbsolutePath());
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }
    }
}