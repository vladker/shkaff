package com.google.firebase.sessions;

import java.util.Map;
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
import p084o4.Q0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public /* synthetic */ class SessionData$$serializer implements O {
    public static final SessionData$$serializer INSTANCE;
    private static final r descriptor;

    static {
        SessionData$$serializer sessionData$$serializer = new SessionData$$serializer();
        INSTANCE = sessionData$$serializer;
        G0 g1 = new G0("com.google.firebase.sessions.SessionData", sessionData$$serializer, 3);
        g1.addElement("sessionDetails", false);
        g1.addElement("backgroundTime", true);
        g1.addElement("processDataMap", true);
        descriptor = g1;
    }

    private SessionData$$serializer() {
    }

    @Override // p084o4.O
    public final p060k4.b[] childSerializers() {
        return new p060k4.b[]{SessionDetails$$serializer.INSTANCE, p066l4.a.getNullable(Time$$serializer.INSTANCE), p066l4.a.getNullable(SessionData.$childSerializers[2])};
    }

    @Override // p084o4.O, p060k4.b, p060k4.a
    public final SessionData deserialize(j decoder) {
        int i5;
        SessionDetails sessionDetails;
        Time time;
        Map map;
        E.f(decoder, "decoder");
        r rVar = descriptor;
        f fVarBeginStructure = decoder.beginStructure(rVar);
        p060k4.b[] bVarArr = SessionData.$childSerializers;
        SessionDetails sessionDetails2 = null;
        if (fVarBeginStructure.decodeSequentially()) {
            SessionDetails sessionDetails3 = (SessionDetails) fVarBeginStructure.decodeSerializableElement(rVar, 0, SessionDetails$$serializer.INSTANCE, null);
            Time time2 = (Time) fVarBeginStructure.decodeNullableSerializableElement(rVar, 1, Time$$serializer.INSTANCE, null);
            map = (Map) fVarBeginStructure.decodeNullableSerializableElement(rVar, 2, bVarArr[2], null);
            sessionDetails = sessionDetails3;
            i5 = 7;
            time = time2;
        } else {
            boolean z6 = true;
            int i6 = 0;
            Time time3 = null;
            Map map2 = null;
            while (z6) {
                int iDecodeElementIndex = fVarBeginStructure.decodeElementIndex(rVar);
                if (iDecodeElementIndex == -1) {
                    z6 = false;
                } else if (iDecodeElementIndex == 0) {
                    sessionDetails2 = (SessionDetails) fVarBeginStructure.decodeSerializableElement(rVar, 0, SessionDetails$$serializer.INSTANCE, sessionDetails2);
                    i6 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    time3 = (Time) fVarBeginStructure.decodeNullableSerializableElement(rVar, 1, Time$$serializer.INSTANCE, time3);
                    i6 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        throw new t(iDecodeElementIndex);
                    }
                    map2 = (Map) fVarBeginStructure.decodeNullableSerializableElement(rVar, 2, bVarArr[2], map2);
                    i6 |= 4;
                }
            }
            i5 = i6;
            sessionDetails = sessionDetails2;
            time = time3;
            map = map2;
        }
        fVarBeginStructure.endStructure(rVar);
        return new SessionData(i5, sessionDetails, time, map, (Q0) null);
    }

    @Override // p084o4.O, p060k4.b, p060k4.m, p060k4.a
    public final r getDescriptor() {
        return descriptor;
    }

    @Override // p084o4.O, p060k4.b, p060k4.m
    public final void serialize(l encoder, SessionData value) {
        E.f(encoder, "encoder");
        E.f(value, "value");
        r rVar = descriptor;
        h hVarBeginStructure = encoder.beginStructure(rVar);
        SessionData.write$Self$com_google_firebase_firebase_sessions(value, hVarBeginStructure, rVar);
        hVarBeginStructure.endStructure(rVar);
    }

    @Override // p084o4.O
    public p060k4.b[] typeParametersSerializers() {
        return N.typeParametersSerializers(this);
    }
}
