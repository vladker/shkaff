package com.appdev.standard.api;

import A5.a;
import A5.f;
import A5.o;
import A5.t;
import com.appdev.standard.api.dto.AppBannerDto;
import com.appdev.standard.api.dto.AppPrintDataAddDto;
import com.appdev.standard.api.dto.BooleanResultDto;
import com.appdev.standard.api.dto.LinkedRecordDto;
import com.appdev.standard.api.dto.PrintPersonalBiaoqianDto;
import com.appdev.standard.api.dto.ScanQrResultDto;
import com.appdev.standard.api.dto.SharedLabelDto;
import com.appdev.standard.api.dto.UpdateBqClouldDto;
import com.appdev.standard.api.dto.UsageRecordDto;
import com.appdev.standard.api.dto.VersionDataDto;
import com.appdev.standard.api.pto.AppPrintDataAddBody;
import com.appdev.standard.api.pto.EditRecordNamePto;
import com.appdev.standard.api.pto.LinkedRecordPto;
import com.appdev.standard.api.pto.UpdateBqClouldPto;
import com.library.base.util.http.JsonResult;
import java.util.Map;
import retrofit2.InterfaceC1613k;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public interface MainApi {
    @o("/api/v1/home/deleteUsageRecord")
    InterfaceC1613k<JsonResult> deleteUsageRecord(@a Map map);

    @o("/api/v1/home/editRecordName")
    InterfaceC1613k<JsonResult> editRecordName(@a EditRecordNamePto editRecordNamePto);

    @f("/api/v1/home/appBanner")
    InterfaceC1613k<AppBannerDto> getAppBanner(@t("environmentPlatform") String str);

    @f("/api/v1/home/getBqCloudShared")
    InterfaceC1613k<SharedLabelDto> getBqCloudShared(@t("id") String str);

    @f("/api/v1/home/getBqShared")
    InterfaceC1613k<SharedLabelDto> getBqShared(@t("id") String str);

    @f("/api/v1/home/getVersionData")
    InterfaceC1613k<VersionDataDto> getVersionData(@t("type") String str);

    @f("/api/v1/home/isJoinTeam")
    InterfaceC1613k<BooleanResultDto> isJoinTeam();

    @o("/api/v1/home/linkedRecord")
    InterfaceC1613k<LinkedRecordDto> linkedRecord(@a LinkedRecordPto linkedRecordPto);

    @o("/api/v1/home/printDataAdd")
    InterfaceC1613k<AppPrintDataAddDto> printDataAdd(@a AppPrintDataAddBody appPrintDataAddBody);

    @f("/api/v1/home/printPersonalBiaoqian")
    InterfaceC1613k<PrintPersonalBiaoqianDto> printPersonalBiaoqian(@t("biaoqianPersonalId") String str);

    @o("/api/v1/home/scanQRCode")
    InterfaceC1613k<ScanQrResultDto> scanQRCode(@a Map map);

    @o("/api/v1/home/updateBqClould")
    InterfaceC1613k<UpdateBqClouldDto> updateBqClould(@a UpdateBqClouldPto updateBqClouldPto);

    @f("/api/v1/home/usageRecordList")
    InterfaceC1613k<UsageRecordDto> usageRecordList();
}
