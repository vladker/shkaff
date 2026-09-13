package p007a4;

import p028e4.I;
import p028e4.x;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class U {
    private static final Y DefaultDelay;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Y y6;
        if (I.systemProp("kotlinx.coroutines.main.delay", false)) {
            AbstractC0265b1 main = C0276f0.getMain();
            y6 = (x.isMissing(main) || !(main instanceof Y)) ? T.INSTANCE : (Y) main;
        } else {
            y6 = T.INSTANCE;
        }
        DefaultDelay = y6;
    }

    public static final Y getDefaultDelay() {
        return DefaultDelay;
    }

    public static /* synthetic */ void getDefaultDelay$annotations() {
    }
}
