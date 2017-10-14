package com.cse.mist.bookstack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Borrower extends AppCompatActivity {

    private Button PopUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrower);


        Button btn = (Button) findViewById(R.id.contact);
        PopUpButton = (Button) findViewById(R.id.popupButton);

        /**    Defining a click event listener    */
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /** Creating an intent with the dialer's action name  */
                /** Since the intent is created with activity's action name, the intent is an implicit intent */
                Intent intent = new Intent("android.intent.action.DIAL");

                /** Starting the Dialer activity */
                startActivity(intent);
            }
        };
        btn.setOnClickListener(listener);

        PopUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popup = new PopupMenu(Borrower.this, PopUpButton);

                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        Toast.makeText(Borrower.this, "Selected:" + item.getTitle(), Toast.LENGTH_LONG).show();
                        return true;
                    }
                });

                popup.show();
            }
        });


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.one1:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                getActionBar().getDisplayOptions();
                return true;
            case R.id.one2:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                getActionBar().getDisplayOptions();
                return true;
            case R.id.one3:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                getActionBar().getDisplayOptions();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

