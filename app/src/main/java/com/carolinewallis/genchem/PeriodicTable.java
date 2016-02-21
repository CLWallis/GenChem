package com.carolinewallis.genchem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class PeriodicTable extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        //get proper layout
        setContentView(R.layout.periodic_table);
    }
}
