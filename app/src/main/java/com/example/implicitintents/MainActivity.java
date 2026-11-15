package com.example.implicitintents;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        InsetsUtil.setupToolbarAndInsets(this);
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
