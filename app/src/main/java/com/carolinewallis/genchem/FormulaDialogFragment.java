package com.carolinewallis.genchem;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class FormulaDialogFragment extends DialogFragment{

    //to get this shell right click on above, Generate, override methods, onCreateDialog
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Note: not the best way to transfer this data
        String selection = Formula.selection;
        String message = "";

        switch (selection){
            case "0":
                message = "n = m / M" + System.getProperty("line.separator")
                + System.getProperty("line.separator") + "n = number of moles"
                        + System.getProperty("line.separator") + "m = mass"
                        + System.getProperty("line.separator") + "M = molar mass";
                break;
            case "1":
                message = "D = m / V" + System.getProperty("line.separator")
                        + System.getProperty("line.separator") + "D = density"
                        + System.getProperty("line.separator") + "m = mass"
                        + System.getProperty("line.separator") + "V = volume";
                break;
            case "2":
                message = "PV = nRT" + System.getProperty("line.separator")
                        + System.getProperty("line.separator") + "P = pressure"
                        + System.getProperty("line.separator") + "V = volume"
                        + System.getProperty("line.separator") + "n = number of moles"
                        + System.getProperty("line.separator") + "R = universal gas constant"
                        + System.getProperty("line.separator") + "T = temperature";
                break;
            case "3":
                message = "\u2206S\u00b0 = \u2211 S\u00b0 products - \u2211 S\u00b0 reactants" ;
                break;
            case "4":
                message = "I = Q / t" + System.getProperty("line.separator")
                        + System.getProperty("line.separator") + "I = current"
                        + System.getProperty("line.separator") + "Q = total charge"
                        + System.getProperty("line.separator") + "t = time taken";
                break;
            case "5":
                message = "Molarity = moles solute / volume solution in L";
                break;
            case "6":
                message = "Molality = moles solute / weight solvent in kg";
                break;
            case "7":
                message = "pH = -log[H\u207A]";
                break;
            case "8":
                message = "pOH = -log[OH\u207B]";
                break;
            case "9":
                message = "\u2206E = h\u22C5v" + System.getProperty("line.separator")
                        + System.getProperty("line.separator") + "E = Energy"
                        + System.getProperty("line.separator") + "h = 6.63 x 10\u207B\u00B3\u2074J\u22C5s"
                        + System.getProperty("line.separator") + "v = frequency";
                break;
            case "10":
                message = "p = m\u22C5v" + System.getProperty("line.separator")
                        + System.getProperty("line.separator") + "p = linear momentum"
                        + System.getProperty("line.separator") + "m = mass"
                        + System.getProperty("line.separator") + "v = velocity";
        }
        //build dialog, pass activity that the fragment is going to be working on top of
        AlertDialog.Builder formulaDialog = new AlertDialog.Builder(getActivity());
        formulaDialog.setMessage(message);
        formulaDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //cancel the dialog????
            }
        });

        //create AlertDialog object and return it
        return formulaDialog.create();
    }
}
