package p147z3;

import I3.c;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import kotlin.jvm.internal.E;

/* JADX INFO: renamed from: z3.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1926f {
    public static void addSuppressed(Throwable th, Throwable exception) throws IllegalAccessException, InvocationTargetException {
        E.f(th, "<this>");
        E.f(exception, "exception");
        if (th != exception) {
            c.IMPLEMENTATIONS.addSuppressed(th, exception);
        }
    }

    public static final StackTraceElement[] getStackTrace(Throwable th) {
        E.f(th, "<this>");
        StackTraceElement[] stackTrace = th.getStackTrace();
        E.c(stackTrace);
        return stackTrace;
    }

    public static final List<Throwable> getSuppressedExceptions(Throwable th) {
        E.f(th, "<this>");
        return c.IMPLEMENTATIONS.getSuppressed(th);
    }

    private static final void printStackTrace(Throwable th) {
        E.f(th, "<this>");
        th.printStackTrace();
    }

    public static final String stackTraceToString(Throwable th) {
        E.f(th, "<this>");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        String string = stringWriter.toString();
        E.e(string, "toString(...)");
        return string;
    }

    private static final void printStackTrace(Throwable th, PrintWriter writer) {
        E.f(th, "<this>");
        E.f(writer, "writer");
        th.printStackTrace(writer);
    }

    private static final void printStackTrace(Throwable th, PrintStream stream) {
        E.f(th, "<this>");
        E.f(stream, "stream");
        th.printStackTrace(stream);
    }

    public static /* synthetic */ void getSuppressedExceptions$annotations(Throwable th) {
    }
}
