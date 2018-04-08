package com.example.android.displayreleasenotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

public class InputNotes extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.displayreleasenotes.MESSAGE";
    static final int PASS_NOTES = 1;
    private EditText inputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_notes);
    }


    public void sendNotes (View view) {
        Intent intent = new Intent(this, DisplayReleaseNotes.class);
        inputText = (EditText) findViewById(R.id.inputText);
        String notes = inputText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, notes);
        startActivityForResult(intent, PASS_NOTES);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PASS_NOTES) {
            if (resultCode == RESULT_OK) {
                inputText = (EditText) findViewById(R.id.inputText);
                inputText.setText(data.getStringExtra("notes"));
            }

        }

    }

}
