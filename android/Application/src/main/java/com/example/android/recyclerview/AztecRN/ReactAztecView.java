package com.example.android.recyclerview.AztecRN;

import android.content.Context;
import android.widget.EditText;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

public class ReactAztecView extends EditText {
    public ReactAztecView(ThemedReactContext reactContext, Context context) {
        super(context);
    }

    @ReactProp(name = "text")
    public void setText(ReactAztecView view, String text) {
        view.setText(text);
    }

}
