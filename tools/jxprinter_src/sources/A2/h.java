package A2;

import kotlin.jvm.internal.E;
import org.apache.logging.log4j.message.ParameterizedMessage;
import p134x2.L0;
import p134x2.M0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements M0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f28a;
    private final String ip;
    private final String name;

    public h(String ip, int i5, String str) {
        E.f(ip, "ip");
        this.ip = ip;
        this.f28a = i5;
        this.name = str;
    }

    public final String getIp() {
        return this.ip;
    }

    @Override // p134x2.M0
    public String getPrintDeviceAddress() {
        return this.ip + ParameterizedMessage.ERROR_MSG_SEPARATOR + this.f28a;
    }

    @Override // p134x2.M0
    public String getPrintDeviceName() {
        String str = this.name;
        return str == null ? getPrintDeviceAddress() : str;
    }

    @Override // p134x2.M0
    public L0 getPrinterType() {
        return L0.c;
    }

    @Override // p134x2.M0
    public boolean isSameDevice(M0 device) {
        E.f(device, "device");
        if (device instanceof h) {
            h hVar = (h) device;
            if (E.a(this.ip, hVar.ip) && this.f28a == hVar.f28a) {
                return true;
            }
        }
        return false;
    }
}
