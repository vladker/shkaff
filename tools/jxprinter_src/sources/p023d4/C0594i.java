package p023d4;

import E3.g;
import E3.q;
import E3.r;
import F3.i;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlinx.coroutines.flow.internal.AbstractC1117f;
import kotlinx.coroutines.flow.internal.J;
import p007a4.M;
import p018c4.B0;
import p018c4.EnumC0368b;
import p018c4.x0;
import p147z3.Q;

/* JADX INFO: renamed from: d4.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0594i extends AbstractC1117f {
    public static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(C0594i.class, "consumed$volatile");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3875a;
    private final B0 channel;
    private volatile /* synthetic */ int consumed$volatile;

    public /* synthetic */ C0594i(B0 b1, boolean z6) {
        this(b1, z6, r.INSTANCE, -3, EnumC0368b.f1135a);
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractC1117f
    public String additionalToStringProps() {
        return "channel=" + this.channel;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractC1117f, kotlinx.coroutines.flow.internal.B, p023d4.InterfaceC0612o
    public Object collect(InterfaceC0615p interfaceC0615p, g<? super Q> gVar) {
        if (this.capacity != -3) {
            Object objCollect = super.collect(interfaceC0615p, gVar);
            return objCollect == i.getCOROUTINE_SUSPENDED() ? objCollect : Q.INSTANCE;
        }
        boolean z6 = this.f3875a;
        if (z6 && b.getAndSet(this, 1) != 0) {
            throw new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once");
        }
        Object objA = F.a(interfaceC0615p, this.channel, z6, gVar);
        return objA == i.getCOROUTINE_SUSPENDED() ? objA : Q.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractC1117f
    public Object collectTo(x0 x0Var, g<? super Q> gVar) {
        Object objA = F.a(new J(x0Var), this.channel, this.f3875a, gVar);
        return objA == i.getCOROUTINE_SUSPENDED() ? objA : Q.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractC1117f
    public AbstractC1117f create(q qVar, int i5, EnumC0368b enumC0368b) {
        return new C0594i(this.channel, this.f3875a, qVar, i5, enumC0368b);
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractC1117f
    public InterfaceC0612o dropChannelOperators() {
        return new C0594i(this.channel, this.f3875a);
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractC1117f
    public B0 produceImpl(M m6) {
        if (!this.f3875a || b.getAndSet(this, 1) == 0) {
            return this.capacity == -3 ? this.channel : super.produceImpl(m6);
        }
        throw new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once");
    }

    public C0594i(B0 b1, boolean z6, q qVar, int i5, EnumC0368b enumC0368b) {
        super(qVar, i5, enumC0368b);
        this.channel = b1;
        this.f3875a = z6;
        this.consumed$volatile = 0;
    }
}
