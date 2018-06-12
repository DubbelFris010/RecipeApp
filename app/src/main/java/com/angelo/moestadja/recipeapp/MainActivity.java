package com.angelo.moestadja.recipeapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button registerButton;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewLogin;
    private ProgressDialog progressDialog;

    private final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main);

        // Initializing firebase auth object
        auth = FirebaseAuth.getInstance();

                if (auth.getCurrentUser() != null) {
                    // profile activity here
                    finish();
                    startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                }

        progressDialog = new ProgressDialog(this);

        // Initializing views
        registerButton = (Button) findViewById(R.id.registerButton);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        textViewLogin = (TextView) findViewById(R.id.textViewLogin);

        // attaching listener to the button
        registerButton.setOnClickListener(this);
        textViewLogin.setOnClickListener(this);
    }

    private void registerUser(){
        // getting email and passwords from editTexts
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)){
            // email is empty
            Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show();
            // stopping the execution of the function
            return;
        }

        if (TextUtils.isEmpty(password)){
            // password is empty
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show();
            // stopping the execution of the function
            return;
        }

        // if the email and password are not empty, display a progress dialog
        progressDialog.setMessage("Registering user...");
        progressDialog.show();

        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // checking if success
                        if (task.isSuccessful()){
                            // start the profile activity
                            finish();
                            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        } else {
                            Toast.makeText(MainActivity.this, "Could not register...please try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onClick(View view){
        if (view == registerButton){
            registerUser();
        }

        if (view == textViewLogin){
            // open login activity
            startActivity(new Intent(this, LoginActivity.class));
        }
    }
}
