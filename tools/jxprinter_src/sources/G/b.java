package G;

import com.library.base.util.http.CallBack;
import com.library.base.util.http.JsonResult;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends CallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f277a;
    public final /* synthetic */ c b;

    public /* synthetic */ b(c cVar, int i5) {
        this.f277a = i5;
        this.b = cVar;
    }

    @Override // com.library.base.util.http.CallBack
    public final void fail(int i5, String str) {
        switch (this.f277a) {
            case 0:
                Object obj = this.b.b;
                if (obj != null) {
                    ((a) obj).deleteMineLabelFailed(i5, str);
                }
                break;
            default:
                Object obj2 = this.b.b;
                if (obj2 != null) {
                    ((a) obj2).deleteMineLabelFailed(i5, str);
                }
                break;
        }
    }

    @Override // com.library.base.util.http.CallBack
    public final void success(JsonResult jsonResult) {
        switch (this.f277a) {
            case 0:
                Object obj = this.b.b;
                if (obj != null) {
                    ((a) obj).deleteMineLabelSuccess();
                }
                break;
            default:
                Object obj2 = this.b.b;
                if (obj2 != null) {
                    ((a) obj2).deleteMineLabelSuccess();
                }
                break;
        }
    }
}
