package com.example.mtg_crucible;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public Button btPlayer1Reset, btPlayer2Reset, btPlayer1LifeIncrease, btPlayer1LifeDecrease, btPlayer2LifeIncrease, btPlayer2LifeDecrease;
    TextView Player1Life, Player2Life;
    public int LifeP1, LifeP2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try // hide top bar
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        btPlayer1Reset = findViewById(R.id.player1_reset);
        btPlayer1LifeIncrease = findViewById(R.id.player1_life_increase);
        btPlayer1LifeDecrease = findViewById(R.id.player1_life_decrease);
        btPlayer2Reset = findViewById(R.id.player2_reset);
        btPlayer2LifeIncrease = findViewById(R.id.player2_life_increse);
        btPlayer2LifeDecrease = findViewById(R.id.player2_life_decrese);
        Player1Life = findViewById(R.id.player1_life);
        Player2Life = findViewById(R.id.player2_life);

        LifeP1 = 40;
        LifeP2 = 40;

        btPlayer1Reset.setOnClickListener(v -> {
            LifeP1 = 40;
            Player1Life.setText(String.valueOf(LifeP1));
        });
        btPlayer1LifeIncrease.setOnClickListener(v -> {
            LifeP1 ++;
            Player1Life.setText(String.valueOf(LifeP1));
        });
        btPlayer1LifeDecrease.setOnClickListener(v -> {
            LifeP1 --;
            Player1Life.setText(String.valueOf(LifeP1));
        });
        btPlayer2Reset.setOnClickListener(v -> {
            LifeP2 = 40;
            Player2Life.setText(String.valueOf(LifeP2));
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