package com.example.memorygame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class ScoreScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_screen);

        TextView scoreText = findViewById(R.id.scoreText);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        int score = intent.getIntExtra("score",0);
        int wrongMoves = intent.getIntExtra("wrongMoves",0);
        scoreText.setText("Congratulations,\n"+ username + "\nYour score: " + score +
                "\nWrong Moves: " + wrongMoves);
        Button playAgainButton = findViewById(R.id.playAgainButton);

        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ScoreScreen.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
