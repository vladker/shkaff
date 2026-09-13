package y5;

import retrofit2.r0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class g {
    private final Throwable error;
    private final r0<Object> response;

    private g(r0<Object> r0Var, Throwable th) {
        this.response = r0Var;
        this.error = th;
    }

    public static g a(Throwable th) {
        if (th != null) {
            return new g(null, th);
        }
        throw new NullPointerException("error == null");
    }

    public static g b(r0 r0Var) {
        if (r0Var != null) {
            return new g(r0Var, null);
        }
        throw new NullPointerException("response == null");
    }

    public Throwable error() {
        return this.error;
    }

    public r0<Object> response() {
        return this.response;
    }
}
