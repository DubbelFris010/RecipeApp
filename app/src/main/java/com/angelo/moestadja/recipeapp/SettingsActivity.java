package com.angelo.moestadja.recipeapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.google.firebase.auth.FirebaseAuth.getInstance;

public class SettingsActivity extends AppCompatActivity {

    private FirebaseAuth auth;

    @BindView(R.id.changePasswordLayout)
    View changePasswordLayout;
    @BindView(R.id.deleteAccountLayout)
    View deleteAccountLayout;
    @BindView(R.id.signOutLayout)
    View signOutLayout;

    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //get firebase auth instance
        auth = FirebaseAuth.getInstance();

        ButterKnife.bind(this);

        dialog = new ProgressDialog(this);
        FirebaseUser auth = FirebaseAuth.getInstance().getCurrentUser();

        /*if (auth == null) {
            // profile activity here
            finish();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }*/

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.action_settings));
        setSupportActionBar(toolbar);
        }

    @OnClick(R.id.deleteAccountLayout)
    void onDeleteAccountLayoutClicked() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null){
            dialog.setMessage("Deactivating...please wait");
            dialog.show();
            user.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(getApplicationContext(), "Account deactivated", Toast.LENGTH_SHORT);
                        finish();
                        Intent i = new Intent(SettingsActivity.this, MainActivity.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(getApplicationContext(), "Account could not be deactivated", Toast.LENGTH_SHORT);
                    }
                }
            });
        }
    }

    @OnClick(R.id.changePasswordLayout)
    void onChangePasswordLayoutCLicked() {
        finish();
        startActivity(new Intent(this, ChangePasswordActivity.class));
    }

    @OnClick(R.id.signOutLayout)
    void onSignOutLayoutClicked() {
        auth.signOut();
    }
}