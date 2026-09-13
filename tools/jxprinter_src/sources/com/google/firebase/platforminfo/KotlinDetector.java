package com.google.firebase.platforminfo;

import androidx.annotation.Nullable;
import p147z3.C1932l;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class KotlinDetector {
    private KotlinDetector() {
    }

    @Nullable
    public static String detectVersion() {
        try {
            return C1932l.CURRENT.toString();
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }
}
