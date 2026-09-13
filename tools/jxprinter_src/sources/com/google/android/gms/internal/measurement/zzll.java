package com.google.android.gms.internal.measurement;

import androidx.collection.a;
import java.io.IOException;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzll extends IOException {
    public zzll() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public zzll(long j6, long j7, int i5, Throwable th) {
        Locale locale = Locale.US;
        StringBuilder sbT = a.t("Pos: ", j6, ", limit: ");
        sbT.append(j7);
        sbT.append(", len: ");
        sbT.append(i5);
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(sbT.toString()), th);
    }

    public zzll(Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
    }
}
