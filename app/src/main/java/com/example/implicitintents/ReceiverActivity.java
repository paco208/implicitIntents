package com.example.implicitintents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Sprejemna aktivnost: v AndroidManifest.xml ima intent-filter za povezave do
 * developer.android.com, zato se ponudi v izbirniku ob kliku na Open Website.
 * Prejeti URI prikaže v TextView.
 */
public class ReceiverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_receiver);
        InsetsUtil.setupToolbarAndInsets(this);

        Intent intent = getIntent();
        Uri uri = intent.getData();
        if (uri != null) {
            TextView textView = findViewById(R.id.text_uri_message);
            textView.setText(getString(R.string.uri_label, uri.toString()));
        }
    }
}
