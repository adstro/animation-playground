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
package com.adstrosoftware.animationplayground.rotate;

import android.graphics.Path;
import android.graphics.PathMeasure;
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
public class RotateFragmentApi12 extends RotateFragment implements View.OnClickListener {

    private View layout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_rotate, container, false);

        layout.findViewById(R.id.animate).setOnClickListener(this);

        return layout;
    }

    @Override
    public void onClick(View v) {

        View animatedView1 = layout.findViewById(R.id.animatedView1);

        Path path = new Path();
        path.moveTo(animatedView1.getX(), animatedView1.getY());
        path.cubicTo(20, 20, 30, 300, 0, 0);

        PathMeasure pathMeasure = new PathMeasure(path, false);

//        ObjectAnimator ani = ObjectAnimator.ofObject(animatedView1, "", new PathEvaluator(), pathMeasure.getP)
    }
}
