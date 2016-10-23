package com.arvention.neoroutecollector.helper;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

/**
 * Created by amcan on 10/23/2016.
 */

public abstract class FieldTextWatcher implements TextWatcher {

    private EditText field;
    private TextInputLayout fieldLayout;
    private String emptyErrorMessage;
    private AppCompatActivity activity;

    public FieldTextWatcher(EditText field, TextInputLayout fieldLayout, String emptyErrorMessage, AppCompatActivity activity){
        this.field = field;
        this.fieldLayout = fieldLayout;
        this.emptyErrorMessage = emptyErrorMessage;
        this.activity = activity;
    }

    @Override
    public abstract void beforeTextChanged(CharSequence s, int start, int count, int after);

    @Override
    public abstract void onTextChanged(CharSequence s, int start, int before, int count);

    @Override
    public abstract void afterTextChanged(Editable s);

    public boolean isEmpty(){
        boolean isEmpty = true;

        if(!field.getText().toString().trim().isEmpty()) {
            isEmpty = false;
            fieldLayout.setErrorEnabled(false);
        } else {
            fieldLayout.setError(emptyErrorMessage);
            requestFocus(fieldLayout);
        }

        return isEmpty;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }
}
