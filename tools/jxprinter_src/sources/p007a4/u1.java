package p007a4;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class u1 extends CancellationException implements C {
    public final transient H0 coroutine;

    public u1(String str, H0 h1) {
        super(str);
        this.coroutine = h1;
    }

    @Override // p007a4.C
    public u1 createCopy() {
        String message = getMessage();
        if (message == null) {
            message = "";
        }
        u1 u1Var = new u1(message, this.coroutine);
        u1Var.initCause(this);
        return u1Var;
    }

    public u1(String str) {
        this(str, null);
    }
}
