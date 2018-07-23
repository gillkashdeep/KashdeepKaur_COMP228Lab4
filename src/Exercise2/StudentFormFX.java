package Exercise2;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.scene.control.*;



public class StudentFormFX extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane root = new GridPane();
        root.setAlignment(Pos.TOP_LEFT);
        root.setHgap(7);
        root.setVgap(7);

        GridPane LeftPane = new GridPane();
        LeftPane.setAlignment(Pos.TOP_LEFT);
        LeftPane.setHgap(7);
        LeftPane.setVgap(7);


        GridPane RightPane = new GridPane();
        RightPane.setAlignment(Pos.TOP_LEFT);
        RightPane.setHgap(2);
        RightPane.setVgap(5);

        GridPane RightLeft = new GridPane();
        RightLeft.setAlignment(Pos.TOP_LEFT);
        RightLeft.setHgap(3);
        RightLeft.setVgap(6);
        GridPane RadioPane = new GridPane();
        RadioPane.setAlignment(Pos.BOTTOM_CENTER);
        RadioPane.setHgap(7);
        RadioPane.setVgap(7);

        GridPane BottomPane = new GridPane();
        BottomPane.setAlignment(Pos.BOTTOM_CENTER);
        BottomPane.setHgap(5);
        BottomPane.setVgap(5);

        Label nameLabel;
        Label addressLabel;
        Label ProvinceLabel;
        Label postalcodeLabel;
        Label phonenumberLabel;
        Label emailLabel;

        TextField nameText;
        TextField addressText;
        TextField ProvinceText;
        TextField postalcodeText;
        TextField phonenumberText;
        TextField emailText;

        CheckBox volunteercheck;
        CheckBox studentcouncilcheck;
        volunteercheck = new CheckBox("Volunteer");
        studentcouncilcheck = new CheckBox("Student Council");

        RadioButton computerRadio, BussinessRadio;
        computerRadio = new RadioButton("Computer Science");
        BussinessRadio = new RadioButton("Business");
        ToggleGroup radioGroup;
        radioGroup = new ToggleGroup();
        computerRadio.setToggleGroup(radioGroup);
        BussinessRadio.setToggleGroup(radioGroup);


        TextArea display;
        display = new TextArea();
        display.setPrefColumnCount(75);
        display.setPrefRowCount(6);
        display.setEditable(false);
        ComboBox<String> courses;
        courses = new ComboBox<String>();
        courses.setVisibleRowCount(4);
        courses.setPrefSize(200, 50);

       Button displayButton;
        displayButton = new Button("Display");
        GridPane.setHalignment(displayButton, HPos.CENTER);
        ScrollPane scroll;
        scroll = new ScrollPane(display);
        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        GridPane.setHalignment(scroll, HPos.CENTER);
        ListView coursesList;

        ObservableList<String> listModelView = FXCollections.observableArrayList();
        ObservableList<String> computerScience = FXCollections.observableArrayList( "Java", "ProgrammingII", "ProgrammingIII",
                "C#");
        ObservableList<String> business = FXCollections.observableArrayList("Management", "Accounts",
                 "Business Communication", "Business Intelligence");
        coursesList = new ListView<String>(listModelView);
        coursesList.setPrefSize(1, 100);



        //LeftPane.add(volunteercheck, 6, 0);
        //LeftPane.add(studentcouncilcheck, 6, 3);

        //RightPane.add(RadioPane, 7, 0);
        //RightPane.add(courses, 7, 2);
        //RightPane.add(coursesList, 7, 3);

        //BottomPane.add(displayButton, 0, 6);
        //BottomPane.add(scroll, 0, 7);

        //RightLeft.add(LeftPane, 0, 0);
        //RightLeft.add(RightPane, 1, 0);

        //root.add(RightLeft, 0, 0);
        //root.add(BottomPane, 0, 1);

        nameLabel = new Label("Name");
        addressLabel = new Label("Address");
        ProvinceLabel = new Label("Province");
        postalcodeLabel = new Label("Postal Code");
        phonenumberLabel = new Label("Phone");
        emailLabel = new Label("Email");
        LeftPane.add(nameLabel,0,0);
        LeftPane.add(addressLabel,0,1);
        LeftPane.add(ProvinceLabel,0,2);
        LeftPane.add(postalcodeLabel,0,3);
        LeftPane.add(phonenumberLabel,0,4);
        LeftPane.add(emailLabel,0,5);




        nameText = new TextField();
        addressText = new TextField();
        ProvinceText = new TextField();
        postalcodeText = new TextField();
        phonenumberText = new TextField();
        emailText= new TextField();

        LeftPane.add(nameText,5,0);
        LeftPane.add(addressText,5,1);
        LeftPane.add(ProvinceText,5,2);
        LeftPane.add(postalcodeText,5,3);
        LeftPane.add(phonenumberText,5,4);
        LeftPane.add(emailText,5,5);

        LeftPane.add(volunteercheck, 6, 1);
        LeftPane.add(studentcouncilcheck, 6, 4);

        RadioPane.add(computerRadio, 0, 0);
        RadioPane.add(BussinessRadio, 1, 0);

        RightPane.add(RadioPane, 7, 0);
        RightPane.add(courses, 7, 2);
        RightPane.add(coursesList, 7, 3);

        BottomPane.add(displayButton, 0, 6);
        BottomPane.add(scroll, 0, 7);

        RightLeft.add(LeftPane, 0, 0);
        RightLeft.add(RightPane, 1, 0);

        root.add(RightLeft, 0, 0);
        root.add(BottomPane, 0, 1);

        radioGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                RadioButton checked = (RadioButton) radioGroup.getSelectedToggle();

                if (checked.getText().equals("Computer Science")) {
                    courses.getSelectionModel().clearSelection();
                    listModelView.clear();
                    courses.setItems(computerScience);
                }

                else {
                    if (checked.getText().equals("Business")) {
                        courses.getSelectionModel().clearSelection();
                        listModelView.clear();
                        courses.setItems(business);
                    }
                }

            }
        });

        courses.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String e1, String e2) {
                // TODO Auto-generated method stub
                if (!listModelView.contains(e2) && e2 != null) {
                    listModelView.add(e2);
                }
            }
        });



        displayButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String fieldStudy = "";
                String CourseStudy = "";
                String additional ="";
                if (studentcouncilcheck.isSelected() && volunteercheck.isSelected())
                    additional = studentcouncilcheck.getText().trim() + "-" + volunteercheck.getText().trim();

                else if (studentcouncilcheck.isSelected() && !volunteercheck.isSelected())
                    additional = studentcouncilcheck.getText().trim();

                else if (volunteercheck.isSelected() && !studentcouncilcheck.isSelected())
                    additional = volunteercheck.getText().trim();

                else if (!studentcouncilcheck.isSelected() && !volunteercheck.isSelected())
                    additional = "No activities";

                if (BussinessRadio.isSelected())

                    fieldStudy = BussinessRadio.getText();

                else if (computerRadio.isSelected())

                    fieldStudy = computerRadio.getText();


                display.setText("");

                // Getting courses from JList and adding the values to myCourses
                // String
                for (int i = 0; i < listModelView.size(); i++) {

                    CourseStudy += listModelView.get(i) + "\n";

                }

                // Printing student information in text area
                display.setText(String.format("%s, %s, %s, %s, %s, %s,%s,%s,%s", nameText.getText(), addressText.getText(),
                        ProvinceText.getText(),postalcodeText .getText(), phonenumberText.getText(), emailText.getText(),additional,fieldStudy,CourseStudy));

            }
        });

        Scene scene = new Scene(root, 850, 400);

        // Configuring stage
        primaryStage.setTitle("Student Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        launch(args);
    }
}
