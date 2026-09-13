package N;

import com.appdev.standard.api.dto.LogoffDto;
import com.library.base.util.http.CallBack;
import com.library.base.util.http.JsonResult;
import p042h2.e;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends CallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f496a;

    public b(c cVar) {
        this.f496a = cVar;
    }

    @Override // com.library.base.util.http.CallBack
    public final void fail(int i5, String str) {
        Object obj = this.f496a.b;
        if (obj != null) {
            ((a) obj).logoffFailed(i5, str);
        }
    }

    @Override // com.library.base.util.http.CallBack
    public final void success(JsonResult jsonResult) {
        boolean zIsResult = ((LogoffDto) jsonResult).getData().isResult();
        c cVar = this.f496a;
        if (!zIsResult) {
            Object obj = cVar.b;
            if (obj != null) {
                ((a) obj).logoffFailed(-1, "");
                return;
            }
            return;
        }
        e.f4031a.i();
        Object obj2 = cVar.b;
        if (obj2 != null) {
            ((a) obj2).logoffSuccess();
        }
    }
}
