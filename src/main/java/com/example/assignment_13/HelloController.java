package com.example.assignment_13;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class HelloController {

    @FXML
    private Slider slider;

    @FXML
    private Label slider_value;

    @FXML
    private TextField sales;

    @FXML
    private TextField commission;

    @FXML
    void updateSlider_value(MouseEvent event) {
        int sliderIntValue = (int) slider.getValue();
        slider_value.setText(String.valueOf(sliderIntValue) + "%");
    }

    @FXML
    void calculateCommission(ActionEvent event) {
        // Get the value from the sales TextField
        String salesText = sales.getText();

        // Check if the input is not empty
        if (!salesText.isEmpty()) {
            try {
                // Parse the sales value to a double
                double salesValue = Double.parseDouble(salesText);

                // Get the value from the slider (which is in percentage)
                double sliderPercentage = slider.getValue();

                // Convert the slider percentage to an integer
                int sliderIntPercentage = (int) sliderPercentage;

                // Convert the integer percentage to a decimal fraction
                double sliderFraction = sliderIntPercentage / 100.0;

                // Calculate the commission
                double commissionValue = salesValue * sliderFraction;

                // Set the calculated commission value to the commission TextField
                commission.setText(String.format("GHS %.2f", commissionValue));
            } catch (NumberFormatException e) {
                // Handle the case where the input is not a valid number
                commission.setText("Invalid input");
            }
        } else {
            // Handle the case where the sales TextField is empty
            sales.setText("Enter a value");
        }
    }

    @FXML
    void handleReset(ActionEvent event) {
        // Reset the sales TextField
        sales.setText("");

        // Reset the commission TextField
        commission.setText("");

        // Reset the slider_value Label
        slider_value.setText("");
    }

}
