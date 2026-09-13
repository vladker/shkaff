package p025e0;

import S4.h;
import com.appdev.standard.api.dto.UserInfoDto;
import com.library.base.util.http.CallBack;
import com.library.base.util.http.JsonResult;
import com.orhanobut.hawk.Hawk;
import p032f2.a;
import p042h2.e;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class j extends CallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f3935a;

    public j(k kVar) {
        this.f3935a = kVar;
    }

    @Override // com.library.base.util.http.CallBack
    public final void fail(int i5, String str) {
        Object obj = this.f3935a.b;
        if (obj != null) {
            ((i) obj).getUserInfoFailed(i5, str);
        }
    }

    @Override // com.library.base.util.http.CallBack
    public final void success(JsonResult jsonResult) {
        UserInfoDto.DataBean data = ((UserInfoDto) jsonResult).getData();
        h hVar = e.f4031a;
        String userName = data.getUserName();
        String avatar = data.getAvatar();
        String nickName = data.getNickName();
        String memberName = data.getMemberName();
        String cloudTagsNumber = data.getCloudTagsNumber();
        String usedCloudTagsNumber = data.getUsedCloudTagsNumber();
        String endTime = data.getEndTime();
        String usedPersonalTagsNumber = data.getUsedPersonalTagsNumber();
        String personalTags = data.getPersonalTags();
        data.isVip();
        int member = data.getMember();
        int systemParameter = data.getSystemParameter();
        if (((a) hVar.b) == null) {
            hVar.b = (a) Hawk.get("user_util_user_data", new a());
        }
        a aVar = (a) hVar.b;
        aVar.d = userName;
        aVar.b = avatar;
        aVar.f3961a = nickName;
        aVar.e = memberName;
        aVar.f3962f = cloudTagsNumber;
        aVar.f3963g = usedCloudTagsNumber;
        aVar.f3964h = endTime;
        aVar.f3965i = usedPersonalTagsNumber;
        aVar.f3966j = personalTags;
        aVar.f3967k = member;
        aVar.f3968l = systemParameter;
        Hawk.put("user_util_user_data", aVar);
        Object obj = this.f3935a.b;
        if (obj != null) {
            ((i) obj).getUserInfoSuccess();
        }
    }
}
