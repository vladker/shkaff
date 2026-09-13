package E;

import com.appdev.standard.api.dto.DictDto;
import com.library.base.util.http.CallBack;
import com.library.base.util.http.JsonResult;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends CallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f225a;
    public final /* synthetic */ e b;

    public /* synthetic */ d(e eVar, int i5) {
        this.f225a = i5;
        this.b = eVar;
    }

    @Override // com.library.base.util.http.CallBack
    public final void fail(int i5, String str) {
        switch (this.f225a) {
            case 0:
                Object obj = this.b.b;
                if (obj != null) {
                    ((c) obj).getBqDictFailed(i5, str);
                }
                break;
            default:
                Object obj2 = this.b.b;
                if (obj2 != null) {
                    ((c) obj2).getBqDictFailed(i5, str);
                }
                break;
        }
    }

    @Override // com.library.base.util.http.CallBack
    public final void success(JsonResult jsonResult) {
        switch (this.f225a) {
            case 0:
                DictDto dictDto = (DictDto) jsonResult;
                Object obj = this.b.b;
                if (obj != null) {
                    ((c) obj).getBqDictSuccess(dictDto.getData());
                }
                break;
            default:
                DictDto dictDto2 = (DictDto) jsonResult;
                Object obj2 = this.b.b;
                if (obj2 != null) {
                    ((c) obj2).getBqDictSuccess(dictDto2.getData());
                }
                break;
        }
    }
}
