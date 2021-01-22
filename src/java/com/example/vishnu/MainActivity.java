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
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
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
import com.example.vishnu.ActivityLogin;
import com.example.vishnu.UserActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity
extends AppCompatActivity {
    Button btnSignUp;
    public EditText emailId;
    FirebaseAuth firebaseAuth;
    public EditText passwd;
    TextView signIn;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2131361821);
        this.firebaseAuth = FirebaseAuth.getInstance();
        this.emailId = (EditText)this.findViewById(2131165186);
        this.passwd = (EditText)this.findViewById(2131165187);
        this.btnSignUp = (Button)this.findViewById(2131165258);
        this.signIn = (TextView)this.findViewById(2131165192);
        this.btnSignUp.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                String string2 = MainActivity.this.emailId.getText().toString();
                String string3 = MainActivity.this.passwd.getText().toString();
                if (string2.isEmpty()) {
                    MainActivity.this.emailId.setError((CharSequence)"Provide your Email first!");
                    MainActivity.this.emailId.requestFocus();
                    return;
                }
                if (string3.isEmpty()) {
                    MainActivity.this.passwd.setError((CharSequence)"Set your password");
                    MainActivity.this.passwd.requestFocus();
                    return;
                }
                if (string2.isEmpty() && string3.isEmpty()) {
                    Toast.makeText((Context)MainActivity.this, (CharSequence)"Fields Empty!", (int)0).show();
                    return;
                }
                if (string2.isEmpty() && string3.isEmpty()) {
                    Toast.makeText((Context)MainActivity.this, (CharSequence)"Error", (int)0).show();
                    return;
                }
                MainActivity.this.firebaseAuth.createUserWithEmailAndPassword(string2, string3).addOnCompleteListener((Activity)MainActivity.this, new OnCompleteListener(){

                    public void onComplete(Task task) {
                        if (!task.isSuccessful()) {
                            Context context = MainActivity.this.getApplicationContext();
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("SignUp unsuccessful: ");
                            stringBuilder.append(task.getException().getMessage());
                            Toast.makeText((Context)context, (CharSequence)stringBuilder.toString(), (int)0).show();
                            return;
                        }
                        MainActivity.this.startActivity(new Intent((Context)MainActivity.this, UserActivity.class));
                    }
                });
            }

        });
        this.signIn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                Intent intent = new Intent((Context)MainActivity.this, ActivityLogin.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }

}

