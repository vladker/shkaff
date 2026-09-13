package F4;

import java.util.function.Function;
import org.apache.commons.io.function.IOFunction;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class d implements IOFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f273a;
    public final /* synthetic */ IOFunction b;
    public final /* synthetic */ Function c;

    public /* synthetic */ d(IOFunction iOFunction, Function function, int i5) {
        this.f273a = i5;
        this.b = iOFunction;
        this.c = function;
    }

    @Override // org.apache.commons.io.function.IOFunction
    public final Object apply(Object obj) {
        switch (this.f273a) {
            case 0:
                return this.b.lambda$compose$1(this.c, obj);
            default:
                return this.b.lambda$andThen$5(this.c, obj);
        }
    }
}
