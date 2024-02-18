package kg.geeks.homelesson31;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText email = findViewById(R.id.email_text);
        EditText subject = findViewById(R.id.subject_text);
        EditText message = findViewById(R.id.message_text);

       findViewById(R.id.send_btn).setOnClickListener(v ->{
           Intent intent = new Intent(Intent.ACTION_SENDTO);
           intent.setData(Uri.parse("mailto:"));
           intent.putExtra(Intent.EXTRA_EMAIL,new String[]{email.getText().toString() + "@gmail.com"});
           intent.putExtra(Intent.EXTRA_SUBJECT,subject.getText().toString());
           intent.putExtra(Intent.EXTRA_TEXT,message.getText().toString());
           startActivity(Intent.createChooser(intent, "Email via..."));
       });
    }
}