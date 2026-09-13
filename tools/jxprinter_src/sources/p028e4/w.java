package p028e4;

import W3.L;
import W3.z;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;
import p007a4.AbstractC0265b1;
import p012b4.a;
import p147z3.C1929i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class w {
    public static final w INSTANCE = new w();
    public static final AbstractC0265b1 dispatcher;

    static {
        Object obj;
        AbstractC0265b1 abstractC0265b1TryCreateDispatcher;
        I.systemProp("kotlinx.coroutines.fast.service.loader", true);
        try {
            List list = L.toList(z.asSequence(Arrays.asList(new a()).iterator()));
            Iterator it = list.iterator();
            if (it.hasNext()) {
                Object next = it.next();
                if (it.hasNext()) {
                    ((v) next).getClass();
                    do {
                        ((v) it.next()).getClass();
                    } while (it.hasNext());
                }
                obj = next;
            } else {
                obj = null;
            }
            v vVar = (v) obj;
            if (vVar == null || (abstractC0265b1TryCreateDispatcher = x.tryCreateDispatcher(vVar, list)) == null) {
                x.throwMissingMainDispatcherException();
                throw new C1929i();
            }
            dispatcher = abstractC0265b1TryCreateDispatcher;
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }
}
