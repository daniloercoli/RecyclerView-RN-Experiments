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

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.android.common.activities.SampleActivityBase;
import com.example.android.common.logger.Log;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Provide views to RecyclerView with data from mDataSet.
 */
public class CustomAdapterRNTextInput extends RecyclerView.Adapter<CustomAdapterRNTextInput.MyViewHolder> implements ItemTouchHelperAdapter {
    private static final String TAG = "CustomAdapterSimpleText";

    private final List<String> mItems = new ArrayList<>();
    private Context ctx;
    private ReactInstanceManager mReactInstanceManager;

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used by RecyclerView.
     */
    CustomAdapterRNTextInput(SampleActivityBase act, String[] dataSet) {
        mItems.addAll(Arrays.asList(dataSet));
        ctx = act.getBaseContext();
        mReactInstanceManager = act.getReactInstanceManager();
    }

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    static class MyViewHolder extends RecyclerView.ViewHolder {
        private ReactInstanceManager mReactInstanceManager;
        private LinearLayout container;
        private Button btnUp;
        private Button btnDown;
        private Context mContext;

        MyViewHolder(Context ctx, ReactInstanceManager reactInstanceManager, View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            /*v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
                }
            });*/
            mReactInstanceManager = reactInstanceManager;
            container = v.findViewById(R.id.rn_container);
            btnUp = v.findViewById(R.id.buttonUp);
            btnDown = v.findViewById(R.id.buttonDown);
            mContext = ctx;
        }

        // UGLY!!!
        void refreshReacNativeView(String text){
            container.removeAllViews();
            ReactRootView reactRootView = new ReactRootView(mContext);
            Bundle RNPropos = new Bundle();
            RNPropos.putString("text", text);
            reactRootView.startReactApplication(mReactInstanceManager, "SimpleTextInput", RNPropos);
            container.addView(reactRootView);
        }

        public Button getBtnUp() {
            return btnUp;
        }

        public Button getBtnDown() {
            return btnDown;
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.rn_row_item, viewGroup, false);

        return new MyViewHolder(ctx, mReactInstanceManager, v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final MyViewHolder viewHolder, final int position) {
        Log.d(TAG, "Element " + position + " set.");
        viewHolder.refreshReacNativeView(mItems.get(position));
        viewHolder.getBtnUp().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = viewHolder.getAdapterPosition();
                if (pos > 0) {
                    CustomAdapterRNTextInput.this.onItemMove(pos, pos - 1);
                }
            }
        });
        viewHolder.getBtnDown().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = viewHolder.getAdapterPosition();
                if (pos < mItems.size() -1) {
                    CustomAdapterRNTextInput.this.onItemMove(pos, pos + 1);
                }
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mItems.size();
    }


    // DRAG AND DROP
    @Override
    public void onItemDismiss(int position) {
        mItems.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(mItems, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(mItems, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }
}