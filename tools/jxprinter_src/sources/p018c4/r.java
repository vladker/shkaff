package p018c4;

import O3.p;
import kotlin.jvm.internal.B;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class r extends B implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f1185a = new r(2, AbstractC0388s.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        long jLongValue = ((Number) obj).longValue();
        E e = (E) obj2;
        int i5 = AbstractC0388s.SEGMENT_SIZE;
        return new E(jLongValue, e, e.getChannel(), 0);
    }
}
