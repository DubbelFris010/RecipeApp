package com.angelo.moestadja.recipeapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChangePasswordActivity extends AppCompatActivity implements View.OnClickListener {

    EditText changePassword;
    Button changePasswordButton;
    FirebaseAuth auth;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pasword);

        dialog = new ProgressDialog(this);
        changePassword = (EditText) findViewById(R.id.editTextChangePassword);
        changePasswordButton = (Button) findViewById(R.id.changePasswordButton);
        auth = FirebaseAuth.getInstance();

        changePasswordButton.setOnClickListener(ChangePasswordActivity.this);
        }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.changePasswordButton:
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            if (user != null) {
                dialog.setMessage("Changing password, please wait");
                dialog.show();
                user.updatePassword(changePassword.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    dialog.dismiss();
                                    Toast.makeText(getApplicationContext(), "Your password has been changed", Toast.LENGTH_SHORT);
                                    auth.signOut();
                                    finish();
                                    Intent i = new Intent(ChangePasswordActivity.this, LoginActivity.class);
                                    startActivity(i);
                                } else {
                                    dialog.dismiss();
                                    Toast.makeText(getApplicationContext(), "Password could not be changed", Toast.LENGTH_SHORT);
                                }
                            }
                        });
            }
            break;
        }
    }
}
