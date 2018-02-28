package com.example.android.recyclerview.AztecRN;

import android.content.Context;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import org.wordpress.aztec.AztecText;

public class ReactAztecView extends AztecText {

    public ReactAztecView(ThemedReactContext reactContext, Context context) {
        super(context);
    }

    @ReactProp(name = "text")
    public void setText(ReactAztecView view, String text) {
        view.fromHtml(text);
    }

}
