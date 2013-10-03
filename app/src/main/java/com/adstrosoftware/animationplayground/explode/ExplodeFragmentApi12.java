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
package com.adstrosoftware.animationplayground.explode;

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
public class ExplodeFragmentApi12 extends ExplodeFragment implements View.OnClickListener {

    private View animationContainer;
    private View layout;
    private boolean animated;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_explode, container, false);

        layout.findViewById(R.id.animate).setOnClickListener(this);
        animationContainer = layout.findViewById(R.id.animationContainer);

        return layout;
    }

    @Override
    public void onClick(View v) {

        if (animated) {
            layout.findViewById(R.id.animatedView1).clearAnimation();
            layout.findViewById(R.id.animatedView2).clearAnimation();
            layout.findViewById(R.id.animatedView3).clearAnimation();
            layout.findViewById(R.id.animatedView4).clearAnimation();
            layout.findViewById(R.id.animatedView5).clearAnimation();
            layout.findViewById(R.id.animatedView6).clearAnimation();
            layout.findViewById(R.id.animatedView7).clearAnimation();
            layout.findViewById(R.id.animatedView8).clearAnimation();
        } else {
            animateToLeft(R.id.animatedView1);
            animateToTopLeft(R.id.animatedView2);
            animateToTop(R.id.animatedView3);
            animateToTopRight(R.id.animatedView4);
            animateToRight(R.id.animatedView5);
            animateToBottomRight(R.id.animatedView6);
            animateToBottom(R.id.animatedView7);
            animateToBottomLeft(R.id.animatedView8);
        }
    }

    private void animateToLeft(int viewId) {
        layout.findViewById(viewId).animate().x(0);
    }

    private void animateToTop(int viewId) {
        layout.findViewById(viewId).animate().y(0);
    }

    private void animateToRight(int viewId) {
        View view = layout.findViewById(viewId);
        view.animate().x(animationContainer.getRight() - view.getWidth());
    }

    private void animateToBottom(int viewId) {
        View view = layout.findViewById(viewId);
        view.animate().y(animationContainer.getBottom() - view.getHeight());
    }

    private void animateToTopLeft(int viewId) {
        View view = layout.findViewById(viewId);
        view.animate().x(0).y(0);
    }

    private void animateToTopRight(int viewId) {
        View view = layout.findViewById(viewId);
        view.animate().x(animationContainer.getRight() - view.getWidth()).y(0);
    }

    private void animateToBottomRight(int viewId) {
        View view = layout.findViewById(viewId);
        view.animate().x(animationContainer.getRight() - view.getWidth()).y(animationContainer.getBottom() - view.getHeight());
    }

    private void animateToBottomLeft(int viewId) {
        View view = layout.findViewById(viewId);
        view.animate().x(0).y(animationContainer.getBottom() - view.getHeight());
    }
}
