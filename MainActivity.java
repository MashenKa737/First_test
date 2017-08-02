package ru.symon.catwars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static int pageNumber=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        TextView textView = (TextView)findViewById(R.id.questionNumber);
//        textView.setText("Вопрос № " + String.valueOf(pageNumber));

        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        switch(pageNumber % 6){
            case 1:
                imageView.setImageResource(R.drawable.a1);
                break;
            case 2:
                imageView.setImageResource(R.drawable.a2);
                break;
            case 3:
                imageView.setImageResource(R.drawable.a3);
                break;
            case 4:
                imageView.setImageResource(R.drawable.a4);
                break;
            case 5:
                imageView.setImageResource(R.drawable.a5);
                break;
            default:
                imageView.setImageResource(R.drawable.a6);
                break;
        }

        pageNumber++;
    }

    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);
    }

}
