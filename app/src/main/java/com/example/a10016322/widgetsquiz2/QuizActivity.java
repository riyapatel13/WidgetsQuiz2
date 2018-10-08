    package com.example.a10016322.widgetsquiz2;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


    public class QuizActivity extends AppCompatActivity {

        ImageView image;
        TextView total, result;
        RadioGroup radioGroup;
        RadioButton one, two;
        Button play;
        int user, cpu, sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        image = (ImageView)(findViewById(R.id.imageView_id));
        total = (TextView) (findViewById(R.id.total_id));
        result = (TextView) (findViewById(R.id.result_id));
        radioGroup = (RadioGroup) (findViewById(R.id.radioGroup_id));
        one = (RadioButton) (findViewById(R.id.radioButton1_id));
        two = (RadioButton) (findViewById(R.id.radioButton2_id));
        play = (Button) (findViewById(R.id.button_id));

        image.setImageResource(R.drawable.guess);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                total.setText("Total");
                result.setText("Result");
                image.setImageResource(R.drawable.guess);
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cpu = (int)(Math.random()*2)+1;

                if(!one.isChecked() && !two.isChecked())
                {
                    Toast message = Toast.makeText(QuizActivity.this, "Please select One or Two", Toast.LENGTH_SHORT);
                    message.show();
                }
                else if (one.isChecked())
                {
                    user = 1;
                    if(cpu==1)
                        image.setImageResource(R.drawable.one);
                    else if(cpu==2)
                        image.setImageResource(R.drawable.two);
                    sum = user+cpu;
                    total.setText("Total is "+sum);
                    if (sum%2 == 0)
                        result.setText("You Win!");
                    else result.setText("Computer Wins");
                }
                else if (two.isChecked())
                {
                    user = 2;
                    if(cpu==1)
                        image.setImageResource(R.drawable.one);
                    else if(cpu==2)
                        image.setImageResource(R.drawable.two);
                    sum = user+cpu;
                    total.setText("Total is "+sum);
                    if (sum%2 == 0)
                        result.setText("You Win!");
                    else result.setText("Computer Wins");
                }

            }
        });

    }
}
