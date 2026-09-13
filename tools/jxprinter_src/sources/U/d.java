package U;

import com.library.base.util.http.CallBack;
import com.library.base.util.http.JsonResult;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends CallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f702a;
    public final /* synthetic */ e b;

    public /* synthetic */ d(e eVar, int i5) {
        this.f702a = i5;
        this.b = eVar;
    }

    @Override // com.library.base.util.http.CallBack
    public final void fail(int i5, String str) {
        switch (this.f702a) {
            case 0:
                Object obj = this.b.b;
                if (obj != null) {
                    ((c) obj).deleteReceiptFailed(i5, str);
                }
                break;
            default:
                Object obj2 = this.b.b;
                if (obj2 != null) {
                    ((c) obj2).deleteReceiptFailed(i5, str);
                }
                break;
        }
    }

    @Override // com.library.base.util.http.CallBack
    public final void success(JsonResult jsonResult) {
        switch (this.f702a) {
            case 0:
                Object obj = this.b.b;
                if (obj != null) {
                    ((c) obj).deleteReceiptSuccess();
                }
                break;
            default:
                Object obj2 = this.b.b;
                if (obj2 != null) {
                    ((c) obj2).deleteReceiptSuccess();
                }
                break;
        }
    }
}
