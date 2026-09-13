package io.reactivex;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class A {
    public static final A b = new A(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f4169a;

    public A(Object obj) {
        this.f4169a = obj;
    }

    public static <T> A createOnComplete() {
        return b;
    }

    public static <T> A createOnError(Throwable th) {
        p039g3.A.b(th, "error is null");
        return new A(new p100r3.l(th));
    }

    public static <T> A createOnNext(T t6) {
        p039g3.A.b(t6, "value is null");
        return new A(t6);
    }

    public final boolean a() {
        Object obj = this.f4169a;
        return (obj == null || (obj instanceof p100r3.l)) ? false : true;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof A) {
            return p039g3.A.a(this.f4169a, ((A) obj).f4169a);
        }
        return false;
    }

    public Throwable getError() {
        Object obj = this.f4169a;
        if (obj instanceof p100r3.l) {
            return ((p100r3.l) obj).f7966a;
        }
        return null;
    }

    public Object getValue() {
        Object obj = this.f4169a;
        if (obj == null || (obj instanceof p100r3.l)) {
            return null;
        }
        return obj;
    }

    public final int hashCode() {
        Object obj = this.f4169a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final String toString() {
        Object obj = this.f4169a;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (obj instanceof p100r3.l) {
            return "OnErrorNotification[" + ((p100r3.l) obj).f7966a + "]";
        }
        return "OnNextNotification[" + obj + "]";
    }
}
