package edu.uconn.depressiontest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;

import java.util.Arrays;

public class FormActivity extends AppCompatActivity {

    public String zero, one, two, three;

    public static final String TAG = "Form Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        zero = getResources().getString(R.string.zero_point_response);
        one = getResources().getString(R.string.one_point_response);
        two = getResources().getString(R.string.two_point_response);
        three = getResources().getString(R.string.three_point_response);
    }

    public void submitForm(View view) {
        final Spinner questionOneSpinner = (Spinner) findViewById(R.id.question_one_spinner);
        final Spinner questionTwoSpinner = (Spinner) findViewById(R.id.question_two_spinner);
        final Spinner questionThreeSpinner = (Spinner) findViewById(R.id.question_three_spinner);
        final Spinner questionFourSpinner = (Spinner) findViewById(R.id.question_four_spinner);
        final Spinner questionFiveSpinner = (Spinner) findViewById(R.id.question_five_spinner);
        final Spinner questionSixSpinner = (Spinner) findViewById(R.id.question_six_spinner);
        final Spinner questionSevenSpinner = (Spinner) findViewById(R.id.question_seven_spinner);
        final Spinner questionEightSpinner = (Spinner) findViewById(R.id.question_eight_spinner);
        final Spinner questionNineSpinner = (Spinner) findViewById(R.id.question_nine_spinner);

        int[] feedback = {
                calculateNumericalScore(questionOneSpinner.getResources().toString()),
                calculateNumericalScore(questionTwoSpinner.getSelectedItem().toString()),
                calculateNumericalScore(questionThreeSpinner.getSelectedItem().toString()),
                calculateNumericalScore(questionFourSpinner.getSelectedItem().toString()),
                calculateNumericalScore(questionFiveSpinner.getSelectedItem().toString()),
                calculateNumericalScore(questionSixSpinner.getSelectedItem().toString()),
                calculateNumericalScore(questionSevenSpinner.getSelectedItem().toString()),
                calculateNumericalScore(questionEightSpinner.getSelectedItem().toString()),
                calculateNumericalScore(questionNineSpinner.getSelectedItem().toString()),
        };

        Log.i(TAG, Arrays.toString(feedback));
        int score = calculateScore(feedback);
        Log.i(TAG, "Score: " + Integer.toString(score));
        String response = generateResponse(score);
        Log.i(TAG, "Response: " + response);
        showResults(response);
    }

    public int calculateNumericalScore(String string) {
        if ( string == zero ) {
            return 0;
        } else if ( string == one ) {
            return 1;
        } else if ( string == two ) {
            return 2;
        } else if ( string == three ) {
            return 3;
        } else {
            return 0;
        }
    }

    public int calculateScore(int[] scores) {
        int score = 0;
        for (int index = 0; index < scores.length; index++ ) {
            score += scores[index];
        }
        return score;
    }

    public String generateResponse(int score) {
        String response = "Unable to calculate response";
        if (score < 5) {
            response = getResources().getString(R.string.feedback_healthy);
            return response;
        } else if (score < 10) {
            response = getResources().getString(R.string.feedback_mild);
            return response;
        } else if (score < 15) {
            response = getResources().getString(R.string.feedback_moderate);
            return response;
        } else if (score < 20) {
            response = getResources().getString(R.string.feedback_moderately_severe);
            return response;
        } else if (score < 28) {
            response = getResources().getString(R.string.feedback_severe);
            return response;
        } else {
            return response;
        }
    }

    public void showResults(String response) {
        Intent intent = new Intent(this, ResponseActivity.class);
        intent.putExtra("response", response);
        startActivity(intent);
    }
}
