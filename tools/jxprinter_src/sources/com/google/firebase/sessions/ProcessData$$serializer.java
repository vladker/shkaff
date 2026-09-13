package com.google.firebase.sessions;

import kotlin.jvm.internal.E;
import p060k4.t;
import p072m4.r;
import p078n4.f;
import p078n4.h;
import p078n4.j;
import p078n4.l;
import p084o4.G0;
import p084o4.N;
import p084o4.O;
import p084o4.V0;
import p084o4.Z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public /* synthetic */ class ProcessData$$serializer implements O {
    public static final ProcessData$$serializer INSTANCE;
    private static final r descriptor;

    static {
        ProcessData$$serializer processData$$serializer = new ProcessData$$serializer();
        INSTANCE = processData$$serializer;
        G0 g1 = new G0("com.google.firebase.sessions.ProcessData", processData$$serializer, 2);
        g1.addElement("pid", false);
        g1.addElement("uuid", false);
        descriptor = g1;
    }

    private ProcessData$$serializer() {
    }

    @Override // p084o4.O
    public final p060k4.b[] childSerializers() {
        return new p060k4.b[]{Z.INSTANCE, V0.INSTANCE};
    }

    @Override // p084o4.O, p060k4.b, p060k4.a
    public final ProcessData deserialize(j decoder) {
        int iDecodeIntElement;
        String strDecodeStringElement;
        int i5;
        E.f(decoder, "decoder");
        r rVar = descriptor;
        f fVarBeginStructure = decoder.beginStructure(rVar);
        if (fVarBeginStructure.decodeSequentially()) {
            iDecodeIntElement = fVarBeginStructure.decodeIntElement(rVar, 0);
            strDecodeStringElement = fVarBeginStructure.decodeStringElement(rVar, 1);
            i5 = 3;
        } else {
            boolean z6 = true;
            iDecodeIntElement = 0;
            int i6 = 0;
            String strDecodeStringElement2 = null;
            while (z6) {
                int iDecodeElementIndex = fVarBeginStructure.decodeElementIndex(rVar);
                if (iDecodeElementIndex == -1) {
                    z6 = false;
                } else if (iDecodeElementIndex == 0) {
                    iDecodeIntElement = fVarBeginStructure.decodeIntElement(rVar, 0);
                    i6 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        throw new t(iDecodeElementIndex);
                    }
                    strDecodeStringElement2 = fVarBeginStructure.decodeStringElement(rVar, 1);
                    i6 |= 2;
                }
            }
            strDecodeStringElement = strDecodeStringElement2;
            i5 = i6;
        }
        fVarBeginStructure.endStructure(rVar);
        return new ProcessData(i5, iDecodeIntElement, strDecodeStringElement, null);
    }

    @Override // p084o4.O, p060k4.b, p060k4.m, p060k4.a
    public final r getDescriptor() {
        return descriptor;
    }

    @Override // p084o4.O, p060k4.b, p060k4.m
    public final void serialize(l encoder, ProcessData value) {
        E.f(encoder, "encoder");
        E.f(value, "value");
        r rVar = descriptor;
        h hVarBeginStructure = encoder.beginStructure(rVar);
        ProcessData.write$Self$com_google_firebase_firebase_sessions(value, hVarBeginStructure, rVar);
        hVarBeginStructure.endStructure(rVar);
    }

    @Override // p084o4.O
    public p060k4.b[] typeParametersSerializers() {
        return N.typeParametersSerializers(this);
    }
}
