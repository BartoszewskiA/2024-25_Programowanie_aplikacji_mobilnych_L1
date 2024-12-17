package com.example.lab06p01_intencje;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageView iv_01, iv_02, iv_03, iv_04;
    int obrazki[] = {R.drawable.wilk01, R.drawable.wilk02, R.drawable.wilk03, R.drawable.wilk04};
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
        iv_01 = findViewById(R.id.iv_01);
        iv_02 = findViewById(R.id.iv_02);
        iv_03 = findViewById(R.id.iv_03);
        iv_04 = findViewById(R.id.iv_04);
        iv_01.setImageResource(obrazki[0]);
        iv_02.setImageResource(obrazki[1]);
        iv_03.setImageResource(obrazki[2]);
        iv_04.setImageResource(obrazki[3]);
        View.OnClickListener sluchacz = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int do_wyslania;
                int id = v.getId();
                if(id == R.id.iv_01)
                    do_wyslania = obrazki[0];
                else if(id == R.id.iv_02)
                    do_wyslania = obrazki[1];
                else if(id == R.id.iv_03)
                    do_wyslania = obrazki[2];
                else
                    do_wyslania = obrazki[3];
                Intent intencja = new Intent(MainActivity.this, MainActivity2.class);
                intencja.putExtra("obraz", do_wyslania);
                startActivity(intencja);
            }
        };
        iv_01.setOnClickListener(sluchacz);
        iv_02.setOnClickListener(sluchacz);
        iv_03.setOnClickListener(sluchacz);
        iv_04.setOnClickListener(sluchacz);


    }
}