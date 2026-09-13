package com.google.firebase.crashlytics;

import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class KeyValueBuilder {
    private final CustomKeysAndValues.Builder builder;

    private KeyValueBuilder(CustomKeysAndValues.Builder builder) {
        this.builder = builder;
    }

    public final CustomKeysAndValues build$com_google_firebase_firebase_crashlytics() {
        CustomKeysAndValues customKeysAndValuesBuild = this.builder.build();
        E.e(customKeysAndValuesBuild, "build(...)");
        return customKeysAndValuesBuild;
    }

    public final void key(String key, boolean z6) {
        E.f(key, "key");
        this.builder.putBoolean(key, z6);
    }

    public final void key(String key, double d) {
        E.f(key, "key");
        this.builder.putDouble(key, d);
    }

    public KeyValueBuilder() {
        this(new CustomKeysAndValues.Builder());
    }

    public final void key(String key, float f6) {
        E.f(key, "key");
        this.builder.putFloat(key, f6);
    }

    public final void key(String key, int i5) {
        E.f(key, "key");
        this.builder.putInt(key, i5);
    }

    public final void key(String key, long j6) {
        E.f(key, "key");
        this.builder.putLong(key, j6);
    }

    public final void key(String key, String value) {
        E.f(key, "key");
        E.f(value, "value");
        this.builder.putString(key, value);
    }
}
