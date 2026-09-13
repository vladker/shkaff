package kotlin.jvm.internal;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class F implements InterfaceC1111z, Serializable {
    private final int arity;

    public F(int i5) {
        this.arity = i5;
    }

    @Override // kotlin.jvm.internal.InterfaceC1111z
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String strRenderLambdaToString = U.renderLambdaToString(this);
        E.e(strRenderLambdaToString, "renderLambdaToString(...)");
        return strRenderLambdaToString;
    }
}
