package com.android.settings.deviceinfo.cadmus;

import android.content.Context;
import android.os.Build;

import com.android.settings.core.BasePreferenceController;

public class CadmusVersionPreferenceController extends BasePreferenceController {

    public CadmusVersionPreferenceController(Context context,
            String preferenceKey) {
        super(context, preferenceKey);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }
}
