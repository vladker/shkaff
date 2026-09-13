package p084o4;

import A3.AbstractC0157z;
import A3.C0130a;
import A3.I;
import kotlin.jvm.internal.E;
import p060k4.b;
import p060k4.l;
import p072m4.C1241a;
import p072m4.r;
import p072m4.w;
import p078n4.f;
import p078n4.h;
import p078n4.j;
import p147z3.Q;
import p147z3.z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Y0 implements b {
    private final b aSerializer;
    private final b bSerializer;
    private final b cSerializer;
    private final r descriptor;

    public Y0(b aSerializer, b bSerializer, b cSerializer) {
        E.f(aSerializer, "aSerializer");
        E.f(bSerializer, "bSerializer");
        E.f(cSerializer, "cSerializer");
        this.aSerializer = aSerializer;
        this.bSerializer = bSerializer;
        this.cSerializer = cSerializer;
        this.descriptor = w.buildClassSerialDescriptor("kotlin.Triple", new r[0], new C0130a(this, 20));
    }

    public static Q a(Y0 y6, C1241a buildClassSerialDescriptor) {
        E.f(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
        buildClassSerialDescriptor.element("first", y6.aSerializer.getDescriptor(), I.emptyList(), false);
        buildClassSerialDescriptor.element("second", y6.bSerializer.getDescriptor(), I.emptyList(), false);
        buildClassSerialDescriptor.element("third", y6.cSerializer.getDescriptor(), I.emptyList(), false);
        return Q.INSTANCE;
    }

    @Override // p060k4.b, p060k4.m, p060k4.a
    public r getDescriptor() {
        return this.descriptor;
    }

    @Override // p060k4.b, p060k4.a
    public z deserialize(j decoder) {
        E.f(decoder, "decoder");
        f fVarBeginStructure = decoder.beginStructure(getDescriptor());
        if (fVarBeginStructure.decodeSequentially()) {
            Object objDecodeSerializableElement = fVarBeginStructure.decodeSerializableElement(getDescriptor(), 0, this.aSerializer, null);
            Object objDecodeSerializableElement2 = fVarBeginStructure.decodeSerializableElement(getDescriptor(), 1, this.bSerializer, null);
            Object objDecodeSerializableElement3 = fVarBeginStructure.decodeSerializableElement(getDescriptor(), 2, this.cSerializer, null);
            fVarBeginStructure.endStructure(getDescriptor());
            return new z(objDecodeSerializableElement, objDecodeSerializableElement2, objDecodeSerializableElement3);
        }
        Object objDecodeSerializableElement4 = Z0.NULL;
        Object objDecodeSerializableElement5 = Z0.NULL;
        Object objDecodeSerializableElement6 = Z0.NULL;
        while (true) {
            int iDecodeElementIndex = fVarBeginStructure.decodeElementIndex(getDescriptor());
            if (iDecodeElementIndex == -1) {
                fVarBeginStructure.endStructure(getDescriptor());
                if (objDecodeSerializableElement4 == Z0.NULL) {
                    throw new l("Element 'first' is missing");
                }
                if (objDecodeSerializableElement5 == Z0.NULL) {
                    throw new l("Element 'second' is missing");
                }
                if (objDecodeSerializableElement6 != Z0.NULL) {
                    return new z(objDecodeSerializableElement4, objDecodeSerializableElement5, objDecodeSerializableElement6);
                }
                throw new l("Element 'third' is missing");
            }
            if (iDecodeElementIndex == 0) {
                objDecodeSerializableElement4 = fVarBeginStructure.decodeSerializableElement(getDescriptor(), 0, this.aSerializer, null);
            } else if (iDecodeElementIndex == 1) {
                objDecodeSerializableElement5 = fVarBeginStructure.decodeSerializableElement(getDescriptor(), 1, this.bSerializer, null);
            } else {
                if (iDecodeElementIndex != 2) {
                    throw new l(AbstractC0157z.k(iDecodeElementIndex, "Unexpected index "));
                }
                objDecodeSerializableElement6 = fVarBeginStructure.decodeSerializableElement(getDescriptor(), 2, this.cSerializer, null);
            }
        }
    }

    @Override // p060k4.b, p060k4.m
    public void serialize(p078n4.l encoder, z value) {
        E.f(encoder, "encoder");
        E.f(value, "value");
        h hVarBeginStructure = encoder.beginStructure(getDescriptor());
        hVarBeginStructure.encodeSerializableElement(getDescriptor(), 0, this.aSerializer, value.f9136a);
        hVarBeginStructure.encodeSerializableElement(getDescriptor(), 1, this.bSerializer, value.b);
        hVarBeginStructure.encodeSerializableElement(getDescriptor(), 2, this.cSerializer, value.c);
        hVarBeginStructure.endStructure(getDescriptor());
    }
}
