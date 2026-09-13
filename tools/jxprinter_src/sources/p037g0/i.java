package p037g0;

import com.appdev.standard.api.dto.ScanQrResultDto;
import com.library.base.util.http.CallBack;
import com.library.base.util.http.JsonResult;
import org.opencv.videoio.Videoio;
import p113u.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class i extends CallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f3983a;

    public i(j jVar) {
        this.f3983a = jVar;
    }

    @Override // com.library.base.util.http.CallBack
    public final void fail(int i5, String str) {
        Object obj = this.f3983a.b;
        if (obj != null) {
            ((h) obj).scanQRCodeFailed(i5, str);
        }
    }

    @Override // com.library.base.util.http.CallBack
    public final void success(JsonResult jsonResult) {
        ScanQrResultDto scanQrResultDto = (ScanQrResultDto) jsonResult;
        ScanQrResultDto.DataBean data = scanQrResultDto != null ? scanQrResultDto.getData() : null;
        j jVar = this.f3983a;
        if (data == null || data.getQrCodeType() != 0) {
            Object obj = jVar.b;
            if (obj != null) {
                ((h) obj).scanQRCodeSuccess();
                return;
            }
            return;
        }
        Object obj2 = jVar.b;
        if (obj2 != null) {
            ((h) obj2).scanQRCodeFailed(Videoio.CAP_QT, jVar.getString(g.qr_code_expired));
        }
    }
}
