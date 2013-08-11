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

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;

import com.adstrosoftware.animationplayground.horizontal.HorizontalFragment;

/**
 * The main activity of the app
 *
 * @author Adam Stroud &#60;<a href="mailto:adstro@adstrosoftware.com">adstro@adstrosoftware.com</a>&#62;
 */
public class MainActivity extends ActionBarActivity implements AnimationListFragment.CallbackListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();

        if (fragmentManager.findFragmentById(R.id.animationListFragment) == null) {

            // Only add the fragment once to prevent overlapping fragments
            if (savedInstanceState == null) {
                Fragment fragment = AnimationListFragment.newInstance();

                fragmentManager
                        .beginTransaction()
                        .add(R.id.fragmentContainer, fragment, fragment.getClass().getName())
                        .commit();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onAnimationSelected(int animation) {
        if (animation == 0) {
            Fragment fragment = HorizontalFragment.newInstance();

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, fragment, fragment.getClass().getName())
                    .commit();
        }
    }
}
