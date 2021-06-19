package com.example.senior_project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    /*
	NAME:
	    onCreate
	SYNOPSIS:
	    onCreate for MainActivity
	DESCRIPTION:
	    sets up startButton for the app
	RETURNS:
	    none
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startButton = findViewById(R.id.start_button);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this,PickPokemon.class);
                startActivity(intent);
            }
        });
    }
}
