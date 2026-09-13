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
public final class Time {
    public static final Companion Companion = new Companion(null);
    private final long ms;
    private final long seconds;
    private final long us;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Companion {
        private Companion() {
        }

        public final p060k4.b serializer() {
            return Time$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(AbstractC1107v abstractC1107v) {
            this();
        }
    }

    public /* synthetic */ Time(int i5, long j6, long j7, long j8, Q0 q6) {
        if (1 != (i5 & 1)) {
            E0.throwMissingFieldException(i5, 1, Time$$serializer.INSTANCE.getDescriptor());
        }
        this.ms = j6;
        this.us = (i5 & 2) == 0 ? ((long) 1000) * j6 : j7;
        if ((i5 & 4) == 0) {
            this.seconds = j6 / ((long) 1000);
        } else {
            this.seconds = j8;
        }
    }

    public static /* synthetic */ Time copy$default(Time time, long j6, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            j6 = time.ms;
        }
        return time.copy(j6);
    }

    public static final /* synthetic */ void write$Self$com_google_firebase_firebase_sessions(Time time, h hVar, r rVar) {
        hVar.encodeLongElement(rVar, 0, time.ms);
        if (hVar.shouldEncodeElementDefault(rVar, 1) || time.us != time.ms * ((long) 1000)) {
            hVar.encodeLongElement(rVar, 1, time.us);
        }
        if (!hVar.shouldEncodeElementDefault(rVar, 2) && time.seconds == time.ms / ((long) 1000)) {
            return;
        }
        hVar.encodeLongElement(rVar, 2, time.seconds);
    }

    public final long component1() {
        return this.ms;
    }

    public final Time copy(long j6) {
        return new Time(j6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Time) && this.ms == ((Time) obj).ms;
    }

    public final long getMs() {
        return this.ms;
    }

    public final long getSeconds() {
        return this.seconds;
    }

    public final long getUs() {
        return this.us;
    }

    public int hashCode() {
        return Long.hashCode(this.ms);
    }

    /* JADX INFO: renamed from: minus-5sfh64U, reason: not valid java name */
    public final long m1014minus5sfh64U(Time time) {
        E.f(time, "time");
        Y3.a aVar = Y3.b.Companion;
        return Y3.d.toDuration(this.ms - time.ms, Y3.e.MILLISECONDS);
    }

    public String toString() {
        return "Time(ms=" + this.ms + ')';
    }

    public Time(long j6) {
        this.ms = j6;
        long j7 = 1000;
        this.us = j6 * j7;
        this.seconds = j6 / j7;
    }
}
