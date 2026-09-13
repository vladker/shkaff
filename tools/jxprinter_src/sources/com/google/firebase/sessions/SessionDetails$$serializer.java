package com.google.firebase.sessions;

import kotlin.jvm.internal.E;
import p060k4.t;
import p072m4.r;
import p078n4.f;
import p078n4.h;
import p078n4.j;
import p078n4.l;
import p084o4.C1318k0;
import p084o4.G0;
import p084o4.N;
import p084o4.O;
import p084o4.V0;
import p084o4.Z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public /* synthetic */ class SessionDetails$$serializer implements O {
    public static final SessionDetails$$serializer INSTANCE;
    private static final r descriptor;

    static {
        SessionDetails$$serializer sessionDetails$$serializer = new SessionDetails$$serializer();
        INSTANCE = sessionDetails$$serializer;
        G0 g1 = new G0("com.google.firebase.sessions.SessionDetails", sessionDetails$$serializer, 4);
        g1.addElement("sessionId", false);
        g1.addElement("firstSessionId", false);
        g1.addElement("sessionIndex", false);
        g1.addElement("sessionStartTimestampUs", false);
        descriptor = g1;
    }

    private SessionDetails$$serializer() {
    }

    @Override // p084o4.O
    public final p060k4.b[] childSerializers() {
        V0 v6 = V0.INSTANCE;
        return new p060k4.b[]{v6, v6, Z.INSTANCE, C1318k0.INSTANCE};
    }

    @Override // p084o4.O, p060k4.b, p060k4.a
    public final SessionDetails deserialize(j decoder) {
        String strDecodeStringElement;
        int i5;
        int iDecodeIntElement;
        String str;
        long jDecodeLongElement;
        E.f(decoder, "decoder");
        r rVar = descriptor;
        f fVarBeginStructure = decoder.beginStructure(rVar);
        if (fVarBeginStructure.decodeSequentially()) {
            strDecodeStringElement = fVarBeginStructure.decodeStringElement(rVar, 0);
            String strDecodeStringElement2 = fVarBeginStructure.decodeStringElement(rVar, 1);
            i5 = 15;
            iDecodeIntElement = fVarBeginStructure.decodeIntElement(rVar, 2);
            str = strDecodeStringElement2;
            jDecodeLongElement = fVarBeginStructure.decodeLongElement(rVar, 3);
        } else {
            strDecodeStringElement = null;
            String strDecodeStringElement3 = null;
            boolean z6 = true;
            long jDecodeLongElement2 = 0;
            int i6 = 0;
            int iDecodeIntElement2 = 0;
            while (z6) {
                int iDecodeElementIndex = fVarBeginStructure.decodeElementIndex(rVar);
                if (iDecodeElementIndex == -1) {
                    z6 = false;
                } else if (iDecodeElementIndex == 0) {
                    strDecodeStringElement = fVarBeginStructure.decodeStringElement(rVar, 0);
                    i6 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    strDecodeStringElement3 = fVarBeginStructure.decodeStringElement(rVar, 1);
                    i6 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    iDecodeIntElement2 = fVarBeginStructure.decodeIntElement(rVar, 2);
                    i6 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        throw new t(iDecodeElementIndex);
                    }
                    jDecodeLongElement2 = fVarBeginStructure.decodeLongElement(rVar, 3);
                    i6 |= 8;
                }
            }
            i5 = i6;
            iDecodeIntElement = iDecodeIntElement2;
            str = strDecodeStringElement3;
            jDecodeLongElement = jDecodeLongElement2;
        }
        String str2 = strDecodeStringElement;
        fVarBeginStructure.endStructure(rVar);
        return new SessionDetails(i5, str2, str, iDecodeIntElement, jDecodeLongElement, null);
    }

    @Override // p084o4.O, p060k4.b, p060k4.m, p060k4.a
    public final r getDescriptor() {
        return descriptor;
    }

    @Override // p084o4.O, p060k4.b, p060k4.m
    public final void serialize(l encoder, SessionDetails value) {
        E.f(encoder, "encoder");
        E.f(value, "value");
        r rVar = descriptor;
        h hVarBeginStructure = encoder.beginStructure(rVar);
        SessionDetails.write$Self$com_google_firebase_firebase_sessions(value, hVarBeginStructure, rVar);
        hVarBeginStructure.endStructure(rVar);
    }

    @Override // p084o4.O
    public p060k4.b[] typeParametersSerializers() {
        return N.typeParametersSerializers(this);
    }
}
