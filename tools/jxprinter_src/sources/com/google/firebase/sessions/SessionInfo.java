package com.google.firebase.sessions;

import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class SessionInfo {
    private final DataCollectionStatus dataCollectionStatus;
    private final long eventTimestampUs;
    private final String firebaseAuthenticationToken;
    private final String firebaseInstallationId;
    private final String firstSessionId;
    private final String sessionId;
    private final int sessionIndex;

    public SessionInfo(String sessionId, String firstSessionId, int i5, long j6, DataCollectionStatus dataCollectionStatus, String firebaseInstallationId, String firebaseAuthenticationToken) {
        E.f(sessionId, "sessionId");
        E.f(firstSessionId, "firstSessionId");
        E.f(dataCollectionStatus, "dataCollectionStatus");
        E.f(firebaseInstallationId, "firebaseInstallationId");
        E.f(firebaseAuthenticationToken, "firebaseAuthenticationToken");
        this.sessionId = sessionId;
        this.firstSessionId = firstSessionId;
        this.sessionIndex = i5;
        this.eventTimestampUs = j6;
        this.dataCollectionStatus = dataCollectionStatus;
        this.firebaseInstallationId = firebaseInstallationId;
        this.firebaseAuthenticationToken = firebaseAuthenticationToken;
    }

    public static /* synthetic */ SessionInfo copy$default(SessionInfo sessionInfo, String str, String str2, int i5, long j6, DataCollectionStatus dataCollectionStatus, String str3, String str4, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = sessionInfo.sessionId;
        }
        if ((i6 & 2) != 0) {
            str2 = sessionInfo.firstSessionId;
        }
        if ((i6 & 4) != 0) {
            i5 = sessionInfo.sessionIndex;
        }
        if ((i6 & 8) != 0) {
            j6 = sessionInfo.eventTimestampUs;
        }
        if ((i6 & 16) != 0) {
            dataCollectionStatus = sessionInfo.dataCollectionStatus;
        }
        if ((i6 & 32) != 0) {
            str3 = sessionInfo.firebaseInstallationId;
        }
        if ((i6 & 64) != 0) {
            str4 = sessionInfo.firebaseAuthenticationToken;
        }
        String str5 = str4;
        DataCollectionStatus dataCollectionStatus2 = dataCollectionStatus;
        long j7 = j6;
        int i7 = i5;
        return sessionInfo.copy(str, str2, i7, j7, dataCollectionStatus2, str3, str5);
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
        return this.eventTimestampUs;
    }

    public final DataCollectionStatus component5() {
        return this.dataCollectionStatus;
    }

    public final String component6() {
        return this.firebaseInstallationId;
    }

    public final String component7() {
        return this.firebaseAuthenticationToken;
    }

    public final SessionInfo copy(String sessionId, String firstSessionId, int i5, long j6, DataCollectionStatus dataCollectionStatus, String firebaseInstallationId, String firebaseAuthenticationToken) {
        E.f(sessionId, "sessionId");
        E.f(firstSessionId, "firstSessionId");
        E.f(dataCollectionStatus, "dataCollectionStatus");
        E.f(firebaseInstallationId, "firebaseInstallationId");
        E.f(firebaseAuthenticationToken, "firebaseAuthenticationToken");
        return new SessionInfo(sessionId, firstSessionId, i5, j6, dataCollectionStatus, firebaseInstallationId, firebaseAuthenticationToken);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionInfo)) {
            return false;
        }
        SessionInfo sessionInfo = (SessionInfo) obj;
        return E.a(this.sessionId, sessionInfo.sessionId) && E.a(this.firstSessionId, sessionInfo.firstSessionId) && this.sessionIndex == sessionInfo.sessionIndex && this.eventTimestampUs == sessionInfo.eventTimestampUs && E.a(this.dataCollectionStatus, sessionInfo.dataCollectionStatus) && E.a(this.firebaseInstallationId, sessionInfo.firebaseInstallationId) && E.a(this.firebaseAuthenticationToken, sessionInfo.firebaseAuthenticationToken);
    }

    public final DataCollectionStatus getDataCollectionStatus() {
        return this.dataCollectionStatus;
    }

    public final long getEventTimestampUs() {
        return this.eventTimestampUs;
    }

    public final String getFirebaseAuthenticationToken() {
        return this.firebaseAuthenticationToken;
    }

    public final String getFirebaseInstallationId() {
        return this.firebaseInstallationId;
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

    public int hashCode() {
        return this.firebaseAuthenticationToken.hashCode() + androidx.exifinterface.media.a.a((this.dataCollectionStatus.hashCode() + ((Long.hashCode(this.eventTimestampUs) + ((Integer.hashCode(this.sessionIndex) + androidx.exifinterface.media.a.a(this.sessionId.hashCode() * 31, 31, this.firstSessionId)) * 31)) * 31)) * 31, 31, this.firebaseInstallationId);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SessionInfo(sessionId=");
        sb.append(this.sessionId);
        sb.append(", firstSessionId=");
        sb.append(this.firstSessionId);
        sb.append(", sessionIndex=");
        sb.append(this.sessionIndex);
        sb.append(", eventTimestampUs=");
        sb.append(this.eventTimestampUs);
        sb.append(", dataCollectionStatus=");
        sb.append(this.dataCollectionStatus);
        sb.append(", firebaseInstallationId=");
        sb.append(this.firebaseInstallationId);
        sb.append(", firebaseAuthenticationToken=");
        return androidx.collection.a.f(')', this.firebaseAuthenticationToken, sb);
    }
}
