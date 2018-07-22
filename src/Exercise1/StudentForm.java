package  Exercise1;

import java.awt.*;
import java.awt.event.ItemListener;
import javax.swing.*;
import java.awt.event.*;
import java.util.EventListener;


public class StudentForm  extends JFrame implements ActionListener, EventListener , MouseListener {

    private final JLabel nameLabel;
    private final JLabel addressLabel;
    private final JLabel ProvinceLabel;
    private final JLabel postalcodeLabel;
    private final JLabel phonenumberLabel;
    private final JLabel emailLabel;
    private final JLabel volunteerworkLabel;
    private final JLabel studentcouncilLabel;
    private final JTextField nameText;
    private final JTextField addressText;
    private final JTextField ProvinceText;
    private final JTextField postalcodeText;
    private final JTextField phonenumberText;
    private final JTextField emailText;
    private final JCheckBox volunteercheck;
    private final JCheckBox studentcouncilcheck;
    private final JRadioButton computerRadio, BussinessRadio;
    private final ButtonGroup radioGroup;
    private final JTextArea display = new JTextArea(4, 75);
    private static final String[] names = {"Java", "ProgrammingII", "ProgrammingIII", "C#"};
    private final String[] icons = new String[4];
    public final JComboBox<String> courses;
    public final JList<String> coursesField;
    private DefaultListModel<String> coursesList= new DefaultListModel<String>();
    private final JButton displayButton ;
    public StudentForm() {
        super("Student Form");
        setLayout(new FlowLayout());
        nameLabel = new JLabel("Name");
        add(nameLabel);
        nameText = new JTextField(15);
        add(nameText);
        addressLabel = new JLabel("Address");
        add(addressLabel);
        addressText = new JTextField(15);
        add(addressText);
        ProvinceLabel = new JLabel("Province");
        add(ProvinceLabel);
        ProvinceText = new JTextField(15);
        add(ProvinceText);
        postalcodeLabel = new JLabel("Postal Code");
        add(postalcodeLabel);
        postalcodeText = new JTextField(15);
        add(postalcodeText);
        phonenumberLabel = new JLabel("Phone Number");
        add(phonenumberLabel);
        phonenumberText = new JTextField(15);
        add(phonenumberText);
        emailLabel = new JLabel("Email");
        add(emailLabel);
        emailText = new JTextField(15);
        add(emailText);
        volunteerworkLabel = new JLabel();
        add(volunteerworkLabel);
        volunteercheck = new JCheckBox("Volunteer");
        add(volunteercheck);
        studentcouncilLabel = new JLabel();
        add(studentcouncilLabel);
        studentcouncilcheck = new JCheckBox("Student Council");
        add(studentcouncilcheck);
        computerRadio = new JRadioButton("Computer Science");
        BussinessRadio = new JRadioButton("Business");
        radioGroup = new ButtonGroup();
        radioGroup.add(computerRadio);
        radioGroup.add(BussinessRadio);
        add(computerRadio);
        add(BussinessRadio);
        coursesField = new JList();
        displayButton = new JButton("Display");
        add(displayButton);
        add(display);
        courses= new JComboBox<String>();
        displayButton.addMouseListener(this);
        computerRadio.addActionListener(this);
        BussinessRadio.addActionListener(this);
       // courses.addItemListener(this);


        add(courses);
        add(coursesField);



        courses.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED)
                {
                    if(!coursesList.contains(e.getItem().toString()))
                    {
                        coursesList.addElement(e.getItem().toString());
                        coursesField.setModel(coursesList);
                    }
                }
            }
        });
    }

                @Override
                public void actionPerformed(ActionEvent e) {

                    JRadioButton tempRadio = (JRadioButton) e.getSource();

                    if (tempRadio.getText() == "Computer Science") {
                                            courses.removeAllItems();
                                            coursesList.removeAllElements();
                                            courses.addItem("");
                                            courses.addItem("Java");
                                            courses.addItem("ProgrammingII");
                                            courses.addItem("ProgrammingIII");
                                            courses.addItem("C#");

                    }
                    else if(tempRadio.getText() == "Business")
                    {
                        courses.removeAllItems();
                        coursesList.removeAllElements();
                        courses.addItem("");
                        courses.addItem("Management");
                        courses.addItem("Accounts");
                        courses.addItem("Business Communication");
                        courses.addItem("Business Intelligence");
                    }


    }
                public void mouseClicked(MouseEvent e) {
                    String fieldStudy = "";
                    String CourseStudy = "";
                    String additional ="";
                    if (studentcouncilcheck.isSelected() && volunteercheck.isSelected())
                        additional = studentcouncilcheck.getText() + volunteercheck.getText();

                    else if (studentcouncilcheck.isSelected() && !volunteercheck.isSelected())
                        additional = studentcouncilcheck.getText();

                    else if (volunteercheck.isSelected() && !studentcouncilcheck.isSelected())
                        additional = volunteercheck.getText();

                    if (computerRadio.isSelected())

                        fieldStudy = computerRadio.getText();

                    else if (BussinessRadio.isSelected())

                        fieldStudy = BussinessRadio.getText();
                    for (int i = 0; i < coursesList.size(); i++) {

                        CourseStudy += coursesList.getElementAt(i) + "\n";
                    }


                    display.setText(String.format("%s, %s, %s, %s, %s, %s,%s,%s,%s", nameText.getText(), addressText.getText(),
                            ProvinceText.getText(),postalcodeText .getText(), phonenumberText.getText(), emailText.getText(),additional,fieldStudy,CourseStudy));
                }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}

