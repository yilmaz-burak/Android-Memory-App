package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.gridlayout.widget.GridLayout;
import android.widget.TextView;

public class GameField extends AppCompatActivity {
    int lastCardId = 0;
    int wrongMoves = 0;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_field);

        TextView welcomePlayerText = findViewById(R.id.welcomePlayerName);

        Intent intent = getIntent();
        final String s = intent.getStringExtra("message");
        final int gameMode = intent.getIntExtra("gameMode",0);
        welcomePlayerText.setText(s);

        GridLayout gl = findViewById(R.id.cardsLayout);

        cards theCards[] = new cards[(gameMode==4?16:gameMode==6?24:28)];
        gl.setColumnCount(4);
        gl.setRowCount(gameMode==4?4:gameMode==6?6:7);






        for(int i=1; i <= (gameMode==4?16:gameMode==6?24:28); i++){
            theCards[i-1] = new cards(this,i,gameMode);
            theCards[i-1].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final cards c = (cards) v;
                    c.turn();
                    if(lastCardId>0){
                        final cards c2 = findViewById(lastCardId);
                        if(c2.frontImage == c.frontImage && c2.getId() != c.getId()){
//                            match
                            c.turnable = false;
                            c2.turnable = false;
                            lastCardId = 0;
                            score++;
                            TextView scoreText = findViewById(R.id.scoreText);
                            scoreText.setText("Score: " + score);
                            if(score==(gameMode==4?8:gameMode==6?12:14)){
                                Intent intent = new Intent(GameField.this,ScoreScreen.class);
                                intent.putExtra("score",score);
                                intent.putExtra("wrongMoves",wrongMoves);
                                intent.putExtra("username",s);
                                startActivity(intent);

                                // game is finished.
                            }
                        }
                        else{
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    c.turn();
                                    c2.turn();
                                }
                            },500);
                            lastCardId = 0;
                            wrongMoves++;
                            TextView scoreText = findViewById(R.id.wrongMoveText);
                            scoreText.setText("Wrong Moves : " + wrongMoves);

//                            no match, turn
                        }
                    }
                    else{
                        lastCardId = c.getId();
                    }
                }
            });
        }

        for(int i=0; i < (gameMode==4?16:gameMode==6?24:28); i++){
            int randomIndex = (int)(Math.random()*(gameMode==4?16:gameMode==6?24:28));
            cards temp = theCards[randomIndex];
            theCards[randomIndex] = theCards[i];
            theCards[i] = temp;
        }

        for(int i=0; i < (gameMode==4?16:gameMode==6?24:28); i++){
            gl.addView(theCards[i]);
        }
    }
}
