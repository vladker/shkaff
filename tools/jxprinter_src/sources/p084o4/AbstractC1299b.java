package p084o4;

import A3.AbstractC0157z;
import V3.c;
import kotlin.jvm.internal.E;
import p060k4.a;
import p060k4.b;
import p060k4.l;
import p060k4.m;
import p072m4.r;
import p078n4.f;
import p078n4.h;
import p078n4.j;

/* JADX INFO: renamed from: o4.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1299b implements b {
    @Override // p060k4.b, p060k4.a
    public final Object deserialize(j decoder) {
        Object objDecodeSerializableElement;
        E.f(decoder, "decoder");
        r descriptor = getDescriptor();
        f fVarBeginStructure = decoder.beginStructure(descriptor);
        if (!fVarBeginStructure.decodeSequentially()) {
            objDecodeSerializableElement = null;
            String strDecodeStringElement = null;
            while (true) {
                int iDecodeElementIndex = fVarBeginStructure.decodeElementIndex(getDescriptor());
                if (iDecodeElementIndex == -1) {
                    if (objDecodeSerializableElement != null) {
                        break;
                    }
                    throw new IllegalArgumentException(AbstractC0157z.n("Polymorphic value has not been read for class ", strDecodeStringElement).toString());
                }
                if (iDecodeElementIndex == 0) {
                    strDecodeStringElement = fVarBeginStructure.decodeStringElement(getDescriptor(), iDecodeElementIndex);
                } else {
                    if (iDecodeElementIndex != 1) {
                        StringBuilder sb = new StringBuilder("Invalid index in polymorphic deserialization of ");
                        if (strDecodeStringElement == null) {
                            strDecodeStringElement = "unknown class";
                        }
                        sb.append(strDecodeStringElement);
                        sb.append("\n Expected 0, 1 or DECODE_DONE(-1), but found ");
                        sb.append(iDecodeElementIndex);
                        throw new l(sb.toString());
                    }
                    if (strDecodeStringElement == null) {
                        throw new IllegalArgumentException("Cannot read polymorphic value before its type token");
                    }
                    objDecodeSerializableElement = fVarBeginStructure.decodeSerializableElement(getDescriptor(), iDecodeElementIndex, p060k4.f.findPolymorphicSerializer(this, fVarBeginStructure, strDecodeStringElement), null);
                }
            }
        } else {
            objDecodeSerializableElement = fVarBeginStructure.decodeSerializableElement(getDescriptor(), 1, p060k4.f.findPolymorphicSerializer(this, fVarBeginStructure, fVarBeginStructure.decodeStringElement(getDescriptor(), 0)), null);
        }
        fVarBeginStructure.endStructure(descriptor);
        return objDecodeSerializableElement;
    }

    public a findPolymorphicSerializerOrNull(f decoder, String str) {
        E.f(decoder, "decoder");
        return decoder.getSerializersModule().getPolymorphic(getBaseClass(), str);
    }

    public abstract c getBaseClass();

    @Override // p060k4.b, p060k4.m, p060k4.a
    public abstract /* synthetic */ r getDescriptor();

    @Override // p060k4.b, p060k4.m
    public final void serialize(p078n4.l encoder, Object value) {
        E.f(encoder, "encoder");
        E.f(value, "value");
        m mVarFindPolymorphicSerializer = p060k4.f.findPolymorphicSerializer(this, encoder, value);
        r descriptor = getDescriptor();
        h hVarBeginStructure = encoder.beginStructure(descriptor);
        hVarBeginStructure.encodeStringElement(getDescriptor(), 0, mVarFindPolymorphicSerializer.getDescriptor().getSerialName());
        hVarBeginStructure.encodeSerializableElement(getDescriptor(), 1, mVarFindPolymorphicSerializer, value);
        hVarBeginStructure.endStructure(descriptor);
    }

    public m findPolymorphicSerializerOrNull(p078n4.l encoder, Object value) {
        E.f(encoder, "encoder");
        E.f(value, "value");
        return encoder.getSerializersModule().getPolymorphic(getBaseClass(), value);
    }
}
