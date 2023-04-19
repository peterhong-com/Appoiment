package my.edu.utar.appoiment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContactUs extends AppCompatActivity {


    EditText editTextSubject,editTextContent,editTextToEmail;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        button = findViewById(R.id.btnSend);
        editTextContent= findViewById(R.id.content);
        editTextSubject=findViewById(R.id.subject);
        editTextToEmail = findViewById(R.id.to_email);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String subject, content, to_email;
                subject = editTextSubject.getText().toString();
                content = editTextContent.getText().toString();
                to_email = editTextToEmail.getText().toString();

                if (subject.equals("") && content.equals("") && to_email.equals("")){
                    Toast.makeText(ContactUs.this,"All Fields are required" ,Toast.LENGTH_SHORT).show();
                }else {
                    sendEmail(subject,content,to_email);
                }
            }
        });
    }

    public void sendEmail(String subject, String content, String to_email){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{to_email});
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT, content);
        startActivity(Intent.createChooser(intent, "Choose email client: "));
    }
}