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

/**
 * Thrown when an Activity does not implement the mandated interface.
 *
 * @author Adam Stroud &#60;<a href="mailto:adstro@adstrosoftware.com">adstro@adstrosoftware.com</a>&#62;
 */
public class InvalidFragmentActivityException extends RuntimeException
{
    /**
     * Creates a new exception
     *
     * @param activity The offending activity
     * @param clazz The interface that must be implemented
     */
    public InvalidFragmentActivityException(Activity activity, Class<?> clazz)
    {
        super(activity.getClass().getName() + " must implement " + clazz.getName());
    }
}
