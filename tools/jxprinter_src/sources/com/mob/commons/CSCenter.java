package com.mob.commons;

import android.content.pm.PackageInfo;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.ServiceState;
import android.telephony.SubscriptionInfo;
import com.mob.MobCustomController;
import com.mob.tools.proguard.PublicMemberKeeper;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class CSCenter implements PublicMemberKeeper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile CSCenter f3621a;
    private final cn.fly.commons.CSCenter b = cn.fly.commons.CSCenter.getInstance();

    private CSCenter() {
    }

    public static CSCenter getInstance() {
        if (f3621a == null) {
            synchronized (CSCenter.class) {
                try {
                    if (f3621a == null) {
                        f3621a = new CSCenter();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f3621a;
    }

    public int getActiveSubscriptionInfoCount() {
        return this.b.getActiveSubscriptionInfoCount();
    }

    public List<SubscriptionInfo> getActiveSubscriptionInfoList() {
        return this.b.getActiveSubscriptionInfoList();
    }

    public String getAdvertisingId() {
        return this.b.getAdvertisingId();
    }

    public List<CellInfo> getAllCellInfo() {
        return this.b.getAllCellInfo();
    }

    public String getCellIpv4() {
        return this.b.getCellIpv4();
    }

    public String getCellIpv6() {
        return this.b.getCellIpv6();
    }

    public CellLocation getCellLocation() {
        return this.b.getCellLocation();
    }

    public WifiInfo getConnectionInfo() {
        return this.b.getConnectionInfo();
    }

    public String getIpAddress() {
        return this.b.getIpAddress();
    }

    public Location getLocation() {
        return this.b.getLocation();
    }

    public List<NeighboringCellInfo> getNeighboringCellInfo() {
        return this.b.getNeighboringCellInfo();
    }

    public int getNetworkType() {
        return this.b.getNetworkType();
    }

    public String getOaid() {
        return this.b.getOaid();
    }

    public List<PackageInfo> getPackageInfos() {
        return this.b.getPackageInfos();
    }

    public ServiceState getServiceState() {
        return this.b.getServiceState();
    }

    public String getSimOperator() {
        return this.b.getSimOperator();
    }

    public String getSimOperatorName() {
        return this.b.getSimOperatorName();
    }

    public List<ScanResult> getWifiScanResults() {
        return this.b.getWifiScanResults();
    }

    public boolean isAdvertisingIdEnable() {
        return this.b.isAdvertisingIdEnable();
    }

    public boolean isAndroidIdEnable() {
        return this.b.isAndroidIdEnable();
    }

    public boolean isAppListDataEnable() {
        return this.b.isAppListDataEnable();
    }

    public boolean isCellLocationDataEnable() {
        return this.b.isCellLocationDataEnable();
    }

    public boolean isConfigEnable() {
        return this.b.isConfigEnable();
    }

    public boolean isCusControllerNotNull() {
        return this.b.isCusControllerNotNull();
    }

    public boolean isDREnable() {
        return this.b.isDREnable();
    }

    public boolean isIpAddressEnable() {
        return this.b.isIpAddressEnable();
    }

    public boolean isLocationDataEnable() {
        return this.b.isLocationDataEnable();
    }

    public boolean isOaidEnable() {
        return this.b.isOaidEnable();
    }

    public boolean isPhoneStateDataEnable() {
        return this.b.isPhoneStateDataEnable();
    }

    public boolean isSocietyPlatformDataEnable() {
        return this.b.isSocietyPlatformDataEnable();
    }

    public boolean isWifiDataEnable() {
        return this.b.isWifiDataEnable();
    }

    public void updateCustomController(MobCustomController mobCustomController) {
        this.b.updateCustomController(com.mob.a.a(mobCustomController));
    }
}
