package kotlin.jvm.internal;

import java.io.Serializable;

/* JADX INFO: renamed from: kotlin.jvm.internal.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1101o implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1101o f5704a = new C1101o();

    private Object readResolve() {
        return f5704a;
    }
}
