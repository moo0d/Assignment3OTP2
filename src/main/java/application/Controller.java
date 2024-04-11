package application;

import dao.UserDao;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import view.Ui;

import java.awt.*;

public class Controller {

    private final Ui gui;

    private final UserDao dao = new UserDao();

    public Controller(Ui gui) {
        this.gui = gui;
    }

    public void saveUser() {
        String firstName = gui.getFirstName();
        String lastName = gui.getLastName();
        String email = gui.getEmail();
        String language = gui.getLanguage();

        switch (language) {
            case "English" -> dao.insertUser("employee_en", firstName, lastName, email);
            case "Farsi" -> dao.insertUser("employee_fa", firstName, lastName, email);
            case "Japanese" -> dao.insertUser("employee_ja", firstName, lastName, email);
        }
    }
}
