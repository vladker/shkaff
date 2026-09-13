package com.library.base.util.http;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class JsonResult {
    public String code;
    public String msg;

    public Object getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public boolean isOk() {
        return "200".equals(this.code);
    }
}
