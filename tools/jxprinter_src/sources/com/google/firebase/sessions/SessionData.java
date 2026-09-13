package com.google.firebase.sessions;

import java.util.Map;
import kotlin.jvm.internal.AbstractC1107v;
import kotlin.jvm.internal.E;
import p060k4.k;
import p072m4.r;
import p078n4.h;
import p084o4.C1306e0;
import p084o4.E0;
import p084o4.Q0;
import p084o4.V0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@k
public final class SessionData {
    private final Time backgroundTime;
    private final Map<String, ProcessData> processDataMap;
    private final SessionDetails sessionDetails;
    public static final Companion Companion = new Companion(null);
    private static final p060k4.b[] $childSerializers = {null, null, new C1306e0(V0.INSTANCE, ProcessData$$serializer.INSTANCE)};

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Companion {
        private Companion() {
        }

        public final p060k4.b serializer() {
            return SessionData$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(AbstractC1107v abstractC1107v) {
            this();
        }
    }

    public /* synthetic */ SessionData(int i5, SessionDetails sessionDetails, Time time, Map map, Q0 q6) {
        if (1 != (i5 & 1)) {
            E0.throwMissingFieldException(i5, 1, SessionData$$serializer.INSTANCE.getDescriptor());
        }
        this.sessionDetails = sessionDetails;
        if ((i5 & 2) == 0) {
            this.backgroundTime = null;
        } else {
            this.backgroundTime = time;
        }
        if ((i5 & 4) == 0) {
            this.processDataMap = null;
        } else {
            this.processDataMap = map;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SessionData copy$default(SessionData sessionData, SessionDetails sessionDetails, Time time, Map map, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            sessionDetails = sessionData.sessionDetails;
        }
        if ((i5 & 2) != 0) {
            time = sessionData.backgroundTime;
        }
        if ((i5 & 4) != 0) {
            map = sessionData.processDataMap;
        }
        return sessionData.copy(sessionDetails, time, map);
    }

    public static final /* synthetic */ void write$Self$com_google_firebase_firebase_sessions(SessionData sessionData, h hVar, r rVar) {
        p060k4.b[] bVarArr = $childSerializers;
        hVar.encodeSerializableElement(rVar, 0, SessionDetails$$serializer.INSTANCE, sessionData.sessionDetails);
        if (hVar.shouldEncodeElementDefault(rVar, 1) || sessionData.backgroundTime != null) {
            hVar.encodeNullableSerializableElement(rVar, 1, Time$$serializer.INSTANCE, sessionData.backgroundTime);
        }
        if (!hVar.shouldEncodeElementDefault(rVar, 2) && sessionData.processDataMap == null) {
            return;
        }
        hVar.encodeNullableSerializableElement(rVar, 2, bVarArr[2], sessionData.processDataMap);
    }

    public final SessionDetails component1() {
        return this.sessionDetails;
    }

    public final Time component2() {
        return this.backgroundTime;
    }

    public final Map<String, ProcessData> component3() {
        return this.processDataMap;
    }

    public final SessionData copy(SessionDetails sessionDetails, Time time, Map<String, ProcessData> map) {
        E.f(sessionDetails, "sessionDetails");
        return new SessionData(sessionDetails, time, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionData)) {
            return false;
        }
        SessionData sessionData = (SessionData) obj;
        return E.a(this.sessionDetails, sessionData.sessionDetails) && E.a(this.backgroundTime, sessionData.backgroundTime) && E.a(this.processDataMap, sessionData.processDataMap);
    }

    public final Time getBackgroundTime() {
        return this.backgroundTime;
    }

    public final Map<String, ProcessData> getProcessDataMap() {
        return this.processDataMap;
    }

    public final SessionDetails getSessionDetails() {
        return this.sessionDetails;
    }

    public int hashCode() {
        int iHashCode = this.sessionDetails.hashCode() * 31;
        Time time = this.backgroundTime;
        int iHashCode2 = (iHashCode + (time == null ? 0 : time.hashCode())) * 31;
        Map<String, ProcessData> map = this.processDataMap;
        return iHashCode2 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "SessionData(sessionDetails=" + this.sessionDetails + ", backgroundTime=" + this.backgroundTime + ", processDataMap=" + this.processDataMap + ')';
    }

    public SessionData(SessionDetails sessionDetails, Time time, Map<String, ProcessData> map) {
        E.f(sessionDetails, "sessionDetails");
        this.sessionDetails = sessionDetails;
        this.backgroundTime = time;
        this.processDataMap = map;
    }

    public /* synthetic */ SessionData(SessionDetails sessionDetails, Time time, Map map, int i5, AbstractC1107v abstractC1107v) {
        this(sessionDetails, (i5 & 2) != 0 ? null : time, (i5 & 4) != 0 ? null : map);
    }
}
