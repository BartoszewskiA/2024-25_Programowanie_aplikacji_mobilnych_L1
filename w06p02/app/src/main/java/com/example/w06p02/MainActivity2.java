package com.example.w06p02;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    int[] obrazki = {R.drawable.wilk01, R.drawable.wilk02, R.drawable.wilk03, R.drawable.wilk04};
    ImageView iv_01, iv_02, iv_03, iv_04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        iv_01 = findViewById(R.id.a2_iV_01);
        iv_02 = findViewById(R.id.a2_iV_02);
        iv_03 = findViewById(R.id.a2_iV_03);
        iv_04 = findViewById(R.id.a2_iV_04);
        iv_01.setImageResource(obrazki[0]);
        iv_02.setImageResource(obrazki[1]);
        iv_03.setImageResource(obrazki[2]);
        iv_04.setImageResource(obrazki[3]);
        iv_01.setOnClickListener(v -> zaladujObrazek(0));
        iv_02.setOnClickListener(v -> zaladujObrazek(1));
        iv_03.setOnClickListener(v -> zaladujObrazek(2));
        iv_04.setOnClickListener(v -> zaladujObrazek(3));
    }

    void zaladujObrazek(int nr) {
        Intent intencja = new Intent();
        intencja.putExtra("wybrany", obrazki[nr]);
        setResult(RESULT_OK, intencja);
        finish();
    }
}