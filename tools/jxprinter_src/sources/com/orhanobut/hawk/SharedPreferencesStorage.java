package com.orhanobut.hawk;

import android.content.Context;
import android.content.SharedPreferences;
import io.flutter.plugins.firebase.crashlytics.Constants;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
final class SharedPreferencesStorage implements Storage {
    private final SharedPreferences preferences;

    public SharedPreferencesStorage(Context context, String str) {
        this.preferences = context.getSharedPreferences(str, 0);
    }

    private SharedPreferences.Editor getEditor() {
        return this.preferences.edit();
    }

    @Override // com.orhanobut.hawk.Storage
    public boolean contains(String str) {
        return this.preferences.contains(str);
    }

    @Override // com.orhanobut.hawk.Storage
    public long count() {
        return this.preferences.getAll().size();
    }

    @Override // com.orhanobut.hawk.Storage
    public boolean delete(String str) {
        return getEditor().remove(str).commit();
    }

    @Override // com.orhanobut.hawk.Storage
    public boolean deleteAll() {
        return getEditor().clear().commit();
    }

    @Override // com.orhanobut.hawk.Storage
    public <T> T get(String str) {
        return (T) this.preferences.getString(str, null);
    }

    @Override // com.orhanobut.hawk.Storage
    public <T> boolean put(String str, T t6) {
        HawkUtils.checkNull(Constants.KEY, str);
        return getEditor().putString(str, String.valueOf(t6)).commit();
    }

    public SharedPreferencesStorage(SharedPreferences sharedPreferences) {
        this.preferences = sharedPreferences;
    }
}
