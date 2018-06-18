package com.example.dirkcornelis.gameplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    TextView username, email, password, password2;
    Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.usernameTxt);
        email = findViewById(R.id.emailTxt);
        password = findViewById(R.id.passwordTxt);
        password2 = findViewById(R.id.passwordTxt2);
        registerBtn = findViewById(R.id.registerBtn);
        mAuth = FirebaseAuth.getInstance();

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = email.getText().toString().trim();
                String Password = password.getText().toString().trim();
                String Password2 = password2.getText().toString().trim();

                if (TextUtils.isEmpty(Email)){
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(Password)){
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_LONG).show();
                    return;
                }
                if (!Password.equals(Password2)){
                    Toast.makeText(getApplicationContext(), "Passwords are not the same", Toast.LENGTH_LONG).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(Email, Password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });
    }
}
