package edu.uconn.depressiontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResponseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);
        String value = getIntent().getExtras().getString("response");
        TextView responsetext = (TextView) findViewById(R.id.form_answer);
        responsetext.setText(value);
    }
}
