package view;

import application.Controller;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

public class Ui extends Application {

    private Controller controller;
    private ChoiceBox<String> choiceBox;
    private TextField firstNameTextField;
    private TextField lastNameTextField;
    private TextField emailTextField;
    private Text language;
    private Text firstName;
    private Text lastName;
    private Text email;
    private Button saveButton;

    private ResourceBundle bundle;
    @Override
    public void start(Stage stage) {

        choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("English", "Farsi", "Japanese");
        firstNameTextField = new TextField();
        lastNameTextField = new TextField();
        emailTextField = new TextField();
        language = new Text("Language");
        firstName = new Text("First name");
        lastName = new Text("Last name");
        email = new Text("Email");
        saveButton = new Button("Save");


        GridPane root = new GridPane();
        root.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);


        root.add(choiceBox, 2, 0);
        root.add(language, 1, 0);
        root.add(firstName, 1, 1);
        root.add(firstNameTextField, 2, 1);
        root.add(lastName, 1, 2);
        root.add(lastNameTextField, 2, 2);
        root.add(email, 1, 3);
        root.add(emailTextField, 2, 3);
        root.add(saveButton, 2, 4);


        GridPane.setHalignment(choiceBox, HPos.CENTER);
        GridPane.setHalignment(language, HPos.CENTER);
        GridPane.setHalignment(firstName, HPos.CENTER);
        GridPane.setHalignment(lastName, HPos.CENTER);
        GridPane.setHalignment(email, HPos.CENTER);
        GridPane.setHalignment(saveButton, HPos.CENTER);

        GridPane.setValignment(choiceBox, VPos.CENTER);


        Scene scene = new Scene(root, 713, 392);
        stage.setScene(scene);
        stage.setTitle("Employee Management");
        stage.show();

        saveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String firstName = firstNameTextField.getText();
                String lastName = lastNameTextField.getText();
                String email = emailTextField.getText();
                String language = choiceBox.getValue();

                if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || language.isEmpty()) {
                    System.out.println("Please fill all fields");
                } else if (!email.contains("@")) {
                    System.out.println("Invalid email");
                } else {
                    controller.saveUser();
                }

            }
        });
        choiceBox.setOnAction(e -> {
            String language = choiceBox.getValue();
            Locale locale;
            if (language.equals("English")) {
                locale = new Locale("en", "US");
            } else if (language.equals("Farsi")) {
                locale = new Locale("fa", "IR");
            } else {
                locale = new Locale("ja", "JP");
            }
            bundle = ResourceBundle.getBundle("messages", locale);
            updateUiText(stage);
        });
    };

    private void updateUiText(Stage stage) {
        stage.setTitle(bundle.getString("app"));
        language.setText(bundle.getString("language"));
        firstName.setText(bundle.getString("firstName"));
        lastName.setText(bundle.getString("lastName"));
        email.setText(bundle.getString("email"));
        saveButton.setText(bundle.getString("saveButton"));
    }

    @Override
    public void init() {
        controller = new Controller(this);
    }

    public String getFirstName() {
        return firstNameTextField.getText();
    }
    public String getLastName() {
        return lastNameTextField.getText();
    }
    public String getEmail() {
        return emailTextField.getText();
    }
    public String getLanguage() {
        return choiceBox.getValue();
    }

}