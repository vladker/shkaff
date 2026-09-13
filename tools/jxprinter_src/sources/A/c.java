package A;

import E.g;
import X.i;
import X.j;
import X.k;
import X.l;
import X.m;
import X.n;
import com.appdev.standard.api.dto.AppBannerDto;
import com.appdev.standard.api.dto.AppMaterialDto;
import com.appdev.standard.api.dto.CloudHeaderDto;
import com.appdev.standard.api.dto.DictDto;
import com.appdev.standard.api.dto.FeedbackDetailDto;
import com.appdev.standard.api.dto.InviteRecordDto;
import com.appdev.standard.api.dto.LoginDto;
import com.appdev.standard.api.dto.MaterialLibraryTypeDto;
import com.appdev.standard.api.dto.TextFontDto;
import com.appdev.standard.dialog.InvitationNotificationTipDialog;
import com.appdev.standard.model.MaterialLibraryTypeModel;
import com.library.base.util.http.CallBack;
import com.library.base.util.http.JsonResult;
import com.orhanobut.hawk.Hawk;
import java.util.List;
import p050j.w;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends CallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5a;
    public final /* synthetic */ Object b;

    public /* synthetic */ c(Object obj, int i5) {
        this.f5a = i5;
        this.b = obj;
    }

    @Override // com.library.base.util.http.CallBack
    public final void fail(int i5, String str) {
        switch (this.f5a) {
            case 0:
                Object obj = ((d) this.b).b;
                if (obj != null) {
                    ((a) obj).sendCodeFailed(2, str);
                    return;
                }
                return;
            case 1:
                Object obj2 = ((f) this.b).b;
                if (obj2 != null) {
                    ((e) obj2).checkCodeFailed(2, str);
                    return;
                }
                return;
            case 2:
                Object obj3 = ((B.b) this.b).b;
                if (obj3 != null) {
                    ((B.a) obj3).getAppBannerFailed(i5, str);
                    return;
                }
                return;
            case 3:
                Object obj4 = ((C.b) this.b).b;
                if (obj4 != null) {
                    ((C.a) obj4).changePasswordFailed(i5, str);
                    return;
                }
                return;
            case 4:
                Object obj5 = ((D.b) this.b).b;
                if (obj5 != null) {
                    ((D.a) obj5).collectUpdateFailed(i5, str);
                    return;
                }
                return;
            case 5:
                Object obj6 = ((E.b) this.b).b;
                if (obj6 != null) {
                    ((E.a) obj6).appMaterialFailed(i5, str);
                    return;
                }
                return;
            case 6:
                Object obj7 = ((g) this.b).b;
                if (obj7 != null) {
                    ((E.f) obj7).getImageDictFailed(i5, str);
                    return;
                }
                return;
            case 7:
                Object obj8 = ((H.b) this.b).b;
                if (obj8 != null) {
                    ((H.a) obj8).deletePublishLabelFailed(i5, str);
                    return;
                }
                return;
            case 8:
                Object obj9 = ((I.b) this.b).b;
                if (obj9 != null) {
                    ((I.a) obj9).feedBackListFailed(i5, str);
                    return;
                }
                return;
            case 9:
                I.d dVar = (I.d) this.b;
                Object obj10 = dVar.b;
                if (obj10 != null) {
                    ((I.c) obj10).submitFeedbackFailed(2, dVar.getString(p113u.g.Feedback_failed_please_try_again_later));
                    return;
                }
                return;
            case 10:
                Object obj11 = ((J.b) this.b).b;
                if (obj11 != null) {
                    ((J.a) obj11).getAppFontLibFailed(i5, str);
                    return;
                }
                return;
            case 11:
                if (((L.a) this.b).b != null) {
                    throw new ClassCastException();
                }
                return;
            case 12:
                M.g gVar = ((M.e) ((M.d) this.b).b).c;
                gVar.b(gVar.getString(p113u.g.error_wechat_login));
                return;
            case 13:
                M.g gVar2 = ((M.e) ((M.d) this.b).b).c;
                gVar2.b(gVar2.getString(p113u.g.text_404));
                return;
            case 14:
                M.g gVar3 = ((M.f) this.b).b;
                gVar3.b(gVar3.getString(p113u.g.text_407));
                return;
            case 15:
                M.g gVar4 = ((M.f) this.b).b;
                gVar4.b(gVar4.getString(p113u.g.text_410));
                return;
            case 16:
                ((M.g) this.b).b(str);
                return;
            case 17:
                Object obj12 = ((P.c) this.b).b;
                if (obj12 != null) {
                    ((P.a) obj12).getMaterialLibraryDataFailed(i5, str);
                    return;
                }
                return;
            case 18:
                Object obj13 = ((Q.b) this.b).b;
                if (obj13 != null) {
                    ((InvitationNotificationTipDialog) ((Q.a) obj13)).getClass();
                    w.c();
                    p042h2.d.a(str);
                    return;
                }
                return;
            case 19:
                Object obj14 = ((Q.d) this.b).b;
                if (obj14 != null) {
                    ((Q.c) obj14).getInviteRecordListFailed(i5, str);
                    return;
                }
                return;
            case 20:
                if (((S.a) this.b).b != null) {
                    throw new ClassCastException();
                }
                return;
            case 21:
                Object obj15 = ((T.e) this.b).b;
                if (obj15 != null) {
                    ((T.d) obj15).printPersonalBiaoqianFailed(i5, str);
                    return;
                }
                return;
            case 22:
                Object obj16 = ((U.b) this.b).b;
                if (obj16 != null) {
                    ((U.a) obj16).addOrEditReceiptFailed(i5, str);
                    return;
                }
                return;
            case 23:
                Object obj17 = ((V.b) this.b).b;
                if (obj17 != null) {
                    ((V.a) obj17).registerFailed(2, str);
                    return;
                }
                return;
            case 24:
                Object obj18 = ((W.b) this.b).b;
                if (obj18 != null) {
                    ((W.a) obj18).resetPasswordFailed(2, str);
                    return;
                }
                return;
            case 25:
                Object obj19 = ((X.e) this.b).b;
                if (obj19 != null) {
                    ((X.d) obj19).cloudHeaderFailed(i5, str);
                    return;
                }
                return;
            case 26:
                Object obj20 = ((j) this.b).b;
                if (obj20 != null) {
                    ((i) obj20).deleteCloudSpaceFailed(i5, str);
                    return;
                }
                return;
            case 27:
                Object obj21 = ((l) this.b).b;
                if (obj21 != null) {
                    ((k) obj21).deleteMemberFailed(i5, str);
                    return;
                }
                return;
            case 28:
                Object obj22 = ((n) this.b).b;
                if (obj22 != null) {
                    ((m) obj22).editCloudLabelNameFailed(i5, str);
                    return;
                }
                return;
            default:
                Object obj23 = ((p020d0.b) this.b).b;
                if (obj23 != null) {
                    ((p020d0.a) obj23).deleteUsageRecordFailed(i5, str);
                    return;
                }
                return;
        }
    }

    @Override // com.library.base.util.http.CallBack
    public final void success(JsonResult jsonResult) {
        switch (this.f5a) {
            case 0:
                d dVar = (d) this.b;
                b bVar = dVar.e;
                if (bVar != null) {
                    bVar.start();
                }
                Object obj = dVar.b;
                if (obj != null) {
                    ((a) obj).sendCodeSuccess(dVar.getString(p113u.g.text_477));
                    return;
                }
                return;
            case 1:
                Object obj2 = ((f) this.b).b;
                if (obj2 != null) {
                    ((e) obj2).checkCodeSuccess();
                    return;
                }
                return;
            case 2:
                AppBannerDto appBannerDto = (AppBannerDto) jsonResult;
                Object obj3 = ((B.b) this.b).b;
                if (obj3 != null) {
                    ((B.a) obj3).getAppBannerSuccess(appBannerDto.getData());
                    return;
                }
                return;
            case 3:
                Object obj4 = ((C.b) this.b).b;
                if (obj4 != null) {
                    ((C.a) obj4).changePasswordSuccess();
                    return;
                }
                return;
            case 4:
                Object obj5 = ((D.b) this.b).b;
                if (obj5 != null) {
                    ((D.a) obj5).collectUpdateSuccess();
                    return;
                }
                return;
            case 5:
                AppMaterialDto appMaterialDto = (AppMaterialDto) jsonResult;
                Object obj6 = ((E.b) this.b).b;
                if (obj6 != null) {
                    ((E.a) obj6).appMaterialSuccess(appMaterialDto.getData());
                    return;
                }
                return;
            case 6:
                DictDto dictDto = (DictDto) jsonResult;
                Object obj7 = ((g) this.b).b;
                if (obj7 != null) {
                    ((E.f) obj7).getImageDictSuccess(dictDto.getData());
                    return;
                }
                return;
            case 7:
                Object obj8 = ((H.b) this.b).b;
                if (obj8 != null) {
                    ((H.a) obj8).deletePublishLabelSuccess();
                    return;
                }
                return;
            case 8:
                FeedbackDetailDto feedbackDetailDto = (FeedbackDetailDto) jsonResult;
                Object obj9 = ((I.b) this.b).b;
                if (obj9 != null) {
                    ((I.a) obj9).feedBackListSuccess(feedbackDetailDto.getData());
                    return;
                }
                return;
            case 9:
                Object obj10 = ((I.d) this.b).b;
                if (obj10 != null) {
                    ((I.c) obj10).submitFeedbackSuccess();
                    return;
                }
                return;
            case 10:
                TextFontDto textFontDto = (TextFontDto) jsonResult;
                J.b bVar2 = (J.b) this.b;
                if (bVar2.b != null) {
                    Hawk.put("FONT_LIB_DATA", textFontDto.getData());
                    ((J.a) bVar2.b).getAppFontLibSuccess(textFontDto.getData());
                    return;
                }
                return;
            case 11:
                if (((L.a) this.b).b != null) {
                    throw new ClassCastException();
                }
                return;
            case 12:
                M.g.a(((M.e) ((M.d) this.b).b).c, (LoginDto) jsonResult);
                return;
            case 13:
                M.g.a(((M.e) ((M.d) this.b).b).c, (LoginDto) jsonResult);
                return;
            case 14:
                M.g.a(((M.f) this.b).b, (LoginDto) jsonResult);
                return;
            case 15:
                M.g.a(((M.f) this.b).b, (LoginDto) jsonResult);
                return;
            case 16:
                M.g.a((M.g) this.b, (LoginDto) jsonResult);
                return;
            case 17:
                MaterialLibraryTypeDto materialLibraryTypeDto = (MaterialLibraryTypeDto) jsonResult;
                List<MaterialLibraryTypeModel> data = materialLibraryTypeDto.getData();
                if (data != null && data.size() > 0) {
                    data.get(0).setSelect(true);
                }
                Object obj11 = ((P.c) this.b).b;
                if (obj11 != null) {
                    ((P.a) obj11).getMaterialLibraryTypeSuccess(materialLibraryTypeDto.getData());
                    return;
                }
                return;
            case 18:
                Object obj12 = ((Q.b) this.b).b;
                if (obj12 != null) {
                    w.c();
                    ((InvitationNotificationTipDialog) ((Q.a) obj12)).dismiss();
                    return;
                }
                return;
            case 19:
                InviteRecordDto inviteRecordDto = (InviteRecordDto) jsonResult;
                Object obj13 = ((Q.d) this.b).b;
                if (obj13 != null) {
                    ((Q.c) obj13).getInviteRecordListSuccess(inviteRecordDto.getData());
                    return;
                }
                return;
            case 20:
                if (((S.a) this.b).b != null) {
                    throw new ClassCastException();
                }
                return;
            case 21:
                Object obj14 = ((T.e) this.b).b;
                if (obj14 != null) {
                    ((T.d) obj14).printPersonalBiaoqianSuccess();
                    return;
                }
                return;
            case 22:
                Object obj15 = ((U.b) this.b).b;
                if (obj15 != null) {
                    ((U.a) obj15).addOrEditReceiptSuccess();
                    return;
                }
                return;
            case 23:
                Object obj16 = ((V.b) this.b).b;
                if (obj16 != null) {
                    ((V.a) obj16).registerSuccess();
                    return;
                }
                return;
            case 24:
                Object obj17 = ((W.b) this.b).b;
                if (obj17 != null) {
                    ((W.a) obj17).resetPasswordSuccess();
                    return;
                }
                return;
            case 25:
                CloudHeaderDto cloudHeaderDto = (CloudHeaderDto) jsonResult;
                Object obj18 = ((X.e) this.b).b;
                if (obj18 != null) {
                    ((X.d) obj18).cloudHeaderSuccess(cloudHeaderDto.getData());
                    return;
                }
                return;
            case 26:
                Object obj19 = ((j) this.b).b;
                if (obj19 != null) {
                    ((i) obj19).deleteCloudSpaceSuccess();
                    return;
                }
                return;
            case 27:
                Object obj20 = ((l) this.b).b;
                if (obj20 != null) {
                    ((k) obj20).deleteMemberSuccess();
                    return;
                }
                return;
            case 28:
                Object obj21 = ((n) this.b).b;
                if (obj21 != null) {
                    ((m) obj21).editCloudLabelNameSuccess();
                    return;
                }
                return;
            default:
                Object obj22 = ((p020d0.b) this.b).b;
                if (obj22 != null) {
                    ((p020d0.a) obj22).deleteUsageRecordSuccess();
                    return;
                }
                return;
        }
    }
}
