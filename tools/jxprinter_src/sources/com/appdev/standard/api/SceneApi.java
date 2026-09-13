package com.appdev.standard.api;

import A5.a;
import A5.f;
import A5.o;
import A5.t;
import com.appdev.standard.api.dto.BooleanResultDto;
import com.appdev.standard.api.dto.CloudHeaderDto;
import com.appdev.standard.api.dto.CloudSpaceCloudLabelDto;
import com.appdev.standard.api.dto.IndustryLabelDto;
import com.appdev.standard.api.dto.MemberDto;
import com.appdev.standard.api.dto.SquareLabelDto;
import com.appdev.standard.api.pto.AddMemberPto;
import com.appdev.standard.api.pto.CollectUpdatePto;
import com.library.base.util.http.JsonResult;
import java.util.Map;
import retrofit2.InterfaceC1613k;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public interface SceneApi {
    @o("/api/v1/scene/addMember")
    InterfaceC1613k<BooleanResultDto> addMember(@a AddMemberPto addMemberPto);

    @f("/api/v1/scene/cloudHeader")
    InterfaceC1613k<CloudHeaderDto> cloudHeader();

    @f("/api/v1/scene/cloudSpaceList")
    InterfaceC1613k<CloudSpaceCloudLabelDto> cloudSpaceCloudLabelList(@t("pageNum") int i5, @t("pageSize") int i6);

    @o("/api/v1/scene/collectUpdate")
    InterfaceC1613k<JsonResult> collectUpdate(@a CollectUpdatePto collectUpdatePto);

    @o("/api/v1/scene/deleteCloudSpace")
    InterfaceC1613k<JsonResult> deleteCloudSpace(@a Map map);

    @o("/api/v1/scene/deleteMember")
    InterfaceC1613k<JsonResult> deleteMember(@a Map map);

    @f("/api/v1/scene/industryTemplateList")
    InterfaceC1613k<IndustryLabelDto> industryTemplateList(@t("keyword") String str, @t("maxWidth") String str2, @t("minWidth") String str3, @t("templateIndustry") String str4, @t("pageNum") int i5, @t("pageSize") int i6, @t("platform") int i7);

    @f("/api/v1/scene/memberList")
    InterfaceC1613k<MemberDto> memberList(@t("pageNum") int i5, @t("pageSize") int i6);

    @f("/api/v1/scene/squareTemplateList")
    InterfaceC1613k<SquareLabelDto> squareTemplateList(@t("keyword") String str, @t("maxWidth") String str2, @t("minWidth") String str3, @t("templateIndustry") String str4, @t("pageNum") int i5, @t("pageSize") int i6);
}
