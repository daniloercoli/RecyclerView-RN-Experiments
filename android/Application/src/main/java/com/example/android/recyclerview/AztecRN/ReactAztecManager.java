package com.example.android.recyclerview.AztecRN;


import android.content.Context;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

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


}
