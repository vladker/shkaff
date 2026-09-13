package F4;

import org.apache.commons.io.function.IOFunction;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class c implements IOFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f272a;
    public final /* synthetic */ IOFunction b;
    public final /* synthetic */ IOFunction c;

    public /* synthetic */ c(IOFunction iOFunction, IOFunction iOFunction2, int i5) {
        this.f272a = i5;
        this.b = iOFunction;
        this.c = iOFunction2;
    }

    @Override // org.apache.commons.io.function.IOFunction
    public final Object apply(Object obj) {
        switch (this.f272a) {
            case 0:
                return this.b.lambda$andThen$4(this.c, obj);
            default:
                return this.b.lambda$compose$0(this.c, obj);
        }
    }
}
