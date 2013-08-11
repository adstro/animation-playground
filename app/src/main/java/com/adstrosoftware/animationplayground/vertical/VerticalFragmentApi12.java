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
package com.adstrosoftware.animationplayground.vertical;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adstrosoftware.animationplayground.R;

/**
 * TODO
 *
 * @author Adam Stroud &#60;<a href="mailto:adstro@adstrosoftware.com">adstro@adstrosoftware.com</a>&#62;
 */
@TargetApi(12)
public class VerticalFragmentApi12 extends VerticalFragment implements View.OnClickListener {

    private View animationContainer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_vertical, container, false);

        animationContainer = layout.findViewById(R.id.animationContainer);
        layout.findViewById(R.id.animate).setOnClickListener(this);

        return layout;
    }

    @Override
    public void onClick(View v) {
        float top = animationContainer.getTop();
        float bottom = animationContainer.getBottom() - animationContainer.findViewById(R.id.animatedView1).getHeight();

        animationContainer.findViewById(R.id.animatedView1).animate().y(top);
        animationContainer.findViewById(R.id.animatedView2).animate().y(bottom);
        animationContainer.findViewById(R.id.animatedView3).animate().y(top);
        animationContainer.findViewById(R.id.animatedView4).animate().y(bottom);
        animationContainer.findViewById(R.id.animatedView5).animate().y(top);
        animationContainer.findViewById(R.id.animatedView6).animate().y(bottom);
    }
}
