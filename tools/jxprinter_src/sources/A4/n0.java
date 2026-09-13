package A4;

import X3.C0241g;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class n0 {
    public static final byte[] asUtf8ToByteArray(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        byte[] bytes = str.getBytes(C0241g.UTF_8);
        kotlin.jvm.internal.E.e(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static final ReentrantLock newLock() {
        return new ReentrantLock();
    }

    public static final String toUtf8String(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        return new String(bArr, C0241g.UTF_8);
    }

    public static final <T> T withLock(ReentrantLock reentrantLock, O3.a action) {
        kotlin.jvm.internal.E.f(reentrantLock, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        reentrantLock.lock();
        try {
            return (T) action.invoke();
        } finally {
            reentrantLock.unlock();
        }
    }
}
