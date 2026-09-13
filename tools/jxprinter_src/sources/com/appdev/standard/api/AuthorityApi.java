package com.appdev.standard.api;

import A5.a;
import A5.c;
import A5.e;
import A5.f;
import A5.o;
import com.appdev.standard.api.dto.LoginDto;
import com.appdev.standard.api.dto.LogoffDto;
import com.appdev.standard.api.dto.LogoutDto;
import com.appdev.standard.api.pto.ActivateDevicePto;
import com.appdev.standard.api.pto.FaceBookLoginPto;
import com.appdev.standard.api.pto.GoogleLoginPto;
import com.appdev.standard.api.pto.LoginPto;
import com.appdev.standard.api.pto.RegisterPto;
import com.appdev.standard.api.pto.ResetPasswordPto;
import com.appdev.standard.api.pto.TwitterLoginPto;
import com.appdev.standard.api.pto.WxLoginPto;
import com.library.base.util.http.JsonResult;
import retrofit2.InterfaceC1613k;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public interface AuthorityApi {
    @o("/api/v1/auth/login")
    InterfaceC1613k<LoginDto> doLogin(@a LoginPto loginPto);

    @o("/api/v1/auth/faceBookLogin")
    InterfaceC1613k<LoginDto> faceBookLogin(@a FaceBookLoginPto faceBookLoginPto);

    @o("/api/v1/newReq/fastLoginQR")
    InterfaceC1613k<LoginDto> fastLoginQR(@a ActivateDevicePto activateDevicePto);

    @o("/api/v1/auth/fastLoginWeChat")
    InterfaceC1613k<LoginDto> fastLoginWeChat(@a WxLoginPto wxLoginPto);

    @e
    @o("login/fasterLogin")
    InterfaceC1613k<LoginDto> fasterLogin(@c("openId") String str, @c("type") int i5, @c("avatar") String str2);

    @f("/api/v1/auth/logOff")
    InterfaceC1613k<LogoffDto> logOff();

    @f("/api/v1/auth/logOut")
    InterfaceC1613k<LogoutDto> logOut();

    @o("/api/v1/auth/loginByGoogle")
    InterfaceC1613k<LoginDto> loginByGoogle(@a GoogleLoginPto googleLoginPto);

    @o("/api/v1/auth/register")
    InterfaceC1613k<JsonResult> register(@a RegisterPto registerPto);

    @o("/api/v1/auth/reset/password")
    InterfaceC1613k<JsonResult> resetPassword(@a ResetPasswordPto resetPasswordPto);

    @o("/api/v1/auth/twitterLogin")
    InterfaceC1613k<LoginDto> twitterLogin(@a TwitterLoginPto twitterLoginPto);
}
