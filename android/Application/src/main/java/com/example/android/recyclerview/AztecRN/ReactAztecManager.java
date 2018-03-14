package com.example.android.recyclerview.AztecRN;


import android.content.Context;
import android.graphics.Color;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

public class ReactAztecManager extends SimpleViewManager<ReactAztecView> {

    public static final String REACT_CLASS = "RCTAztecView";
    private Context mCallerContext;

    public ReactAztecManager(Context ctx) {
        super();
        this.mCallerContext = ctx;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected ReactAztecView createViewInstance(ThemedReactContext reactContext) {
        return new ReactAztecView(reactContext, mCallerContext);
    }

    @ReactProp(name = "text")
    public void setText(ReactAztecView view, String text) {
        view.fromHtml(text);
    }
    @ReactProp(name = "color")
    public void setColor(ReactAztecView view, String color) {
        int newColor = Color.BLACK;
        try {
            newColor = Color.parseColor(color);
        } catch (IllegalArgumentException e) {
        }
        view.setTextColor(newColor);
    }
    @ReactProp(name = "maxImagesWidth")
    public void setMaxImagesWidth(ReactAztecView view, int maxWidth) {
        view.setMaxImagesWidth(maxWidth);
    }
    @ReactProp(name = "minImagesWidth")
    public void setMinImagesWidth(ReactAztecView view, int minWidth) {
        view.setMinImagesWidth(minWidth);
    }
}
