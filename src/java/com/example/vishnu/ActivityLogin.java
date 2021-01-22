/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.text.Editable
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.TextView
 *  android.widget.Toast
 *  androidx.appcompat.app.AppCompatActivity
 *  com.google.android.gms.tasks.OnCompleteListener
 *  com.google.android.gms.tasks.Task
 *  com.google.firebase.auth.FirebaseAuth
 *  com.google.firebase.auth.FirebaseAuth$AuthStateListener
 *  com.google.firebase.auth.FirebaseUser
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package com.example.vishnu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.vishnu.MainActivity;
import com.example.vishnu.UserActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ActivityLogin
extends AppCompatActivity {
    private FirebaseAuth.AuthStateListener authStateListener;
    Button btnLogIn;
    FirebaseAuth firebaseAuth;
    public EditText logInpasswd;
    public EditText loginEmailId;
    TextView signup;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2131361820);
        this.firebaseAuth = FirebaseAuth.getInstance();
        this.loginEmailId = (EditText)this.findViewById(2131165307);
        this.logInpasswd = (EditText)this.findViewById(2131165308);
        this.btnLogIn = (Button)this.findViewById(2131165256);
        this.signup = (TextView)this.findViewById(2131165192);
        this.authStateListener = new FirebaseAuth.AuthStateListener(){

            public void onAuthStateChanged(FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    Toast.makeText((Context)ActivityLogin.this, (CharSequence)"User logged in ", (int)0).show();
                    Intent intent = new Intent((Context)ActivityLogin.this, UserActivity.class);
                    ActivityLogin.this.startActivity(intent);
                    return;
                }
                Toast.makeText((Context)ActivityLogin.this, (CharSequence)"Login to continue", (int)0).show();
            }
        };
        this.signup.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                Intent intent = new Intent((Context)ActivityLogin.this, MainActivity.class);
                ActivityLogin.this.startActivity(intent);
            }
        });
        this.btnLogIn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                String string2 = ActivityLogin.this.loginEmailId.getText().toString();
                String string3 = ActivityLogin.this.logInpasswd.getText().toString();
                if (string2.isEmpty()) {
                    ActivityLogin.this.loginEmailId.setError((CharSequence)"Provide your Email first!");
                    ActivityLogin.this.loginEmailId.requestFocus();
                    return;
                }
                if (string3.isEmpty()) {
                    ActivityLogin.this.logInpasswd.setError((CharSequence)"Enter Password!");
                    ActivityLogin.this.logInpasswd.requestFocus();
                    return;
                }
                if (string2.isEmpty() && string3.isEmpty()) {
                    Toast.makeText((Context)ActivityLogin.this, (CharSequence)"Fields Empty!", (int)0).show();
                    return;
                }
                if (string2.isEmpty() && string3.isEmpty()) {
                    Toast.makeText((Context)ActivityLogin.this, (CharSequence)"Error", (int)0).show();
                    return;
                }
                ActivityLogin.this.firebaseAuth.signInWithEmailAndPassword(string2, string3).addOnCompleteListener((Activity)ActivityLogin.this, new OnCompleteListener(){

                    public void onComplete(Task task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText((Context)ActivityLogin.this, (CharSequence)"Not sucessfull", (int)0).show();
                            return;
                        }
                        ActivityLogin.this.startActivity(new Intent((Context)ActivityLogin.this, UserActivity.class));
                    }
                });
            }

        });
    }

    protected void onStart() {
        super.onStart();
        this.firebaseAuth.addAuthStateListener(this.authStateListener);
    }

}

