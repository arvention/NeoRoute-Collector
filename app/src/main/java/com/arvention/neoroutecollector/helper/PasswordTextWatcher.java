package com.arvention.neoroutecollector.helper;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import com.arvention.neoroutecollector.R;

/**
 * Created by amcan on 10/22/2016.
 */

public class PasswordTextWatcher implements TextWatcher, TextValidator{

    private EditText editTextPassword;
    private TextInputLayout textInputLayoutPassword;
    private AppCompatActivity activity;

    public PasswordTextWatcher(EditText editTextPassword, TextInputLayout textInputLayoutPassword, AppCompatActivity activity) {
        this.editTextPassword = editTextPassword;
        this.textInputLayoutPassword = textInputLayoutPassword;
        this.activity = activity;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        validate();
    }

    @Override
    public boolean validate(){
        boolean isEmpty = false;

        if(editTextPassword.getText().toString().trim().isEmpty()) {
            textInputLayoutPassword.setError(activity.getString(R.string.err_password_empty));
            requestFocus(textInputLayoutPassword);
        } else {
            isEmpty = true;
            textInputLayoutPassword.setErrorEnabled(false);
        }

        return isEmpty;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }
}
