package com.carolinewallis.genchem;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //menu selection items for menuListView
        String[] menuItems = {"Periodic Table", "Atomic Mass", "Formulas", "Conversion Factors",
        "Constants", "Khan Academy Resource"};

        //make adapter so the array can work with the listView
        ListAdapter menuListAdapter = new ArrayAdapter<String>(this,
                R.layout.row_layout, R.id.textForMenuList, menuItems);

        //get view object to convert to ListView, declared final b/c used in inner method
        final ListView menuListView = (ListView) findViewById(R.id.menuListView);

        //send data from menuItems array to ListView
        menuListView.setAdapter(menuListAdapter);

        //catch clicks on menu list items
        menuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String message = "You picked " +
                        String.valueOf(parent.getItemAtPosition(position));

                //get numerical position of item clicked in list
                Long menuSelectedPosition = (menuListView.getItemIdAtPosition(position));
                //convert Long data type to String
                String menuSelectedPositionString = Long.toString(menuSelectedPosition);
                //determine which button was clicked and take appropriate action
                switch (menuSelectedPositionString) {
                    case "0":
                        Intent periodicTableIntent = new Intent(MainActivity.this, PeriodicTable.class);
                        //periodicTableIntent.putExtra("key", value); to pass data
                        MainActivity.this.startActivity(periodicTableIntent);
                        break;
                    case "1":
                        Intent atomicMassIntent = new Intent(MainActivity.this, AtomicMass.class);
                        MainActivity.this.startActivity(atomicMassIntent);
                        break;
                    case "2":
                        //Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                        Intent formulaIntent = new Intent (MainActivity.this, Formula.class);
                        MainActivity.this.startActivity(formulaIntent);
                        break;
                    case "3":
                        Intent unitConversionIntent = new Intent(MainActivity.this, UnitConversion.class);
                        MainActivity.this.startActivity(unitConversionIntent);
                        break;
                    case "4":
                        Intent constantsIntent = new Intent(MainActivity.this, Constants.class);
                        MainActivity.this.startActivity(constantsIntent);
                        break;
                    case "5":
                        Uri uriUrl = Uri.parse("http://khanacademy.org/science/chemistry/");
                        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                        startActivity(launchBrowser);
                        break;
                }
            }
        });
    }

    public void onClickPeriodicTable(View view){
        //create intent to open another activity and pass context and activity to be opened
        Intent getPeriodicTableIntent = new Intent(this, PeriodicTable.class);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
