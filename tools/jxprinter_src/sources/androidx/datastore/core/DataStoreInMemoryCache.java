package androidx.datastore.core;

import kotlin.jvm.internal.E;
import p023d4.InterfaceC0612o;
import p023d4.V1;
import p023d4.p2;
import p023d4.q2;
import p147z3.C1937q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class DataStoreInMemoryCache<T> {
    private final V1 cachedValue;

    public DataStoreInMemoryCache() {
        UnInitialized unInitialized = UnInitialized.INSTANCE;
        E.d(unInitialized, "null cannot be cast to non-null type androidx.datastore.core.State<T of androidx.datastore.core.DataStoreInMemoryCache>");
        this.cachedValue = q2.MutableStateFlow(unInitialized);
    }

    public final State<T> getCurrentState() {
        return (State) ((p2) this.cachedValue).getValue();
    }

    public final InterfaceC0612o getFlow() {
        return this.cachedValue;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002e  */
    public final State<T> tryUpdate(State<T> newState) {
        p2 p2Var;
        Object value;
        State<T> state;
        E.f(newState, "newState");
        V1 v6 = this.cachedValue;
        do {
            p2Var = (p2) v6;
            value = p2Var.getValue();
            state = (State) value;
            if (state instanceof ReadException ? true : E.a(state, UnInitialized.INSTANCE)) {
                state = newState;
            } else if (state instanceof Data) {
                if (newState.getVersion() > state.getVersion()) {
                    state = newState;
                }
            } else if (!(state instanceof Final)) {
                throw new C1937q();
            }
        } while (!p2Var.c(value, state));
        return state;
    }

    private static /* synthetic */ void getCachedValue$annotations() {
    }
}
