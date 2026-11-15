package com.example.implicitintents;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;

/**
 * Nastavi MaterialToolbar kot naslovno vrstico aktivnosti in doda odmike za
 * sistemske vrstice (edge-to-edge). Toolbar dobi zgornji odmik za statusno
 * vrstico, korenski pogled pa levi, desni in spodnji odmik (vključno s
 * tipkovnico), da vsebina ni pod naslovno ali navigacijsko vrstico.
 */
public final class InsetsUtil {

    private InsetsUtil() {
    }

    public static void setupToolbarAndInsets(AppCompatActivity activity) {
        View root = activity.findViewById(R.id.main);
        MaterialToolbar toolbar = activity.findViewById(R.id.toolbar);
        activity.setSupportActionBar(toolbar);

        // Bele ikone v statusni vrstici na modrem ozadju.
        WindowCompat.getInsetsController(activity.getWindow(), activity.getWindow().getDecorView())
                .setAppearanceLightStatusBars(false);

        ViewCompat.setOnApplyWindowInsetsListener(root, (v, insets) -> {
            Insets bars = insets.getInsets(
                    WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.ime());
            v.setPadding(bars.left, 0, bars.right, bars.bottom);
            toolbar.setPadding(0, bars.top, 0, 0);
            return insets;
        });
    }
}
