package p051j0;

import A.c;
import L.a;
import V1.b;
import X3.W;
import android.app.Activity;
import com.appdev.standard.api.pto.LinkedRecordPto;
import com.bumptech.glide.f;
import com.orhanobut.hawk.Hawk;
import kotlin.jvm.internal.E;
import org.apache.commons.compress.archivers.tar.TarConstants;
import p134x2.C1849c;
import p134x2.M0;
import p134x2.N0;
import p134x2.O0;
import p134x2.P0;
import p137y.i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements O0 {
    @Override // p134x2.O0
    public final void onGetPrinterInfo(M0 m6, boolean z6, P0 printerInfo) {
        E.f(printerInfo, "printerInfo");
        a.n(printerInfo);
        a aVar = f.linkedRecordWorker;
        E.c(aVar);
        aVar.d.linkedRecord(new LinkedRecordPto(printerInfo.getFactoryName(), printerInfo.getDpiStr(), printerInfo.getDeviceName(), String.valueOf(printerInfo.c))).b(new c(aVar, 11));
        if ("01".equals(printerInfo.getZipEnable())) {
            Hawk.put("isUseZip", Boolean.TRUE);
        } else {
            Hawk.put("isUseZip", Boolean.FALSE);
        }
        a.k("PrintUtil", "printerInfo.getDpiType() = " + printerInfo.getDpiType());
        if (W.equals(printerInfo.getDpiType(), TarConstants.VERSION_POSIX, false)) {
            C1849c.refreshRatio(8);
        } else if (W.equals(printerInfo.getDpiType(), "01", false)) {
            C1849c.refreshRatio(12);
        } else if (W.equals(printerInfo.getDpiType(), "02", false)) {
            C1849c.refreshRatio(24);
        }
        S4.d.b().f(new i(6, false));
    }

    @Override // p134x2.O0
    public final void onPrinterConnected(M0 m6, boolean z6, byte[] stateData) {
        E.f(stateData, "stateData");
        Hawk.delete("LastDeviceState");
        synchronized (i.class) {
            if (stateData.length == 4) {
                i.a(i.h(f.a(stateData[0])), i.h(f.a(stateData[1])), i.h(f.a(stateData[2])));
            }
        }
        S4.d.b().f(new i(1, true));
    }

    @Override // p134x2.O0
    public final void onPrinterDisconnected(M0 m6) {
        S4.d.b().f(new i(3, false));
        C1849c.refreshRatio(8);
    }

    @Override // p134x2.O0
    public final void onPrinterError(M0 m6, boolean z6, N0 code, String msg) {
        E.f(code, "code");
        E.f(msg, "msg");
        if (code == N0.b) {
            S4.d.b().f(new i(5, true));
        } else if (code == N0.c) {
            S4.d.b().f(new i(3, !z6));
        } else {
            S4.d.b().f(new i(2, !z6));
        }
        C1849c.refreshRatio(8);
    }

    @Override // p134x2.O0
    public final void onRecvData(M0 m6, byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            return;
        }
        byte b = bArr[0];
        if (b == 27 && bArr[1] == 35 && bArr[2] == 82 && bArr[3] == 80) {
            if (f.getPrinter() == null || !f.getPrinter().a()) {
                return;
            }
            b.h().getClass();
            Activity activityD = b.d();
            activityD.runOnUiThread(new W2.c(activityD, 17));
            return;
        }
        if (b == 101 && bArr[1] == 114 && bArr[2] == 114 && bArr[3] == 58) {
            i.a(i.h(f.a(bArr[4])), i.h(f.a(bArr[5])), i.h(f.a(bArr[6])));
        }
    }

    @Override // p134x2.O0
    public final void onVerfiyPrinterSuccess(M0 m6, boolean z6) {
    }
}
