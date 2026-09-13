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
public final class ProcessData {
    public static final Companion Companion = new Companion(null);
    private final int pid;
    private final String uuid;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Companion {
        private Companion() {
        }

        public final p060k4.b serializer() {
            return ProcessData$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(AbstractC1107v abstractC1107v) {
            this();
        }
    }

    public /* synthetic */ ProcessData(int i5, int i6, String str, Q0 q6) {
        if (3 != (i5 & 3)) {
            E0.throwMissingFieldException(i5, 3, ProcessData$$serializer.INSTANCE.getDescriptor());
        }
        this.pid = i6;
        this.uuid = str;
    }

    public static /* synthetic */ ProcessData copy$default(ProcessData processData, int i5, String str, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i5 = processData.pid;
        }
        if ((i6 & 2) != 0) {
            str = processData.uuid;
        }
        return processData.copy(i5, str);
    }

    public static final /* synthetic */ void write$Self$com_google_firebase_firebase_sessions(ProcessData processData, h hVar, r rVar) {
        hVar.encodeIntElement(rVar, 0, processData.pid);
        hVar.encodeStringElement(rVar, 1, processData.uuid);
    }

    public final int component1() {
        return this.pid;
    }

    public final String component2() {
        return this.uuid;
    }

    public final ProcessData copy(int i5, String uuid) {
        E.f(uuid, "uuid");
        return new ProcessData(i5, uuid);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProcessData)) {
            return false;
        }
        ProcessData processData = (ProcessData) obj;
        return this.pid == processData.pid && E.a(this.uuid, processData.uuid);
    }

    public final int getPid() {
        return this.pid;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public int hashCode() {
        return this.uuid.hashCode() + (Integer.hashCode(this.pid) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ProcessData(pid=");
        sb.append(this.pid);
        sb.append(", uuid=");
        return androidx.collection.a.f(')', this.uuid, sb);
    }

    public ProcessData(int i5, String uuid) {
        E.f(uuid, "uuid");
        this.pid = i5;
        this.uuid = uuid;
    }
}
