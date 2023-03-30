package com.example.midtermexam;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;

import javax.swing.text.html.ImageView;

public class BMIController implements Initializable {
    @FXML
    private Label resultText;

    @FXML
    private Button CalButton;

    @FXML
    private TextField hInput;

    @FXML
    private TextField wInput;

    @FXML
    private ComboBox<String> hCombo;

    @FXML
    private ComboBox<String> wCombo;


    /**
     * The method onCalculateButtonClick is the actionEvent when user click the button "Calculate".
     * Getting information from TextField and combox and using them in the calculation.
     * The height and weight values will be switch when user choose lb, inch, and cm as unit.
     * BMI formula I use: Weight(kg) / Height(m)^2.
     */

    //protected void onHelloButtonClick()
    public void onCalButtonClick() {
        String heightUnit = hCombo.getSelectionModel().getSelectedItem();
        String weightUnit = wCombo.getSelectionModel().getSelectedItem();
        double hswitch,wswitch,hIn,wIn;

        // get double values of height and weight from input
        hIn = Double.parseDouble(hInput.getText());
        wIn = Double.parseDouble(wInput.getText());
        wswitch = 0;
        hswitch = 0;

        // switch the unit of each variable (height and weight)
        if (weightUnit.equals("kg")){
            wswitch = 1.0;
        }
        if (weightUnit.equals("lb")){
            wswitch = 0.454;
        }
        if (heightUnit.equals("inch")){
            hswitch = 0.0254;
        }
        if (heightUnit.equals("cm")){
            hswitch = 0.01;
        }

        // calculate BMI here following formula
        double result = wIn * wswitch / Math.pow(hIn * hswitch,2);
        String str = String.format("%.2f",result);
        String range = "";
        if (result < 18.5){
            range = "Underweight";
        }
        else if (18.5 <= result && result <= 24.9){
            range = "Normal Weight";
        }
        else if (25.0 <= result && result <= 29.9 ){
            range = "Overweight";
        }
        else{
            range = "Obsity Weight";
        }

        // print result here
        resultText.setText("Your BMI is: " + str + ". " + range);
    }

    /**
     * This method is using for initial the comboxes hCombo and wCombo.
     * Set inch and cm into hCombo
     * Set kg and lb in wCombo
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hCombo.setItems(FXCollections.observableArrayList("inch","cm"));
        wCombo.setItems(FXCollections.observableArrayList("kg","lb"));
    }


}