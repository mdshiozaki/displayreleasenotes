package com.example.android.displayreleasenotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;


public class DisplayReleaseNotes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_release_notes);

        Intent intent = getIntent();
        String message = intent.getStringExtra(InputNotes.EXTRA_MESSAGE);

        TextView noteView = (TextView) findViewById(R.id.noteView);
        noteView.setMovementMethod(new ScrollingMovementMethod());
        noteView.setText(message);

    }
}
