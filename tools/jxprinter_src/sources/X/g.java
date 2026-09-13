package X;

import com.appdev.standard.api.dto.CloudSpaceCloudLabelDto;
import com.library.base.util.http.CallBack;
import com.library.base.util.http.JsonResult;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class g extends CallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f832a;

    public g(h hVar) {
        this.f832a = hVar;
    }

    @Override // com.library.base.util.http.CallBack
    public final void fail(int i5, String str) {
        Object obj = this.f832a.b;
        if (obj != null) {
            ((f) obj).cloudSpaceCloudLabelListFailed(i5, str);
        }
    }

    @Override // com.library.base.util.http.CallBack
    public final void success(JsonResult jsonResult) {
        CloudSpaceCloudLabelDto cloudSpaceCloudLabelDto = (CloudSpaceCloudLabelDto) jsonResult;
        Object obj = this.f832a.b;
        if (obj != null) {
            ((f) obj).cloudSpaceCloudLabelListSuccess(cloudSpaceCloudLabelDto.getData().getRows(), Integer.parseInt(cloudSpaceCloudLabelDto.getData().getTotal()));
        }
    }
}
