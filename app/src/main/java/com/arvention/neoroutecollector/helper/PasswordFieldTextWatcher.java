package com.arvention.neoroutecollector.helper;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.widget.EditText;

/**
 * Created by amcan on 10/23/2016.
 */

public class PasswordFieldTextWatcher extends FieldTextWatcher {

    public PasswordFieldTextWatcher(EditText field, TextInputLayout fieldLayout, String emptyErrorMessage, AppCompatActivity activity) {
        super(field, fieldLayout, emptyErrorMessage, activity);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        isEmpty();
        // add password validation
    }
}
