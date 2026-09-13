package p100r3;

import io.reactivex.I;
import t5.c;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f7968a;
    public static final /* synthetic */ n[] b;

    static {
        n nVar = new n("COMPLETE", 0);
        f7968a = nVar;
        b = new n[]{nVar};
    }

    public static boolean a(I i5, Object obj) {
        if (obj == f7968a) {
            i5.onComplete();
            return true;
        }
        if (obj instanceof l) {
            i5.onError(((l) obj).f7966a);
            return true;
        }
        if (obj instanceof k) {
            i5.onSubscribe(((k) obj).f7965a);
            return false;
        }
        i5.onNext(obj);
        return false;
    }

    public static boolean b(Object obj, c cVar) {
        if (obj == f7968a) {
            cVar.onComplete();
            return true;
        }
        if (obj instanceof l) {
            cVar.onError(((l) obj).f7966a);
            return true;
        }
        if (obj instanceof m) {
            cVar.onSubscribe(((m) obj).f7967a);
            return false;
        }
        cVar.onNext(obj);
        return false;
    }

    public static boolean c(Object obj) {
        return obj == f7968a;
    }

    public static n valueOf(String str) {
        return (n) Enum.valueOf(n.class, str);
    }

    public static n[] values() {
        return (n[]) b.clone();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "NotificationLite.Complete";
    }
}
