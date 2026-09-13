package p020d0;

import com.appdev.standard.api.dto.UsageRecordDto;
import com.library.base.util.http.CallBack;
import com.library.base.util.http.JsonResult;
import p025e0.b;
import p025e0.c;
import p025e0.g;
import p025e0.h;
import p038g2.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends CallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3774a;
    public final /* synthetic */ a b;

    public /* synthetic */ d(a aVar, int i5) {
        this.f3774a = i5;
        this.b = aVar;
    }

    @Override // com.library.base.util.http.CallBack
    public final void fail(int i5, String str) {
        switch (this.f3774a) {
            case 0:
                Object obj = ((e) this.b).b;
                if (obj != null) {
                    ((c) obj).editRecordNameFailed(i5, str);
                }
                break;
            case 1:
                Object obj2 = ((g) this.b).b;
                if (obj2 != null) {
                    ((f) obj2).getUsageRecordListFailed(i5, str);
                }
                break;
            case 2:
                Object obj3 = ((b) this.b).b;
                if (obj3 != null) {
                    ((p025e0.a) obj3).checkPasswordFailed(i5, str);
                }
                break;
            case 3:
                Object obj4 = ((p025e0.d) this.b).b;
                if (obj4 != null) {
                    ((c) obj4).updateAvatarFailed(i5, str);
                }
                break;
            default:
                Object obj5 = ((h) this.b).b;
                if (obj5 != null) {
                    ((g) obj5).editUserNameFailed(i5, str);
                }
                break;
        }
    }

    @Override // com.library.base.util.http.CallBack
    public final void success(JsonResult jsonResult) {
        switch (this.f3774a) {
            case 0:
                Object obj = ((e) this.b).b;
                if (obj != null) {
                    ((c) obj).editRecordNameSuccess();
                }
                break;
            case 1:
                UsageRecordDto usageRecordDto = (UsageRecordDto) jsonResult;
                Object obj2 = ((g) this.b).b;
                if (obj2 != null) {
                    ((f) obj2).getUsageRecordListSuccess(usageRecordDto.getData());
                }
                break;
            case 2:
                Object obj3 = ((b) this.b).b;
                if (obj3 != null) {
                    ((p025e0.a) obj3).checkPasswordSuccess();
                }
                break;
            case 3:
                Object obj4 = ((p025e0.d) this.b).b;
                if (obj4 != null) {
                    ((c) obj4).updateAvatarSuccess();
                }
                break;
            default:
                Object obj5 = ((h) this.b).b;
                if (obj5 != null) {
                    ((g) obj5).editUserNameSuccess();
                }
                break;
        }
    }
}
