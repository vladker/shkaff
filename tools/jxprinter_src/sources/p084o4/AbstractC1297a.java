package p084o4;

import java.util.Iterator;
import kotlin.jvm.internal.E;
import p060k4.b;
import p072m4.r;
import p078n4.f;
import p078n4.j;
import p078n4.l;

/* JADX INFO: renamed from: o4.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1297a implements b {
    public abstract Object a();

    public abstract int b(Object obj);

    public abstract void c(int i5, Object obj);

    public abstract Iterator<Object> collectionIterator(Object obj);

    public abstract int d(Object obj);

    @Override // p060k4.b, p060k4.a
    public Object deserialize(j decoder) {
        E.f(decoder, "decoder");
        return merge(decoder, null);
    }

    public abstract Object e(Object obj);

    public abstract Object f(Object obj);

    @Override // p060k4.b, p060k4.m, p060k4.a
    public abstract /* synthetic */ r getDescriptor();

    public final Object merge(j decoder, Object obj) {
        Object objA;
        E.f(decoder, "decoder");
        if (obj == null || (objA = e(obj)) == null) {
            objA = a();
        }
        int iB = b(objA);
        f fVarBeginStructure = decoder.beginStructure(getDescriptor());
        if (!fVarBeginStructure.decodeSequentially()) {
            while (true) {
                int iDecodeElementIndex = fVarBeginStructure.decodeElementIndex(getDescriptor());
                if (iDecodeElementIndex == -1) {
                    break;
                }
                readElement(fVarBeginStructure, iDecodeElementIndex + iB, objA, true);
            }
        } else {
            int iDecodeCollectionSize = fVarBeginStructure.decodeCollectionSize(getDescriptor());
            c(iDecodeCollectionSize, objA);
            readAll(fVarBeginStructure, objA, iB, iDecodeCollectionSize);
        }
        fVarBeginStructure.endStructure(getDescriptor());
        return f(objA);
    }

    public abstract void readAll(f fVar, Object obj, int i5, int i6);

    public abstract void readElement(f fVar, int i5, Object obj, boolean z6);

    @Override // p060k4.b, p060k4.m
    public abstract void serialize(l lVar, Object obj);
}
