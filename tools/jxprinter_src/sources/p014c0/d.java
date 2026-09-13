package p014c0;

import com.appdev.standard.api.dto.UploadImageDto;
import com.library.base.util.http.CallBack;
import com.library.base.util.http.JsonResult;
import p113u.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends CallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1099a;
    public final /* synthetic */ e b;

    public d(e eVar, String str) {
        this.b = eVar;
        this.f1099a = str;
    }

    @Override // com.library.base.util.http.CallBack
    public final void fail(int i5, String str) {
        e eVar = this.b;
        Object obj = eVar.b;
        if (obj != null) {
            ((a) obj).uploadImageFailed(2, eVar.getString(g.Failed_to_upload_picture_please_try_again));
        }
    }

    @Override // com.library.base.util.http.CallBack
    public final void success(JsonResult jsonResult) {
        UploadImageDto uploadImageDto = (UploadImageDto) jsonResult;
        e eVar = this.b;
        Object obj = eVar.b;
        if (obj != null) {
            try {
                ((a) obj).uploadImageSuccess(uploadImageDto.getData().getUrl(), this.f1099a);
            } catch (Exception unused) {
                ((a) eVar.b).uploadImageFailed(2, eVar.getString(g.Failed_to_upload_picture_please_try_again));
            }
        }
    }
}
