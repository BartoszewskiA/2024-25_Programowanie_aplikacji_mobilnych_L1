package com.example.lab04p01_atlas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    int[] obrazki = {
            R.drawable.muchomor,
            R.drawable.borowik,
            R.drawable.maslak
    };

    String[] nazwy;
    String[] opisy;
    int poz = 0;

    ImageView imageView;
    Button btn_next, btn_back;
    TextView tv_nazwa, tv_opis;

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
        nazwy = getResources().getStringArray(R.array.nazwy);
        opisy = getResources().getStringArray(R.array.opisy);
        imageView = findViewById(R.id.imageView01);
        btn_next = findViewById(R.id.button02);
        btn_back = findViewById(R.id.button01);
        tv_nazwa = findViewById(R.id.textView02);
        tv_opis = findViewById(R.id.textView03);
        odswierz();

        View.OnClickListener sluchacz = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Id = v.getId();
                if(Id == R.id.button01)
                    poz++;
                else if(Id == R.id.button02)
                    poz--;
                if(poz < 0)
                    poz = obrazki.length-1;
                else if(poz > obrazki.length-1)
                    poz = 0;
                odswierz();
            }
        };
        btn_next.setOnClickListener(sluchacz);
        btn_back.setOnClickListener(sluchacz);
    }

    private void odswierz() {
        imageView.setImageResource(obrazki[poz]);
        tv_nazwa.setText(nazwy[poz]);
        tv_opis.setText(opisy[poz]);
    }

}