package com.arvention.neoroutecollector.helper;

import android.text.TextWatcher;

/**
 * Created by amcan on 10/22/2016.
 */

public class TextValidatorContext {

    private TextValidator textValidatorStrategy;

    public TextValidatorContext(TextValidator textValidatorStrategy){
        this.textValidatorStrategy = textValidatorStrategy;
    }

    public boolean executeValidation(){
        return textValidatorStrategy.validate();
    }

}
