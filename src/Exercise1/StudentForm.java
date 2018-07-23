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
    private final JTextArea display = new JTextArea(6,70);
    private final JPanel west, east, eastNorth, eastCenter, south, center,southArea;
    //private final JPanel CheckBoxPanel;
    private final JScrollPane scroll;
   // private static final String[] names = {"Java", "ProgrammingII", "ProgrammingIII", "C#"};
    private final String[] icons = new String[4];
    public final JComboBox<String> courses;
    public final JList<String> coursesField;
    private DefaultListModel<String> coursesList= new DefaultListModel<String>();
    private final JButton displayButton ;
    public StudentForm() {
        super("Student Form");
        setLayout(new FlowLayout());
        //Finally adding content management
        west = new JPanel();
        east = new JPanel();
        eastNorth = new JPanel();
        eastCenter = new JPanel();
        south = new JPanel();
        southArea = new JPanel();
        center = new JPanel();
        //CheckBoxPanel = new JPanel();
        setLayout(new BorderLayout(4, 4));
        west.setLayout(new GridLayout(7, 1, 3, 3));
        add(west, BorderLayout.WEST);
        add(east, BorderLayout.EAST);
        add(south, BorderLayout.SOUTH);
        add(center, BorderLayout.CENTER);
        south.add(southArea);
        southArea.setLayout(new BoxLayout(southArea, BoxLayout.Y_AXIS));
        east.setLayout(new BorderLayout(2, 40));
        east.add(eastNorth, BorderLayout.NORTH);
        eastNorth.setLayout(new FlowLayout());
        east.add(eastCenter, BorderLayout.CENTER);
        eastCenter.setLayout(new GridLayout(2, 1, 0, 0));

        //Form contents Label and TextFields

        nameLabel = new JLabel("Name");
        west.add(nameLabel);
        nameText = new JTextField(15);
        west.add(nameText);
        addressLabel = new JLabel("Address");
        west.add(addressLabel);
        addressText = new JTextField(15);
        west.add(addressText);
        ProvinceLabel = new JLabel("Province");
        west.add(ProvinceLabel);
        ProvinceText = new JTextField(15);
        west.add(ProvinceText);
        postalcodeLabel = new JLabel("Postal Code");
        west.add(postalcodeLabel);
        postalcodeText = new JTextField(15);
        west.add(postalcodeText);
        phonenumberLabel = new JLabel("Phone Number");
        west.add(phonenumberLabel);
        phonenumberText = new JTextField(15);
        west.add(phonenumberText);
        emailLabel = new JLabel("Email");
        west.add(emailLabel);
        emailText = new JTextField(15);
        west.add(emailText);

        center.setLayout(new BorderLayout(2, 2));
        volunteercheck = new JCheckBox("Volunteer");
        volunteercheck.setBounds(80,20,10,10);
        studentcouncilcheck = new JCheckBox("Student Council");
        center.add(volunteercheck,BorderLayout.NORTH);
        center.add(studentcouncilcheck,BorderLayout.CENTER);
        computerRadio = new JRadioButton("Computer Science");
        BussinessRadio = new JRadioButton("Business");
        radioGroup = new ButtonGroup();
        radioGroup.add(computerRadio);
        radioGroup.add(BussinessRadio);
        eastNorth.add(computerRadio);
        eastNorth.add(BussinessRadio);
        coursesField = new JList();
        displayButton = new JButton("Display");
        displayButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        southArea.add(displayButton);
        scroll = new JScrollPane(display);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        southArea.add(displayButton);
        southArea.add(scroll);
        courses= new JComboBox<String>();
        courses.setMaximumRowCount(4);
        //courses.setPreferredSize(new Dimension(20, 5));
        courses.setSize(new Dimension(10, 80));
        displayButton.addMouseListener(this);
        computerRadio.addActionListener(this);
        BussinessRadio.addActionListener(this);
       //   courses.addItemListener(this);


        eastCenter.add(courses);
        eastCenter.add(coursesField);



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

