package androidx.window.java.core;

import androidx.core.util.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.E;
import p007a4.AbstractC0272e;
import p007a4.AbstractC0313y0;
import p007a4.H0;
import p007a4.N;
import p023d4.InterfaceC0612o;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class CallbackToFlowAdapter {
    private final ReentrantLock lock = new ReentrantLock();
    private final Map<Consumer<?>, H0> consumerToJobMap = new LinkedHashMap();

    public final <T> void connect(Executor executor, Consumer<T> consumer, InterfaceC0612o flow) {
        E.f(executor, "executor");
        E.f(consumer, "consumer");
        E.f(flow, "flow");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.consumerToJobMap.get(consumer) == null) {
                this.consumerToJobMap.put(consumer, AbstractC0272e.b(N.CoroutineScope(AbstractC0313y0.from(executor)), null, 3, new CallbackToFlowAdapter$connect$1$1(flow, consumer, null)));
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void disconnect(Consumer<?> consumer) {
        E.f(consumer, "consumer");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            H0 h1 = this.consumerToJobMap.get(consumer);
            if (h1 != null) {
                h1.cancel((CancellationException) null);
            }
            this.consumerToJobMap.remove(consumer);
        } finally {
            reentrantLock.unlock();
        }
    }
}
