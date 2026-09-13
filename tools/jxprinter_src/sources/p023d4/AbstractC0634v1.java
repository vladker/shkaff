package p023d4;

import E3.g;
import E3.r;
import O3.p;
import kotlin.jvm.internal.E;
import kotlinx.coroutines.flow.internal.AbstractC1117f;
import p007a4.AbstractC0272e;
import p007a4.AbstractC0308w;
import p007a4.H0;
import p007a4.InterfaceC0304u;
import p007a4.M;
import p007a4.P;
import p018c4.C0390u;
import p018c4.EnumC0368b;
import p018c4.InterfaceC0391v;

/* JADX INFO: renamed from: d4.v1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class AbstractC0634v1 {
    /* JADX WARN: Code duplicated, block: B:19:0x0030  */
    public static final f2 a(InterfaceC0612o interfaceC0612o, int i5) {
        AbstractC1117f abstractC1117f;
        InterfaceC0612o interfaceC0612oDropChannelOperators;
        InterfaceC0391v.Factory.getClass();
        int i6 = C0390u.b;
        if (i5 >= i6) {
            i6 = i5;
        }
        int i7 = i6 - i5;
        if (!(interfaceC0612o instanceof AbstractC1117f) || (interfaceC0612oDropChannelOperators = (abstractC1117f = (AbstractC1117f) interfaceC0612o).dropChannelOperators()) == null) {
            return new f2(interfaceC0612o, i7, EnumC0368b.f1135a, r.INSTANCE);
        }
        int i8 = abstractC1117f.capacity;
        if (i8 != -3 && i8 != -2 && i8 != 0) {
            i7 = i8;
        } else if (abstractC1117f.onBufferOverflow == EnumC0368b.f1135a) {
            if (i8 == 0) {
                i7 = 0;
            }
        } else if (i5 == 0) {
            i7 = 1;
        } else {
            i7 = 0;
        }
        return new f2(interfaceC0612oDropChannelOperators, i7, abstractC1117f.onBufferOverflow, abstractC1117f.context);
    }

    public static final <T> Z1 asSharedFlow(U1 u6) {
        return new W1(u6, null);
    }

    public static final <T> n2 asStateFlow(V1 v6) {
        return new X1(v6, null);
    }

    public static final <T> Z1 onSubscription(Z1 z6, p pVar) {
        return new v2(z6, pVar);
    }

    public static final <T> Z1 shareIn(InterfaceC0612o interfaceC0612o, M m6, h2 h2Var, int i5) {
        f2 f2VarA = a(interfaceC0612o, i5);
        U1 u1MutableSharedFlow = c2.MutableSharedFlow(i5, f2VarA.extraBufferCapacity, f2VarA.onBufferOverflow);
        return new W1(u1MutableSharedFlow, AbstractC0272e.launch(m6, f2VarA.context, E.a(h2Var, h2.Companion.getEagerly()) ? P.f943a : P.c, new S2.p(h2Var, f2VarA.upstream, u1MutableSharedFlow, c2.NO_VALUE, (g) null)));
    }

    public static final <T> n2 stateIn(InterfaceC0612o interfaceC0612o, M m6, h2 h2Var, T t6) {
        f2 f2VarA = a(interfaceC0612o, 1);
        V1 v1MutableStateFlow = q2.MutableStateFlow(t6);
        return new X1(v1MutableStateFlow, AbstractC0272e.launch(m6, f2VarA.context, E.a(h2Var, h2.Companion.getEagerly()) ? P.f943a : P.c, new S2.p(h2Var, f2VarA.upstream, v1MutableStateFlow, t6, (g) null)));
    }

    public static final <T> Object stateIn(InterfaceC0612o interfaceC0612o, M m6, g<? super n2> gVar) {
        f2 f2VarA = a(interfaceC0612o, 1);
        InterfaceC0304u interfaceC0304uCompletableDeferred = AbstractC0308w.CompletableDeferred((H0) null);
        AbstractC0272e.b(m6, f2VarA.context, 2, new S2.r(f2VarA.upstream, interfaceC0304uCompletableDeferred, (g) null, 2));
        return interfaceC0304uCompletableDeferred.await(gVar);
    }
}
