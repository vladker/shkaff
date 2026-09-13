package p084o4;

import java.util.Map;
import kotlin.jvm.internal.E;
import p060k4.b;
import p072m4.C;
import p072m4.r;
import p072m4.w;

/* JADX INFO: renamed from: o4.n0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1324n0 extends AbstractC1302c0 {
    private final r descriptor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1324n0(b keySerializer, b valueSerializer) {
        super(keySerializer, valueSerializer);
        E.f(keySerializer, "keySerializer");
        E.f(valueSerializer, "valueSerializer");
        this.descriptor = w.buildSerialDescriptor("kotlin.collections.Map.Entry", C.INSTANCE, new r[0], new C1320l0(keySerializer, valueSerializer, 0));
    }

    @Override // p084o4.AbstractC1302c0, p060k4.b, p060k4.m, p060k4.a
    public r getDescriptor() {
        return this.descriptor;
    }

    @Override // p084o4.AbstractC1302c0
    /* JADX INFO: renamed from: getKey, reason: merged with bridge method [inline-methods] */
    public Object a(Map.Entry<Object, Object> entry) {
        E.f(entry, "<this>");
        return entry.getKey();
    }

    @Override // p084o4.AbstractC1302c0
    /* JADX INFO: renamed from: getValue, reason: merged with bridge method [inline-methods] */
    public Object b(Map.Entry<Object, Object> entry) {
        E.f(entry, "<this>");
        return entry.getValue();
    }

    @Override // p084o4.AbstractC1302c0
    /* JADX INFO: renamed from: toResult, reason: merged with bridge method [inline-methods] */
    public Map.Entry<Object, Object> c(Object obj, Object obj2) {
        return new C1322m0(obj, obj2);
    }
}
