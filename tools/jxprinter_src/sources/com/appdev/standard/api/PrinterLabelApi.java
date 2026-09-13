package com.appdev.standard.api;

import A5.a;
import A5.f;
import A5.o;
import A5.t;
import com.appdev.standard.api.dto.BiaoqianDto;
import com.appdev.standard.api.dto.MaterialLibraryTypeDto;
import com.appdev.standard.api.pto.TemplateElementPto;
import com.appdev.standard.api.pto.UpdateCloudBiaoQianPto;
import com.library.base.util.http.JsonResult;
import retrofit2.InterfaceC1613k;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public interface PrinterLabelApi {
    @f("/api/v1/home/getBiaoqianImg")
    InterfaceC1613k<BiaoqianDto> getBiaoqianImg(@t("materialTypeId") long j6);

    @f("/api/v1/home/getBiaoqianImgType")
    InterfaceC1613k<MaterialLibraryTypeDto> getBiaoqianImgType();

    @o("/api/v1/home/issue")
    InterfaceC1613k<JsonResult> publishTemplatePto(@a TemplateElementPto templateElementPto);

    @o("/api/v1/home/updateCloudBiaoqian")
    InterfaceC1613k<JsonResult> updateCloudBiaoqian(@a UpdateCloudBiaoQianPto updateCloudBiaoQianPto);
}
