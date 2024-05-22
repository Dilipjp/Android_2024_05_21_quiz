package com.example.exam3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText answerEditText;
    TextView questionTextView, scoreTextView;
    Button submit_btn, back_btn;
    private int score;
    private  String scoreText;
    private int real_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        score = 0;
        questionTextView = findViewById(R.id.question);
        answerEditText = findViewById(R.id.answer);
        scoreTextView = findViewById(R.id.score);
        submit_btn = findViewById(R.id.submit);
        back_btn = findViewById(R.id.back);
        //scoreTextView.setText("score: 0");

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int num1 = random.nextInt(10);
                int num2 = random.nextInt(10);
                int operator = random.nextInt(4);

                String question;


                if (operator == 0) {
                    question = num1 + " + " + num2 + " = ?";
                    real_answer = num1 + num2;
                } else if (operator == 1){
                    question = num1 + " - " + num2 + " = ?";
                    real_answer = num1 - num2;
                } else if (operator == 2){
                    question = num1 + " * " + num2 + " = ?";
                    real_answer = num1 * num2;
                }else {
                    question = num1 + " / " + num2 + " = ?";
                    real_answer = num1 / num2;
                }
                String answerString = answerEditText.getText().toString();
                if (answerString.isEmpty()) {
                    return;
                }
                int answer = Integer.parseInt(answerString);

                if( real_answer == answer){
                    score++;
                }

                scoreText = "Score: " + score;
                questionTextView.setText(question);
                answerEditText.setText("");
                scoreTextView.setText(scoreText);
               // Toast.makeText(MainActivity.this, "ssss", Toast.LENGTH_SHORT).show();
            }
        });

    }


}