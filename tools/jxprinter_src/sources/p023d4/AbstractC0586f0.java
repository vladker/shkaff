package p023d4;

import O3.l;
import S2.m;
import W3.B;
import kotlinx.coroutines.flow.internal.z;
import p007a4.AbstractC0261a0;
import p007a4.M;
import p018c4.B0;
import p018c4.v0;

/* JADX INFO: renamed from: d4.f0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class AbstractC0586f0 {
    public static final <T> InterfaceC0612o debounce(InterfaceC0612o interfaceC0612o, long j6) {
        if (j6 >= 0) {
            return j6 == 0 ? interfaceC0612o : z.scopedFlow(new Z(new U(j6, 0), interfaceC0612o, null));
        }
        throw new IllegalArgumentException("Debounce timeout should not be negative");
    }

    /* JADX INFO: renamed from: debounce-HG0u8IE, reason: not valid java name */
    public static final <T> InterfaceC0612o m1023debounceHG0u8IE(InterfaceC0612o interfaceC0612o, long j6) {
        return AbstractC0618q.debounce(interfaceC0612o, AbstractC0261a0.a(j6));
    }

    public static final <T> InterfaceC0612o debounceDuration(InterfaceC0612o interfaceC0612o, l lVar) {
        return z.scopedFlow(new Z(new B(1, lVar), interfaceC0612o, null));
    }

    public static final B0 fixedPeriodTicker(M m6, long j6) {
        return v0.a(m6, 0, new m(j6, null), 1);
    }

    public static final <T> InterfaceC0612o sample(InterfaceC0612o interfaceC0612o, long j6) {
        if (j6 > 0) {
            return z.scopedFlow(new C0574b0(j6, interfaceC0612o, null));
        }
        throw new IllegalArgumentException("Sample period should be positive");
    }

    /* JADX INFO: renamed from: sample-HG0u8IE, reason: not valid java name */
    public static final <T> InterfaceC0612o m1024sampleHG0u8IE(InterfaceC0612o interfaceC0612o, long j6) {
        return AbstractC0618q.sample(interfaceC0612o, AbstractC0261a0.a(j6));
    }

    /* JADX INFO: renamed from: timeout-HG0u8IE, reason: not valid java name */
    public static final <T> InterfaceC0612o m1025timeoutHG0u8IE(InterfaceC0612o interfaceC0612o, long j6) {
        return z.scopedFlow(new C0583e0(j6, interfaceC0612o, null));
    }

    public static final <T> InterfaceC0612o debounce(InterfaceC0612o interfaceC0612o, l lVar) {
        return z.scopedFlow(new Z(lVar, interfaceC0612o, null));
    }
}
