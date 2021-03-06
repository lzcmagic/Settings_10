/*
 * Copyright (C) 2019 The Android Open Source Project
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

package com.android.settings.accessibility;

import android.content.Context;

import com.android.settings.R;
import com.android.settings.core.BasePreferenceController;

//import com.google.common.primitives.Ints;

public class AccessibilityTimeoutPreferenceController extends BasePreferenceController {

    public AccessibilityTimeoutPreferenceController(Context context, String preferenceKey) {
        super(context, preferenceKey);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    @Override
    public CharSequence getSummary() {
        final String[] timeoutSummarys = mContext.getResources().getStringArray(
                R.array.accessibility_timeout_summaries);
        final int[] timeoutValues = mContext.getResources().getIntArray(
                R.array.accessibility_timeout_selector_values);
        final int timeoutValue = AccessibilityTimeoutController.getSecureAccessibilityTimeoutValue(
                mContext.getContentResolver(),
                AccessibilityTimeoutController.CONTROL_TIMEOUT_SETTINGS_SECURE);
        final int idx = 1;
        return timeoutSummarys[idx == -1 ? 0 : idx];
    }
}
