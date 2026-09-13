package p009b0;

import S4.h;
import com.library.base.util.http.CallBack;
import com.library.base.util.http.JsonResult;
import com.orhanobut.hawk.Hawk;
import p025e0.e;
import p025e0.f;
import p038g2.a;
import p113u.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends CallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1085a;
    public final /* synthetic */ String b;
    public final /* synthetic */ a c;

    public /* synthetic */ b(a aVar, String str, int i5) {
        this.f1085a = i5;
        this.c = aVar;
        this.b = str;
    }

    @Override // com.library.base.util.http.CallBack
    public final void fail(int i5, String str) {
        switch (this.f1085a) {
            case 0:
                Object obj = ((c) this.c).b;
                if (obj != null) {
                    ((a) obj).publishTemplateFailed(i5, str);
                }
                break;
            default:
                f fVar = (f) this.c;
                Object obj2 = fVar.b;
                if (obj2 != null) {
                    ((e) obj2).updateUserInfoFailed(2, fVar.getString(g.Failed_to_modify_nickname_Please_try_again_later));
                }
                break;
        }
    }

    @Override // com.library.base.util.http.CallBack
    public final void success(JsonResult jsonResult) {
        switch (this.f1085a) {
            case 0:
                Object obj = ((c) this.c).b;
                if (obj != null) {
                    ((a) obj).publishTemplateSuccess(this.b);
                }
                break;
            default:
                h hVar = p042h2.e.f4031a;
                p032f2.a aVar = (p032f2.a) Hawk.get("user_util_user_data", null);
                hVar.b = aVar;
                if (aVar != null) {
                    aVar.f3961a = this.b;
                    Hawk.put("user_util_user_data", aVar);
                }
                Object obj2 = ((f) this.c).b;
                if (obj2 != null) {
                    ((e) obj2).updateUserInfoSuccess();
                }
                break;
        }
    }
}
