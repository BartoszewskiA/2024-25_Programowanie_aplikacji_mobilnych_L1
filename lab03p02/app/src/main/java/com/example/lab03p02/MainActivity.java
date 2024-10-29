package com.example.lab03p02;

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

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText et_dlugosc, et_haslo;
    Button btn_generuj;
    Random random = new Random();

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
        et_dlugosc = findViewById(R.id.et_dlugosc);
        et_haslo = findViewById(R.id.et_haslo);
        btn_generuj = findViewById(R.id.btn_generuj);
        btn_generuj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ile =0;
                try {
                    ile = Integer.parseInt(et_dlugosc.getText().toString());
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Pole 'Długość hasła' nie może być puste ", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(ile<8 || ile>20) {
                    Toast.makeText(MainActivity.this, "długośc  8- 20 znaków ", Toast.LENGTH_SHORT).show();
                    return;
                }

                et_haslo.setText(generuj_haslo(ile));
            }
        });
    }

    private String generuj_haslo(int ile) {
        String maleLitery = "abcdefghijklmnopqrstuvwxyz";
        String duzeLitery = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String cyfry = "0123456789";
        String znakiSpecjalne = "!@#$%^&*()";
        StringBuilder haslo = new StringBuilder();
        for (int i = 0; i < ile-3; i++)
            haslo.append(maleLitery.charAt(random.nextInt(maleLitery.length())));

        int poz = random.nextInt(haslo.length());
        haslo.insert(poz, duzeLitery.charAt(random.nextInt(duzeLitery.length())));
        poz = random.nextInt(haslo.length());
        haslo.insert(poz, cyfry.charAt(random.nextInt(cyfry.length())));
        poz = random.nextInt(haslo.length());
        haslo.insert(poz, znakiSpecjalne.charAt(random.nextInt(znakiSpecjalne.length())));

        return haslo.toString() ;
    }
}