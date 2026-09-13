package F4;

import java.util.function.Consumer;
import org.apache.commons.io.function.IOConsumer;
import org.apache.commons.io.function.IOFunction;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements IOConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f270a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ a(Object obj, Object obj2, int i5) {
        this.f270a = i5;
        this.b = obj;
        this.c = obj2;
    }

    @Override // org.apache.commons.io.function.IOConsumer
    public final void accept(Object obj) {
        switch (this.f270a) {
            case 0:
                ((IOConsumer) this.b).lambda$andThen$1((IOConsumer) this.c, obj);
                break;
            case 1:
                ((IOFunction) this.c).lambda$andThen$6((IOConsumer) this.b, obj);
                break;
            default:
                ((IOFunction) this.b).lambda$andThen$7((Consumer) this.c, obj);
                break;
        }
    }

    public /* synthetic */ a(IOFunction iOFunction, IOConsumer iOConsumer) {
        this.f270a = 1;
        this.c = iOFunction;
        this.b = iOConsumer;
    }
}
