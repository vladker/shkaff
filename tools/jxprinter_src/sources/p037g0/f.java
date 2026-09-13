package p037g0;

import com.appdev.standard.api.dto.JudgeRankDto;
import com.library.base.util.http.CallBack;
import com.library.base.util.http.JsonResult;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class f extends CallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f3982a;

    public f(g gVar) {
        this.f3982a = gVar;
    }

    @Override // com.library.base.util.http.CallBack
    public final void fail(int i5, String str) {
        Object obj = this.f3982a.b;
        if (obj != null) {
            ((e) obj).judgeRankFailed(i5, str);
        }
    }

    @Override // com.library.base.util.http.CallBack
    public final void success(JsonResult jsonResult) {
        JudgeRankDto judgeRankDto = (JudgeRankDto) jsonResult;
        Object obj = this.f3982a.b;
        if (obj != null) {
            ((e) obj).judgeRankSuccess(judgeRankDto.getData().isResult());
        }
    }
}
