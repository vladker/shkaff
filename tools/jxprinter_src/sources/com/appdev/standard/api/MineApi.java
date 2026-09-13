package com.appdev.standard.api;

import A5.a;
import A5.f;
import A5.o;
import A5.t;
import com.appdev.standard.api.dto.ActivateDeviceResultDto;
import com.appdev.standard.api.dto.BooleanDto;
import com.appdev.standard.api.dto.DisposeInviteRecordDto;
import com.appdev.standard.api.dto.FeedbackDetailDto;
import com.appdev.standard.api.dto.HelpCenterDto;
import com.appdev.standard.api.dto.InviteRecordDto;
import com.appdev.standard.api.dto.JudgeRankDto;
import com.appdev.standard.api.dto.UserInfoDto;
import com.appdev.standard.api.dto.VipPayDto;
import com.appdev.standard.api.dto.VipPto;
import com.appdev.standard.api.pto.ActivateDevicePto;
import com.appdev.standard.api.pto.DisposeInviteRecordPto;
import com.appdev.standard.api.pto.EditUserNamePto;
import com.appdev.standard.api.pto.FeedbackPto;
import com.appdev.standard.api.pto.GooglePayPto;
import com.appdev.standard.api.pto.VipPayPto;
import com.library.base.util.http.JsonResult;
import java.util.Map;
import retrofit2.InterfaceC1613k;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public interface MineApi {
    @o("/api/v1/newReq/activateDevice")
    InterfaceC1613k<ActivateDeviceResultDto> activateDevice(@a ActivateDevicePto activateDevicePto);

    @f("/api/v1/myInfo/checkPwd")
    InterfaceC1613k<JsonResult> checkPwd(@t("pwd") String str);

    @o("/api/v1/myInfo/disposeInviteRecord")
    InterfaceC1613k<DisposeInviteRecordDto> disposeInviteRecord(@a DisposeInviteRecordPto disposeInviteRecordPto);

    @o("/api/v1/myInfo/editUserName")
    InterfaceC1613k<JsonResult> editUserName(@a EditUserNamePto editUserNamePto);

    @f("/api/v1/myInfo/feedBackList")
    InterfaceC1613k<FeedbackDetailDto> feedBackList();

    @f("/api/v1/myInfo/helpCenter")
    InterfaceC1613k<HelpCenterDto> getHelpCenterList(@t("pageNum") int i5, @t("pageSize") int i6, @t("keyword") String str, @t("platform") int i7);

    @f("/api/v1/newReq/getVip")
    InterfaceC1613k<BooleanDto> getVip(@t("deviceUid") String str);

    @f("/api/v1/myInfo/vip")
    InterfaceC1613k<VipPto> getVipList(@t("pageNum") int i5, @t("pageSize") int i6);

    @o("/api/v1/notify/googleCheckOrder")
    InterfaceC1613k<JsonResult> googlePay(@a GooglePayPto googlePayPto);

    @f("/api/v1/myInfo/inviteRecordList")
    InterfaceC1613k<InviteRecordDto> inviteRecordList();

    @f("/api/v1/myInfo/judgeRank")
    InterfaceC1613k<JudgeRankDto> judgeRank(@t("vipPackageId") String str);

    @o("/api/v1/myInfo/feedBack")
    InterfaceC1613k<JsonResult> submitFeedback(@a FeedbackPto feedbackPto);

    @o("/api/v1/myInfo/editAvatar")
    InterfaceC1613k<JsonResult> updateAvatar(@a Map map);

    @o("/api/v1/myInfo/editNickName")
    InterfaceC1613k<JsonResult> updateNickname(@a Map map);

    @o("/api/v1/myInfo/editPassword")
    InterfaceC1613k<JsonResult> updatePassword(@a Map map);

    @f("/api/v1/myInfo/userInfo")
    InterfaceC1613k<UserInfoDto> userInfo();

    @o("/api/v1/myInfo/vipPay")
    InterfaceC1613k<VipPayDto> vipPay(@a VipPayPto vipPayPto);
}
