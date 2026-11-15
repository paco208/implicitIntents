package com.example.implicitintents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

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
        String url = mWebsiteEditText.getText().toString().trim();
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startIfResolvable(intent);
    }

    /** Gumb Open Location: prikaže lokacijo na zemljevidu. */
    public void openLocation(View view) {
        String loc = mLocationEditText.getText().toString().trim();
        // Oblika geo:0,0?q=iskana_lokacija; presledke in posebne znake zakodiramo.
        Uri addressUri = Uri.parse("geo:0,0?q=" + Uri.encode(loc));
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
        startIfResolvable(intent);
    }

    /** Gumb Share This Text: deli besedilo z drugimi aplikacijami. */
    public void shareText(View view) {
    }

    /**
     * Zažene implicitni namen samo, če sistem najde aktivnost, ki ga zna
     * obdelati; sicer prikaže obvestilo, da aplikacija ne pade.
     */
    private void startIfResolvable(Intent intent) {
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d(LOG_TAG, "Can't handle this intent: " + intent);
            Toast.makeText(this, R.string.no_app_found, Toast.LENGTH_SHORT).show();
        }
    }
}
