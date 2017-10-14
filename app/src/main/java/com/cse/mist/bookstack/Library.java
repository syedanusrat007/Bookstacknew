package com.cse.mist.bookstack;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Library extends AppCompatActivity {

    ListView listviewbooks;
    DatabaseReference databasebook;
    List<Books> bookList;
    ListView ListViewBooks;
    private EditText editTextInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library);

        databasebook = FirebaseDatabase.getInstance().getReference("books");


        editTextInput = (EditText) findViewById(R.id.editTextInput);
        ListViewBooks = (ListView) findViewById(R.id.listviewbooks);
        bookList = new ArrayList<>();
    }

    protected void onStart() {
        super.onStart();


        databasebook.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                bookList.clear();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    //getting book
                    Books temp = snapshot.getValue(Books.class);

                    //adding book to the list
                    bookList.add(temp);

                }


                BookAdapter bookAdapter = new BookAdapter(Library.this, bookList);
                //BookAdapter bookAdapter1 = new BookAdapter(Main7Activity, bookList);

                //set the adapter to the list view
                ListViewBooks.setAdapter(bookAdapter);
                //bookListView.setAdapter(bookAdapter1);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

    }

    public void onSearchClick(View v) {
        try {
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            String term = editTextInput.getText().toString();
            intent.putExtra(SearchManager.QUERY, term);
            startActivity(intent);
        } catch (Exception e) {
            // TODO: handle exception
        }

    }


}