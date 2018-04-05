package com.example.android.displayreleasenotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

public class InputNotes extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.displayreleasenotes.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_notes);
    }


    public void sendNotes (View view) {
        Intent intent = new Intent(this, DisplayReleaseNotes.class);
        EditText inputText = (EditText) findViewById(R.id.inputText);
        String notes = inputText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, notes);
        startActivity(intent);

    }

}
