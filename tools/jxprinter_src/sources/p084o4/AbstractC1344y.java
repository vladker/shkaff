package p084o4;

import java.util.Iterator;
import kotlin.jvm.internal.E;
import p060k4.b;
import p072m4.r;
import p078n4.f;
import p078n4.h;
import p078n4.l;

/* JADX INFO: renamed from: o4.y, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1344y extends AbstractC1297a {
    private final b elementSerializer;

    public AbstractC1344y(b bVar) {
        this.elementSerializer = bVar;
    }

    public abstract void g(int i5, Object obj, Object obj2);

    @Override // p084o4.AbstractC1297a, p060k4.b, p060k4.m, p060k4.a
    public abstract r getDescriptor();

    @Override // p084o4.AbstractC1297a
    public final void readAll(f decoder, Object obj, int i5, int i6) {
        E.f(decoder, "decoder");
        if (i6 < 0) {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL");
        }
        for (int i7 = 0; i7 < i6; i7++) {
            readElement(decoder, i5 + i7, obj, false);
        }
    }

    @Override // p084o4.AbstractC1297a
    public void readElement(f decoder, int i5, Object obj, boolean z6) {
        E.f(decoder, "decoder");
        g(i5, obj, decoder.decodeSerializableElement(getDescriptor(), i5, this.elementSerializer, null));
    }

    @Override // p084o4.AbstractC1297a, p060k4.b, p060k4.m
    public void serialize(l encoder, Object obj) {
        E.f(encoder, "encoder");
        int iD = d(obj);
        r descriptor = getDescriptor();
        h hVarBeginCollection = encoder.beginCollection(descriptor, iD);
        Iterator<Object> itCollectionIterator = collectionIterator(obj);
        for (int i5 = 0; i5 < iD; i5++) {
            hVarBeginCollection.encodeSerializableElement(getDescriptor(), i5, this.elementSerializer, itCollectionIterator.next());
        }
        hVarBeginCollection.endStructure(descriptor);
    }
}
