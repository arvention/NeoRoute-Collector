package com.arvention.neoroutecollector.activity;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.arvention.neoroutecollector.R;
import com.arvention.neoroutecollector.helper.PasswordTextWatcher;
import com.arvention.neoroutecollector.helper.TextValidator;
import com.arvention.neoroutecollector.helper.TextValidatorContext;
import com.arvention.neoroutecollector.helper.UsernameTextWatcher;

public class SplashActivity extends AppCompatActivity {

    private ImageView icon;

    private EditText editTextUsername;
    private EditText editTextPassword;
    private TextInputLayout textInputLayoutUsername;
    private TextInputLayout textInputLayoutPassword;

    private Button buttonLetsGo;
    private Button buttonSignIn;

    private Animation rotateIndefinitely;

    private UsernameTextWatcher usernameTextWatcher;
    private PasswordTextWatcher passwordTextWatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        icon = (ImageView) findViewById(R.id.icon);

        editTextUsername = (EditText) findViewById(R.id.edit_text_username);
        editTextPassword = (EditText) findViewById(R.id.edit_text_password);
        textInputLayoutUsername = (TextInputLayout) findViewById(R.id.text_input_layout_username);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.text_input_layout_password);

        buttonLetsGo = (Button) findViewById(R.id.button_lets_go);
        buttonSignIn = (Button) findViewById(R.id.button_sign_in);

        rotateIndefinitely = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_indefinitely);

        usernameTextWatcher = new UsernameTextWatcher(editTextUsername, textInputLayoutUsername, this);
        passwordTextWatcher = new PasswordTextWatcher(editTextPassword, textInputLayoutPassword, this);

        icon.startAnimation(rotateIndefinitely);
        editTextUsername.addTextChangedListener(usernameTextWatcher);
        editTextPassword.addTextChangedListener(passwordTextWatcher);

        addListeners();
    }

    private void addListeners(){
        buttonLetsGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextValidatorContext usernameValidator = new TextValidatorContext(usernameTextWatcher);
                TextValidatorContext passwordValidator = new TextValidatorContext(passwordTextWatcher);

                if(usernameValidator.executeValidation() && passwordValidator.executeValidation()){
                    // try to log in

                    // if success
                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // go to Sign In activity
            }
        });
    }
}
