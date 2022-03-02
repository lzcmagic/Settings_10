package com.android.settings.deviceinfo.cadmus;

import android.app.settings.SettingsEnums;
import android.content.Context;
import android.provider.SearchIndexableResource;

import com.android.settings.R;
import com.android.settings.dashboard.DashboardFragment;
import com.android.settings.search.BaseSearchIndexProvider;
import com.android.settingslib.search.Indexable;
import com.android.settingslib.search.SearchIndexable;

import java.util.ArrayList;
import java.util.List;

@SearchIndexable
public class CadmusVersion extends DashboardFragment {

    private static final String TAG = "CadmusVersion";

    @Override
    public int getMetricsCategory() {
        return SettingsEnums.ABOUT_LEGAL_SETTINGS;
    }

    @Override
    protected int getPreferenceScreenResId() {
        return R.xml.about_cadmus;
    }

    @Override
    protected String getLogTag() {
        return TAG;
    }

    public static final BaseSearchIndexProvider SEARCH_INDEX_DATA_PROVIDER =
            new BaseSearchIndexProvider(R.xml.about_cadmus);
}
