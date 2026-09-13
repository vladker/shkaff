package com.appdev.standard.api.pto;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class VipPayPto {
    private String discountRate;
    private int payCount;
    private int payType;
    private String price;
    private String vipPackageId;

    public VipPayPto(String str, int i5, int i6, String str2, String str3) {
        this.discountRate = str;
        this.payCount = i5;
        this.payType = i6;
        this.price = str2;
        this.vipPackageId = str3;
    }
}
