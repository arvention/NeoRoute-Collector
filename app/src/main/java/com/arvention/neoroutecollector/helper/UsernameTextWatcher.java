package com.arvention.neoroutecollector.helper;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.arvention.neoroutecollector.R;

/**
 * Created by amcan on 10/22/2016.
 */

public class UsernameTextWatcher implements TextWatcher, TextValidator{

    private EditText editTextUsername;
    private TextInputLayout textInputLayoutUsername;
    private AppCompatActivity activity;

    public UsernameTextWatcher(EditText editTextUsername, TextInputLayout textInputLayoutUsername, AppCompatActivity activity) {
        this.editTextUsername = editTextUsername;
        this.textInputLayoutUsername = textInputLayoutUsername;
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

        if(editTextUsername.getText().toString().trim().isEmpty()) {
            textInputLayoutUsername.setError(activity.getString(R.string.err_username_empty));
            requestFocus(textInputLayoutUsername);
        } else {
            isEmpty = true;
            textInputLayoutUsername.setErrorEnabled(false);
        }

        return isEmpty;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }
}
