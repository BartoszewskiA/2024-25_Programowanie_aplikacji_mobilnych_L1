package com.example.lab03p03;

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

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int[] obrazki = {R.drawable.owoc01, R.drawable.owoc02, R.drawable.owoc03, R.drawable.owoc04};
    int los_1=0, los_2=0, los_3=0;
    int kredyt = 50;
    int licznik =0;

    ImageView  iv_01, iv_02, iv_03;
    TextView tv_kredyt, tv_seria;
    Button btn_graj, btn_nowa_gra;
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
        iv_01 = findViewById(R.id.iv_01);
        iv_02 = findViewById(R.id.iv_02);
        iv_03 = findViewById(R.id.iv_03);
        tv_kredyt = findViewById(R.id.tv_kredyt);
        tv_seria = findViewById(R.id.tv_seria);
        btn_graj = findViewById(R.id.btn_graj);
        btn_nowa_gra = findViewById(R.id.btn_nowa_gra);
        btn_graj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                losuj();
                podlicz_wyniki();
            }
        });
        btn_nowa_gra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_graj.setEnabled(true);
                kredyt=50;
                licznik=0;
                tv_kredyt.setText(kredyt+" $$");
                tv_seria.setText(String.valueOf(licznik));
                iv_01.setImageDrawable(null);
                iv_02.setImageDrawable(null);
                iv_03.setImageDrawable(null);
            }
        });
    }

    private void podlicz_wyniki() {
        if(los_1==los_2 && los_2==los_3)
            kredyt+=30;
        else if(los_1==los_2 || los_1==los_3 || los_2==los_3);
        else kredyt-=5;
        licznik++;
        tv_kredyt.setText(kredyt+" $$");
        tv_seria.setText(String.valueOf(licznik));
        if(kredyt<=0)
            btn_graj.setEnabled(false);
    }

    private void losuj() {

            los_1 = random.nextInt(obrazki.length);
            los_2 = random.nextInt(obrazki.length);
            los_3 = random.nextInt(obrazki.length);
            iv_01.setImageResource(obrazki[los_1]);
            iv_02.setImageResource(obrazki[los_2]);
            iv_03.setImageResource(obrazki[los_3]);
    }
}