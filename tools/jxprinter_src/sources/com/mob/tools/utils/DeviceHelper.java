package com.mob.tools.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.location.Location;
import android.view.View;
import com.mob.tools.proguard.PublicMemberKeeper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DeviceHelper implements PublicMemberKeeper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static DeviceHelper f3672a = new DeviceHelper();
    private volatile Context b;

    public static Object currentActivityThread() {
        return cn.fly.tools.utils.DeviceHelper.currentActivityThread();
    }

    public static synchronized DeviceHelper getInstance(Context context) {
        try {
            if (f3672a.b == null && context != null) {
                f3672a.b = context.getApplicationContext();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f3672a;
    }

    public String Base64AES(String str, String str2) {
        return Data.Base64AES(str, str2);
    }

    public boolean checkNetworkAvailable() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).checkNetworkAvailable();
    }

    public boolean checkPad() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).checkPad();
    }

    public boolean checkPermission(String str) {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).checkPermission(str);
    }

    public boolean checkUA() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).checkUA();
    }

    public boolean cx() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).cx();
    }

    public boolean debugable() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).debugable();
    }

    public boolean devEnable() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).devEnable();
    }

    public ApplicationInfo getAInfo() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getAInfo();
    }

    public HashMap<String, Object> getALLD() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getALLD();
    }

    public String getAdvertisingID() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getAdvertisingID();
    }

    public String getAppLanguage() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getAppLanguage();
    }

    public long getAppLastUpdateTime() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getAppLastUpdateTime();
    }

    public String getAppName() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getAppName();
    }

    public int getAppVersion() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getAppVersion();
    }

    public String getAppVersionName() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getAppVersionName();
    }

    public Context getApplication() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getApplication();
    }

    public ArrayList<HashMap<String, Object>> getAvailableWifiListOneKey() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getAvailableWifiListOneKey();
    }

    public String getBaseband() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getBaseband();
    }

    public String getBoardFromSysProperty() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getBoardFromSysProperty();
    }

    public String getBoardPlatform() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getBoardPlatform();
    }

    public String getBrand() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getBrand();
    }

    public String getBssid() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getBssid();
    }

    public String getCInfo() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getCInfo();
    }

    public HashMap<String, Object> getCPUInfo() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getCPUInfo();
    }

    public String getCarrier() {
        return getCarrier(false);
    }

    public String getCarrierName() {
        return getCarrierName(false);
    }

    public String getCgroup() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getCgroup();
    }

    public String getCurrentProcessName() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getCurrentProcessName();
    }

    public HashMap<String, Object> getCurrentWifiInfo() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getCurrentWifiInfo();
    }

    public int getDataNtType() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getDataNtType();
    }

    public String getDefaultIMPkg() {
        return null;
    }

    public String getDetailNetworkTypeForStatic() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getDetailNetworkTypeForStatic();
    }

    public String getDeviceData() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getDeviceData();
    }

    public String getDeviceDataNotAES() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getDeviceDataNotAES();
    }

    public String getDeviceId() {
        return null;
    }

    public String getDeviceKey() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getDeviceKey();
    }

    public String getDeviceName() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getDeviceName();
    }

    public String getDeviceType() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getDeviceType();
    }

    public String getFlavor() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getFlavor();
    }

    public ArrayList<HashMap<String, String>> getIA(boolean z6) {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getIA(z6);
    }

    public String getIMEI() {
        return null;
    }

    public String getIMSI() {
        return null;
    }

    public String getIPAddress() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getIPAddress();
    }

    public Location getLocation(int i5, int i6, boolean z6) {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getLocation(i5, i6, z6);
    }

    public String getMIUIVersion() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getMIUIVersion();
    }

    public String getManufacturer() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getManufacturer();
    }

    public HashMap<String, Long> getMemoryInfo() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getMemoryInfo();
    }

    public String getModel() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getModel();
    }

    public ArrayList<HashMap<String, Object>> getNeighboringCellInfo() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getNeighboringCellInfo();
    }

    public String getNetworkType() {
        return getNetworkType(false);
    }

    public String getNetworkTypeForStatic() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getNetworkTypeForStatic();
    }

    public String getOD() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getOD();
    }

    public String getODH() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getODH();
    }

    public String getOSCountry() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getOSCountry();
    }

    public String getOSLanguage() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getOSLanguage();
    }

    public int getOSVersionInt() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getOSVersionInt();
    }

    public String getOSVersionName() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getOSVersionName();
    }

    public PackageInfo getPInfo(String str, int i5) {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getPInfo(str, i5);
    }

    public String getPackageName() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getPackageName();
    }

    public int getPlatformCode() {
        return 1;
    }

    public String getQemuKernel() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getQemuKernel();
    }

    public ArrayList<HashMap<String, String>> getSA() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getSA();
    }

    public String getSSID() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getSSID();
    }

    public String getScreenSize() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getScreenSize();
    }

    public String getSdcardPath() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getSdcardPath();
    }

    public boolean getSdcardState() {
        return false;
    }

    public String getSerialno() {
        return null;
    }

    public String getSignMD5() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getSignMD5();
    }

    public String getSimSerialNumber() {
        return null;
    }

    public HashMap<String, HashMap<String, Long>> getSizeInfo() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getSizeInfo();
    }

    public String getSystemProperties(String str) {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getSystemProperties(str);
    }

    public Object getSystemServiceSafe(String str) {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getSystemServiceSafe(str);
    }

    public ArrayList<ArrayList<String>> getTTYDriversInfo() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getTTYDriversInfo();
    }

    public String getTimezone() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getTimezone();
    }

    public Activity getTopActivity() {
        return null;
    }

    public void hideSoftInput(View view) {
        com.mob.commons.a.a(view);
    }

    public <T> T invokeInstanceMethod(Object obj, String str, Object... objArr) {
        return (T) ReflectHelper.invokeInstanceMethodNoThrow(obj, str, null, objArr);
    }

    public boolean isInMainProcess() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).isInMainProcess();
    }

    public boolean isPackageInstalled(String str) {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).isPackageInstalled(str);
    }

    public boolean isRooted() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).isRooted();
    }

    public boolean isWifiProxy() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).isWifiProxy();
    }

    public String[] queryIMEI() {
        return null;
    }

    public String[] queryIMSI() {
        return null;
    }

    public List<ResolveInfo> queryIntentServices(Intent intent, int i5) {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).queryIntentServices(intent, i5);
    }

    public ResolveInfo resolveActivity(Intent intent, int i5) {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).resolveActivity(intent, i5);
    }

    public void showSoftInput(View view) {
        com.mob.commons.a.b(view);
    }

    public boolean usbEnable() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).usbEnable();
    }

    public boolean vpn() {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).vpn();
    }

    public ApplicationInfo getAInfo(String str, int i5) {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getAInfo(str, i5);
    }

    public String getAppName(String str) {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getAppName(str);
    }

    public String getCarrier(boolean z6) {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getCarrier(z6);
    }

    public String getCarrierName(boolean z6) {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getCarrierName(z6);
    }

    public String getDeviceKey(boolean z6) {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getDeviceKey(z6);
    }

    public String getNetworkType(boolean z6) {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getNetworkType(z6);
    }

    public PackageInfo getPInfo(boolean z6, String str, int i5) {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getPInfo(z6, str, i5);
    }

    public String getSignMD5(String str) {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getSignMD5(str);
    }

    public <T> T invokeInstanceMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) {
        return (T) ReflectHelper.invokeInstanceMethod(obj, str, objArr, clsArr, null);
    }

    public ApplicationInfo getAInfo(boolean z6, String str, int i5) {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getAInfo(z6, str, i5);
    }

    public PackageInfo getPInfo(int i5, String str, int i6) {
        return cn.fly.tools.utils.DeviceHelper.getInstance(this.b).getPInfo(i5, str, i6);
    }
}
