package com.appdev.standard.api;

import A5.a;
import A5.f;
import A5.l;
import A5.o;
import A5.q;
import A5.t;
import com.appdev.standard.api.dto.AppMaterialDto;
import com.appdev.standard.api.dto.CheckAccessTokenDto;
import com.appdev.standard.api.dto.CheckAppVersionDto;
import com.appdev.standard.api.dto.DictDto;
import com.appdev.standard.api.dto.TextFontDto;
import com.appdev.standard.api.dto.UploadImageDto;
import com.appdev.standard.api.pto.SendCodePto;
import com.library.base.util.http.JsonResult;
import okhttp3.D;
import retrofit2.InterfaceC1613k;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public interface CommonApi {
    @f("/api/v1/home/appFontLib")
    InterfaceC1613k<TextFontDto> appFontLib();

    @f("/api/v1/home/appMaterial")
    InterfaceC1613k<AppMaterialDto> appMaterial(@t("materialType") String str);

    @o("common/checkAccessToken")
    InterfaceC1613k<CheckAccessTokenDto> checkAccessToken();

    @f("appversion/checkAppVersion")
    InterfaceC1613k<CheckAppVersionDto> checkAppVersion();

    @f("/api/v1/dict/getBqIndustryDict")
    InterfaceC1613k<DictDto> getBqIndustryDict();

    @f("/api/v1/dict/getBqPlazaDict")
    InterfaceC1613k<DictDto> getBqPlazaDict();

    @f("/api/v1/dict/getImageDict")
    InterfaceC1613k<DictDto> getImageDict();

    @o("/api/v1/sms/sendSmsCode")
    InterfaceC1613k<JsonResult> sendCode(@a SendCodePto sendCodePto);

    @o("/api/v1/common/upload")
    @l
    InterfaceC1613k<UploadImageDto> uploadImage(@q D d);

    @f("/api/v1/sms/verifySmsCode")
    InterfaceC1613k<JsonResult> verifySmsCode(@t("accountType") int i5, @t("code") String str, @t("type") int i6, @t("username") String str2);
}
