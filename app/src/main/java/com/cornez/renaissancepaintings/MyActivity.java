package com.cornez.renaissancepaintings;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MyActivity extends Activity {

    //CONTAINING PAINTINGS
    private LinearLayout mLinearList;
    ImageView candyCane;
    Animation rotateAnim;
    MediaPlayer player1 = null;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        //REFERENCE THE SCROLLABLE LAYOUT STRUCTURE IN MAIN_SCREEN.XML
        mLinearList = (LinearLayout) findViewById(R.id.linearList);

        //FILL THE SCROLLABLE LAYOUT STRUCTURE WITH PAINTINGS
        fillPaintingCarousel();

        candyCane=(ImageView)findViewById(R.id.candycane);
        player1 = MediaPlayer.create(this, R.raw.carolofthebells);
        rotateAnimation();
    }

    private void rotateAnimation() {
        rotateAnim = AnimationUtils.loadAnimation(this, R.anim.rotate);
        candyCane.startAnimation(rotateAnim);
    }

    private void fillPaintingCarousel() {

        // POPULATE THE LINEAR LIST CAROUSEL WITH PAINTINGS AND DESCRIPTIONS
        ImageButton buttonItem;

        for (int i = 0; i < RenaissanceDatabase.description.length; i++) {
            //STORE THE INDIVIDUAL PAINTINGS AS BUTTONS
            buttonItem = new ImageButton(this);


            Painting painting = new Painting(RenaissanceDatabase.description[i], RenaissanceDatabase.id[i]);

            //USE THE CONTENT DESCRIPTION PROPERTY TO STORE
            //PAINTING DATA

            buttonItem.setContentDescription(painting.getDescription());

            //LOAD THE PAINTING USING ITS UNIQUE ID

            buttonItem.setImageDrawable(getResources().getDrawable(
                    painting.getId()));

            if(i == 0) {
                buttonItem.setOnClickListener(play1);
            }
            else if(i == 1) {
                buttonItem.setOnClickListener(play2);
            }
            else if(i == 2) {
                buttonItem.setOnClickListener(play3);
            }
            else if(i == 3) {
                buttonItem.setOnClickListener(play4);
            }
            else if(i == 4) {
                buttonItem.setOnClickListener(play5);
            }
            else if(i == 5) {
                buttonItem.setOnClickListener(play6);
            }


            //SET AN ONCLICK LISTENER FOR THE IMAGE BUTTON
            //buttonItem.setOnClickListener(displayPaintingInformation);

            //ADD THE IMAGE BUTTON TO THE SCROLLABLE LINEAR LIST
            mLinearList.addView(buttonItem);
        }
    }

    private View.OnClickListener displayPaintingInformation = new View.OnClickListener() {
        public void onClick(View btn) {
            // COLLECT THE INFORMATION STORED ABOUT THE PAINTING
            String paintingDescription = (String) btn.getContentDescription();

            // MAKE A METHOD CALL TO DISPLAY THE INFORMATION
            displayToast(paintingDescription);
        }
    };

    private void stopMusic(View btn, int id) {

        String songDescription = (String)btn.getContentDescription();

        if(id == 1){
            player1.release();
            player1 = MediaPlayer.create(this, R.raw.carolofthebells);
            displayToast(songDescription);
            player1.start();

        }
        else if(id == 2) {
            player1.release();
            player1 = MediaPlayer.create(this, R.raw.deckthehalls);
            displayToast(songDescription);
            player1.start();
        }
        else if(id == 3) {
            player1.release();
            player1 = MediaPlayer.create(this, R.raw.joytotheworld);
            displayToast(songDescription);
            player1.start();
        }
        else if(id == 4) {
            player1.release();
            player1 = MediaPlayer.create(this, R.raw.oholynight);
            displayToast(songDescription);
            player1.start();
        }
        else if(id == 5) {
            player1.release();
            player1 = MediaPlayer.create(this, R.raw.wewishyouamerrychristmas);
            displayToast(songDescription);
            player1.start();
        }
        else if(id == 6) {
            player1.release();
            player1 = MediaPlayer.create(this, R.raw.funk);
            displayToast(songDescription);
            player1.start();
        }

    }


    private View.OnClickListener play1 = new View.OnClickListener() {
        public void onClick(View btn) {
            stopMusic(btn, 1);

        }
    };

    private View.OnClickListener play2 = new View.OnClickListener() {
        public void onClick(View btn) {
            stopMusic(btn, 2);
            //managerOfSound(btn, false);

        }
    };
    private View.OnClickListener play3 = new View.OnClickListener() {
        public void onClick(View btn) {
            stopMusic(btn,3);

        }
    };

    private View.OnClickListener play4 = new View.OnClickListener() {
        public void onClick(View btn) {
            stopMusic(btn,4);

        }
    };

    private View.OnClickListener play5 = new View.OnClickListener() {
        public void onClick(View btn) {
            stopMusic(btn,5);

        }
    };

    private View.OnClickListener play6 = new View.OnClickListener() {
        public void onClick(View btn) {
            stopMusic(btn,6);

        }
    };

    private void displayToast(String paintingDescription) {
        // SHOW THE INFORMATION ABOUT THE PAINTING AS
        // A TOAST WITH A SHORT DISPLAY LIFE
        Toast.makeText(this, paintingDescription, Toast.LENGTH_SHORT).show();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
