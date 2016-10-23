package com.arvention.neoroutecollector.activity;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.arvention.neoroutecollector.R;
import com.arvention.neoroutecollector.helper.EmailFieldTextWatcher;
import com.arvention.neoroutecollector.helper.FieldTextWatcher;
import com.arvention.neoroutecollector.helper.NameFieldTextWatcher;
import com.arvention.neoroutecollector.helper.PasswordFieldTextWatcher;
import com.arvention.neoroutecollector.helper.UsernameFieldTextWatcher;

public class SignUpActivity extends AppCompatActivity {

    private CoordinatorLayout signUpActivityCoordinator;

    private EditText signUpEditTextFirstname;
    private EditText signUpEditTextLastname;
    private EditText signUpEditTextEmail;
    private EditText signUpEditTextUsername;
    private EditText signUpEditTextPassword;
    private TextInputLayout signUpTextInputLayoutFirstname;
    private TextInputLayout signUpTextInputLayoutLastname;
    private TextInputLayout signUpTextInputLayoutEmail;
    private TextInputLayout signUpTextInputLayoutUsername;
    private TextInputLayout signUpTextInputLayoutPassword;

    private Button signUpButton;

    private FieldTextWatcher textWatcherFirstname;
    private FieldTextWatcher textWatcherLastname;
    private FieldTextWatcher textWatcherEmail;
    private FieldTextWatcher textWatcherUsername;
    private FieldTextWatcher textWatcherPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signUpActivityCoordinator = (CoordinatorLayout) findViewById(R.id.activity_sign_up_coordinator);

        signUpEditTextFirstname = (EditText) findViewById(R.id.sign_up_edit_text_firstname);
        signUpEditTextLastname = (EditText) findViewById(R.id.sign_up_edit_text_lastname);
        signUpEditTextEmail = (EditText) findViewById(R.id.sign_up_edit_text_email);
        signUpEditTextUsername = (EditText) findViewById(R.id.sign_up_edit_text_username);
        signUpEditTextPassword = (EditText) findViewById(R.id.sign_up_edit_text_password);
        signUpTextInputLayoutFirstname = (TextInputLayout) findViewById(R.id.sign_up_text_input_layout_firstname);
        signUpTextInputLayoutLastname = (TextInputLayout) findViewById(R.id.sign_up_text_input_layout_lastname);
        signUpTextInputLayoutEmail = (TextInputLayout) findViewById(R.id.sign_up_text_input_layout_email);
        signUpTextInputLayoutUsername = (TextInputLayout) findViewById(R.id.sign_up_text_input_layout_username);
        signUpTextInputLayoutPassword = (TextInputLayout) findViewById(R.id.sign_up_text_input_layout_password);

        signUpButton = (Button) findViewById(R.id.sign_up_button);

        textWatcherFirstname = new NameFieldTextWatcher(signUpEditTextFirstname, signUpTextInputLayoutFirstname, getString(R.string.err_sign_up_firstname_empty), this);
        textWatcherLastname = new NameFieldTextWatcher(signUpEditTextLastname, signUpTextInputLayoutLastname, getString(R.string.err_sign_up_lastname_empty), this);
        textWatcherEmail = new EmailFieldTextWatcher(signUpEditTextEmail, signUpTextInputLayoutEmail, getString(R.string.err_sign_up_email_empty), this);
        textWatcherUsername = new UsernameFieldTextWatcher(signUpEditTextUsername, signUpTextInputLayoutUsername, getString(R.string.err_sign_up_username_empty), this);
        textWatcherPassword = new PasswordFieldTextWatcher(signUpEditTextPassword, signUpTextInputLayoutPassword, getString(R.string.err_sign_up_password_empty), this);

        addListeners();
    }

    private void addListeners(){
        signUpEditTextFirstname.addTextChangedListener(textWatcherFirstname);
        signUpEditTextLastname.addTextChangedListener(textWatcherLastname);
        signUpEditTextEmail.addTextChangedListener(textWatcherEmail);
        signUpEditTextUsername.addTextChangedListener(textWatcherUsername);
        signUpEditTextPassword.addTextChangedListener(textWatcherPassword);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!textWatcherFirstname.isEmpty() && !textWatcherLastname.isEmpty() && !textWatcherEmail.isEmpty()
                        && !textWatcherUsername.isEmpty() && !textWatcherPassword.isEmpty()){
                    // check validation
                    // if all valid add to database and make a snackbar below and go back to splash
                    Snackbar.make(signUpActivityCoordinator, SignUpActivity.this.getString(R.string.thanks_for_signing_up), Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }
}
