package com.google.firebase.crashlytics.internal.settings;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class Settings {
    public final int cacheDuration;
    public final long expiresAtMillis;
    public final FeatureFlagData featureFlagData;
    public final double onDemandBackoffBase;
    public final int onDemandBackoffStepDurationSeconds;
    public final double onDemandUploadRatePerMinute;
    public final SessionData sessionData;
    public final int settingsVersion;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class FeatureFlagData {
        public final boolean collectAnrs;
        public final boolean collectBuildIds;
        public final boolean collectReports;

        public FeatureFlagData(boolean z6, boolean z7, boolean z8) {
            this.collectReports = z6;
            this.collectAnrs = z7;
            this.collectBuildIds = z8;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class SessionData {
        public final int maxCompleteSessionsCount;
        public final int maxCustomExceptionEvents;

        public SessionData(int i5, int i6) {
            this.maxCustomExceptionEvents = i5;
            this.maxCompleteSessionsCount = i6;
        }
    }

    public Settings(long j6, SessionData sessionData, FeatureFlagData featureFlagData, int i5, int i6, double d, double d6, int i7) {
        this.expiresAtMillis = j6;
        this.sessionData = sessionData;
        this.featureFlagData = featureFlagData;
        this.settingsVersion = i5;
        this.cacheDuration = i6;
        this.onDemandUploadRatePerMinute = d;
        this.onDemandBackoffBase = d6;
        this.onDemandBackoffStepDurationSeconds = i7;
    }

    public boolean isExpired(long j6) {
        return this.expiresAtMillis < j6;
    }
}
