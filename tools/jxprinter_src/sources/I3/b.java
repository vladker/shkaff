package I3;

import A3.AbstractC0151t;
import A3.I;
import S3.f;
import X3.C0254u;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.MatchResult;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public void addSuppressed(Throwable cause, Throwable exception) throws IllegalAccessException, InvocationTargetException {
        E.f(cause, "cause");
        E.f(exception, "exception");
        Method method = a.addSuppressed;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }

    public f defaultPlatformRandom() {
        return new S3.c();
    }

    public C0254u getMatchResultNamedGroup(MatchResult matchResult, String name) {
        E.f(matchResult, "matchResult");
        E.f(name, "name");
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }

    public List<Throwable> getSuppressed(Throwable exception) {
        Object objInvoke;
        List<Throwable> listAsList;
        E.f(exception, "exception");
        Method method = a.getSuppressed;
        return (method == null || (objInvoke = method.invoke(exception, null)) == null || (listAsList = AbstractC0151t.asList((Throwable[]) objInvoke)) == null) ? I.emptyList() : listAsList;
    }
}
