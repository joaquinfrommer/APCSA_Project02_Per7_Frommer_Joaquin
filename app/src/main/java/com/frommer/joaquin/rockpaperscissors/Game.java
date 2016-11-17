package com.frommer.joaquin.rockpaperscissors;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.util.Random;
import android.widget.TextView;
import android.media.MediaPlayer;


/**
 * Created by student on 6/23/2016.
 */
public class Game extends Activity {
    ImageView imageView1;
    TextView counting;
    TextView result;
    ImageView imageView2;
    int score;
    MediaPlayer mp;
    public enum Choice
    {
        PENS,SHARKS,CAPS,KINGS,STARS,BLUES,RANGERS
    }
    Choice playerChoice;
    Choice compChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        imageView1 = (ImageView)findViewById(R.id.imageView1);
        imageView2 = (ImageView)findViewById(R.id.imageView2);
        result = (TextView)findViewById(R.id.Result);
        mp = MediaPlayer.create(this, R.raw.pensfinal);
        counting = (TextView)findViewById(R.id.counting);
        score = 0;



    }
    public void pensButtonPressed(View view) {

        imageView1.setImageResource(R.drawable.penslogo);
        playerChoice = Choice.PENS;
        mp.start();
        compChoice1();
    }

    public void sharksButtonPressed(View view) {
        imageView1.setImageResource(R.drawable.sharkslogo);
        playerChoice = Choice.SHARKS;

        compChoice1();

    }

    public void capitalsButtonPressed(View view) {
        imageView1.setImageResource(R.drawable.capitalslogo);
        playerChoice = Choice.CAPS;
        compChoice1();
    }

    public void rangersButtonPressed(View view)
    {
        imageView1.setImageResource(R.drawable.rangerslogo);
        playerChoice = Choice.RANGERS;
        compChoice1();
    }

    public void kingsButtonPressed(View view)
    {
        imageView1.setImageResource(R.drawable.kingslogo);
        playerChoice = Choice.KINGS;
        compChoice1();
    }

    public void starsButtonPressed(View view)
    {
        imageView1.setImageResource(R.drawable.starslogo);
        playerChoice = Choice.STARS;
        compChoice1();
    }

    public void bluesButtonPressed(View view)
    {
        imageView1.setImageResource(R.drawable.blueslogo);
        playerChoice = Choice.BLUES;
        compChoice1();
    }

    public void compChoice1()
    {
        Random random = new Random();
        int rando = random.nextInt(7);
        switch(rando)
        {
            case 0: compChoice = Choice.PENS;
                imageView2.setImageResource(R.drawable.penslogo);
                winner();
                break;
            case 1: compChoice = Choice.SHARKS;
                    imageView2.setImageResource(R.drawable.sharkslogo);
                winner();
                break;
            case 2: compChoice = Choice.CAPS;
                    imageView2.setImageResource(R.drawable.capitalslogo);
                winner();
                break;
            case 3: compChoice = Choice.RANGERS;
                imageView2.setImageResource(R.drawable.rangerslogo);
                winner();
                break;
            case 4: compChoice = Choice.KINGS;
                imageView2.setImageResource(R.drawable.kingslogo);
                winner();
                break;
            case 5: compChoice = Choice.STARS;
                imageView2.setImageResource(R.drawable.starslogo);
                winner();
                break;
            case 6: compChoice = Choice.BLUES;
                imageView2.setImageResource(R.drawable.blueslogo);
                winner();
                break;
        }


    }

    public void winner()
    {
        if(playerChoice == Choice.PENS)
        {
           result.setText("You Win");
            counter();
        }
        if(playerChoice == Choice.SHARKS)
        {
            if (compChoice == Choice.SHARKS)
            {
                result.setText("Tie");
            }
            else if (compChoice == Choice.PENS || compChoice == Choice.KINGS)
            {
                result.setText("Take an L");
            }
            else
            {
                result.setText("You Win");
                mp.start();
                counter();
            }
        }
        if(playerChoice == Choice.CAPS)
        {
            if (compChoice == Choice.CAPS)
            {
                result.setText("Tie");
            }
            else if (compChoice == Choice.SHARKS || compChoice == Choice.PENS)
            {
                result.setText("Take an L");
            }
            else
            {
                result.setText("You Win");
                mp.start();
                counter();
            }
        }
        if(playerChoice == Choice.RANGERS)
        {
            if (compChoice == Choice.RANGERS)
            {
                result.setText("Tie");
            }
            else if (compChoice == Choice.SHARKS || compChoice == Choice.PENS || compChoice == Choice.CAPS || compChoice == Choice.KINGS)
            {
                result.setText("Take an L");
            }
            else
            {
                result.setText("You Win");
                mp.start();
                counter();
            }
        }
        if(playerChoice == Choice.KINGS)
        {
            if (compChoice == Choice.KINGS)
            {
                result.setText("Tie");
            }
            else if (compChoice == Choice.STARS || compChoice == Choice.PENS)
            {
                result.setText("Take an L");
            }
            else
            {
                result.setText("You Win");
                mp.start();
                counter();
            }
        }
        if(playerChoice == Choice.STARS)
        {
            if (compChoice == Choice.STARS)
            {
                result.setText("Tie");
            }
            else if (compChoice == Choice.SHARKS || compChoice == Choice.PENS || compChoice == Choice.CAPS || compChoice == Choice.RANGERS)
            {
                result.setText("Take an L");
            }
            else
            {
                result.setText("You Win");
                mp.start();
                counter();
            }
        }
        if(playerChoice == Choice.BLUES)
        {
            if (compChoice == Choice.BLUES)
            {
                result.setText("Tie");
            }
            else if (compChoice == Choice.SHARKS || compChoice == Choice.PENS || compChoice == Choice.RANGERS || compChoice == Choice.KINGS)
            {
                result.setText("Take an L");
            }
            else
            {
                result.setText("You Win");
                mp.start();
                counter();
            }
        }



    }

    public void counter()
    {

        counting.setText("Wins:" + String.valueOf(++score));


    }


}
