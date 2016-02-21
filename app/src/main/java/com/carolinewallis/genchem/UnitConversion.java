package com.carolinewallis.genchem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class UnitConversion extends Activity {

    private EditText numberToBeConvertedEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        //get proper layout
        setContentView(R.layout.unit_conversions);

        //create array adapter using string array and a default spinner layout
        ArrayAdapter<CharSequence> unitsAdapter = ArrayAdapter.createFromResource(this,
                R.array.units_array, android.R.layout.simple_spinner_item);

        //create a spinner for the from units
        final Spinner fromUnitSpinner = (Spinner) findViewById(R.id.fromUnitSelection);
        //create a spinner for the to units
        Spinner toUnitSpinner = (Spinner) findViewById(R.id.toUnitSelection);

        //specify layout to use when list of choices appears
        unitsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //apply adapter to spinner
        fromUnitSpinner.setAdapter(unitsAdapter);
        //apply adapter to the spinner, will work because the selections are the same
        toUnitSpinner.setAdapter(unitsAdapter);

    }

    public void convertClick(View view) {

        Double result = null;

        //get position and value of FROM unit
        Spinner fromUnitSelection = (Spinner) findViewById(R.id.fromUnitSelection);
        int fromPosition = fromUnitSelection.getSelectedItemPosition();
        String fromUnit = fromUnitSelection.getSelectedItem().toString();
        //Toast.makeText(UnitConversion.this,"Position " + fromPosition, Toast.LENGTH_LONG).show();
        //Toast.makeText(UnitConversion.this,"Position " + fromUnit, Toast.LENGTH_LONG).show();

        //get position and value of TO unit
        Spinner toUnitSelection = (Spinner) findViewById(R.id.toUnitSelection);
        int toPosition = toUnitSelection.getSelectedItemPosition();
        String toUnit = toUnitSelection.getSelectedItem().toString();

        //get number to be converted
        numberToBeConvertedEditText = (EditText) findViewById(R.id.numberToBeConvertedEditText);
        String numberToBeConvertedString = numberToBeConvertedEditText.getText().toString();

        //if the EditText is empty
        if (numberToBeConvertedString.matches("")) {
            Toast.makeText(this, "Enter a number to be converted", Toast.LENGTH_LONG).show();
        } else { //if it is not empty proceed with conversion
            Double numberToBeConverted = Double.parseDouble(numberToBeConvertedString);
            //compare the to against the from, the conversion must be compatible
            switch (fromPosition) {
                case 0:
                    if(toPosition == 0) { //Celsius to Celsius
                        result = Math.round((numberToBeConverted) * 10) / 10D;
                        displayResults(result, numberToBeConvertedString, fromUnit, toUnit);
                    }else
                        if(toPosition == 1){ //Celsius to Fahrenheit
                            result = Math.round((numberToBeConverted * (9.0 / 5.0) + 32) * 10) / 10D;
                            displayResults(result, numberToBeConvertedString, fromUnit, toUnit);
                        }else
                            if(toPosition == 2){ //Celsius to Kelvin
                                result = Math.round((numberToBeConverted + 273.15) * 10) / 10D;
                                displayResults(result, numberToBeConvertedString, fromUnit, toUnit);
                            }else
                                Toast.makeText(this, "Incompatible conversion.", Toast.LENGTH_LONG).show();
                    break;
                case 1:
                    if(toPosition == 0){ //Fahrenheit to Celsius
                        result = Math.round(((numberToBeConverted - 32.0) * (5.0 / 9.0)) * 10) / 10D;
                        displayResults(result, numberToBeConvertedString, fromUnit, toUnit);
                    }else
                        if(toPosition == 1){ //Fahrenheit to Fahrenheit
                            result = Math.round((numberToBeConverted) * 10) / 10D;
                            displayResults(result, numberToBeConvertedString, fromUnit, toUnit);
                        }else
                            if(toPosition == 2){ //Fahrenheit to Kelvin
                                result = Math.round(((numberToBeConverted + 459.67) * (5.0 / 9.0)) * 10) / 10D;
                                displayResults(result, numberToBeConvertedString, fromUnit, toUnit);
                            }else
                                Toast.makeText(this, "Incompatible conversion.", Toast.LENGTH_LONG).show();
                    break;
                case 2:
                    if(toPosition == 0){ //Kelvin to Celsius
                        result = Math.round((numberToBeConverted - 273.15) * 10) / 10D;
                        displayResults(result, numberToBeConvertedString, fromUnit, toUnit);
                    }else
                        if(toPosition == 1){ //Kelvin to Fahrenheit
                            result = Math.round((numberToBeConverted * 9 / 5 - 459.67) * 10) / 10D;
                            displayResults(result, numberToBeConvertedString, fromUnit, toUnit);
                        }else
                            if(toPosition == 2){ //Kelvin to Kelvin
                                result = Math.round((numberToBeConverted) * 10) / 10D;
                                displayResults(result, numberToBeConvertedString, fromUnit, toUnit);
                            }else
                                Toast.makeText(this, "Incompatible conversion.", Toast.LENGTH_LONG).show();
                    break;
                case 3:
                    if(toPosition == 3){ //Joule to Joule
                        result = Math.round((numberToBeConverted) * 100) / 100D;
                        displayResults(result, numberToBeConvertedString, fromUnit, toUnit);
                    }else
                        if(toPosition == 4){ //Joule to calorie
                            result = Math.round((numberToBeConverted / 4.184) * 100) / 100D;
                            displayResults(result, numberToBeConvertedString, fromUnit, toUnit);
                        }else
                            Toast.makeText(this, "Incompatible conversion.", Toast.LENGTH_LONG).show();
                    break;
                case 4:
                    if(toPosition == 3){ //calorie to Joule
                        result = Math.round((numberToBeConverted * 4.184) * 100) / 100D;
                        displayResults(result, numberToBeConvertedString, fromUnit, toUnit);
                    }else
                        if(toPosition == 4){ //calorie to calorie
                            result = Math.round((numberToBeConverted) * 100) / 100D;
                            displayResults(result, numberToBeConvertedString, fromUnit, toUnit);
                        }else
                            Toast.makeText(this, "Incompatible conversion.", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }

    //method to display result of conversion
    public void displayResults(Double result, String numberToBeConvertedString,
                               String fromUnit, String toUnit){
        String message = "";
        String resultString = "";

        resultString = String.valueOf(result);
        message = numberToBeConvertedString + " " + fromUnit + " = " + resultString + " " + toUnit;

        TextView resultTextView = (TextView) findViewById(R.id.resultTextView);
        resultTextView.setText(message);
    }

    //when a number to be converted is entered make sure edit text and result text view are
    //empty when focus is on edit text
    public void editTextClick(View view) {
        //will crash if edit text has never had focus and convert button is clicked
        //numberToBeConvertedEditText.setText("");
        TextView resultTextView = (TextView) findViewById(R.id.resultTextView);
        resultTextView.setText("");
    }
}
