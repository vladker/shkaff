package com.appdev.standard.model;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class VipModel implements Serializable {
    private String cloudTagsNumber;
    private String discountRate;
    private boolean isSelect = false;
    private String memberName;
    private String periodOfValidity;
    private String personalTagsNumber;
    private String price;
    private String supportersNumber;
    private String vipExplain;
    private String vipPackageId;

    public String getCloudTagsNumber() {
        return this.cloudTagsNumber;
    }

    public String getDiscountRate() {
        return this.discountRate;
    }

    public String getMemberName() {
        return this.memberName;
    }

    public String getPeriodOfValidity() {
        return this.periodOfValidity;
    }

    public String getPersonalTagsNumber() {
        return this.personalTagsNumber;
    }

    public String getPrice() {
        return this.price;
    }

    public String getSupportersNumber() {
        return this.supportersNumber;
    }

    public String getVipExplain() {
        return this.vipExplain;
    }

    public String getVipPackageId() {
        return this.vipPackageId;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public void setCloudTagsNumber(String str) {
        this.cloudTagsNumber = str;
    }

    public void setDiscountRate(String str) {
        this.discountRate = str;
    }

    public void setMemberName(String str) {
        this.memberName = str;
    }

    public void setPeriodOfValidity(String str) {
        this.periodOfValidity = str;
    }

    public void setPersonalTagsNumber(String str) {
        this.personalTagsNumber = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setSelect(boolean z6) {
        this.isSelect = z6;
    }

    public void setSupportersNumber(String str) {
        this.supportersNumber = str;
    }

    public void setVipExplain(String str) {
        this.vipExplain = str;
    }

    public void setVipPackageId(String str) {
        this.vipPackageId = str;
    }
}
