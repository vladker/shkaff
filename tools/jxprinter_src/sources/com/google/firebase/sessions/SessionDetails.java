package com.google.firebase.sessions;

import kotlin.jvm.internal.AbstractC1107v;
import kotlin.jvm.internal.E;
import p060k4.k;
import p072m4.r;
import p078n4.h;
import p084o4.E0;
import p084o4.Q0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@k
public final class SessionDetails {
    public static final Companion Companion = new Companion(null);
    private final String firstSessionId;
    private final String sessionId;
    private final int sessionIndex;
    private final long sessionStartTimestampUs;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Companion {
        private Companion() {
        }

        public final p060k4.b serializer() {
            return SessionDetails$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(AbstractC1107v abstractC1107v) {
            this();
        }
    }

    public /* synthetic */ SessionDetails(int i5, String str, String str2, int i6, long j6, Q0 q6) {
        if (15 != (i5 & 15)) {
            E0.throwMissingFieldException(i5, 15, SessionDetails$$serializer.INSTANCE.getDescriptor());
        }
        this.sessionId = str;
        this.firstSessionId = str2;
        this.sessionIndex = i6;
        this.sessionStartTimestampUs = j6;
    }

    public static /* synthetic */ SessionDetails copy$default(SessionDetails sessionDetails, String str, String str2, int i5, long j6, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = sessionDetails.sessionId;
        }
        if ((i6 & 2) != 0) {
            str2 = sessionDetails.firstSessionId;
        }
        if ((i6 & 4) != 0) {
            i5 = sessionDetails.sessionIndex;
        }
        if ((i6 & 8) != 0) {
            j6 = sessionDetails.sessionStartTimestampUs;
        }
        int i7 = i5;
        return sessionDetails.copy(str, str2, i7, j6);
    }

    public static final /* synthetic */ void write$Self$com_google_firebase_firebase_sessions(SessionDetails sessionDetails, h hVar, r rVar) {
        hVar.encodeStringElement(rVar, 0, sessionDetails.sessionId);
        hVar.encodeStringElement(rVar, 1, sessionDetails.firstSessionId);
        hVar.encodeIntElement(rVar, 2, sessionDetails.sessionIndex);
        hVar.encodeLongElement(rVar, 3, sessionDetails.sessionStartTimestampUs);
    }

    public final String component1() {
        return this.sessionId;
    }

    public final String component2() {
        return this.firstSessionId;
    }

    public final int component3() {
        return this.sessionIndex;
    }

    public final long component4() {
        return this.sessionStartTimestampUs;
    }

    public final SessionDetails copy(String sessionId, String firstSessionId, int i5, long j6) {
        E.f(sessionId, "sessionId");
        E.f(firstSessionId, "firstSessionId");
        return new SessionDetails(sessionId, firstSessionId, i5, j6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionDetails)) {
            return false;
        }
        SessionDetails sessionDetails = (SessionDetails) obj;
        return E.a(this.sessionId, sessionDetails.sessionId) && E.a(this.firstSessionId, sessionDetails.firstSessionId) && this.sessionIndex == sessionDetails.sessionIndex && this.sessionStartTimestampUs == sessionDetails.sessionStartTimestampUs;
    }

    public final String getFirstSessionId() {
        return this.firstSessionId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final int getSessionIndex() {
        return this.sessionIndex;
    }

    public final long getSessionStartTimestampUs() {
        return this.sessionStartTimestampUs;
    }

    public int hashCode() {
        return Long.hashCode(this.sessionStartTimestampUs) + ((Integer.hashCode(this.sessionIndex) + androidx.exifinterface.media.a.a(this.sessionId.hashCode() * 31, 31, this.firstSessionId)) * 31);
    }

    public String toString() {
        return "SessionDetails(sessionId=" + this.sessionId + ", firstSessionId=" + this.firstSessionId + ", sessionIndex=" + this.sessionIndex + ", sessionStartTimestampUs=" + this.sessionStartTimestampUs + ')';
    }

    public SessionDetails(String sessionId, String firstSessionId, int i5, long j6) {
        E.f(sessionId, "sessionId");
        E.f(firstSessionId, "firstSessionId");
        this.sessionId = sessionId;
        this.firstSessionId = firstSessionId;
        this.sessionIndex = i5;
        this.sessionStartTimestampUs = j6;
    }
}
