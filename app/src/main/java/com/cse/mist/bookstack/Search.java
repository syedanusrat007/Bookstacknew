package com.cse.mist.bookstack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Search extends AppCompatActivity {

    private Button button1;
    private EditText editTextInput2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);


        editTextInput2 = (EditText) findViewById(R.id.editTextInput1);
        button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {

                                       @Override
                                       public void onClick(View view) {

                                           Intent intent1 = new Intent(Search.this, MapsActivity2.class);
                                           startActivity(intent1);

                                       }
                                   }
        );

    }


}
