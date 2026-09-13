package com.google.firebase.sessions.settings;

import kotlin.jvm.internal.AbstractC1107v;
import p060k4.b;
import p060k4.k;
import p072m4.r;
import p078n4.h;
import p084o4.C1313i;
import p084o4.C1318k0;
import p084o4.E;
import p084o4.E0;
import p084o4.Q0;
import p084o4.Z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@k
public final class SessionConfigs {
    public static final Companion Companion = new Companion(null);
    private final Integer cacheDurationSeconds;
    private final Long cacheUpdatedTimeSeconds;
    private final Double sessionSamplingRate;
    private final Integer sessionTimeoutSeconds;
    private final Boolean sessionsEnabled;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Companion {
        private Companion() {
        }

        public final b serializer() {
            return SessionConfigs$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(AbstractC1107v abstractC1107v) {
            this();
        }
    }

    public /* synthetic */ SessionConfigs(int i5, Boolean bool, Double d, Integer num, Integer num2, Long l6, Q0 q6) {
        if (31 != (i5 & 31)) {
            E0.throwMissingFieldException(i5, 31, SessionConfigs$$serializer.INSTANCE.getDescriptor());
        }
        this.sessionsEnabled = bool;
        this.sessionSamplingRate = d;
        this.sessionTimeoutSeconds = num;
        this.cacheDurationSeconds = num2;
        this.cacheUpdatedTimeSeconds = l6;
    }

    public static /* synthetic */ SessionConfigs copy$default(SessionConfigs sessionConfigs, Boolean bool, Double d, Integer num, Integer num2, Long l6, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            bool = sessionConfigs.sessionsEnabled;
        }
        if ((i5 & 2) != 0) {
            d = sessionConfigs.sessionSamplingRate;
        }
        if ((i5 & 4) != 0) {
            num = sessionConfigs.sessionTimeoutSeconds;
        }
        if ((i5 & 8) != 0) {
            num2 = sessionConfigs.cacheDurationSeconds;
        }
        if ((i5 & 16) != 0) {
            l6 = sessionConfigs.cacheUpdatedTimeSeconds;
        }
        Long l7 = l6;
        Integer num3 = num;
        return sessionConfigs.copy(bool, d, num3, num2, l7);
    }

    public static final /* synthetic */ void write$Self$com_google_firebase_firebase_sessions(SessionConfigs sessionConfigs, h hVar, r rVar) {
        hVar.encodeNullableSerializableElement(rVar, 0, C1313i.INSTANCE, sessionConfigs.sessionsEnabled);
        hVar.encodeNullableSerializableElement(rVar, 1, E.INSTANCE, sessionConfigs.sessionSamplingRate);
        Z z6 = Z.INSTANCE;
        hVar.encodeNullableSerializableElement(rVar, 2, z6, sessionConfigs.sessionTimeoutSeconds);
        hVar.encodeNullableSerializableElement(rVar, 3, z6, sessionConfigs.cacheDurationSeconds);
        hVar.encodeNullableSerializableElement(rVar, 4, C1318k0.INSTANCE, sessionConfigs.cacheUpdatedTimeSeconds);
    }

    public final Boolean component1() {
        return this.sessionsEnabled;
    }

    public final Double component2() {
        return this.sessionSamplingRate;
    }

    public final Integer component3() {
        return this.sessionTimeoutSeconds;
    }

    public final Integer component4() {
        return this.cacheDurationSeconds;
    }

    public final Long component5() {
        return this.cacheUpdatedTimeSeconds;
    }

    public final SessionConfigs copy(Boolean bool, Double d, Integer num, Integer num2, Long l6) {
        return new SessionConfigs(bool, d, num, num2, l6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionConfigs)) {
            return false;
        }
        SessionConfigs sessionConfigs = (SessionConfigs) obj;
        return kotlin.jvm.internal.E.a(this.sessionsEnabled, sessionConfigs.sessionsEnabled) && kotlin.jvm.internal.E.a(this.sessionSamplingRate, sessionConfigs.sessionSamplingRate) && kotlin.jvm.internal.E.a(this.sessionTimeoutSeconds, sessionConfigs.sessionTimeoutSeconds) && kotlin.jvm.internal.E.a(this.cacheDurationSeconds, sessionConfigs.cacheDurationSeconds) && kotlin.jvm.internal.E.a(this.cacheUpdatedTimeSeconds, sessionConfigs.cacheUpdatedTimeSeconds);
    }

    public final Integer getCacheDurationSeconds() {
        return this.cacheDurationSeconds;
    }

    public final Long getCacheUpdatedTimeSeconds() {
        return this.cacheUpdatedTimeSeconds;
    }

    public final Double getSessionSamplingRate() {
        return this.sessionSamplingRate;
    }

    public final Integer getSessionTimeoutSeconds() {
        return this.sessionTimeoutSeconds;
    }

    public final Boolean getSessionsEnabled() {
        return this.sessionsEnabled;
    }

    public int hashCode() {
        Boolean bool = this.sessionsEnabled;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Double d = this.sessionSamplingRate;
        int iHashCode2 = (iHashCode + (d == null ? 0 : d.hashCode())) * 31;
        Integer num = this.sessionTimeoutSeconds;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.cacheDurationSeconds;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l6 = this.cacheUpdatedTimeSeconds;
        return iHashCode4 + (l6 != null ? l6.hashCode() : 0);
    }

    public String toString() {
        return "SessionConfigs(sessionsEnabled=" + this.sessionsEnabled + ", sessionSamplingRate=" + this.sessionSamplingRate + ", sessionTimeoutSeconds=" + this.sessionTimeoutSeconds + ", cacheDurationSeconds=" + this.cacheDurationSeconds + ", cacheUpdatedTimeSeconds=" + this.cacheUpdatedTimeSeconds + ')';
    }

    public SessionConfigs(Boolean bool, Double d, Integer num, Integer num2, Long l6) {
        this.sessionsEnabled = bool;
        this.sessionSamplingRate = d;
        this.sessionTimeoutSeconds = num;
        this.cacheDurationSeconds = num2;
        this.cacheUpdatedTimeSeconds = l6;
    }
}
