package p084o4;

import A3.AbstractC0157z;
import kotlin.jvm.internal.E;
import p060k4.b;
import p060k4.l;
import p072m4.r;
import p078n4.f;
import p078n4.h;
import p078n4.j;

/* JADX INFO: renamed from: o4.c0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1302c0 implements b {
    private final b keySerializer;
    private final b valueSerializer;

    public AbstractC1302c0(b bVar, b bVar2) {
        this.keySerializer = bVar;
        this.valueSerializer = bVar2;
    }

    public abstract Object a(Object obj);

    public abstract Object b(Object obj);

    public abstract Object c(Object obj, Object obj2);

    @Override // p060k4.b, p060k4.a
    public Object deserialize(j decoder) {
        Object objC;
        E.f(decoder, "decoder");
        r descriptor = getDescriptor();
        f fVarBeginStructure = decoder.beginStructure(descriptor);
        if (fVarBeginStructure.decodeSequentially()) {
            objC = c(fVarBeginStructure.decodeSerializableElement(getDescriptor(), 0, getKeySerializer(), null), fVarBeginStructure.decodeSerializableElement(getDescriptor(), 1, getValueSerializer(), null));
        } else {
            Object objDecodeSerializableElement = Z0.NULL;
            Object objDecodeSerializableElement2 = Z0.NULL;
            while (true) {
                int iDecodeElementIndex = fVarBeginStructure.decodeElementIndex(getDescriptor());
                if (iDecodeElementIndex == -1) {
                    if (objDecodeSerializableElement == Z0.NULL) {
                        throw new l("Element 'key' is missing");
                    }
                    if (objDecodeSerializableElement2 == Z0.NULL) {
                        throw new l("Element 'value' is missing");
                    }
                    objC = c(objDecodeSerializableElement, objDecodeSerializableElement2);
                    break;
                }
                if (iDecodeElementIndex == 0) {
                    objDecodeSerializableElement = fVarBeginStructure.decodeSerializableElement(getDescriptor(), 0, getKeySerializer(), null);
                } else {
                    if (iDecodeElementIndex != 1) {
                        throw new l(AbstractC0157z.k(iDecodeElementIndex, "Invalid index: "));
                    }
                    objDecodeSerializableElement2 = fVarBeginStructure.decodeSerializableElement(getDescriptor(), 1, getValueSerializer(), null);
                }
            }
        }
        fVarBeginStructure.endStructure(descriptor);
        return objC;
    }

    @Override // p060k4.b, p060k4.m, p060k4.a
    public abstract /* synthetic */ r getDescriptor();

    public final b getKeySerializer() {
        return this.keySerializer;
    }

    public final b getValueSerializer() {
        return this.valueSerializer;
    }

    @Override // p060k4.b, p060k4.m
    public void serialize(p078n4.l encoder, Object obj) {
        E.f(encoder, "encoder");
        h hVarBeginStructure = encoder.beginStructure(getDescriptor());
        hVarBeginStructure.encodeSerializableElement(getDescriptor(), 0, this.keySerializer, a(obj));
        hVarBeginStructure.encodeSerializableElement(getDescriptor(), 1, this.valueSerializer, b(obj));
        hVarBeginStructure.endStructure(getDescriptor());
    }
}
