package com.nagkaustav.buttonclickcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText userInput;
    private TextView textView;
    private Button button;
    private int numOfItems = 1;
    private static final String TAG = "MainActivity";
    private final String TEXT_CONTENTS = "TextContents";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: begins");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //all widgets are views
        userInput = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);

        textView.setText("");
        userInput.setText("");

        //to make textView scroll. You still need to add scrollbars in the layout
        textView.setMovementMethod(new ScrollingMovementMethod());

        //define your listeners
        View.OnClickListener ourOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = String.valueOf(userInput.getText());

                if (!result.isEmpty()) {
                    result = String.valueOf(numOfItems) + ". " + result + "\n";
                    textView.append(result);
                    numOfItems += 1;
                }

                userInput.setText("");
            }
        };

        //call the listener
        button.setOnClickListener(ourOnClickListener);
        Log.d(TAG, "onCreate: ends");
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: begins");
        super.onStart();
        Log.d(TAG, "onStart: ends");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d(TAG, "onRestoreInstanceState: begins");
        super.onRestoreInstanceState(savedInstanceState);
        textView.setText(savedInstanceState.getString(TEXT_CONTENTS));
        Log.d(TAG, "onRestoreInstanceState: ends");
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: begins");
        super.onResume();
        Log.d(TAG, "onResume: ends");
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: begins");
        super.onPause();
        Log.d(TAG, "onPause: ends");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: begins");
        outState.putString(TEXT_CONTENTS, String.valueOf(textView.getText()));
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: ends");
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart: begins");
        super.onRestart();
        Log.d(TAG, "onRestart: ends");
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: begins");
        super.onStop();
        Log.d(TAG, "onStop: ends");
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: begins");
        super.onDestroy();
        Log.d(TAG, "onDestroy: ends");
    }

}
