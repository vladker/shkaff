package androidx.datastore.core;

import O3.p;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.F;
import p007a4.InterfaceC0304u;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class DataStoreImpl$writeActor$2 extends F implements p {
    public static final DataStoreImpl$writeActor$2 INSTANCE = new DataStoreImpl$writeActor$2();

    public DataStoreImpl$writeActor$2() {
        super(2);
    }

    @Override // O3.p
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Message.Update) obj, (Throwable) obj2);
        return Q.INSTANCE;
    }

    public final void invoke(Message.Update<T> msg, Throwable th) {
        E.f(msg, "msg");
        InterfaceC0304u ack = msg.getAck();
        if (th == null) {
            th = new CancellationException("DataStore scope was cancelled before updateData could complete");
        }
        ack.completeExceptionally(th);
    }
}
