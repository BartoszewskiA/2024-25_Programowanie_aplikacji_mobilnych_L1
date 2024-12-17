package com.example.lab07p01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText et_a, et_b;
    Button btn_oblicz;
    TextView tv_wynik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        et_a = findViewById(R.id.et_a);
        et_b = findViewById(R.id.et_b);
        btn_oblicz = findViewById(R.id.button);
        tv_wynik = findViewById(R.id.tv_wynik);

        btn_oblicz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = 0;
                int b = 0;
                try {
                    a = Integer.parseInt(et_a.getText().toString());
                    b = Integer.parseInt(et_b.getText().toString());
                } catch (NumberFormatException e) {
                    tv_wynik.setText("Podaj liczby całkowite");
                    return;
                }
                NajwiekszyWspolnyDzielnik nwd = new NajwiekszyWspolnyDzielnik(a,b);
                tv_wynik.setText("NWD = " + nwd.getNajwiekszyWspolnyDzielnik());
            }
        });

    }
}