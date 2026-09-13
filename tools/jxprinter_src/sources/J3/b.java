package J3;

import A3.AbstractC0151t;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends I3.b {
    @Override // I3.b
    public void addSuppressed(Throwable cause, Throwable exception) throws IllegalAccessException, InvocationTargetException {
        E.f(cause, "cause");
        E.f(exception, "exception");
        Integer num = a.sdkVersion;
        if (num == null || num.intValue() >= 19) {
            cause.addSuppressed(exception);
        } else {
            super.addSuppressed(cause, exception);
        }
    }

    @Override // I3.b
    public List<Throwable> getSuppressed(Throwable exception) {
        E.f(exception, "exception");
        Integer num = a.sdkVersion;
        if (num != null && num.intValue() < 19) {
            return super.getSuppressed(exception);
        }
        Throwable[] suppressed = exception.getSuppressed();
        E.e(suppressed, "getSuppressed(...)");
        return AbstractC0151t.asList(suppressed);
    }
}
