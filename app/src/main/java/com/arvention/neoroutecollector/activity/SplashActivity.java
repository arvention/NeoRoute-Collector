package com.arvention.neoroutecollector.activity;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.arvention.neoroutecollector.R;
import com.arvention.neoroutecollector.helper.FieldTextWatcher;
import com.arvention.neoroutecollector.helper.PasswordFieldTextWatcher;
import com.arvention.neoroutecollector.helper.UsernameFieldTextWatcher;

public class SplashActivity extends AppCompatActivity {

    private CoordinatorLayout splashActivityCoordinator;

    private ImageView splashIcon;

    private EditText splashEditTextUsername;
    private EditText splashEditTextPassword;
    private TextInputLayout splashTextInputLayoutUsername;
    private TextInputLayout splashTextInputLayoutPassword;

    private Button splashButtonLetsGo;
    private Button splashButtonSignIn;

    private Animation rotateIndefinitely;

    private FieldTextWatcher textWatcherUsername;
    private FieldTextWatcher textWatcherPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashActivityCoordinator = (CoordinatorLayout) findViewById(R.id.activity_splash_coordinator);

        splashIcon = (ImageView) findViewById(R.id.splash_icon);

        splashEditTextUsername = (EditText) findViewById(R.id.splash_edit_text_username);
        splashEditTextPassword = (EditText) findViewById(R.id.splash_edit_text_password);
        splashTextInputLayoutUsername = (TextInputLayout) findViewById(R.id.splash_text_input_layout_username);
        splashTextInputLayoutPassword = (TextInputLayout) findViewById(R.id.splash_text_input_layout_password);

        splashButtonLetsGo = (Button) findViewById(R.id.splash_button_lets_go);
        splashButtonSignIn = (Button) findViewById(R.id.splash_button_sign_in);

        rotateIndefinitely = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_indefinitely);

        textWatcherUsername = new UsernameFieldTextWatcher(splashEditTextUsername, splashTextInputLayoutUsername, getString(R.string.err_splash_username_empty), this);
        textWatcherPassword = new PasswordFieldTextWatcher(splashEditTextPassword, splashTextInputLayoutPassword, getString(R.string.err_splash_password_empty), this);

        splashIcon.startAnimation(rotateIndefinitely);

        addListeners();
    }

    private void addListeners(){

        splashEditTextUsername.addTextChangedListener(textWatcherUsername);
        splashEditTextPassword.addTextChangedListener(textWatcherPassword);

        splashButtonLetsGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!textWatcherUsername.isEmpty() && !textWatcherPassword.isEmpty()){
                    // try to log in

                    // if success
                    Snackbar.make(splashActivityCoordinator, SplashActivity.this.getString(R.string.welcome_to_neoroute), Snackbar.LENGTH_LONG).show();
                }
            }
        });

        splashButtonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this, SignUpActivity.class));
            }
        });
    }
}
