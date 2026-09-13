package retrofit2;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m0 f8130a;
    public static final C1612j b;
    static final Executor callbackExecutor;

    static {
        String property = System.getProperty("java.vm.name");
        property.getClass();
        if (property.equals("RoboVM")) {
            callbackExecutor = null;
            f8130a = new m0();
            b = new C1612j();
        } else if (property.equals("Dalvik")) {
            callbackExecutor = new ExecutorC1601a();
            f8130a = new k0();
            b = new C1611i();
        } else {
            callbackExecutor = null;
            f8130a = new l0();
            b = new C1611i();
        }
    }
}
