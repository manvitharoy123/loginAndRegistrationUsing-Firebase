/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  androidx.appcompat.app.AppCompatActivity
 *  com.google.firebase.auth.FirebaseAuth
 *  com.google.firebase.auth.FirebaseAuth$AuthStateListener
 *  java.lang.Class
 *  java.lang.Object
 */
package com.example.vishnu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.vishnu.ActivityLogin;
import com.google.firebase.auth.FirebaseAuth;

public class UserActivity
extends AppCompatActivity {
    private FirebaseAuth.AuthStateListener authStateListener;
    Button btnLogOut;
    FirebaseAuth firebaseAuth;

    protected void onCreate(Bundle bundle) {
        Button button;
        super.onCreate(bundle);
        this.setContentView(2131361822);
        this.btnLogOut = button = (Button)this.findViewById(2131165257);
        button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent((Context)UserActivity.this, ActivityLogin.class);
                UserActivity.this.startActivity(intent);
            }
        });
    }

}

