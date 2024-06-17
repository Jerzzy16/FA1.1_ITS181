package com.example.fa.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Result {
    @FXML
    private TextField nameField;
    @FXML
    private TextField roleField;
    @FXML
    private TextField dependentField;
    @FXML
    private TextField hoursField;
    @FXML
    private Label resultLabel;



    @FXML
    private void resultInfo(ActionEvent actionEvent) throws IOException {
        try {
            String name = nameField.getText();
            if (name.isEmpty() || name.trim().isEmpty()) {
                resultLabel.setText("Please Enter Name.");
                return;
            }
            boolean containsDigit = false;
            for (char c : name.toCharArray()) {
                if (Character.isDigit(c)) {
                    containsDigit = true;
                    break;
                }
            }
            if (containsDigit) {
                resultLabel.setText("Name cannot contain numbers.");
                return;
            }

            String role = roleField.getText().toLowerCase();
            if (!(role.equals("tester") || role.equals("programmer") || role.equals("analyst"))) {
                resultLabel.setText("Please enter a Valid Role");
                return;
            }

            int numDependents = Integer.parseInt(dependentField.getText());
            int hoursWorked = Integer.parseInt(hoursField.getText());

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fa/view2.fxml"));
            Parent root = loader.load();


            displayResult dr = loader.getController();
            dr.setRole(role);
            dr.setHoursWorked(hoursWorked);
            dr.setNumDependents(numDependents);

            dr.showResult();

            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (NumberFormatException x) {
            resultLabel.setText("Invalid input. Please Check Again");
        }
    }

}