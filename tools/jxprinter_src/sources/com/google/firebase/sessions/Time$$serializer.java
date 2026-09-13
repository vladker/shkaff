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

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public /* synthetic */ class Time$$serializer implements O {
    public static final Time$$serializer INSTANCE;
    private static final r descriptor;

    static {
        Time$$serializer time$$serializer = new Time$$serializer();
        INSTANCE = time$$serializer;
        G0 g1 = new G0("com.google.firebase.sessions.Time", time$$serializer, 3);
        g1.addElement("ms", false);
        g1.addElement("us", true);
        g1.addElement("seconds", true);
        descriptor = g1;
    }

    private Time$$serializer() {
    }

    @Override // p084o4.O
    public final p060k4.b[] childSerializers() {
        C1318k0 c1318k0 = C1318k0.INSTANCE;
        return new p060k4.b[]{c1318k0, c1318k0, c1318k0};
    }

    @Override // p084o4.O, p060k4.b, p060k4.a
    public final Time deserialize(j decoder) {
        int i5;
        long jDecodeLongElement;
        long j6;
        long j7;
        E.f(decoder, "decoder");
        r rVar = descriptor;
        f fVarBeginStructure = decoder.beginStructure(rVar);
        if (fVarBeginStructure.decodeSequentially()) {
            long jDecodeLongElement2 = fVarBeginStructure.decodeLongElement(rVar, 0);
            long jDecodeLongElement3 = fVarBeginStructure.decodeLongElement(rVar, 1);
            jDecodeLongElement = fVarBeginStructure.decodeLongElement(rVar, 2);
            i5 = 7;
            j6 = jDecodeLongElement2;
            j7 = jDecodeLongElement3;
        } else {
            long jDecodeLongElement4 = 0;
            boolean z6 = true;
            int i6 = 0;
            long jDecodeLongElement5 = 0;
            long jDecodeLongElement6 = 0;
            while (z6) {
                int iDecodeElementIndex = fVarBeginStructure.decodeElementIndex(rVar);
                if (iDecodeElementIndex == -1) {
                    z6 = false;
                } else if (iDecodeElementIndex == 0) {
                    jDecodeLongElement5 = fVarBeginStructure.decodeLongElement(rVar, 0);
                    i6 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    jDecodeLongElement6 = fVarBeginStructure.decodeLongElement(rVar, 1);
                    i6 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        throw new t(iDecodeElementIndex);
                    }
                    jDecodeLongElement4 = fVarBeginStructure.decodeLongElement(rVar, 2);
                    i6 |= 4;
                }
            }
            i5 = i6;
            jDecodeLongElement = jDecodeLongElement4;
            j6 = jDecodeLongElement5;
            j7 = jDecodeLongElement6;
        }
        fVarBeginStructure.endStructure(rVar);
        return new Time(i5, j6, j7, jDecodeLongElement, null);
    }

    @Override // p084o4.O, p060k4.b, p060k4.m, p060k4.a
    public final r getDescriptor() {
        return descriptor;
    }

    @Override // p084o4.O, p060k4.b, p060k4.m
    public final void serialize(l encoder, Time value) {
        E.f(encoder, "encoder");
        E.f(value, "value");
        r rVar = descriptor;
        h hVarBeginStructure = encoder.beginStructure(rVar);
        Time.write$Self$com_google_firebase_firebase_sessions(value, hVarBeginStructure, rVar);
        hVarBeginStructure.endStructure(rVar);
    }

    @Override // p084o4.O
    public p060k4.b[] typeParametersSerializers() {
        return N.typeParametersSerializers(this);
    }
}
