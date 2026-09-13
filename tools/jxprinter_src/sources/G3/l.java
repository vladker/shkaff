package G3;

import kotlin.jvm.internal.E;
import kotlin.jvm.internal.InterfaceC1111z;
import kotlin.jvm.internal.U;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l extends k implements InterfaceC1111z {
    private final int arity;

    public l(int i5, E3.g<Object> gVar) {
        super(gVar);
        this.arity = i5;
    }

    @Override // kotlin.jvm.internal.InterfaceC1111z
    public int getArity() {
        return this.arity;
    }

    @Override // G3.a
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String strRenderLambdaToString = U.renderLambdaToString(this);
        E.e(strRenderLambdaToString, "renderLambdaToString(...)");
        return strRenderLambdaToString;
    }
}
