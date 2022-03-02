package com.android.settings.deviceinfo.cadmus;

import android.content.Context;

import com.android.settings.core.BasePreferenceController;

import com.android.settings.R;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import android.provider.Settings;

public class LinuxAppModulePreferenceController extends BasePreferenceController {
    private final Context mContext;

    public LinuxAppModulePreferenceController(Context context,
            String preferenceKey) {
        super(context, preferenceKey);
        mContext = context;
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    @Override
    public CharSequence getSummary() {
        String summary = getSettingsSummary();

        if (summary != null) {
            return summary;
        }

        summary = getArraysSummary();
        if (summary != null) {
            return summary;
        }
        return "null";
    }

    private String getArraysSummary() {
        final List<String> versionList = Arrays.asList(mContext.getResources().getStringArray(R.array.app_module_version));
        String version = "";

        for (int i = 0; i < versionList.size(); i++) {
            if (versionList.get(i) == null || versionList.get(i).isEmpty() || versionList.get(i).equals("null")) {
                return null;
            }
            if (i == versionList.size() - 1) {
                version += versionList.get(i);
            } else {
                version += versionList.get(i) + "\n";
            }
        }
        return version;
    }

    private String getSettingsSummary() {
        String versionSummary = "";
        List<String> versionList = new ArrayList<>();

        final String name = Settings.System.getString(mContext.getContentResolver(), Settings.System.CADMUS_VERSION_LINUX_APP_NAME);
        final String md5 = Settings.System.getString(mContext.getContentResolver(), Settings.System.CADMUS_VERSION_LINUX_APP_MD5);
        final String version = Settings.System.getString(mContext.getContentResolver(), Settings.System.CADMUS_VERSION_LINUX_APP_VERSION);
        final String gitPath = Settings.System.getString(mContext.getContentResolver(), Settings.System.CADMUS_VERSION_LINUX_APP_GIT_PATH);
        final String gitVerison = Settings.System.getString(mContext.getContentResolver(), Settings.System.CADMUS_VERSION_LINUX_APP_GIT_VERSION);

        versionList.add(name);
        versionList.add(md5);
        versionList.add(version);
        versionList.add(gitPath);
        versionList.add(gitVerison);

        for (int i = 0; i < versionList.size(); i++) {
            if (versionList.get(i) == null || versionList.get(i).isEmpty() || versionList.get(i).equals("null")) {
                return null;
            }
            if (i == versionList.size() - 1) {
                versionSummary += versionList.get(i);
            } else {
                versionSummary += versionList.get(i) + "\n";
            }
        }
        return versionSummary;
    }
}
