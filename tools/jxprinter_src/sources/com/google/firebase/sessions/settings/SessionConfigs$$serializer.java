package com.google.firebase.sessions.settings;

import p060k4.b;
import p060k4.t;
import p066l4.a;
import p072m4.r;
import p078n4.f;
import p078n4.h;
import p078n4.j;
import p078n4.l;
import p084o4.C1313i;
import p084o4.C1318k0;
import p084o4.E;
import p084o4.G0;
import p084o4.N;
import p084o4.O;
import p084o4.Z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public /* synthetic */ class SessionConfigs$$serializer implements O {
    public static final SessionConfigs$$serializer INSTANCE;
    private static final r descriptor;

    static {
        SessionConfigs$$serializer sessionConfigs$$serializer = new SessionConfigs$$serializer();
        INSTANCE = sessionConfigs$$serializer;
        G0 g1 = new G0("com.google.firebase.sessions.settings.SessionConfigs", sessionConfigs$$serializer, 5);
        g1.addElement("sessionsEnabled", false);
        g1.addElement("sessionSamplingRate", false);
        g1.addElement("sessionTimeoutSeconds", false);
        g1.addElement("cacheDurationSeconds", false);
        g1.addElement("cacheUpdatedTimeSeconds", false);
        descriptor = g1;
    }

    private SessionConfigs$$serializer() {
    }

    @Override // p084o4.O
    public final b[] childSerializers() {
        b nullable = a.getNullable(C1313i.INSTANCE);
        b nullable2 = a.getNullable(E.INSTANCE);
        Z z6 = Z.INSTANCE;
        return new b[]{nullable, nullable2, a.getNullable(z6), a.getNullable(z6), a.getNullable(C1318k0.INSTANCE)};
    }

    @Override // p084o4.O, p060k4.b, p060k4.a
    public final SessionConfigs deserialize(j decoder) {
        int i5;
        Boolean bool;
        Double d;
        Integer num;
        Integer num2;
        Long l6;
        kotlin.jvm.internal.E.f(decoder, "decoder");
        r rVar = descriptor;
        f fVarBeginStructure = decoder.beginStructure(rVar);
        Boolean bool2 = null;
        if (fVarBeginStructure.decodeSequentially()) {
            Boolean bool3 = (Boolean) fVarBeginStructure.decodeNullableSerializableElement(rVar, 0, C1313i.INSTANCE, null);
            Double d6 = (Double) fVarBeginStructure.decodeNullableSerializableElement(rVar, 1, E.INSTANCE, null);
            Z z6 = Z.INSTANCE;
            Integer num3 = (Integer) fVarBeginStructure.decodeNullableSerializableElement(rVar, 2, z6, null);
            bool = bool3;
            num2 = (Integer) fVarBeginStructure.decodeNullableSerializableElement(rVar, 3, z6, null);
            l6 = (Long) fVarBeginStructure.decodeNullableSerializableElement(rVar, 4, C1318k0.INSTANCE, null);
            num = num3;
            d = d6;
            i5 = 31;
        } else {
            boolean z7 = true;
            int i6 = 0;
            Double d7 = null;
            Integer num4 = null;
            Integer num5 = null;
            Long l7 = null;
            while (z7) {
                int iDecodeElementIndex = fVarBeginStructure.decodeElementIndex(rVar);
                if (iDecodeElementIndex == -1) {
                    z7 = false;
                } else if (iDecodeElementIndex == 0) {
                    bool2 = (Boolean) fVarBeginStructure.decodeNullableSerializableElement(rVar, 0, C1313i.INSTANCE, bool2);
                    i6 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    d7 = (Double) fVarBeginStructure.decodeNullableSerializableElement(rVar, 1, E.INSTANCE, d7);
                    i6 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    num4 = (Integer) fVarBeginStructure.decodeNullableSerializableElement(rVar, 2, Z.INSTANCE, num4);
                    i6 |= 4;
                } else if (iDecodeElementIndex == 3) {
                    num5 = (Integer) fVarBeginStructure.decodeNullableSerializableElement(rVar, 3, Z.INSTANCE, num5);
                    i6 |= 8;
                } else {
                    if (iDecodeElementIndex != 4) {
                        throw new t(iDecodeElementIndex);
                    }
                    l7 = (Long) fVarBeginStructure.decodeNullableSerializableElement(rVar, 4, C1318k0.INSTANCE, l7);
                    i6 |= 16;
                }
            }
            i5 = i6;
            bool = bool2;
            d = d7;
            num = num4;
            num2 = num5;
            l6 = l7;
        }
        fVarBeginStructure.endStructure(rVar);
        return new SessionConfigs(i5, bool, d, num, num2, l6, null);
    }

    @Override // p084o4.O, p060k4.b, p060k4.m, p060k4.a
    public final r getDescriptor() {
        return descriptor;
    }

    @Override // p084o4.O, p060k4.b, p060k4.m
    public final void serialize(l encoder, SessionConfigs value) {
        kotlin.jvm.internal.E.f(encoder, "encoder");
        kotlin.jvm.internal.E.f(value, "value");
        r rVar = descriptor;
        h hVarBeginStructure = encoder.beginStructure(rVar);
        SessionConfigs.write$Self$com_google_firebase_firebase_sessions(value, hVarBeginStructure, rVar);
        hVarBeginStructure.endStructure(rVar);
    }

    @Override // p084o4.O
    public b[] typeParametersSerializers() {
        return N.typeParametersSerializers(this);
    }
}
