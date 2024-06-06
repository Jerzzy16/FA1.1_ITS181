package com.example.fa1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
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
    private void resultInfo() {
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

            double grossPay = hoursWorked * 1000.0;
            double socialSecurityDeduction = grossPay * 0.0785;
            double federalTaxDeduction = (grossPay - (grossPay * 0.05 * numDependents)) * 0.15;
            double membershipFee = grossPay * 0.15;
            double netPay = grossPay - (socialSecurityDeduction + federalTaxDeduction + membershipFee);


            String resultBuilder =
                    "Role: " + role + "\n" +
                    "Gross: " + String.format("%,.2f", grossPay) + "\n" +
                    "Net: " + String.format("%,.2f", netPay) + "\n";

            resultLabel.setText(resultBuilder);
        } catch (NumberFormatException x) {
            resultLabel.setText("Invalid input. Please Check Again");
        }
    }
}