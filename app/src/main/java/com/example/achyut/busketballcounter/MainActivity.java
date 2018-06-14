/* Project Done By Achyut Ghosh */

package com.example.achyut.busketballcounter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView scoreViewofA, scoreViewofB;
    SharedPreferences sprf, sprf1;
    private Button s3A, s2A, s1A,s3B, s2B, s1B;
    private FloatingActionButton floatingActionButton;
    //Track of score for Team A
    public int scoreTeamA = 0;

    //Track of score for Team B
    public int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Mapping the view for button
        s3A = (Button) findViewById(R.id.three_for_A);
        s2A = (Button) findViewById(R.id.two_for_A);
        s1A = (Button) findViewById(R.id.one_for_A);
        s3B = (Button) findViewById(R.id.three_for_B);
        s2B = (Button) findViewById(R.id.two_for_B);
        s1B = (Button) findViewById(R.id.one_for_B);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.reload_btn);

        //Mapping the viw for TextView
        scoreViewofA = (TextView) findViewById(R.id.team_a_score);
        scoreViewofB = (TextView) findViewById(R.id.team_b_score);

        //Binding buttons to same actionlistener
        s3A.setOnClickListener(this);
        s2A.setOnClickListener(this);
        s1A.setOnClickListener(this);
        s3B.setOnClickListener(this);
        s2B.setOnClickListener(this);
        s1B.setOnClickListener(this);
        floatingActionButton.setOnClickListener(this);
        //Share Preference
        sprf = getSharedPreferences("ScorePreferenceFileA", Context.MODE_PRIVATE);

    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        scoreViewofA.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        scoreViewofB.setText(String.valueOf(score));
    }

    /**
     * Resetting the score of team A and B
     */
    public void reset(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        Toast.makeText(this, "Scores are reset", Toast.LENGTH_SHORT).show();
        }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.three_for_A:
                scoreTeamA = scoreTeamA + 3;
                //Adding the key value pair of Score 3 of Team A from ScorePreferenceFile
                //displayForTeamA(scoreTeamA);
                SharedPreferences.Editor editor = sprf.edit();
                editor.putString("ScoreKey", String.valueOf(scoreTeamA));
                editor.apply();
                editor.commit();
                displayForTeamA(scoreTeamA);
                break;

            case R.id.two_for_A:
                scoreTeamA = scoreTeamA + 2;
                //displayForTeamA(scoreTeamA);
                //Adding the key value pair of Score 2 of Team A from ScorePreferenceFile
                SharedPreferences.Editor editor1 = sprf.edit();
                editor1.putString("ScoreKey", String.valueOf(scoreTeamA));
                editor1.apply();
                editor1.commit();
                displayForTeamA(scoreTeamA);
                break;

            case R.id.one_for_A:
                scoreTeamA = scoreTeamA + 1;
                //displayForTeamA(scoreTeamA);
                //Adding the key value pair of Score 1 of Team A from ScorePrefarenceFile
                SharedPreferences.Editor editor2 = sprf.edit();
                editor2.putString("ScoreKey", String.valueOf(scoreTeamA));
                editor2.apply();
                editor2.commit();
                //Displaying the value
                displayForTeamA(scoreTeamA);
                break;

            case R.id.three_for_B:
                scoreTeamB = scoreTeamB + 3;
                //displayForTeamA(scoreTeamB);
                //Adding the key value pair of Score 3 of Team B from ScorePrefarenceFile
                SharedPreferences.Editor editor3 = sprf.edit();
                editor3.putString("ScoreKey1", String.valueOf(scoreTeamB));
                editor3.apply();
                editor3.commit();
                //Displaying the value
                displayForTeamB(scoreTeamB);
                break;
            case R.id.two_for_B:
                scoreTeamB = scoreTeamB + 2;
                //displayForTeamA(scoreTeamB);
                //Adding the key value pair of Score 3 of Team B from ScorePrefarenceFile
                SharedPreferences.Editor editor4 = sprf.edit();
                editor4.putString("ScoreKey1", String.valueOf(scoreTeamB));
                editor4.apply();
                editor4.commit();
                //Displaying the value
                displayForTeamB(scoreTeamB);
                break;
            case R.id.one_for_B:
                scoreTeamB = scoreTeamB + 1;
                //displayForTeamA(scoreTeamB);
                //Adding the key value pair of Score 3 of Team B from ScorePrefarenceFile
                SharedPreferences.Editor editor5 = sprf.edit();
                editor5.putString("ScoreKey1", String.valueOf(scoreTeamB));
                editor5.apply();
                editor5.commit();
                //Displaying the value
                displayForTeamB(scoreTeamB);
                break;

            case R.id.reload_btn:
                //Retrieving the value of score 3 from ScorePrefarenceFile using key value pair
                String scoreThreeOfA = sprf.getString("ScoreKey", "");
                scoreViewofA.setText(scoreThreeOfA);
                //Retrieving the value of score 2 from ScorePrefarenceFile using key value pair
                String scoreTwoOfA = sprf.getString("ScoreKey", "");
                scoreViewofA.setText(scoreTwoOfA);
                //Retrieving the value of score 3 from ScorePrefarenceFile using key value pair
                String scoreOneOfA = sprf.getString("ScoreKey", "");
                scoreViewofA.setText(scoreOneOfA);
                //Retrieving the value of score 3 from ScorePrefarenceFile using key value pair
                String scoreThreeOfB = sprf.getString("ScoreKey1", "");
                scoreViewofB.setText(scoreThreeOfB);
                //Retrieving the value of score 2 from ScorePrefarenceFile using key value pair
                String scoreTwoOfB = sprf.getString("ScoreKey1", "");
                scoreViewofB.setText(scoreTwoOfB);
                //Retrieving the value of score 1 from ScorePrefarenceFile using key value pair
                String scoreOneOfB = sprf.getString("ScoreKey1", "");
                scoreViewofB.setText(scoreOneOfB);
                //Toast give the notification msg that data has been reloaded
                //Toast.makeText(getBaseContext(), "Reloaded", Toast.LENGTH_SHORT).show();
                break;
        }


    }
}
