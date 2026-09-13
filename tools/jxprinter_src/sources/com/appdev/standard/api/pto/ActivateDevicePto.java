package com.appdev.standard.api.pto;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ActivateDevicePto {
    private String deviceType;
    private String deviceUid;
    private String factoryName;
    private boolean isActivate;

    public ActivateDevicePto(String str, String str2, String str3, boolean z6) {
        this.deviceType = str;
        this.deviceUid = str2;
        this.factoryName = str3;
        this.isActivate = z6;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public String getDeviceUid() {
        return this.deviceUid;
    }

    public String getFactoryName() {
        return this.factoryName;
    }

    public boolean isActivate() {
        return this.isActivate;
    }

    public void setActivate(boolean z6) {
        this.isActivate = z6;
    }

    public void setDeviceType(String str) {
        this.deviceType = str;
    }

    public void setDeviceUid(String str) {
        this.deviceUid = str;
    }

    public void setFactoryName(String str) {
        this.factoryName = str;
    }

    public ActivateDevicePto(String str, String str2, String str3) {
        this(str, str2, str3, false);
    }
}
