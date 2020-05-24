package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean modeSelected = false;
    int gameMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nameInput = findViewById(R.id.nameInputEditText);
        final TextView errorView = findViewById(R.id.errorText);
        final Button fourbyfour = findViewById(R.id.fourByfourButton);
        final Button sixbyfor = findViewById(R.id.sixBySixButton);
        final Button sevenbyfour = findViewById(R.id.sevenByFourButton);

        fourbyfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modeSelected = true;
                gameMode = 4;
                fourbyfour.setBackgroundColor(Color.BLUE);
                sixbyfor.setBackgroundColor(Color.WHITE);
                sevenbyfour.setBackgroundColor(Color.WHITE);
            }
        });


        sixbyfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modeSelected = true;
                gameMode = 6;
                fourbyfour.setBackgroundColor(Color.WHITE);
                sixbyfor.setBackgroundColor(Color.BLUE);
                sevenbyfour.setBackgroundColor(Color.WHITE);
            }
        });

        sevenbyfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modeSelected = true;
                gameMode = 7;
                sevenbyfour.setBackgroundColor(Color.BLUE);
                fourbyfour.setBackgroundColor(Color.WHITE);
                sixbyfor.setBackgroundColor(Color.WHITE);

            }
        });


        findViewById(R.id.enterToGameButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(modeSelected) {
                    Intent i = new Intent(MainActivity.this, GameField.class);
                    i.putExtra("message", nameInput.getText().toString());
                    i.putExtra("gameMode", gameMode);
                    startActivity(i);
                }
                else{
                    errorView.setText("Select a game mode.");
                }
            }
        });






    }
}
