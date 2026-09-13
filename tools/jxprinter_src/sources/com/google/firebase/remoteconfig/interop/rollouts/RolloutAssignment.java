package com.google.firebase.remoteconfig.interop.rollouts;

import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@AutoValue
@Encodable
public abstract class RolloutAssignment {
    private static final String PARAMETER_KEY = "parameterKey";
    private static final String PARAMETER_VALUE = "parameterValue";
    public static final DataEncoder ROLLOUT_ASSIGNMENT_JSON_ENCODER = new JsonDataEncoderBuilder().configureWith(AutoRolloutAssignmentEncoder.CONFIG).build();
    private static final String ROLLOUT_ID = "rolloutId";
    private static final String TEMPLATE_VERSION = "templateVersion";
    private static final String VARIANT_ID = "variantId";

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract RolloutAssignment build();

        @NonNull
        public abstract Builder setParameterKey(@NonNull String str);

        @NonNull
        public abstract Builder setParameterValue(@NonNull String str);

        @NonNull
        public abstract Builder setRolloutId(@NonNull String str);

        @NonNull
        public abstract Builder setTemplateVersion(long j6);

        @NonNull
        public abstract Builder setVariantId(@NonNull String str);
    }

    @NonNull
    public static Builder builder() {
        return new AutoValue_RolloutAssignment.Builder();
    }

    @NonNull
    public static RolloutAssignment create(@NonNull JSONObject jSONObject) {
        return builder().setRolloutId(jSONObject.getString(ROLLOUT_ID)).setVariantId(jSONObject.getString(VARIANT_ID)).setParameterKey(jSONObject.getString(PARAMETER_KEY)).setParameterValue(jSONObject.getString(PARAMETER_VALUE)).setTemplateVersion(jSONObject.getLong(TEMPLATE_VERSION)).build();
    }

    @NonNull
    public abstract String getParameterKey();

    @NonNull
    public abstract String getParameterValue();

    @NonNull
    public abstract String getRolloutId();

    public abstract long getTemplateVersion();

    @NonNull
    public abstract String getVariantId();

    @NonNull
    public static RolloutAssignment create(@NonNull String str) {
        return create(new JSONObject(str));
    }
}
