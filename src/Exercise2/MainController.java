package Exercise2;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController {
    //Declarations and initializations
    @FXML private TextField NameTxt;
    @FXML private TextField AddressTxt;
    @FXML private TextField ProvinceTxt;
    @FXML private TextField CityTxt;
    @FXML private TextField PostalCodeTxt;
    @FXML private TextField PhNumberTxt;
    @FXML private TextField EmailTxt;
    @FXML private CheckBox StudentCouncil;
    @FXML private CheckBox VolunteerWork;
    @FXML private RadioButton CompScience;
    @FXML private RadioButton Business;
    @FXML private Button DisplayBtn;
    @FXML private TextArea textArea;
    @FXML private ComboBox<String> ComboBox ;
    @FXML private ListView<String> ListView;

    int count = 0;
    String a[]=new String[4];


    //new method for the click of Display button
    @FXML private void onDisplayBtnClicked() {
        String course="";
        String value1 = " ";
        String value2 = " ";
        String value3 =" ";
        ObservableList<String> courses = ListView.getItems();

        for (String each: courses)
        {
            course = course +each+System.lineSeparator() ;
        }

        if (StudentCouncil.isSelected()) {
            value1 = "Student Council" + System.lineSeparator();
        }
        if (VolunteerWork.isSelected()) {
            value2 = "Volunteer Work" ;
        }

        value3=(NameTxt.getText() +", " +AddressTxt.getText() +", " +ProvinceTxt.getText() +", " +
                CityTxt.getText() +", " +PostalCodeTxt.getText() +", " +PhNumberTxt.getText() +", " +EmailTxt.getText() + System.lineSeparator() + System.lineSeparator() + "course" );
        textArea.setText(value3 + course + System.lineSeparator() +"Additional Information"+ System.lineSeparator() +value1+ value2);

    }
    //new method for the selections of radio buttons
    @FXML private void initialize()
    {
        ObservableList<String> ComputerScienceCourses = FXCollections.observableArrayList("Java", "Python", "C++","C#");
        ObservableList<String> BusinessCourses = FXCollections.observableArrayList("Management", "Finance", "Accounting");


        if (CompScience.isSelected())
        {
            ComboBox.setItems(ComputerScienceCourses);

        }else if (Business.isSelected())
        {

            ComboBox.setItems(BusinessCourses);
        }
    }
    //new method for the selections of courses in combo box
    @FXML private void OnSelectCourse()
    {
        int check = 0;
        String userChoice = ComboBox.getValue();
        ListView.getItems().add(userChoice);

        if(count<=3)
        {
            a[count]=userChoice;
            count++;
        }

        for(int i=0;i<=3;i++)
        {
            if (userChoice == a[i])
            {
                check=1;
                break;
            }
        }
        if(check==0)
        {}
    }




}
