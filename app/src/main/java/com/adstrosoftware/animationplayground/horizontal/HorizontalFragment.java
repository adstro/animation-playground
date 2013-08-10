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
package com.adstrosoftware.animationplayground.horizontal;

import android.os.Build;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.adstrosoftware.animationplayground.BuildConfig;

/**
 * Factory to instantiate the horizontal animation fragment based in API version.
 *
 * @author Adam Stroud &#60;<a href="mailto:adstro@adstrosoftware.com">adstro@adstrosoftware.com</a>&#62;
 */
public class HorizontalFragment extends Fragment {

    private static final String TAG = "HorizontalFragment";

    public static HorizontalFragment newInstance() {
        HorizontalFragment horizontalFragment;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
            horizontalFragment = new HorizontalFragmentApi12();
        } else {
            horizontalFragment = new HorizontalFragmentLegacy();
        }

        if (BuildConfig.DEBUG) {
            Log.d(TAG, "HorizontalFragment instance = -> " + horizontalFragment.getClass().getName());
        }

        return horizontalFragment;
    }
}
