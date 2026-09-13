package com.appdev.standard.api;

import A5.a;
import A5.f;
import A5.l;
import A5.o;
import A5.q;
import A5.t;
import A5.w;
import A5.y;
import com.appdev.standard.api.dto.AppMyDocResp;
import com.appdev.standard.api.dto.BiaoQianMyLabelDocResp;
import com.appdev.standard.api.dto.CollectLabelDto;
import com.appdev.standard.api.dto.ConvertDto;
import com.appdev.standard.api.dto.DelMyDocBodyV2;
import com.library.base.util.http.JsonResult;
import java.util.Map;
import okhttp3.D;
import okhttp3.Q;
import okhttp3.W;
import retrofit2.InterfaceC1613k;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public interface DocumentApi {
    @f("/api/v1/doc/myCollectDoc")
    InterfaceC1613k<CollectLabelDto> collectLabel(@t("pageNum") int i5, @t("pageSize") int i6);

    @o("/api/v1/doc/convert")
    @l
    InterfaceC1613k<ConvertDto> convert(@q D d, @q("description") Q q6);

    @o("/api/v1/doc/delMyDocV2")
    InterfaceC1613k<JsonResult> deleteMineLabel(@a DelMyDocBodyV2 delMyDocBodyV2);

    @o("/api/v1/doc/delMyIssue")
    InterfaceC1613k<JsonResult> deletePublishLabel(@a Map map);

    @f
    @w
    InterfaceC1613k<W> downloadFile(@y String str);

    @o("/api/v1/doc/insertJxAppPrintLog")
    InterfaceC1613k<JsonResult> insertJxAppPrintLog(@a Map map);

    @f("/api/v1/doc/getMyLabelDoc")
    InterfaceC1613k<BiaoQianMyLabelDocResp> mineLabel(@t("keyword") String str, @t("pageNum") int i5, @t("pageSize") int i6, @t("width") Integer num, @t("height") Integer num2);

    @f("/api/v1/doc/myDoc")
    InterfaceC1613k<AppMyDocResp> myDoc(@t("pageNum") int i5, @t("pageSize") int i6);

    @f("/api/v1/doc/myIssueDoc")
    InterfaceC1613k<CollectLabelDto> publishLabel(@t("pageNum") int i5, @t("pageSize") int i6);
}
