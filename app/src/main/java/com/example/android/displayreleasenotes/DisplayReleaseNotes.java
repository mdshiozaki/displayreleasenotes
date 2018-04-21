package com.example.android.displayreleasenotes;

import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.widget.TextView;


public class DisplayReleaseNotes extends AppCompatActivity {

    private TextView noteView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_release_notes);

        Intent intent = getIntent();
        String notes = intent.getStringExtra(InputNotes.EXTRA_MESSAGE);

        noteView = (TextView) findViewById(R.id.noteView);
        noteView.setMovementMethod(new ScrollingMovementMethod());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            noteView.setText(Html.fromHtml(notes, Html.FROM_HTML_MODE_COMPACT));
        }else {
            noteView.setText(Html.fromHtml(notes));
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                Intent i = new Intent(this, InputNotes.class);
                i.putExtra("notes", noteView.getText().toString());
                setResult(RESULT_OK, i);

                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent();
        i.putExtra("notes", noteView.getText().toString());
        setResult(RESULT_OK, i);
        //finish();
        super.onBackPressed();
    }
}
