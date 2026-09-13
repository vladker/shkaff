package p084o4;

import A3.k0;
import U3.B;
import U3.n;
import androidx.collection.a;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.E;
import p060k4.b;
import p072m4.p;
import p072m4.r;
import p078n4.f;
import p078n4.h;
import p078n4.l;

/* JADX INFO: renamed from: o4.p0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1328p0 extends AbstractC1297a {
    private final b keySerializer;
    private final b valueSerializer;

    public AbstractC1328p0(b bVar, b bVar2) {
        this.keySerializer = bVar;
        this.valueSerializer = bVar2;
    }

    @Override // p084o4.AbstractC1297a, p060k4.b, p060k4.m, p060k4.a
    public abstract r getDescriptor();

    public final b getKeySerializer() {
        return this.keySerializer;
    }

    public final b getValueSerializer() {
        return this.valueSerializer;
    }

    public abstract void insertKeyValuePair(Map<Object, Object> map, int i5, Object obj, Object obj2);

    @Override // p084o4.AbstractC1297a, p060k4.b, p060k4.m
    public void serialize(l encoder, Object obj) {
        E.f(encoder, "encoder");
        int iD = d(obj);
        r descriptor = getDescriptor();
        h hVarBeginCollection = encoder.beginCollection(descriptor, iD);
        Iterator<Object> itCollectionIterator = collectionIterator(obj);
        int i5 = 0;
        while (itCollectionIterator.hasNext()) {
            Map.Entry entry = (Map.Entry) itCollectionIterator.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            int i6 = i5 + 1;
            hVarBeginCollection.encodeSerializableElement(getDescriptor(), i5, getKeySerializer(), key);
            i5 += 2;
            hVarBeginCollection.encodeSerializableElement(getDescriptor(), i6, getValueSerializer(), value);
        }
        hVarBeginCollection.endStructure(descriptor);
    }

    @Override // p084o4.AbstractC1297a
    public final void readAll(f decoder, Map<Object, Object> builder, int i5, int i6) {
        E.f(decoder, "decoder");
        E.f(builder, "builder");
        if (i6 < 0) {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL");
        }
        n nVarStep = B.step(B.until(0, i6 * 2), 2);
        int i7 = nVarStep.f732a;
        int i8 = nVarStep.b;
        int i9 = nVarStep.c;
        if ((i9 <= 0 || i7 > i8) && (i9 >= 0 || i8 > i7)) {
            return;
        }
        while (true) {
            readElement(decoder, i5 + i7, builder, false);
            if (i7 == i8) {
                return;
            } else {
                i7 += i9;
            }
        }
    }

    @Override // p084o4.AbstractC1297a
    public final void readElement(f decoder, int i5, Map<Object, Object> builder, boolean z6) {
        int iDecodeElementIndex;
        E.f(decoder, "decoder");
        E.f(builder, "builder");
        Object objDecodeSerializableElement = decoder.decodeSerializableElement(getDescriptor(), i5, this.keySerializer, null);
        if (z6) {
            iDecodeElementIndex = decoder.decodeElementIndex(getDescriptor());
            if (iDecodeElementIndex != i5 + 1) {
                throw new IllegalArgumentException(a.h(i5, iDecodeElementIndex, "Value must follow key in a map, index for key: ", ", returned index for value: ").toString());
            }
        } else {
            iDecodeElementIndex = i5 + 1;
        }
        builder.put(objDecodeSerializableElement, (!builder.containsKey(objDecodeSerializableElement) || (this.valueSerializer.getDescriptor().getKind() instanceof p)) ? decoder.decodeSerializableElement(getDescriptor(), iDecodeElementIndex, this.valueSerializer, null) : decoder.decodeSerializableElement(getDescriptor(), iDecodeElementIndex, this.valueSerializer, k0.getValue(builder, objDecodeSerializableElement)));
    }
}
