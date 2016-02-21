package com.carolinewallis.genchem;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Formula extends Activity {

    //Note: not the best way to transfer data
    public static String selection;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //get Intent
        Intent intent = getIntent();

        //get proper layout
        setContentView(R.layout.formula);

        //menu selection items for ListView
        String [] formulaMenuItems = {"Number of Moles", "Density", "Ideal Gas Law", "Entropy Change",
                "Electric Current", "Molarity", "Molality", "pH", "pOH", "Planck's Energy",
                "Linear Momentum"};

        //adapter for custom row layout
        ListAdapter formulaListAdapter = new ArrayAdapter<String>(this, R.layout.formula_row_layout,
                R.id.textForFormulaList, formulaMenuItems);

        //make adapter using default row layout
        //ListAdapter formulaListAdapter = new ArrayAdapter<String>
          //      (Formula.this, android.R.layout.simple_list_item_1, formulaMenuItems);

        //get view object to convert to ListView
        final ListView formulaListView = (ListView) findViewById(R.id.formulaListView);

        //send data from formulaMenuItems array to ListView
        formulaListView.setAdapter(formulaListAdapter);

        //NOTE: set the listener, when new listener is declared then method will automatically be added
        formulaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //get numerical position of item clicked
                Long formulaSelectedPosition = (formulaListView.getItemIdAtPosition(position));

                //convert Long data type to String
                selection = Long.toString(formulaSelectedPosition);

                DialogFragment displayFragment = new FormulaDialogFragment();
                //The second argument, "anyWord", is a unique tag name that the system uses to save
                // and restore the fragment state when necessary. The tag also allows you to get
                // a handle to the fragment by calling findFragmentByTag().
                displayFragment.show(getFragmentManager(), "anyWord");
            }
        });
    }
}
