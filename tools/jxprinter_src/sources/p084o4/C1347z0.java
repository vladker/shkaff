package p084o4;

import kotlin.jvm.internal.E;
import p060k4.b;
import p072m4.r;
import p072m4.w;
import p147z3.A;
import p147z3.C1938s;

/* JADX INFO: renamed from: o4.z0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1347z0 extends AbstractC1302c0 {
    private final r descriptor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1347z0(b keySerializer, b valueSerializer) {
        super(keySerializer, valueSerializer);
        E.f(keySerializer, "keySerializer");
        E.f(valueSerializer, "valueSerializer");
        this.descriptor = w.buildClassSerialDescriptor("kotlin.Pair", new r[0], new C1320l0(keySerializer, valueSerializer, 1));
    }

    @Override // p084o4.AbstractC1302c0, p060k4.b, p060k4.m, p060k4.a
    public r getDescriptor() {
        return this.descriptor;
    }

    @Override // p084o4.AbstractC1302c0
    /* JADX INFO: renamed from: getKey, reason: merged with bridge method [inline-methods] */
    public Object a(C1938s c1938s) {
        E.f(c1938s, "<this>");
        return c1938s.f9134a;
    }

    @Override // p084o4.AbstractC1302c0
    /* JADX INFO: renamed from: getValue, reason: merged with bridge method [inline-methods] */
    public Object b(C1938s c1938s) {
        E.f(c1938s, "<this>");
        return c1938s.b;
    }

    @Override // p084o4.AbstractC1302c0
    /* JADX INFO: renamed from: toResult, reason: merged with bridge method [inline-methods] */
    public C1938s c(Object obj, Object obj2) {
        return A.to(obj, obj2);
    }
}
