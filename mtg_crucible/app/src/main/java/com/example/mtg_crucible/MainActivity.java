package com.example.mtg_crucible;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.provider.Telephony.Mms.Part.TEXT;

public class MainActivity extends AppCompatActivity {
    public Button  btPlayer1LifeIncrease, btPlayer1LifeDecrease,
            btPlayer2LifeIncrease, btPlayer2LifeDecrease, setDefault20, setDefault25, setDefault40;
    public TextView Player1Life, Player2Life;
    public int LifeP1, LifeP2, defaultLife;
    public static final String SHARED_PREFS = "sharedPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // set layout file on create

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);   // keeps screen awake

        try // hide top bar
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        // link Buttons to layout objects
        btPlayer1LifeIncrease = findViewById(R.id.player1_life_increase);
        btPlayer1LifeDecrease = findViewById(R.id.player1_life_decrease);
        btPlayer2LifeIncrease = findViewById(R.id.player2_life_increse);
        btPlayer2LifeDecrease = findViewById(R.id.player2_life_decrese);
        setDefault20 = findViewById(R.id.setDefault20);
        setDefault25 = findViewById(R.id.setDefault25);
        setDefault40 = findViewById(R.id.setDefault40);
        // Link TextView to layout objects
        Player1Life = findViewById(R.id.player1_life);
        Player2Life = findViewById(R.id.player2_life);

        defaultLife = 20; // sets default starting life life

        LifeP1 = defaultLife;
        LifeP2 = defaultLife;

        loadData();
        updateViews();

        Player1Life.setText(String.valueOf(LifeP1));
        Player2Life.setText(String.valueOf(LifeP2));

        setDefault20.setOnClickListener(c -> { // acts on Button click
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
            saveData();
        });
        btPlayer1LifeDecrease.setOnClickListener(v -> {
            LifeP1 --;
            Player1Life.setText(String.valueOf(LifeP1));
            saveData();
        });

        btPlayer2LifeIncrease.setOnClickListener(v -> {
            LifeP2 ++;
            Player2Life.setText(String.valueOf(LifeP2));
            saveData();
        });
        btPlayer2LifeDecrease.setOnClickListener(v -> {
            LifeP2 --;
            Player2Life.setText(String.valueOf(LifeP2));
            saveData();
        });


    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) { // saves data for activity change
        super.onSaveInstanceState(savedInstanceState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        //savedInstanceState.putBoolean("MyBoolean", true);
        //savedInstanceState.putDouble("myDouble", 1.9);
        savedInstanceState.putInt("LifeP1", LifeP1);
        savedInstanceState.putInt("LifeP2", LifeP2);
        //savedInstanceState.putString("MyString", "Welcome back to Android");
        // etc.
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        //boolean myBoolean = savedInstanceState.getBoolean("MyBoolean");
        //double myDouble = savedInstanceState.getDouble("myDouble");
        int LifeP1 = savedInstanceState.getInt("LifeP1", 20);
        int LifeP2 = savedInstanceState.getInt("LifeP2", 20);
        Player1Life.setText(String.valueOf(LifeP1));
        Player2Life.setText(String.valueOf(LifeP2));
        //String myString = savedInstanceState.getString("MyString");
    }


    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //editor.putString(TEXT, textView.getText().toString());
        //editor.putBoolean(SWITCH1, switch1.isChecked());
        editor.putInt("Player1Life",LifeP1);
        editor.putInt("Player2Life",LifeP2);
        editor.apply();
        //Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        LifeP1 = sharedPreferences.getInt("Player1Life", 20);
        LifeP2 = sharedPreferences.getInt("Player2Life", 20);
        //text = sharedPreferences.getString(TEXT, "");
        //switchOnOff = sharedPreferences.getBoolean(SWITCH1, false);
    }

    public void updateViews() {
        Player1Life.setText(String.valueOf(LifeP1));
        Player2Life.setText(String.valueOf(LifeP2));
        //textView.setText(text);
        //switch1.setChecked(switchOnOff);
    }



}