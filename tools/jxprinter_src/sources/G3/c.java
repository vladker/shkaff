package G3;

import E3.q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements E3.g {
    public static final c INSTANCE = new c();

    @Override // E3.g
    public q getContext() {
        throw new IllegalStateException("This continuation is already complete");
    }

    @Override // E3.g
    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete");
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
