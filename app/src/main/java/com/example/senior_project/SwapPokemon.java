package com.example.senior_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
//import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class SwapPokemon extends AppCompatActivity {
    Game game;
    Player player;
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

    /*
    NAME:
        onCreate
    SYNOPSIS:
        onCreate for the SwapPokemon activity
    DESCRIPTION:
        checks if user has to switch out a pokemon
            if yes checks to see if the player has a pokemon it can switch out to
        allows the user to switch out a pokemon as their move
    RETURNS:
        none
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swap_pokemon);
        game = (Game) getIntent().getSerializableExtra("GAME");
        player = game.getPlayerAtIndex(game.getPlayerIndex());

        updateSwapPokemon();

        pokemon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(isDown(player.getPokemonAtIndex(0)))
                {
                    Toast.makeText(SwapPokemon.this,"Cannot switch into pokemon with 0 HP!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(player.getPokemonIndex() == 0)
                    {
                        Toast.makeText(SwapPokemon.this,"Cannot switch into the same Pokemon!",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        if (game.getPlayerIndex() == 0)
                        {
                            game.saveTurn(true, 0);
                            game.setPassthrough(game.getPassthrough() + 1);
                            game.setPlayerIndex(1);
                            Intent intent = new Intent(SwapPokemon.this, SwapDownPokemon.class);
                            intent.putExtra("GAME", game);
                            startActivity(intent);
                        } else if (game.getPlayerIndex() == 1) {
                            game.saveTurn(true, 0);
                            game.setPlayerIndex(0);
                            game.setPassthrough(0);
                            Intent intent = new Intent(SwapPokemon.this, SwapDownPokemon.class);
                            intent.putExtra("GAME", game);
                            startActivity(intent);
                        }
                    }
                }
            }
        });

        pokemon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(isDown(player.getPokemonAtIndex(1)))
                {
                    Toast.makeText(SwapPokemon.this,"Cannot switch into pokemon with 0 HP!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(player.getPokemonIndex() == 1)
                    {
                        Toast.makeText(SwapPokemon.this,"Cannot switch into the same Pokemon!",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        if(game.getPlayerIndex() == 0)
                        {
                            game.saveTurn(true,1);
                            game.setPassthrough(game.getPassthrough() + 1);
                            game.setPlayerIndex(1);
                            Intent intent = new Intent(SwapPokemon.this, SwapDownPokemon.class);
                            intent.putExtra("GAME", game);
                            startActivity(intent);
                        }
                        else if(game.getPlayerIndex() == 1)
                        {
                            game.saveTurn(true,1);
                            game.setPlayerIndex(0);
                            game.setPassthrough(0);
                            Intent intent = new Intent(SwapPokemon.this, SwapDownPokemon.class);
                            intent.putExtra("GAME", game);
                            startActivity(intent);
                        }
                    }
                }
            }
        });

        pokemon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(isDown(player.getPokemonAtIndex(2)))
                {
                    Toast.makeText(SwapPokemon.this,"Cannot switch into pokemon with 0 HP!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(player.getPokemonIndex() == 2)
                    {
                        Toast.makeText(SwapPokemon.this,"Cannot switch into the same Pokemon!",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        if(game.getPlayerIndex() == 0)
                        {
                            game.saveTurn(true,2);
                            game.setPassthrough(game.getPassthrough() + 1);
                            game.setPlayerIndex(1);
                            Intent intent = new Intent(SwapPokemon.this, SwapDownPokemon.class);
                            intent.putExtra("GAME", game);
                            startActivity(intent);
                        }
                        else if(game.getPlayerIndex() == 1)
                        {
                            game.saveTurn(true,2);
                            game.setPlayerIndex(0);
                            game.setPassthrough(0);
                            Intent intent = new Intent(SwapPokemon.this, SwapDownPokemon.class);
                            intent.putExtra("GAME", game);
                            startActivity(intent);
                        }
                    }
                }
            }
        });

        pokemon4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(isDown(player.getPokemonAtIndex(3)))
                {
                    Toast.makeText(SwapPokemon.this,"Cannot switch into pokemon with 0 HP!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(player.getPokemonIndex() == 3)
                    {
                        Toast.makeText(SwapPokemon.this,"Cannot switch into the same Pokemon!",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        if(game.getPlayerIndex() == 0)
                        {
                            game.saveTurn(true,3);
                            game.setPassthrough(game.getPassthrough() + 1);
                            game.setPlayerIndex(1);
                            Intent intent = new Intent(SwapPokemon.this, SwapDownPokemon.class);
                            intent.putExtra("GAME", game);
                            startActivity(intent);
                        }
                        else if(game.getPlayerIndex() == 1)
                        {
                            game.saveTurn(true,3);
                            game.setPlayerIndex(0);
                            game.setPassthrough(0);
                            Intent intent = new Intent(SwapPokemon.this, SwapDownPokemon.class);
                            intent.putExtra("GAME", game);
                            startActivity(intent);
                        }
                    }
                }
            }
        });

        pokemon5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(isDown(player.getPokemonAtIndex(4)))
                {
                    Toast.makeText(SwapPokemon.this,"Cannot switch into pokemon with 0 HP!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(player.getPokemonIndex() == 4)
                    {
                        Toast.makeText(SwapPokemon.this,"Cannot switch into the same Pokemon!",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        if(game.getPlayerIndex() == 0)
                        {
                            game.saveTurn(true,4);
                            game.setPassthrough(game.getPassthrough() + 1);
                            game.setPlayerIndex(1);
                            Intent intent = new Intent(SwapPokemon.this, SwapDownPokemon.class);
                            intent.putExtra("GAME", game);
                            startActivity(intent);
                        }
                        else if(game.getPlayerIndex() == 1)
                        {
                            game.saveTurn(true,4);
                            game.setPlayerIndex(0);
                            game.setPassthrough(0);
                            Intent intent = new Intent(SwapPokemon.this, SwapDownPokemon.class);
                            intent.putExtra("GAME", game);
                            startActivity(intent);
                        }
                    }
                }
            }
        });

        pokemon6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(isDown(player.getPokemonAtIndex(5)))
                {
                    Toast.makeText(SwapPokemon.this,"Cannot switch into pokemon with 0 HP!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(player.getPokemonIndex() == 5)
                    {
                        Toast.makeText(SwapPokemon.this,"Cannot switch into the same Pokemon!",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        if(game.getPlayerIndex() == 0)
                        {
                            game.saveTurn(true,5);
                            game.setPassthrough(game.getPassthrough() + 1);
                            game.setPlayerIndex(1);
                            Intent intent = new Intent(SwapPokemon.this, SwapDownPokemon.class);
                            intent.putExtra("GAME", game);
                            startActivity(intent);
                        }
                        else if(game.getPlayerIndex() == 1)
                        {
                            game.saveTurn(true,5);
                            game.setPassthrough(0);
                            game.setPlayerIndex(0);
                            Intent intent = new Intent(SwapPokemon.this, SwapDownPokemon.class);
                            intent.putExtra("GAME", game);
                            startActivity(intent);
                        }
                    }
                }
            }
        });

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
    public void updateSwapPokemon()
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

}
