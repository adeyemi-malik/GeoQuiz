package com.geoquiz.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.geoquiz.R;

public class CheatActivity extends AppCompatActivity {
    private static final String EXTRA_ANSWER_IS_TRUE ="com.geoquiz.answer_is_true";
    private static final String EXTRA_ANSWER_SHOWN ="com.geoquiz.answer_shown";
    private boolean answerIsTrue;

    private TextView answerTextView;
    private Button showAnswerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        answerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
        showAnswerButton = findViewById(R.id.showAnswerButton);
        showAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answerIsTrue) {answerTextView.setText(R.string.true_button);}
                else
                    {answerTextView.setText(R.string.false_button);}
                setAnswerShown(true);
            }
        });
        answerTextView = findViewById(R.id.answer);
    }
    public static boolean wasAnswerShown(Intent result) {return result.getBooleanExtra(EXTRA_ANSWER_SHOWN, false);}
    public static Intent newIntent(Context context, boolean answerisTrue)
    {
        Intent i = new Intent(context, CheatActivity.class);
        i.putExtra(EXTRA_ANSWER_IS_TRUE, answerisTrue);
        return i;
    }

    private void setAnswerShown(boolean isAnswerShown)
    {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }
}
