package com.example.senior_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class SwapDownPokemon extends AppCompatActivity {
    Game game;
    Player player1;
    Player player2;
    ImageButton pokemon1;
    ImageButton pokemon2;
    ImageButton pokemon3;
    ImageButton pokemon4;
    ImageButton pokemon5;
    ImageButton pokemon6;
    TextView pokemonView1;
    TextView pokemonView2;
    TextView pokemonView3;
    TextView pokemonView4;
    TextView pokemonView5;
    TextView pokemonView6;
    TextView playerTurn;
    int pokemonIndex = 0;
    int opponentPokemonIndex = 0;

    /*
	NAME:
	    onCreate
	SYNOPSIS:
	    onCreate for the SwapDownPokemon activity
	DESCRIPTION:
	    checks if user has to switch out a pokemon
	        if yes checks to see if the player has a pokemon it can switch out to
	    allows the user to switch out a downed pokemon at the end of a turn
	RETURNS:
	    none
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swap_pokemon);
        game = (Game) getIntent().getSerializableExtra("GAME");

        updatePlayer();
        updateSwapPokemon(player1);

        pokemon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(isDown(player1.getPokemonAtIndex(0)))
                {
                    Toast.makeText(SwapDownPokemon.this,"Cannot switch into pokemon with 0 HP!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    game.setInfo("Player " + Integer.toString(game.getPlayerIndex() + 1) + " switched their down pokemon to " + player1.getPokemonAtIndex(0).getName());
                    player1.setPokemonIndex(0);
                }
                if(isDown(player2.getPokemonAtIndex(player2.getPokemonIndex())))
                {
                    Intent intent = new Intent(SwapDownPokemon.this, SwapDownPokemon.class);
                    intent.putExtra("GAME",game);
                    startActivity(intent);
                }
                //if no then call main activity
                if(!(isDown(player1.getPokemonAtIndex(0))))
                {
                    game.setPlayerIndex(0);
                    Intent intent = new Intent(SwapDownPokemon.this, MainBattle.class);
                    intent.putExtra("GAME", game);
                    startActivity(intent);
                }

            }
        });

        pokemon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(isDown(player1.getPokemonAtIndex(1)))
                {
                    Toast.makeText(SwapDownPokemon.this,"Cannot switch into pokemon with 0 HP!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    game.setInfo("Player " + Integer.toString(game.getPlayerIndex() + 1) + " switched their down pokemon to " + player1.getPokemonAtIndex(1).getName());
                    player1.setPokemonIndex(1);
                }
                if(isDown(player2.getPokemonAtIndex(player2.getPokemonIndex())))
                {
                    Intent intent = new Intent(SwapDownPokemon.this, SwapDownPokemon.class);
                    intent.putExtra("GAME",game);
                    startActivity(intent);
                }
                //if no then call main activity
                if(!(isDown(player1.getPokemonAtIndex(1))))
                {
                    game.setPlayerIndex(0);
                    Intent intent = new Intent(SwapDownPokemon.this, MainBattle.class);
                    intent.putExtra("GAME", game);
                    startActivity(intent);
                }
            }
        });

        pokemon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(isDown(player1.getPokemonAtIndex(2)))
                {
                    Toast.makeText(SwapDownPokemon.this,"Cannot switch into pokemon with 0 HP!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    game.setInfo("Player " + Integer.toString(game.getPlayerIndex() + 1) + " switched their down pokemon to " + player1.getPokemonAtIndex(2).getName());
                    player1.setPokemonIndex(2);
                }
                if(isDown(player2.getPokemonAtIndex(player2.getPokemonIndex())))
                {
                    Intent intent = new Intent(SwapDownPokemon.this, SwapDownPokemon.class);
                    intent.putExtra("GAME",game);
                    startActivity(intent);
                }
                //if no then call main activity
                if(!(isDown(player1.getPokemonAtIndex(2))))
                {
                    game.setPlayerIndex(0);
                    Intent intent = new Intent(SwapDownPokemon.this, MainBattle.class);
                    intent.putExtra("GAME", game);
                    startActivity(intent);
                }

            }
        });

        pokemon4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(isDown(player1.getPokemonAtIndex(3)))
                {
                    Toast.makeText(SwapDownPokemon.this,"Cannot switch into pokemon with 0 HP!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    game.setInfo("Player " + Integer.toString(game.getPlayerIndex() + 1) + " switched their down pokemon to " + player1.getPokemonAtIndex(3).getName());
                    player1.setPokemonIndex(3);
                }
                if(isDown(player2.getPokemonAtIndex(player2.getPokemonIndex())))
                {
                    Intent intent = new Intent(SwapDownPokemon.this, SwapDownPokemon.class);
                    intent.putExtra("GAME",game);
                    startActivity(intent);
                }
                //if no then call main activity
                if(!(isDown(player1.getPokemonAtIndex(3))))
                {
                    game.setPlayerIndex(0);
                    Intent intent = new Intent(SwapDownPokemon.this, MainBattle.class);
                    intent.putExtra("GAME", game);
                    startActivity(intent);
                }

            }
        });

        pokemon5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(isDown(player1.getPokemonAtIndex(4)))
                {
                    Toast.makeText(SwapDownPokemon.this,"Cannot switch into pokemon with 0 HP!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    game.setInfo("Player " + Integer.toString(game.getPlayerIndex() + 1) + " switched their down pokemon to " + player1.getPokemonAtIndex(4).getName());
                    player1.setPokemonIndex(4);
                }
                if(isDown(player2.getPokemonAtIndex(player2.getPokemonIndex())))
                {
                    Intent intent = new Intent(SwapDownPokemon.this, SwapDownPokemon.class);
                    intent.putExtra("GAME",game);
                    startActivity(intent);
                }
                //if no then call main activity
                if(!(isDown(player1.getPokemonAtIndex(4))))
                {
                    game.setPlayerIndex(0);
                    Intent intent = new Intent(SwapDownPokemon.this, MainBattle.class);
                    intent.putExtra("GAME", game);
                    startActivity(intent);
                }

            }
        });

        pokemon6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(isDown(player1.getPokemonAtIndex(5)))
                {
                    Toast.makeText(SwapDownPokemon.this,"Cannot switch into pokemon with 0 HP!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    game.setInfo("Player " + Integer.toString(game.getPlayerIndex() + 1) + " switched their down pokemon to " + player1.getPokemonAtIndex(5).getName());
                    player1.setPokemonIndex(5);
                }
                if(isDown(player2.getPokemonAtIndex(player2.getPokemonIndex())))
                {
                    Intent intent = new Intent(SwapDownPokemon.this, SwapDownPokemon.class);
                    intent.putExtra("GAME",game);
                    startActivity(intent);
                }
                //if no then call main activity
                if(!(isDown(player1.getPokemonAtIndex(5))))
                {
                    game.setPlayerIndex(0);
                    Intent intent = new Intent(SwapDownPokemon.this, MainBattle.class);
                    intent.putExtra("GAME", game);
                    startActivity(intent);
                }

            }
        });

    }

/*
	NAME:
	    updatePlayer
	SYNOPSIS:
	    updates the buttons to reflect the correct player that needs to switch their pokemon
	DESCRIPTION:
	    checks if player 1 needs to switch out
	        if yes then switch out and call activity from player 2 perspective
	    checks if player 2 needs to switch out
	        if yes then switch out and go back to MainBattle to continue the game
	RETURNS:
	    none
*/
    public void updatePlayer()
    {
        player1 = game.getPlayerAtIndex(0);
        player2 = game.getPlayerAtIndex(1);

        if(allDown(player1))
        {
            Intent intent = new Intent(SwapDownPokemon.this,EndGame.class);
            intent.putExtra("WINNER","2");
            startActivity(intent);
        }
        else if(allDown(player2))
        {
            Intent intent = new Intent(SwapDownPokemon.this,EndGame.class);
            intent.putExtra("WINNER","1");
            startActivity(intent);
        }
        else if(player1.getPokemonAtIndex(player1.getPokemonIndex()).getHp() <= 0)
        {
            player1 = game.getPlayerAtIndex(0);
            player2 = game.getPlayerAtIndex(1);
            game.setPlayerIndex(0);

            pokemonIndex = game.getPlayerAtIndex(0).getPokemonIndex();
            opponentPokemonIndex = game.getPlayerAtIndex(1).getPokemonIndex();
        }
        else if(player2.getPokemonAtIndex(player2.getPokemonIndex()).getHp() <= 0)
        {
            if(player2.getType().equals("Computer"))
            {
                player2.setPokemonIndex(player2.computerPickPokemon(player1.getPokemonAtIndex(player1.getPokemonIndex())));
                game.setInfo("Player 2 switched to " + player2.getPokemonAtIndex(player2.getPokemonIndex()).getName());
                game.setPassthrough(0);
                game.setPlayerIndex(0);
                Intent intent = new Intent(SwapDownPokemon.this, MainBattle.class);
                intent.putExtra("GAME",game);
                startActivity(intent);
            }
            else
            {
                player1 = game.getPlayerAtIndex(1);
                player2 = game.getPlayerAtIndex(0);
                game.setPlayerIndex(1);

                pokemonIndex = game.getPlayerAtIndex(1).getPokemonIndex();
                opponentPokemonIndex = game.getPlayerAtIndex(0).getPokemonIndex();
            }
        }
        else
        {
            //go back to mainBattle activity
            Intent intent = new Intent(SwapDownPokemon.this, MainBattle.class);
            intent.putExtra("GAME",game);
            startActivity(intent);
        }
    }

    /*
	NAME:
	    updateSwapPokemon
	SYNOPSIS:
	    changes the view of the activity to the right player
	DESCRIPTION:
	    changes the buttons and names and info to the perspective of the player that is currently switching out a downed pokemon
	RETURNS:
	    none
*/
    public void updateSwapPokemon(Player player)
    {
        String imageName;
        String pokemonInfo;
        int id;

        pokemon1 = findViewById(R.id.pokemon_button_1);
        pokemon2 = findViewById(R.id.pokemon_button_2);
        pokemon3 = findViewById(R.id.pokemon_button_3);
        pokemon4 = findViewById(R.id.pokemon_button_4);
        pokemon5 = findViewById(R.id.pokemon_button_5);
        pokemon6 = findViewById(R.id.pokemon_button_6);

        pokemonView1 = findViewById(R.id.pokemon_textView_1);
        pokemonView2 = findViewById(R.id.pokemon_textView_2);
        pokemonView3 = findViewById(R.id.pokemon_textView_3);
        pokemonView4 = findViewById(R.id.pokemon_textView_4);
        pokemonView5 = findViewById(R.id.pokemon_textView_5);
        pokemonView6 = findViewById(R.id.pokemon_textView_6);

        playerTurn = findViewById(R.id.player);
        playerTurn.setText("Player " + Integer.toString(game.getPlayerIndex() + 1));

        imageName = player.getPokemonAtIndex(0).getName();
        id = getResources().getIdentifier( imageName, "drawable",getPackageName());
        pokemon1.setImageResource(id);

        pokemonInfo = "Pokemon name: " + player.getPokemonAtIndex(0).getName() + "\n" + "HP Left: " + (Integer.toString(player.getPokemonAtIndex(0).getHp()));
        pokemonView1.setText(pokemonInfo);

        imageName = player.getPokemonAtIndex(1).getName();
        id = getResources().getIdentifier( imageName, "drawable",getPackageName());
        pokemon2.setImageResource(id);

        pokemonInfo = "Pokemon name: " + player.getPokemonAtIndex(1).getName() + "\n" + "HP Left: " + (Integer.toString(player.getPokemonAtIndex(1).getHp()));
        pokemonView2.setText(pokemonInfo);

        imageName = player.getPokemonAtIndex(2).getName();
        id = getResources().getIdentifier( imageName, "drawable",getPackageName());
        pokemon3.setImageResource(id);

        pokemonInfo = "Pokemon name: " + player.getPokemonAtIndex(2).getName() + "\n" + "HP Left: " + (Integer.toString(player.getPokemonAtIndex(2).getHp()));
        pokemonView3.setText(pokemonInfo);

        imageName = player.getPokemonAtIndex(3).getName();
        id = getResources().getIdentifier( imageName, "drawable",getPackageName());
        pokemon4.setImageResource(id);

        pokemonInfo = "Pokemon name: " + player.getPokemonAtIndex(3).getName() + "\n" + "HP Left: " + (Integer.toString(player.getPokemonAtIndex(3).getHp()));
        pokemonView4.setText(pokemonInfo);

        imageName = player.getPokemonAtIndex(4).getName();
        id = getResources().getIdentifier( imageName, "drawable",getPackageName());
        pokemon5.setImageResource(id);

        pokemonInfo = "Pokemon name: " + player.getPokemonAtIndex(4).getName() + "\n" + "HP Left: " + (Integer.toString(player.getPokemonAtIndex(4).getHp()));
        pokemonView5.setText(pokemonInfo);

        imageName = player.getPokemonAtIndex(5).getName();
        id = getResources().getIdentifier( imageName, "drawable",getPackageName());
        pokemon6.setImageResource(id);

        pokemonInfo = "Pokemon name: " + player.getPokemonAtIndex(5).getName() + "\n" + "HP Left: " + (Integer.toString(player.getPokemonAtIndex(5).getHp()));
        pokemonView6.setText(pokemonInfo);

    }

    /*
	NAME:
	    isDown
	SYNOPSIS:
	    checks if a pokemon is down
	DESCRIPTION:
	    if pokemon's health is 0 then that pokemon is down and cannot battle (true)
	    if not then the pokemon can be switched into and still battle (false)
	RETURNS:
	    boolean true or false
*/
    public boolean isDown(Pokemon pokemon)
    {
        if(pokemon.getHp() <= 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /*
	NAME:
	    allDown
	SYNOPSIS:
	    sees if a all a player's pokemon are down
	DESCRIPTION:
	    returns true if all a player's pokemon's hp is 0
	    returns false if not
	RETURNS:
	    boolean true or false
*/
    public boolean allDown(Player player)
    {

        int count = 0;
        for(int i =0; i<player.getPokemon().size();i++)
        {
            if(isDown(player.getPokemonAtIndex(i)))
            {
                count++;
            }
        }

        if(count >= 6)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
