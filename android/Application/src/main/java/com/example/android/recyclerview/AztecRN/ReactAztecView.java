package com.example.android.recyclerview.AztecRN;

import android.content.Context;
import android.graphics.Color;

import com.facebook.react.uimanager.ThemedReactContext;

import org.wordpress.aztec.AztecText;
import org.wordpress.aztec.plugins.IAztecPlugin;
import org.wordpress.aztec.plugins.shortcodes.AudioShortcodePlugin;
import org.wordpress.aztec.plugins.shortcodes.CaptionShortcodePlugin;
import org.wordpress.aztec.plugins.shortcodes.VideoShortcodePlugin;
import org.wordpress.aztec.plugins.wpcomments.WordPressCommentsPlugin;
import org.wordpress.aztec.plugins.wpcomments.toolbar.MoreToolbarButton;
import org.wordpress.aztec.glideloader.GlideImageLoader;
import org.wordpress.aztec.glideloader.GlideVideoThumbnailLoader;

public class ReactAztecView extends AztecText {

    public ReactAztecView(ThemedReactContext reactContext, Context context) {
        super(context);
        this.setFocusableInTouchMode(true);
        this.setFocusable(true);
        this.setMaxImagesWidth(200);
        addPlugin(new WordPressCommentsPlugin(this));
        addPlugin(new MoreToolbarButton(this));
        addPlugin(new CaptionShortcodePlugin(this));
        addPlugin(new VideoShortcodePlugin());
        addPlugin(new AudioShortcodePlugin());
        //this.setImageGetter(new GlideImageLoader(context));
        //this.setVideoThumbnailGetter(new GlideVideoThumbnailLoader(context));
    }

    private void addPlugin(IAztecPlugin plugin) {
        super.getPlugins().add(plugin);
       /* if (plugin instanceof IToolbarButton) {
            toolbar.addButton(plugin)
        }
*/
    }
}
