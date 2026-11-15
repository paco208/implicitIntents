package com.example.implicitintents;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText mWebsiteEditText;
    private EditText mLocationEditText;
    private EditText mShareTextEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        InsetsUtil.setupToolbarAndInsets(this);

        mWebsiteEditText = findViewById(R.id.website_edittext);
        mLocationEditText = findViewById(R.id.location_edittext);
        mShareTextEditText = findViewById(R.id.share_edittext);
    }

    /** Gumb Open Website: odpre spletno stran. */
    public void openWebsite(View view) {
    }

    /** Gumb Open Location: prikaže lokacijo na zemljevidu. */
    public void openLocation(View view) {
    }

    /** Gumb Share This Text: deli besedilo z drugimi aplikacijami. */
    public void shareText(View view) {
    }
}
