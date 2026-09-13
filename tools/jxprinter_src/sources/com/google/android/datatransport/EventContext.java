package com.google.android.datatransport;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@AutoValue
public abstract class EventContext {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract EventContext build();

        @NonNull
        public abstract Builder setExperimentIdsClear(byte[] bArr);

        @NonNull
        public abstract Builder setExperimentIdsEncrypted(byte[] bArr);

        @NonNull
        public abstract Builder setPseudonymousId(String str);
    }

    public static Builder builder() {
        return new AutoValue_EventContext.Builder();
    }

    @Nullable
    public abstract byte[] getExperimentIdsClear();

    @Nullable
    public abstract byte[] getExperimentIdsEncrypted();

    @Nullable
    public abstract String getPseudonymousId();
}
