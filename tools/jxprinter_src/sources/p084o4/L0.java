package p084o4;

import java.util.Iterator;
import kotlin.jvm.internal.E;
import p060k4.b;
import p072m4.r;
import p078n4.f;
import p078n4.h;
import p078n4.j;
import p078n4.l;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class L0 extends AbstractC1344y {
    private final r descriptor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L0(b primitiveSerializer) {
        super(primitiveSerializer);
        E.f(primitiveSerializer, "primitiveSerializer");
        this.descriptor = new K0(primitiveSerializer.getDescriptor());
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: builder, reason: merged with bridge method [inline-methods] */
    public final J0 a() {
        return (J0) e(h());
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: builderSize, reason: merged with bridge method [inline-methods] */
    public final int b(J0 j1) {
        E.f(j1, "<this>");
        return j1.d();
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: checkCapacity, reason: merged with bridge method [inline-methods] */
    public final void c(J0 j1, int i5) {
        E.f(j1, "<this>");
        j1.b(i5);
    }

    @Override // p084o4.AbstractC1297a
    public final Iterator<Object> collectionIterator(Object obj) {
        throw new IllegalStateException("This method lead to boxing and must not be used, use writeContents instead");
    }

    @Override // p084o4.AbstractC1297a, p060k4.b, p060k4.a
    public final Object deserialize(j decoder) {
        E.f(decoder, "decoder");
        return merge(decoder, null);
    }

    @Override // p084o4.AbstractC1344y, p084o4.AbstractC1297a, p060k4.b, p060k4.m, p060k4.a
    public final r getDescriptor() {
        return this.descriptor;
    }

    public abstract Object h();

    @Override // p084o4.AbstractC1344y
    /* JADX INFO: renamed from: insert, reason: merged with bridge method [inline-methods] */
    public final void g(J0 j1, int i5, Object obj) {
        E.f(j1, "<this>");
        throw new IllegalStateException("This method lead to boxing and must not be used, use Builder.append instead");
    }

    public abstract void readElement(f fVar, int i5, J0 j1, boolean z6);

    @Override // p084o4.AbstractC1344y, p084o4.AbstractC1297a, p060k4.b, p060k4.m
    public final void serialize(l encoder, Object obj) {
        E.f(encoder, "encoder");
        int iD = d(obj);
        r rVar = this.descriptor;
        h hVarBeginCollection = encoder.beginCollection(rVar, iD);
        writeContent(hVarBeginCollection, obj, iD);
        hVarBeginCollection.endStructure(rVar);
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: toResult, reason: merged with bridge method [inline-methods] */
    public final Object f(J0 j1) {
        E.f(j1, "<this>");
        return j1.a();
    }

    public abstract void writeContent(h hVar, Object obj, int i5);
}
