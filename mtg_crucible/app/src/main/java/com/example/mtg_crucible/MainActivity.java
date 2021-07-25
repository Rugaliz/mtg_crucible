package com.example.mtg_crucible;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public Button  btPlayer1LifeIncrease, btPlayer1LifeDecrease,
            btPlayer2LifeIncrease, btPlayer2LifeDecrease, setDefault20, setDefault25, setDefault40;
    TextView Player1Life, Player2Life;
    public int LifeP1, LifeP2, defaultLife;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON); // keeps screen awake

        try // hide top bar
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        btPlayer1LifeIncrease = findViewById(R.id.player1_life_increase);
        btPlayer1LifeDecrease = findViewById(R.id.player1_life_decrease);
        btPlayer2LifeIncrease = findViewById(R.id.player2_life_increse);
        btPlayer2LifeDecrease = findViewById(R.id.player2_life_decrese);
        Player1Life = findViewById(R.id.player1_life);
        Player2Life = findViewById(R.id.player2_life);
        setDefault20 = findViewById(R.id.setDefault20);
        setDefault25 = findViewById(R.id.setDefault25);
        setDefault40 = findViewById(R.id.setDefault40);
        defaultLife = 20;

        LifeP1 = defaultLife;
        LifeP2 = defaultLife;

        Player1Life.setText(String.valueOf(LifeP1));
        Player2Life.setText(String.valueOf(LifeP2));

        setDefault20.setOnClickListener(c -> {
            defaultLife = 20;
            LifeP1 = defaultLife;
            LifeP2 = defaultLife;
            Player1Life.setText(String.valueOf(LifeP1));
            Player2Life.setText(String.valueOf(LifeP2));
        });

        setDefault25.setOnClickListener(c -> {
            defaultLife = 25;
            LifeP1 = defaultLife;
            LifeP2 = defaultLife;
            Player1Life.setText(String.valueOf(LifeP1));
            Player2Life.setText(String.valueOf(LifeP2));
        });

        setDefault40.setOnClickListener(c -> {
            defaultLife = 40;
            LifeP1 = defaultLife;
            LifeP2 = defaultLife;
            Player1Life.setText(String.valueOf(LifeP1));
            Player2Life.setText(String.valueOf(LifeP2));
        });


        btPlayer1LifeIncrease.setOnClickListener(v -> {
            LifeP1 ++;
            Player1Life.setText(String.valueOf(LifeP1));
        });
        btPlayer1LifeDecrease.setOnClickListener(v -> {
            LifeP1 --;
            Player1Life.setText(String.valueOf(LifeP1));
        });

        btPlayer2LifeIncrease.setOnClickListener(v -> {
            LifeP2 ++;
            Player2Life.setText(String.valueOf(LifeP2));
        });
        btPlayer2LifeDecrease.setOnClickListener(v -> {
            LifeP2 --;
            Player2Life.setText(String.valueOf(LifeP2));
        });


    }
}