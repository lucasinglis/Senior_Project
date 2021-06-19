package com.example.senior_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EndGame extends AppCompatActivity {

    String winningPlayer;

    /*
	NAME:
	   onCreate
	SYNOPSIS:
	   onCreate for the EndGame Activity class
	DESCRIPTION:
	    sets up variables and buttons for the activity
	RETURNS:
	    none
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        //buttons and textviews for the activity
        Button restartButton = findViewById(R.id.replay_button);
        TextView gameWinner = findViewById(R.id.winner_textbox);

        //winning player that is returned from SwapDownPokemon activity
        winningPlayer = (String) getIntent().getSerializableExtra("WINNER");

        gameWinner.setText("The winner is Player " + winningPlayer + "\n" + "If you want to play again hit the Play Again button!");

        //restart button listener
        restartButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(EndGame.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }


}
