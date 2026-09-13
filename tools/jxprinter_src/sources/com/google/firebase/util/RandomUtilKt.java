package com.google.firebase.util;

import A3.AbstractC0157z;
import A3.J;
import A3.T;
import A3.e0;
import S3.f;
import U3.B;
import U3.q;
import java.util.ArrayList;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class RandomUtilKt {
    private static final String ALPHANUMERIC_ALPHABET = "23456789abcdefghjkmnpqrstvwxyz";

    public static final String nextAlphanumericString(f fVar, int i5) {
        E.f(fVar, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "invalid length: ").toString());
        }
        q qVarUntil = B.until(0, i5);
        ArrayList arrayList = new ArrayList(J.collectionSizeOrDefault(qVarUntil, 10));
        e0 it = qVarUntil.iterator();
        while (it.hasNext()) {
            it.nextInt();
            arrayList.add(Character.valueOf(X3.e0.random(ALPHANUMERIC_ALPHABET, fVar)));
        }
        return T.g(arrayList, "", null, null, null, 62);
    }

    private static /* synthetic */ void getALPHANUMERIC_ALPHABET$annotations() {
    }
}
