package com.appdev.standard.api;

import A5.a;
import A5.f;
import A5.o;
import A5.t;
import com.appdev.standard.api.dto.AppDeleteReceiptBodyV2;
import com.appdev.standard.api.dto.ReceiptDto;
import com.appdev.standard.model.ReceiptModel;
import com.library.base.util.http.JsonResult;
import retrofit2.InterfaceC1613k;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public interface ReceiptApi {
    @o("/api/v1/home/editReceipt")
    InterfaceC1613k<JsonResult> addOrEditReceipt(@a ReceiptModel receiptModel);

    @o("/api/v1/home/deleteReceiptV2")
    InterfaceC1613k<JsonResult> deleteReceipt(@a AppDeleteReceiptBodyV2 appDeleteReceiptBodyV2);

    @f("/api/v1/home/receiptList")
    InterfaceC1613k<ReceiptDto> receiptList(@t("pageNum") int i5, @t("pageSize") int i6);
}
