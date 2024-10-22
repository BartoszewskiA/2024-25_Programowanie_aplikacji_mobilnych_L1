package com.example.lab02p02a;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText et_haslo, et_dlugosc;
    Button btn_generuj;

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
        et_haslo = findViewById(R.id.et_haslo);
        et_dlugosc = findViewById(R.id.et_dlugosc);
        btn_generuj = findViewById(R.id.btn_generuj);
        btn_generuj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n =0;
                try {
                    n = Integer.parseInt(et_dlugosc.getText().toString());
                } catch (Exception e)
                {
                    Toast.makeText(MainActivity.this, "Pole 'Długość hasła' nie może być puste", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(n<8 || n>20)
                {
                    Toast.makeText(MainActivity.this, "Pole 'Długość hasła' musi wynosić kiędzy 8 - 20", Toast.LENGTH_SHORT).show();
                    et_dlugosc.setText("");
                    return;
                }
                et_haslo.setText(generuj_haslo(n));
            }
        });
    }

    private String generuj_haslo(int n) {
        return "testowe_haslo";
    }
}