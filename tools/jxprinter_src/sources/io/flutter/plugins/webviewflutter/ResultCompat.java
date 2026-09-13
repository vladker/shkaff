package io.flutter.plugins.webviewflutter;

import kotlin.jvm.internal.AbstractC1107v;
import kotlin.jvm.internal.Y;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class ResultCompat<T> {
    public static final Companion Companion = new Companion(null);
    private final Throwable exception;
    private final boolean isFailure;
    private final boolean isSuccess;
    private final Object result;
    private final T value;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1107v abstractC1107v) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Q asCompatCallback$lambda$0(O3.l lVar, p147z3.u uVar) {
            lVar.invoke(new ResultCompat(uVar.b()));
            return Q.INSTANCE;
        }

        public final <T> O3.l asCompatCallback(O3.l result) {
            kotlin.jvm.internal.E.f(result, "result");
            return new k(result, 2);
        }

        public final <T> void success(T t6, Object callback) {
            kotlin.jvm.internal.E.f(callback, "callback");
            Y.c(1, callback);
            ((O3.l) callback).invoke(p147z3.u.a(p147z3.u.m1361constructorimpl(t6)));
        }

        private Companion() {
        }
    }

    public ResultCompat(Object obj) {
        this.result = obj;
        this.value = obj instanceof z3.u.a ? null : (T) obj;
        this.exception = p147z3.u.m1362exceptionOrNullimpl(obj);
        this.isSuccess = !(obj instanceof z3.u.a);
        this.isFailure = obj instanceof z3.u.a;
    }

    public static final <T> O3.l asCompatCallback(O3.l lVar) {
        return Companion.asCompatCallback(lVar);
    }

    public static final <T> void success(T t6, Object obj) {
        Companion.success(t6, obj);
    }

    public final Throwable exceptionOrNull() {
        return this.exception;
    }

    public final T getOrNull() {
        return this.value;
    }

    /* JADX INFO: renamed from: getResult-d1pmJ48, reason: not valid java name */
    public final Object m1038getResultd1pmJ48() {
        return this.result;
    }

    public final boolean isFailure() {
        return this.isFailure;
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }
}
