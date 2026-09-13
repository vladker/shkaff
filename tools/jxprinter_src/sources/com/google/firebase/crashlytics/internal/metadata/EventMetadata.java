package com.google.firebase.crashlytics.internal.metadata;

import A3.k0;
import java.util.Map;
import kotlin.jvm.internal.AbstractC1107v;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class EventMetadata {
    private final Map<String, String> additionalCustomKeys;
    private final String sessionId;
    private final long timestamp;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EventMetadata(String sessionId, long j6) {
        this(sessionId, j6, null, 4, null);
        E.f(sessionId, "sessionId");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EventMetadata copy$default(EventMetadata eventMetadata, String str, long j6, Map map, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = eventMetadata.sessionId;
        }
        if ((i5 & 2) != 0) {
            j6 = eventMetadata.timestamp;
        }
        if ((i5 & 4) != 0) {
            map = eventMetadata.additionalCustomKeys;
        }
        return eventMetadata.copy(str, j6, map);
    }

    public final String component1() {
        return this.sessionId;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final Map<String, String> component3() {
        return this.additionalCustomKeys;
    }

    public final EventMetadata copy(String sessionId, long j6, Map<String, String> additionalCustomKeys) {
        E.f(sessionId, "sessionId");
        E.f(additionalCustomKeys, "additionalCustomKeys");
        return new EventMetadata(sessionId, j6, additionalCustomKeys);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EventMetadata)) {
            return false;
        }
        EventMetadata eventMetadata = (EventMetadata) obj;
        return E.a(this.sessionId, eventMetadata.sessionId) && this.timestamp == eventMetadata.timestamp && E.a(this.additionalCustomKeys, eventMetadata.additionalCustomKeys);
    }

    public final Map<String, String> getAdditionalCustomKeys() {
        return this.additionalCustomKeys;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return this.additionalCustomKeys.hashCode() + ((Long.hashCode(this.timestamp) + (this.sessionId.hashCode() * 31)) * 31);
    }

    public String toString() {
        return "EventMetadata(sessionId=" + this.sessionId + ", timestamp=" + this.timestamp + ", additionalCustomKeys=" + this.additionalCustomKeys + ')';
    }

    public EventMetadata(String sessionId, long j6, Map<String, String> additionalCustomKeys) {
        E.f(sessionId, "sessionId");
        E.f(additionalCustomKeys, "additionalCustomKeys");
        this.sessionId = sessionId;
        this.timestamp = j6;
        this.additionalCustomKeys = additionalCustomKeys;
    }

    public /* synthetic */ EventMetadata(String str, long j6, Map map, int i5, AbstractC1107v abstractC1107v) {
        this(str, j6, (i5 & 4) != 0 ? k0.emptyMap() : map);
    }
}
