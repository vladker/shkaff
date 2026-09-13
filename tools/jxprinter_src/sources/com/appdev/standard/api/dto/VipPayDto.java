package com.appdev.standard.api.dto;

import com.library.base.util.http.JsonResult;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class VipPayDto extends JsonResult {
    private DataBean data;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class DataBean {
        private AliPayBean aliPay;
        private GooglePayBean googlePay;
        private WxPayBean wxPay;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static class AliPayBean {
            private String alipay;
            private String orderId;

            public String getAlipay() {
                return this.alipay;
            }

            public String getOrderId() {
                return this.orderId;
            }

            public void setAlipay(String str) {
                this.alipay = str;
            }

            public void setOrderId(String str) {
                this.orderId = str;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static class GooglePayBean {
            private String outTradeNo;
            private String vipPackageId;

            public String getOutTradeNo() {
                return this.outTradeNo;
            }

            public String getVipPackageId() {
                return this.vipPackageId;
            }

            public void setOutTradeNo(String str) {
                this.outTradeNo = str;
            }

            public void setVipPackageId(String str) {
                this.vipPackageId = str;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static class WxPayBean {
            private String appid;
            private String noncestr;
            private String partnerid;
            private String prepayid;
            private String sign;
            private String timestamp;

            public String getAppid() {
                return this.appid;
            }

            public String getNoncestr() {
                return this.noncestr;
            }

            public String getPartnerid() {
                return this.partnerid;
            }

            public String getPrepayid() {
                return this.prepayid;
            }

            public String getSign() {
                return this.sign;
            }

            public String getTimestamp() {
                return this.timestamp;
            }

            public void setAppid(String str) {
                this.appid = str;
            }

            public void setNoncestr(String str) {
                this.noncestr = str;
            }

            public void setPartnerid(String str) {
                this.partnerid = str;
            }

            public void setPrepayid(String str) {
                this.prepayid = str;
            }

            public void setSign(String str) {
                this.sign = str;
            }

            public void setTimestamp(String str) {
                this.timestamp = str;
            }
        }

        public AliPayBean getAliPay() {
            return this.aliPay;
        }

        public GooglePayBean getGooglePay() {
            return this.googlePay;
        }

        public WxPayBean getWxPay() {
            return this.wxPay;
        }

        public void setAliPay(AliPayBean aliPayBean) {
            this.aliPay = aliPayBean;
        }

        public void setGooglePay(GooglePayBean googlePayBean) {
            this.googlePay = googlePayBean;
        }

        public void setWxPay(WxPayBean wxPayBean) {
            this.wxPay = wxPayBean;
        }
    }

    public DataBean getData() {
        return this.data;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }
}
