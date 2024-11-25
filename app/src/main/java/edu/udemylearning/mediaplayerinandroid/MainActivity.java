package edu.udemylearning.mediaplayerinandroid;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private MaterialButton mainBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainBtn = findViewById(R.id.mainBtn);
        mainBtn.setOnClickListener(V->nextPage());
    }

    private void nextPage() {
        startActivity(new Intent(MainActivity.this, DisplayTrailer.class));
        finish();
    }
}