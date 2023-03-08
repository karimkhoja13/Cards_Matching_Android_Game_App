package ca.gbc.mobile.karim.matchit_assignment1_karim;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/***************************************************************************************************
 * KARIM KHOJA
 * 100874100
 * Created on October 12, 2014
 * Last Modified on October 24, 2014
 **************************************************************************************************/

public class GameActivity extends Activity{

    ArrayList<CardView> ViewDeck = new ArrayList<CardView>();
//    int current_time = 0;
    String finalTime;
    private Timer timer;
    private CardView card;
    private boolean finished = false;
    private String playerName;
    private long startTime = 0L;
    private Handler customHandler = new Handler();

    private Timer timerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);

        getViews();
        Deck myDeck = new Deck(ViewDeck, GameActivity.this);
        timerView = (Timer) findViewById(R.id.timerView);
        startTime = SystemClock.uptimeMillis();
        customHandler.postDelayed(updateTimerThread, 0);

        final Button btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {

                Bundle extras = getIntent().getExtras();
                if (extras != null) {
                    playerName = extras.getString("Name");
                }

                if (finished)
                {
                    MySqlHelper dbHandler = new MySqlHelper(getApplicationContext(), null, null, 1);
//                    String quantity = finalTime;

                    Score product = new Score(playerName, finalTime);
//                    dbHandler.deleteall();

                    dbHandler.addScore(product);
                }
//                Intent intent = new Intent(GameActivity.this, MainActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(intent);
                finish();
            }
        });
    }

//    private Timer timerView = (Timer) findViewById(R.id.timerView);
    private Runnable updateTimerThread = new Runnable() {

        public void run() {
            if (!finished) {
                long timeInMilliseconds;
                long timeSwapBuff = 0L;
                long updatedTime;
                timeInMilliseconds = SystemClock.uptimeMillis() - startTime;
                updatedTime = timeSwapBuff + timeInMilliseconds;
                int secs = (int) (updatedTime / 1000);
                int mins = secs / 60;
                secs = secs % 60;
                int milliseconds = (int) (updatedTime % 100);
                timerView.setText("" + String.format("%02d", mins) + ":"
                        + String.format("%02d", secs) + ":"
                        + String.format("%02d", milliseconds));
                customHandler.postDelayed(this, 0);
            }
        }
    };

    public void EndGame(){
        finished = true;
        Button btnBack = (Button)findViewById(R.id.btnBack);
        btnBack.setText("Main Menu");
        Timer textView = (Timer) findViewById(R.id.timerView);
        finalTime = (String) timerView.getText();
        textView.setText("Finished at " + timerView.getText());
//        finish();
    }

    public void getViews(){
        card = (CardView)findViewById(R.id.view1);
        ViewDeck.add(card);
        card = (CardView)findViewById(R.id.view2);
        ViewDeck.add(card);
        card = (CardView)findViewById(R.id.view3);
        ViewDeck.add(card);
        card = (CardView)findViewById(R.id.view4);
        ViewDeck.add(card);
        card = (CardView)findViewById(R.id.view5);
        ViewDeck.add(card);
        card = (CardView)findViewById(R.id.view6);
        ViewDeck.add(card);
        card = (CardView)findViewById(R.id.view7);
        ViewDeck.add(card);
        card = (CardView)findViewById(R.id.view8);
        ViewDeck.add(card);
        card = (CardView)findViewById(R.id.view9);
        ViewDeck.add(card);
        card = (CardView)findViewById(R.id.view10);
        ViewDeck.add(card);
        card = (CardView)findViewById(R.id.view11);
        ViewDeck.add(card);
        card = (CardView)findViewById(R.id.view12);
        ViewDeck.add(card);
    }
}
