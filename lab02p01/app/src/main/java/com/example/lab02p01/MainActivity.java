package com.example.lab02p01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn_plus, btn_minus;
    TextView tv_licznik;
    int licznik = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btn_plus = findViewById(R.id.btn_plus);
        btn_minus = findViewById(R.id.btn_mius);
        tv_licznik = findViewById(R.id.tv_licznik);
        dodaj_sluchacze();
    }

    private void dodaj_sluchacze() {
        View.OnClickListener sluchacz = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int id = v.getId();
               if(id==R.id.btn_plus)
                 licznik++;
               else
                   licznik--;
                tv_licznik.setText(String.valueOf(licznik));
            }
        };
        btn_plus.setOnClickListener(sluchacz);
        btn_minus.setOnClickListener(sluchacz);

        tv_licznik.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                licznik=0;
                tv_licznik.setText(String.valueOf(licznik));
                return false;
            }
        });
    }
}