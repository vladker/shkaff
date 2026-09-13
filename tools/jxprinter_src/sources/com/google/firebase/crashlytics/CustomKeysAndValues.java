package com.google.firebase.crashlytics;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class CustomKeysAndValues {
    final Map<String, String> keysAndValues;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Builder {
        private Map<String, String> keysAndValues = new HashMap();

        @NonNull
        public CustomKeysAndValues build() {
            return new CustomKeysAndValues(this);
        }

        @NonNull
        public Builder putBoolean(@NonNull String str, boolean z6) {
            this.keysAndValues.put(str, Boolean.toString(z6));
            return this;
        }

        @NonNull
        public Builder putDouble(@NonNull String str, double d) {
            this.keysAndValues.put(str, Double.toString(d));
            return this;
        }

        @NonNull
        public Builder putFloat(@NonNull String str, float f6) {
            this.keysAndValues.put(str, Float.toString(f6));
            return this;
        }

        @NonNull
        public Builder putInt(@NonNull String str, int i5) {
            this.keysAndValues.put(str, Integer.toString(i5));
            return this;
        }

        @NonNull
        public Builder putLong(@NonNull String str, long j6) {
            this.keysAndValues.put(str, Long.toString(j6));
            return this;
        }

        @NonNull
        public Builder putString(@NonNull String str, @NonNull String str2) {
            this.keysAndValues.put(str, str2);
            return this;
        }
    }

    public CustomKeysAndValues(@NonNull Builder builder) {
        this.keysAndValues = builder.keysAndValues;
    }
}
