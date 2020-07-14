package by.student.testProject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        // Получить Intent, который запустил это действие, и извлечь строку
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        // Захватить TextView макета и установить строку в качестве его текста
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);
    }

    @Override
    public void onClick(View view) {

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setType("message/rfc822");
        sendIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"viktar.dabrou@gmail.com"});
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Android task1");
        sendIntent.putExtra(Intent.EXTRA_TEXT, message);

        startActivity(Intent.createChooser(sendIntent, "Send mail..."));
    }
}