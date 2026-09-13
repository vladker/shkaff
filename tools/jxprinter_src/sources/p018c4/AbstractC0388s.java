package p018c4;

import O3.q;
import V3.g;
import p007a4.InterfaceC0285k;
import p028e4.H;
import p028e4.I;

/* JADX INFO: renamed from: c4.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0388s {
    private static final E NULL_SEGMENT = new E(-1, null, null, 0);
    public static final int SEGMENT_SIZE = I.systemProp("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 1, (8 & 8) != 0 ? Integer.MAX_VALUE : 2097150);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f1186a = I.systemProp("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 1, (8 & 8) != 0 ? Integer.MAX_VALUE : 2097150);
    public static final H BUFFERED = new H("BUFFERED");
    private static final H IN_BUFFER = new H("SHOULD_BUFFER");
    private static final H RESUMING_BY_RCV = new H("S_RESUMING_BY_RCV");
    private static final H RESUMING_BY_EB = new H("RESUMING_BY_EB");
    private static final H POISONED = new H("POISONED");
    private static final H DONE_RCV = new H("DONE_RCV");
    private static final H INTERRUPTED_SEND = new H("INTERRUPTED_SEND");
    private static final H INTERRUPTED_RCV = new H("INTERRUPTED_RCV");
    private static final H CHANNEL_CLOSED = new H("CHANNEL_CLOSED");
    private static final H SUSPEND = new H("SUSPEND");
    private static final H SUSPEND_NO_WAITER = new H("SUSPEND_NO_WAITER");
    private static final H FAILED = new H("FAILED");
    private static final H NO_RECEIVE_RESULT = new H("NO_RECEIVE_RESULT");
    private static final H CLOSE_HANDLER_CLOSED = new H("CLOSE_HANDLER_CLOSED");
    private static final H CLOSE_HANDLER_INVOKED = new H("CLOSE_HANDLER_INVOKED");
    private static final H NO_CLOSE_CAUSE = new H("NO_CLOSE_CAUSE");

    public static final <E> g createSegmentFunction() {
        return r.f1185a;
    }

    public static final H getCHANNEL_CLOSED() {
        return CHANNEL_CLOSED;
    }

    public static final boolean p(InterfaceC0285k interfaceC0285k, Object obj, q qVar) {
        Object objTryResume = interfaceC0285k.tryResume(obj, null, qVar);
        if (objTryResume == null) {
            return false;
        }
        interfaceC0285k.completeResume(objTryResume);
        return true;
    }
}
