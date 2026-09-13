package p007a4;

import g4.e;
import g4.f;
import p028e4.w;

/* JADX INFO: renamed from: a4.f0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0276f0 {
    public static final C0276f0 INSTANCE = new C0276f0();
    private static final F Default = f.INSTANCE;
    private static final F Unconfined = y1.INSTANCE;

    public static final F getDefault() {
        return Default;
    }

    public static final F getIO() {
        return e.INSTANCE;
    }

    public static final AbstractC0265b1 getMain() {
        return w.dispatcher;
    }

    public static final F getUnconfined() {
        return Unconfined;
    }

    public final void shutdown() {
        T.INSTANCE.shutdown();
        f.INSTANCE.a();
    }

    public static /* synthetic */ void getDefault$annotations() {
    }

    public static /* synthetic */ void getIO$annotations() {
    }

    public static /* synthetic */ void getMain$annotations() {
    }

    public static /* synthetic */ void getUnconfined$annotations() {
    }
}
