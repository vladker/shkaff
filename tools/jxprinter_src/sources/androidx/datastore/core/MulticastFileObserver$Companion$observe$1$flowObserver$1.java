package androidx.datastore.core;

import O3.l;
import java.io.File;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.F;
import p018c4.x0;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class MulticastFileObserver$Companion$observe$1$flowObserver$1 extends F implements l {
    final /* synthetic */ x0 $$this$channelFlow;
    final /* synthetic */ File $file;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MulticastFileObserver$Companion$observe$1$flowObserver$1(File file, x0 x0Var) {
        super(1);
        this.$file = file;
        this.$$this$channelFlow = x0Var;
    }

    @Override // O3.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Q.INSTANCE;
    }

    public final void invoke(String str) {
        if (E.a(str, this.$file.getName())) {
            p018c4.F.trySendBlocking(this.$$this$channelFlow, Q.INSTANCE);
        }
    }
}
