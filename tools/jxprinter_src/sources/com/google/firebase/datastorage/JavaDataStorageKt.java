package com.google.firebase.datastorage;

import androidx.datastore.preferences.core.Preferences;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class JavaDataStorageKt {
    public static final <T> T getOrDefault(Preferences preferences, Preferences.Key<T> key, T t6) {
        E.f(preferences, "<this>");
        E.f(key, "key");
        T t7 = (T) preferences.get(key);
        return t7 == null ? t6 : t7;
    }
}
