package androidx.datastore.core;

import E3.q;
import O3.p;
import kotlin.jvm.internal.AbstractC1107v;
import kotlin.jvm.internal.E;
import p007a4.InterfaceC0304u;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Message<T> {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Read<T> extends Message<T> {
        private final State<T> lastState;

        public Read(State<T> state) {
            super(null);
            this.lastState = state;
        }

        @Override // androidx.datastore.core.Message
        public State<T> getLastState() {
            return this.lastState;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Update<T> extends Message<T> {
        private final InterfaceC0304u ack;
        private final q callerContext;
        private final State<T> lastState;
        private final p transform;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Update(p transform, InterfaceC0304u ack, State<T> state, q callerContext) {
            super(null);
            E.f(transform, "transform");
            E.f(ack, "ack");
            E.f(callerContext, "callerContext");
            this.transform = transform;
            this.ack = ack;
            this.lastState = state;
            this.callerContext = callerContext;
        }

        public final InterfaceC0304u getAck() {
            return this.ack;
        }

        public final q getCallerContext() {
            return this.callerContext;
        }

        @Override // androidx.datastore.core.Message
        public State<T> getLastState() {
            return this.lastState;
        }

        public final p getTransform() {
            return this.transform;
        }
    }

    public /* synthetic */ Message(AbstractC1107v abstractC1107v) {
        this();
    }

    public abstract State<T> getLastState();

    private Message() {
    }
}
