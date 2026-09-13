package X;

import com.appdev.standard.api.dto.MemberDto;
import com.library.base.util.http.CallBack;
import com.library.base.util.http.JsonResult;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class p extends CallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f833a;

    public p(q qVar) {
        this.f833a = qVar;
    }

    @Override // com.library.base.util.http.CallBack
    public final void fail(int i5, String str) {
        Object obj = this.f833a.b;
        if (obj != null) {
            ((o) obj).memberListFailed(i5, str);
        }
    }

    @Override // com.library.base.util.http.CallBack
    public final void success(JsonResult jsonResult) {
        MemberDto memberDto = (MemberDto) jsonResult;
        Object obj = this.f833a.b;
        if (obj != null) {
            ((o) obj).memberListSuccess(memberDto.getData().getRows(), Integer.parseInt(memberDto.getData().getTotal()));
        }
    }
}
