package p134x2;

import A3.I;
import A3.T;
import E3.g;
import F3.i;
import G3.m;
import O3.p;
import X3.G;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.E;
import org.apache.logging.log4j.message.ParameterizedMessage;
import p007a4.M;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: renamed from: x2.z, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1894z extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8951a;
    public final /* synthetic */ M b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1894z(M m6, g gVar) {
        super(2, gVar);
        this.b = m6;
    }

    @Override // G3.a
    public final g<Q> create(Object obj, g<?> gVar) {
        return new C1894z(this.b, gVar);
    }

    @Override // O3.p
    public final Object invoke(M m6, g<? super Q> gVar) {
        return ((C1894z) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        List listEmptyList;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i5 = this.f8951a;
        if (i5 == 0) {
            v.throwOnFailure(obj);
            M m6 = this.b;
            String bleDeviceMac = m6.getBleDeviceMac();
            E.c(bleDeviceMac);
            List<String> listSplit = new G(ParameterizedMessage.ERROR_MSG_SEPARATOR).split(bleDeviceMac, 0);
            if (!listSplit.isEmpty()) {
                ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        listEmptyList = I.emptyList();
                        break;
                    }
                    if (listIterator.previous().length() != 0) {
                        listEmptyList = T.take(listSplit, listIterator.nextIndex() + 1);
                        break;
                    }
                }
            } else {
                listEmptyList = I.emptyList();
                break;
            }
            String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
            if (strArr.length != 2) {
                return Q.INSTANCE;
            }
            try {
                Integer.parseInt(strArr[1]);
                E e = E.INSTANCE;
                String bleDeviceName = m6.getBleDeviceName();
                E.c(bleDeviceName);
                String str = strArr[0];
                int i6 = Integer.parseInt(strArr[1]);
                this.f8951a = 1;
                if (e.connectWifiDevice(bleDeviceName, str, i6, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (Exception unused) {
                O.INSTANCE.e("CurrentPrinter", "connectWifiDevice error port " + strArr[1]);
                return Q.INSTANCE;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
        }
        return Q.INSTANCE;
    }
}
