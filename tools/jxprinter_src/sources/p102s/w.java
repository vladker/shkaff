package p102s;

import O3.l;
import kotlin.jvm.internal.E;
import org.apache.logging.log4j.message.ParameterizedMessage;
import p108t.C1770b;
import p108t.b0;
import p108t.d0;
import p134x2.M0;
import p134x2.N0;
import p134x2.O;
import p134x2.O0;
import p134x2.P0;
import p147z3.Q;
import p147z3.u;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class w implements O0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8181a;
    public final /* synthetic */ l b;
    public final /* synthetic */ Object c;

    public /* synthetic */ w(Object obj, l lVar, int i5) {
        this.f8181a = i5;
        this.c = obj;
        this.b = lVar;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0002. Please report as an issue. */
    @Override // p134x2.O0
    public final void onGetPrinterInfo(M0 m6, boolean z6, P0 printerInfo) {
        switch (this.f8181a) {
        }
        E.f(printerInfo, "printerInfo");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0002. Please report as an issue. */
    @Override // p134x2.O0
    public final void onPrinterConnected(M0 m6, boolean z6, byte[] stateData) {
        switch (this.f8181a) {
        }
        E.f(stateData, "stateData");
    }

    @Override // p134x2.O0
    public final void onPrinterDisconnected(M0 m6) {
        int i5 = this.f8181a;
    }

    @Override // p134x2.O0
    public final void onPrinterError(M0 m6, boolean z6, N0 code, String msg) {
        switch (this.f8181a) {
            case 0:
                E.f(code, "code");
                E.f(msg, "msg");
                if (!z6) {
                    if (m6 == null || E.a(m6.getPrintDeviceAddress(), ((C1770b) this.c).getAddress())) {
                        p134x2.E.INSTANCE.removeEventListener(this);
                        try {
                            this.b.invoke(u.a(u.m1361constructorimpl(Q.INSTANCE)));
                        } catch (Exception e) {
                            O.INSTANCE.e("AndroidFlutterPrintUtil", "callback error", e);
                            return;
                        }
                    }
                    break;
                }
                break;
            case 1:
                E.f(code, "code");
                E.f(msg, "msg");
                if (!z6) {
                    if (m6 == null || E.a(m6.getPrintDeviceAddress(), ((b0) this.c).getAddress())) {
                        p134x2.E.INSTANCE.removeEventListener(this);
                        try {
                            this.b.invoke(u.a(u.m1361constructorimpl(Q.INSTANCE)));
                        } catch (Exception e6) {
                            O.INSTANCE.e("AndroidFlutterPrintUtil", "callback error", e6);
                            return;
                        }
                    }
                    break;
                }
                break;
            default:
                d0 d0Var = (d0) this.c;
                E.f(code, "code");
                E.f(msg, "msg");
                if (!z6) {
                    if (m6 != null) {
                        if (!E.a(m6.getPrintDeviceAddress(), d0Var.getIp() + ParameterizedMessage.ERROR_MSG_SEPARATOR + d0Var.f8527a)) {
                        }
                    }
                    p134x2.E.INSTANCE.removeEventListener(this);
                    try {
                        this.b.invoke(u.a(u.m1361constructorimpl(Q.INSTANCE)));
                    } catch (Exception e7) {
                        O.INSTANCE.e("AndroidFlutterPrintUtil", "callback error", e7);
                    }
                    break;
                }
                break;
        }
    }

    @Override // p134x2.O0
    public final void onRecvData(M0 m6, byte[] bArr) {
        int i5 = this.f8181a;
    }

    @Override // p134x2.O0
    public final void onVerfiyPrinterSuccess(M0 m6, boolean z6) {
        switch (this.f8181a) {
            case 0:
                if (!z6) {
                    if (m6 == null || E.a(m6.getPrintDeviceAddress(), ((C1770b) this.c).getAddress())) {
                        p134x2.E.INSTANCE.removeEventListener(this);
                        try {
                            this.b.invoke(u.a(u.m1361constructorimpl(Q.INSTANCE)));
                        } catch (Exception e) {
                            O.INSTANCE.e("AndroidFlutterPrintUtil", "callback error", e);
                            return;
                        }
                    }
                    break;
                }
                break;
            case 1:
                if (!z6) {
                    if (m6 == null || E.a(m6.getPrintDeviceAddress(), ((b0) this.c).getAddress())) {
                        p134x2.E.INSTANCE.removeEventListener(this);
                        try {
                            this.b.invoke(u.a(u.m1361constructorimpl(Q.INSTANCE)));
                        } catch (Exception e6) {
                            O.INSTANCE.e("AndroidFlutterPrintUtil", "callback error", e6);
                            return;
                        }
                    }
                    break;
                }
                break;
            default:
                d0 d0Var = (d0) this.c;
                if (!z6) {
                    if (m6 != null) {
                        if (!E.a(m6.getPrintDeviceAddress(), d0Var.getIp() + ParameterizedMessage.ERROR_MSG_SEPARATOR + d0Var.f8527a)) {
                        }
                    }
                    p134x2.E.INSTANCE.removeEventListener(this);
                    try {
                        this.b.invoke(u.a(u.m1361constructorimpl(Q.INSTANCE)));
                    } catch (Exception e7) {
                        O.INSTANCE.e("AndroidFlutterPrintUtil", "callback error", e7);
                    }
                    break;
                }
                break;
        }
    }

    private final void a(M0 m6) {
    }

    private final void b(M0 m6) {
    }

    private final void c(M0 m6) {
    }

    private final void d(M0 m6, byte[] bArr) {
    }

    private final void e(M0 m6, byte[] bArr) {
    }

    private final void f(M0 m6, byte[] bArr) {
    }
}
