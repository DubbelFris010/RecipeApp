package com.angelo.moestadja.recipeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ContactActivity extends AppCompatActivity {

    @BindView(R.id.your_name)
    EditText yourNameEditText;
    @BindView(R.id.your_email)
    EditText yourEmailEditText;
    @BindView(R.id.your_subject)
    EditText yourSubjectEditText;
    @BindView(R.id.your_message)
    EditText yourMessageEditText;
    @BindView(R.id.post_message)
    Button emailBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_form);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.post_message)
    public void sendMsg (View v) {
        String name = yourNameEditText.getText().toString();
        String email = yourEmailEditText.getText().toString();
        String subject = yourSubjectEditText.getText().toString();
        String message = yourMessageEditText.getText().toString();
        if (TextUtils.isEmpty(name)) {
            yourNameEditText.setError("Enter Your Name");
            yourNameEditText.requestFocus();
            return;
        }

        Boolean onError = false;
        if (!isValidEmail(email)) {
            onError = true;
            yourEmailEditText.setError("Invalid Email");
            return;
        }

        if (TextUtils.isEmpty(subject)) {
            yourSubjectEditText.setError("Enter Your Subject");
            yourSubjectEditText.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(message)) {
            yourMessageEditText.setError("Enter Your Message");
            yourEmailEditText.requestFocus();
        }

        Intent sendEmail = new Intent(android.content.Intent.ACTION_SEND);

        // Fill it with data
        sendEmail.setType("plain/text");
        sendEmail.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"amoestadja@gmail.com"});
        sendEmail.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
        sendEmail.putExtra(android.content.Intent.EXTRA_TEXT,
                "name:" + name + '\n' + "Email ID:" + email + '\n' + "Message:" + '\n' + message);

        // Send it off to the Activity-Chooser
        startActivity(Intent.createChooser(sendEmail, "Send mail..."));
    }

    // validating email id
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}

