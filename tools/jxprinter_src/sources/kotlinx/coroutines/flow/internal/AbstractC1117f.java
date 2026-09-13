package kotlinx.coroutines.flow.internal;

import A3.T;
import java.util.ArrayList;
import p007a4.N;
import p007a4.P;
import p007a4.S;
import p018c4.B0;
import p018c4.EnumC0368b;
import p018c4.v0;
import p018c4.x0;
import p023d4.InterfaceC0612o;
import p023d4.InterfaceC0615p;
import p147z3.Q;

/* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1117f implements B {
    public final int capacity;
    public final E3.q context;
    public final EnumC0368b onBufferOverflow;

    public AbstractC1117f(E3.q qVar, int i5, EnumC0368b enumC0368b) {
        this.context = qVar;
        this.capacity = i5;
        this.onBufferOverflow = enumC0368b;
    }

    public String additionalToStringProps() {
        return null;
    }

    @Override // kotlinx.coroutines.flow.internal.B, p023d4.InterfaceC0612o
    public Object collect(InterfaceC0615p interfaceC0615p, E3.g<? super Q> gVar) {
        Object objCoroutineScope = N.coroutineScope(new C1116e(interfaceC0615p, this, (E3.g) null), gVar);
        return objCoroutineScope == F3.i.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Q.INSTANCE;
    }

    public abstract Object collectTo(x0 x0Var, E3.g<? super Q> gVar);

    public abstract AbstractC1117f create(E3.q qVar, int i5, EnumC0368b enumC0368b);

    public InterfaceC0612o dropChannelOperators() {
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0013  */
    @Override // kotlinx.coroutines.flow.internal.B
    public InterfaceC0612o fuse(E3.q qVar, int i5, EnumC0368b enumC0368b) {
        E3.q qVarPlus = qVar.plus(this.context);
        if (enumC0368b == EnumC0368b.f1135a) {
            int i6 = this.capacity;
            if (i6 != -3) {
                if (i5 == -3) {
                    i5 = i6;
                } else if (i6 != -2) {
                    if (i5 == -2) {
                        i5 = i6;
                    } else {
                        i5 += i6;
                        if (i5 < 0) {
                            i5 = Integer.MAX_VALUE;
                        }
                    }
                }
            }
            enumC0368b = this.onBufferOverflow;
        }
        return (kotlin.jvm.internal.E.a(qVarPlus, this.context) && i5 == this.capacity && enumC0368b == this.onBufferOverflow) ? this : create(qVarPlus, i5, enumC0368b);
    }

    public final O3.p getCollectToFun$kotlinx_coroutines_core() {
        return new p018c4.G(this, null, 5);
    }

    public B0 produceImpl(p007a4.M m6) {
        E3.q qVar = this.context;
        int i5 = this.capacity;
        if (i5 == -3) {
            i5 = -2;
        }
        return v0.produce(m6, qVar, i5, this.onBufferOverflow, P.ATOMIC, null, getCollectToFun$kotlinx_coroutines_core());
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String strAdditionalToStringProps = additionalToStringProps();
        if (strAdditionalToStringProps != null) {
            arrayList.add(strAdditionalToStringProps);
        }
        if (this.context != E3.r.INSTANCE) {
            arrayList.add("context=" + this.context);
        }
        if (this.capacity != -3) {
            arrayList.add("capacity=" + this.capacity);
        }
        if (this.onBufferOverflow != EnumC0368b.f1135a) {
            arrayList.add("onBufferOverflow=" + this.onBufferOverflow);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(S.getClassSimpleName(this));
        sb.append('[');
        return androidx.collection.a.f(']', T.g(arrayList, ", ", null, null, null, 62), sb);
    }
}
