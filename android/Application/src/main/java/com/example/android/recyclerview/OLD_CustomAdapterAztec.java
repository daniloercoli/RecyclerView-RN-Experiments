/*
* Copyright (C) 2014 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.recyclerview;

import com.example.android.common.logger.Log;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.wordpress.aztec.Aztec;
import org.wordpress.aztec.AztecText;
import org.wordpress.aztec.ITextFormat;
import org.wordpress.aztec.plugins.shortcodes.AudioShortcodePlugin;
import org.wordpress.aztec.plugins.shortcodes.CaptionShortcodePlugin;
import org.wordpress.aztec.plugins.shortcodes.VideoShortcodePlugin;
import org.wordpress.aztec.plugins.wpcomments.WordPressCommentsPlugin;
import org.wordpress.aztec.plugins.wpcomments.toolbar.MoreToolbarButton;
import org.wordpress.aztec.source.SourceViewEditText;
import org.wordpress.aztec.toolbar.AztecToolbar;
import org.wordpress.aztec.toolbar.IAztecToolbarClickListener;

/**
 * Provide views to RecyclerView with data from mDataSet.
 */
public class OLD_CustomAdapterAztec extends RecyclerView.Adapter<OLD_CustomAdapterAztec.ViewHolder> {
    private static final String TAG = "OLD_CustomAdapterAztec";

    private String[] mDataSet;

    // BEGIN_INCLUDE(recyclerViewSampleViewHolder)
    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final AztecText content;
        private AztecToolbar formattingToolbar;
        private SourceViewEditText source;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            /*v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
                }
            });*/
            content = (AztecText) v.findViewById(R.id.aztec);
            formattingToolbar = (AztecToolbar) v.findViewById(R.id.formatting_toolbar);
            source = (SourceViewEditText) v.findViewById(R.id.source);

            Aztec.Factory.with(content, source, formattingToolbar, new IAztecToolbarClickListener() {
                @Override
                public void onToolbarCollapseButtonClicked() {

                }

                @Override
                public void onToolbarExpandButtonClicked() {

                }

                @Override
                public void onToolbarFormatButtonClicked(ITextFormat iTextFormat, boolean b) {

                }

                @Override
                public void onToolbarHeadingButtonClicked() {

                }

                @Override
                public void onToolbarHtmlButtonClicked() {

                }

                @Override
                public void onToolbarListButtonClicked() {

                }

                @Override
                public boolean onToolbarMediaButtonClicked() {
                    return false;
                }
            })
                    .addPlugin(new WordPressCommentsPlugin(content))
                    .addPlugin(new MoreToolbarButton(content))
                    .addPlugin(new CaptionShortcodePlugin(content))
                    .addPlugin(new VideoShortcodePlugin())
                    .addPlugin(new AudioShortcodePlugin());

            //content.refreshText();
        }

        public AztecText getAztecView() {
            return content;
        }
    }
    // END_INCLUDE(recyclerViewSampleViewHolder)

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used by RecyclerView.
     */
    public OLD_CustomAdapterAztec(String[] dataSet) {
        mDataSet = dataSet;
    }

    // BEGIN_INCLUDE(recyclerViewOnCreateViewHolder)
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.aztec_row_item, viewGroup, false);

        return new ViewHolder(v);
    }
    // END_INCLUDE(recyclerViewOnCreateViewHolder)

    // BEGIN_INCLUDE(recyclerViewOnBindViewHolder)
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Log.d(TAG, "Element " + position + " set.");

        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        viewHolder.getAztecView().setText(mDataSet[position]);
    }
    // END_INCLUDE(recyclerViewOnBindViewHolder)

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}
