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

import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adstrosoftware.animationplayground.R;

/**
 * Fragment that implements horizontal animation using API 12 API.
 *
 * @author Adam Stroud &#60;<a href="mailto:adstro@adstrosoftware.com">adstro@adstrosoftware.com</a>&#62;
 */
@TargetApi(12)
public class HorizontalFragmentApi12 extends HorizontalFragment implements View.OnClickListener {

    private static final String TAG = "HorizontalFragmentAps12";

    private View layout;

    /**
     * no-arg constructor needed by Android SDK
     */
    public HorizontalFragmentApi12() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_horizontal, container, false);
        layout.findViewById(R.id.animate).setOnClickListener(this);

        return layout;
    }

    @Override
    public void onClick(View v) {
        float left = layout.getX();
        float right = layout.getWidth() - layout.findViewById(R.id.textView1).getWidth();

        layout.findViewById(R.id.textView1).animate().x(left);
        layout.findViewById(R.id.textView2).animate().x(right);
        layout.findViewById(R.id.textView3).animate().x(left);
        layout.findViewById(R.id.textView4).animate().x(right);
        layout.findViewById(R.id.textView5).animate().x(left);
        layout.findViewById(R.id.textView6).animate().x(right);
    }
}
