package com.example.fa.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.Objects;

public class displayResult {

    @FXML
    private Button button;
    @FXML
    private Label result;

    private String role;
    private int hoursWorked;
    private int numDependents;

    public void setRole(String role) {
        this.role = role;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void setNumDependents(int numDependents) {
        this.numDependents = numDependents;
    }

    @FXML
    public void bClick() throws IOException {
        Parent newRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/fa/view.fxml")));
        button.getScene().setRoot(newRoot);
    }

    public void showResult() {
        double grossPay = hoursWorked * 1000.0;
        double socialSecurityDeduction = grossPay * 0.0785;
        double federalTaxDeduction = (grossPay - (grossPay * 0.05 * numDependents)) * 0.15;
        double membershipFee = grossPay * 0.15;
        double netPay = grossPay - (socialSecurityDeduction + federalTaxDeduction + membershipFee);

        String Roles = role.substring(0, 1).toUpperCase() + role.substring(1);
        String resultBuilder =
                "Role: " + Roles + "\n" +
                        "Gross: " + String.format("Php " + "%,.2f", grossPay) + "\n" +
                        "Net: " + String.format("Php " + "%,.2f", netPay) + "\n";

        result.setText(resultBuilder);
    }

}




