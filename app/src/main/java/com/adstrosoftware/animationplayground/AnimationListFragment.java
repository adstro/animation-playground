/**
 * Copyright 2013 Adstro Software
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.adstrosoftware.animationplayground;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Fragment to list the supported animations
 *
 * @author Adam Stroud &#60;<a href="mailto:adstro@adstrosoftware.com">adstro@adstrosoftware.com</a>&#62;
 */
public class AnimationListFragment extends ListFragment {

    private CallbackListener callbackListener;

    /**
     * No-arg constructor needed by Android
     */
    public AnimationListFragment() {
        // no-op
    }

    public static AnimationListFragment newInstance() {
        return new AnimationListFragment();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(getActivity(),
                                                android.R.layout.simple_list_item_1,
                                                getResources().getStringArray(R.array.animation_array)));
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof CallbackListener) {
            callbackListener = (CallbackListener) activity;
        } else {
            throw new InvalidFragmentActivityException(activity, CallbackListener.class);
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        callbackListener.onAnimationSelected(position);
    }

    /**
     * Handles the callbacks for fragment actions
     */
    public interface CallbackListener {
        /**
         * Animation selection handler
         *
         * @param animation The animation index that was selected
         */
        public void onAnimationSelected(int animation);
    }
}
