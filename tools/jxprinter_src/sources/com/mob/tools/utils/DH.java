package com.mob.tools.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.location.Location;
import android.view.View;
import com.mob.tools.MobLog;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class DH {

    public interface DHResponder {
        void onResponse(DHResponse dHResponse);
    }

    public static class RequestBuilder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final cn.fly.tools.utils.DH.RequestBuilder f3670a;

        public RequestBuilder checkDebbing() {
            this.f3670a.checkDebbing();
            return this;
        }

        public RequestBuilder checkNetworkAvailable() {
            this.f3670a.checkNetworkAvailable();
            return this;
        }

        public RequestBuilder checkPad() {
            this.f3670a.checkPad();
            return this;
        }

        public RequestBuilder checkUA() {
            this.f3670a.checkUA();
            return this;
        }

        public RequestBuilder cx() {
            this.f3670a.cx();
            return this;
        }

        public RequestBuilder debugable() {
            this.f3670a.debugable();
            return this;
        }

        public RequestBuilder devEnable() {
            this.f3670a.devEnable();
            return this;
        }

        public RequestBuilder getACIfo() {
            this.f3670a.getACIfo();
            return this;
        }

        public RequestBuilder getAInfo() {
            this.f3670a.getAInfo();
            return this;
        }

        public RequestBuilder getAInfoForPkg(String str, int i5) {
            this.f3670a.getAInfoForPkg(str, i5);
            return this;
        }

        public RequestBuilder getAInfoForPkgForce(boolean z6, String str, int i5) {
            this.f3670a.getAInfoForPkgForce(z6, str, i5);
            return this;
        }

        public RequestBuilder getALLD() {
            this.f3670a.getALLD();
            return this;
        }

        public RequestBuilder getAbis() {
            this.f3670a.getAbis();
            return this;
        }

        public RequestBuilder getAdvertisingID() {
            this.f3670a.getAdvertisingID();
            return this;
        }

        public RequestBuilder getAppLastUpdateTime() {
            this.f3670a.getAppLastUpdateTime();
            return this;
        }

        public RequestBuilder getAppName() {
            this.f3670a.getAppName();
            return this;
        }

        public RequestBuilder getAppNameForPkg(String str) {
            this.f3670a.getAppNameForPkg(str);
            return this;
        }

        public RequestBuilder getBaseband() {
            this.f3670a.getBaseband();
            return this;
        }

        public RequestBuilder getBdT() {
            this.f3670a.getBdT();
            return this;
        }

        public RequestBuilder getBoardFromSysProperty() {
            this.f3670a.getBoardFromSysProperty();
            return this;
        }

        public RequestBuilder getBoardPlatform() {
            this.f3670a.getBoardPlatform();
            return this;
        }

        public RequestBuilder getBssid() {
            this.f3670a.getBssid();
            return this;
        }

        public RequestBuilder getBssidForce(boolean z6) {
            this.f3670a.getBssidForce(z6);
            return this;
        }

        public RequestBuilder getCInfo() {
            this.f3670a.getCInfo();
            return this;
        }

        public RequestBuilder getCLoc() {
            this.f3670a.getCLoc();
            return this;
        }

        public RequestBuilder getCPUInfo() {
            this.f3670a.getCPUInfo();
            return this;
        }

        public RequestBuilder getCarrier() {
            this.f3670a.getCarrier();
            return this;
        }

        public RequestBuilder getCarrierForce(boolean z6) {
            this.f3670a.getCarrierForce(z6);
            return this;
        }

        public RequestBuilder getCarrierName() {
            this.f3670a.getCarrierName();
            return this;
        }

        public RequestBuilder getCarrierNameForce(boolean z6) {
            this.f3670a.getCarrierNameForce(z6);
            return this;
        }

        public RequestBuilder getCarrierNameStrict(boolean z6) {
            this.f3670a.getCarrierNameStrict(z6);
            return this;
        }

        public RequestBuilder getCarrierStrict(boolean z6) {
            this.f3670a.getCarrierStrict(z6);
            return this;
        }

        public RequestBuilder getCgroup() {
            this.f3670a.getCgroup();
            return this;
        }

        public RequestBuilder getCurrentWifiInfo() {
            this.f3670a.getCurrentWifiInfo();
            return this;
        }

        public RequestBuilder getDM(boolean z6) {
            this.f3670a.getDM(z6);
            return this;
        }

        public RequestBuilder getDataNtType() {
            this.f3670a.getDataNtType();
            return this;
        }

        public RequestBuilder getDataNtTypeStrict() {
            this.f3670a.getDataNtTypeStrict();
            return this;
        }

        public RequestBuilder getDetailNetworkTypeForStatic() {
            this.f3670a.getDetailNetworkTypeForStatic();
            return this;
        }

        public RequestBuilder getDeviceData() {
            this.f3670a.getDeviceData();
            return this;
        }

        public RequestBuilder getDeviceDataNotAES() {
            this.f3670a.getDeviceDataNotAES();
            return this;
        }

        public RequestBuilder getDeviceKey() {
            this.f3670a.getDeviceKey();
            return this;
        }

        public RequestBuilder getDeviceKeyFromCache(boolean z6) {
            this.f3670a.getDeviceKeyFromCache(z6);
            return this;
        }

        public RequestBuilder getDeviceName() {
            this.f3670a.getDeviceName();
            return this;
        }

        public RequestBuilder getDeviceType() {
            this.f3670a.getDeviceType();
            return this;
        }

        public RequestBuilder getDrID() {
            this.f3670a.getDrID();
            return this;
        }

        public RequestBuilder getFlavor() {
            this.f3670a.getFlavor();
            return this;
        }

        public RequestBuilder getGrammaticalGender() {
            this.f3670a.getGrammaticalGender();
            return this;
        }

        public RequestBuilder getHmEPMState() {
            this.f3670a.getHmEPMState();
            return this;
        }

        public RequestBuilder getHmOsDetailedVer() {
            this.f3670a.getHmOsDetailedVer();
            return this;
        }

        public RequestBuilder getHmOsVer() {
            this.f3670a.getHmOsVer();
            return this;
        }

        public RequestBuilder getHmPMState() {
            this.f3670a.getHmPMState();
            return this;
        }

        public RequestBuilder getIA(boolean z6) {
            this.f3670a.getIA(z6);
            return this;
        }

        public RequestBuilder getIAForce(boolean z6, boolean z7) {
            this.f3670a.getIAForce(z6, z7);
            return this;
        }

        public RequestBuilder getIPAddress() {
            this.f3670a.getIPAddress();
            return this;
        }

        public RequestBuilder getIPAddressStrict() {
            this.f3670a.getIPAddressStrict();
            return this;
        }

        public RequestBuilder getInnerAppLanguage() {
            this.f3670a.getInnerAppLanguage();
            return this;
        }

        public RequestBuilder getLATime(String str) {
            this.f3670a.getLATime(str);
            return this;
        }

        public RequestBuilder getLocation(int i5, int i6, boolean z6) {
            this.f3670a.getLocation(i5, i6, z6);
            return this;
        }

        public RequestBuilder getMIUIVersion() {
            this.f3670a.getMIUIVersion();
            return this;
        }

        public RequestBuilder getMbcdi() {
            this.f3670a.getMbcdi();
            return this;
        }

        public RequestBuilder getMbcdiForce(boolean z6) {
            this.f3670a.getMbcdiForce(z6);
            return this;
        }

        public RequestBuilder getMcdi() {
            this.f3670a.getMcdi();
            return this;
        }

        public RequestBuilder getMcdiForce(boolean z6) {
            this.f3670a.getMcdiForce(z6);
            return this;
        }

        public RequestBuilder getMemoryInfo() {
            this.f3670a.getMemoryInfo();
            return this;
        }

        public RequestBuilder getMnbclfo() {
            this.f3670a.getMnbclfo();
            return this;
        }

        public RequestBuilder getMpfo(String str, int i5) {
            this.f3670a.getMpfo(str, i5);
            return this;
        }

        public RequestBuilder getMpfof(boolean z6, String str, int i5) {
            this.f3670a.getMpfof(z6, str, i5);
            return this;
        }

        public RequestBuilder getMpfos(int i5, String str, int i6) {
            this.f3670a.getMpfos(i5, str, i6);
            return this;
        }

        public RequestBuilder getMwfo() {
            this.f3670a.getMwfo();
            return this;
        }

        public RequestBuilder getMwfoForce(boolean z6) {
            this.f3670a.getMwfoForce(z6);
            return this;
        }

        public RequestBuilder getMwlfo() {
            this.f3670a.getMwlfo();
            return this;
        }

        public RequestBuilder getNeighboringCellInfo() {
            this.f3670a.getNeighboringCellInfo();
            return this;
        }

        @Deprecated
        public RequestBuilder getNetworkType() {
            this.f3670a.getNetworkType();
            return this;
        }

        public RequestBuilder getNetworkTypeForStatic() {
            this.f3670a.getNetworkTypeForStatic();
            return this;
        }

        public RequestBuilder getNetworkTypeForce(boolean z6) {
            this.f3670a.getNetworkTypeForce(z6);
            return this;
        }

        public RequestBuilder getNetworkTypeNew() {
            this.f3670a.getNetworkTypeNew();
            return this;
        }

        public RequestBuilder getOD() {
            this.f3670a.getOD();
            return this;
        }

        public RequestBuilder getODH() {
            this.f3670a.getODH();
            return this;
        }

        public RequestBuilder getPInfo(String str, int i5) {
            this.f3670a.getPInfo(str, i5);
            return this;
        }

        public RequestBuilder getPInfoForce(boolean z6, String str, int i5) {
            this.f3670a.getPInfoForce(z6, str, i5);
            return this;
        }

        public RequestBuilder getPInfoStrategy(int i5, String str, int i6) {
            this.f3670a.getPInfoStrategy(i5, str, i6);
            return this;
        }

        public RequestBuilder getPPL(boolean z6) {
            this.f3670a.getPPL(z6);
            return this;
        }

        public RequestBuilder getPosCommForce(int i5, int i6, boolean z6, boolean z7) {
            this.f3670a.getPosCommForce(i5, i6, z6, z7);
            return this;
        }

        public RequestBuilder getQemuKernel() {
            this.f3670a.getQemuKernel();
            return this;
        }

        public RequestBuilder getRd() {
            this.f3670a.getRd();
            return this;
        }

        public RequestBuilder getSA() {
            this.f3670a.getSA();
            return this;
        }

        public RequestBuilder getSSID() {
            this.f3670a.getSSID();
            return this;
        }

        public RequestBuilder getSSIDForce(boolean z6) {
            this.f3670a.getSSIDForce(z6);
            return this;
        }

        public RequestBuilder getScreenInch() {
            this.f3670a.getScreenInch();
            return this;
        }

        public RequestBuilder getScreenPpi() {
            this.f3670a.getScreenPpi();
            return this;
        }

        public RequestBuilder getScreenSize() {
            this.f3670a.getScreenSize();
            return this;
        }

        public RequestBuilder getSecurePch() {
            this.f3670a.getSecurePch();
            return this;
        }

        public RequestBuilder getSignMD5() {
            this.f3670a.getSignMD5();
            return this;
        }

        public RequestBuilder getSignMD5ForPkg(String str) {
            this.f3670a.getSignMD5ForPkg(str);
            return this;
        }

        public RequestBuilder getSizeInfo() {
            this.f3670a.getSizeInfo();
            return this;
        }

        public RequestBuilder getSystemProperties(String str) {
            this.f3670a.getSystemProperties(str);
            return this;
        }

        public RequestBuilder getTTYDriversInfo() {
            this.f3670a.getTTYDriversInfo();
            return this;
        }

        public RequestBuilder isHmOs() {
            this.f3670a.isHmOs();
            return this;
        }

        public RequestBuilder isMwpy() {
            this.f3670a.isMwpy();
            return this;
        }

        public RequestBuilder isPackageInstalled(String str) {
            this.f3670a.isPackageInstalled(str);
            return this;
        }

        public RequestBuilder isRooted() {
            this.f3670a.isRooted();
            return this;
        }

        public RequestBuilder isWifiProxy() {
            this.f3670a.isWifiProxy();
            return this;
        }

        public RequestBuilder queryIntentServices(Intent intent, int i5) {
            this.f3670a.queryIntentServices(intent, i5);
            return this;
        }

        public void request(final DHResponder dHResponder) {
            this.f3670a.request(new cn.fly.tools.utils.DH.DHResponder() { // from class: com.mob.tools.utils.DH.RequestBuilder.1
                @Override // cn.fly.tools.utils.DH.DHResponder
                public void onResponse(cn.fly.tools.utils.DH.DHResponse dHResponse) {
                    dHResponder.onResponse(DHResponse.a(dHResponse));
                }
            });
        }

        public RequestBuilder resolveActivity(Intent intent, int i5) {
            this.f3670a.resolveActivity(intent, i5);
            return this;
        }

        public RequestBuilder usbEnable() {
            this.f3670a.usbEnable();
            return this;
        }

        public RequestBuilder vpn() {
            this.f3670a.vpn();
            return this;
        }

        private RequestBuilder(Context context) {
            this.f3670a = cn.fly.tools.utils.DH.requester(context);
        }

        public RequestBuilder getBtM() {
            return this;
        }

        public RequestBuilder getDeviceId() {
            return this;
        }

        public RequestBuilder getIMEI() {
            return this;
        }

        public RequestBuilder getIMSI() {
            return this;
        }

        public RequestBuilder getSdcardState() {
            return this;
        }

        public RequestBuilder getSerialno() {
            return this;
        }

        public RequestBuilder getSimSerialNumber() {
            return this;
        }

        public RequestBuilder getTopActivity() {
            return this;
        }

        public RequestBuilder getUpM() {
            return this;
        }

        public RequestBuilder queryIMEI() {
            return this;
        }

        public RequestBuilder queryIMSI() {
            return this;
        }
    }

    public static final class SyncMtd {
        public static String Base64AES(String str, String str2) {
            return Data.Base64AES(str, str2);
        }

        public static boolean checkPermission(String str) {
            return cn.fly.tools.utils.DH.SyncMtd.checkPermission(str);
        }

        public static Object currentActivityThread() {
            return cn.fly.tools.utils.DH.SyncMtd.currentActivityThread();
        }

        public static String getAppLanguage() {
            return cn.fly.tools.utils.DH.SyncMtd.getAppLanguage();
        }

        public static int getAppVersion() {
            return cn.fly.tools.utils.DH.SyncMtd.getAppVersion();
        }

        public static String getAppVersionName() {
            return cn.fly.tools.utils.DH.SyncMtd.getAppVersionName();
        }

        public static Context getApplication() {
            return cn.fly.tools.utils.DH.SyncMtd.getApplication();
        }

        public static String getBrand() {
            return cn.fly.tools.utils.DH.SyncMtd.getBrand();
        }

        public static String getCurrentProcessName() {
            return cn.fly.tools.utils.DH.SyncMtd.getCurrentProcessName();
        }

        public static String getManufacturer() {
            return cn.fly.tools.utils.DH.SyncMtd.getManufacturer();
        }

        public static String getModel() {
            return cn.fly.tools.utils.DH.SyncMtd.getModel();
        }

        public static String getOSCountry() {
            return cn.fly.tools.utils.DH.SyncMtd.getOSCountry();
        }

        public static String getOSLanguage() {
            return cn.fly.tools.utils.DH.SyncMtd.getOSLanguage();
        }

        public static int getOSVersionInt() {
            return cn.fly.tools.utils.DH.SyncMtd.getOSVersionInt();
        }

        public static String getOSVersionName() {
            return cn.fly.tools.utils.DH.SyncMtd.getOSVersionName();
        }

        public static String getPackageName() {
            return cn.fly.tools.utils.DH.SyncMtd.getPackageName();
        }

        public static int getPlatformCode() {
            return 1;
        }

        public static String getSandboxPath() {
            return cn.fly.tools.utils.DH.SyncMtd.getSandboxPath();
        }

        public static String getSystemProperties(String str) {
            return cn.fly.tools.utils.DH.SyncMtd.getSystemProperties(str);
        }

        public static Object getSystemServiceSafe(String str) {
            return cn.fly.tools.utils.DH.SyncMtd.getSystemServiceSafe(str);
        }

        public static String getTimezone() {
            return cn.fly.tools.utils.DH.SyncMtd.getTimezone();
        }

        public static void hideSoftInput(View view) {
            cn.fly.tools.utils.DH.SyncMtd.hideSoftInput(view);
        }

        public static <T> T invokeInstanceMethod(Object obj, String str, Object... objArr) {
            return (T) ReflectHelper.invokeInstanceMethodNoThrow(obj, str, null, objArr);
        }

        public static boolean isAut() {
            return cn.fly.tools.utils.DH.SyncMtd.isAut();
        }

        public static boolean isInMainProcess() {
            return cn.fly.tools.utils.DH.SyncMtd.isInMainProcess();
        }

        public static boolean isSupportPushRid() {
            return true;
        }

        public static void showSoftInput(View view) {
            cn.fly.tools.utils.DH.SyncMtd.showSoftInput(view);
        }

        public static <T> T invokeInstanceMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) {
            try {
                return (T) ReflectHelper.invokeInstanceMethod(obj, str, objArr, clsArr);
            } catch (Throwable th) {
                if (th instanceof InvocationTargetException) {
                    String name = th.getClass().getName();
                    String message = th.getMessage();
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        name = cause.getClass().getName();
                        message = cause.getMessage();
                    }
                    MobLog.getInstance().d(androidx.exifinterface.media.a.m("Exception: ", name, ": ", message), new Object[0]);
                    return null;
                }
                if (!(th instanceof PackageManager.NameNotFoundException)) {
                    MobLog.getInstance().d(th);
                    return null;
                }
                MobLog.getInstance().d("Exception: " + th.getClass().getName() + ": " + th.getMessage(), new Object[0]);
                return null;
            }
        }
    }

    public static RequestBuilder requester(Context context) {
        return new RequestBuilder(context);
    }

    public static class DHResponse {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final cn.fly.tools.utils.DH.DHResponse f3669a;

        public DHResponse() {
            this.f3669a = new cn.fly.tools.utils.DH.DHResponse();
        }

        public static DHResponse a(cn.fly.tools.utils.DH.DHResponse dHResponse) {
            return new DHResponse(dHResponse);
        }

        public boolean checkDebbing() {
            return this.f3669a.checkDebbing();
        }

        public boolean checkNetworkAvailable() {
            return this.f3669a.checkNetworkAvailable();
        }

        public boolean checkPad() {
            return this.f3669a.checkPad();
        }

        public boolean checkUA() {
            return this.f3669a.checkUA();
        }

        public boolean cx() {
            return this.f3669a.cx();
        }

        public boolean debugable() {
            return this.f3669a.debugable();
        }

        public boolean devEnable() {
            return this.f3669a.devEnable();
        }

        public ArrayList<HashMap<String, Object>> getACIfo() {
            return this.f3669a.getACIfo();
        }

        public ApplicationInfo getAInfo() {
            return this.f3669a.getAInfo();
        }

        public ApplicationInfo getAInfoForPkg(int... iArr) {
            return this.f3669a.getAInfoForPkg(iArr);
        }

        public ApplicationInfo getAInfoForPkgForce(int... iArr) {
            return this.f3669a.getAInfoForPkgForce(iArr);
        }

        public HashMap<String, Object> getALLD() {
            return this.f3669a.getALLD();
        }

        public String getAbis() {
            return this.f3669a.getAbis();
        }

        public String getAdvertisingID() {
            return this.f3669a.getAdvertisingID();
        }

        public long getAppLastUpdateTime() {
            return this.f3669a.getAppLastUpdateTime();
        }

        public String getAppName() {
            return this.f3669a.getAppName();
        }

        public String getAppNameForPkg(int... iArr) {
            return this.f3669a.getAppNameForPkg(iArr);
        }

        public String getBaseband() {
            return this.f3669a.getBaseband();
        }

        public long getBdT() {
            return this.f3669a.getBdT();
        }

        public String getBoardFromSysProperty() {
            return this.f3669a.getBoardFromSysProperty();
        }

        public String getBoardPlatform() {
            return this.f3669a.getBoardPlatform();
        }

        public String getBssid() {
            return this.f3669a.getBssid();
        }

        public String getBssidForce(int... iArr) {
            return this.f3669a.getBssidForce(iArr);
        }

        public String getBtM() {
            return this.f3669a.getBtM();
        }

        public String getCInfo() {
            return this.f3669a.getCInfo();
        }

        public Object getCLoc() {
            return this.f3669a.getCLoc();
        }

        public HashMap<String, Object> getCPUInfo() {
            return this.f3669a.getCPUInfo();
        }

        public String getCarrier() {
            return this.f3669a.getCarrier();
        }

        public String getCarrierForce(int... iArr) {
            return this.f3669a.getCarrierForce(iArr);
        }

        public String getCarrierName() {
            return this.f3669a.getCarrierName();
        }

        public String getCarrierNameForce(int... iArr) {
            return this.f3669a.getCarrierNameForce(iArr);
        }

        public String getCarrierNameStrict(int... iArr) {
            return this.f3669a.getCarrierNameStrict(iArr);
        }

        public String getCarrierStrict(int... iArr) {
            return this.f3669a.getCarrierStrict(iArr);
        }

        public String getCgroup() {
            return this.f3669a.getCgroup();
        }

        public HashMap<String, Object> getCurrentWifiInfo() {
            return this.f3669a.getCurrentWifiInfo();
        }

        public String getDM() {
            return this.f3669a.getDM();
        }

        public int getDataNtType() {
            return this.f3669a.getDataNtType();
        }

        public int getDataNtTypeStrict() {
            return this.f3669a.getDataNtTypeStrict();
        }

        public String getDetailNetworkTypeForStatic() {
            return this.f3669a.getDetailNetworkTypeForStatic();
        }

        public String getDeviceData() {
            return this.f3669a.getDeviceData();
        }

        public String getDeviceDataNotAES() {
            return this.f3669a.getDeviceDataNotAES();
        }

        public String getDeviceId() {
            return null;
        }

        public String getDeviceKey() {
            return this.f3669a.getDeviceKey();
        }

        public String getDeviceKeyFromCache(int... iArr) {
            return this.f3669a.getDeviceKeyFromCache(iArr);
        }

        public String getDeviceName() {
            return this.f3669a.getDeviceName();
        }

        public String getDeviceType() {
            return this.f3669a.getDeviceType();
        }

        public String getDrID() {
            return this.f3669a.getDrID();
        }

        public String getFlavor() {
            return this.f3669a.getFlavor();
        }

        public int getGrammaticalGender() {
            return this.f3669a.getGrammaticalGender();
        }

        public int getHmEPMState() {
            return this.f3669a.getHmEPMState();
        }

        public String getHmOsDetailedVer() {
            return this.f3669a.getHmOsDetailedVer();
        }

        public String getHmOsVer() {
            return this.f3669a.getHmOsVer();
        }

        public int getHmPMState() {
            return this.f3669a.getHmPMState();
        }

        public ArrayList<HashMap<String, String>> getIA(int... iArr) {
            return this.f3669a.getIA(iArr);
        }

        public ArrayList<HashMap<String, String>> getIAForce(int... iArr) {
            return this.f3669a.getIAForce(iArr);
        }

        public String getIMEI() {
            return null;
        }

        public String getIMSI() {
            return null;
        }

        public String getIPAddress() {
            return this.f3669a.getIPAddress();
        }

        public String getIPAddressStrict() {
            return this.f3669a.getIPAddressStrict();
        }

        public String getInnerAppLanguage() {
            return this.f3669a.getInnerAppLanguage();
        }

        public long getLATime(int... iArr) {
            return this.f3669a.getLATime(iArr);
        }

        public Location getLocation(int... iArr) {
            return this.f3669a.getLocation(iArr);
        }

        public String getMIUIVersion() {
            return this.f3669a.getMIUIVersion();
        }

        public String getMbcdi() {
            return this.f3669a.getMbcdi();
        }

        public String getMbcdiForce(int... iArr) {
            return this.f3669a.getMbcdiForce(iArr);
        }

        public String getMcdi() {
            return this.f3669a.getMcdi();
        }

        public String getMcdiForce(int... iArr) {
            return this.f3669a.getMcdiForce(iArr);
        }

        public HashMap<String, Long> getMemoryInfo() {
            return this.f3669a.getMemoryInfo();
        }

        public ArrayList<HashMap<String, Object>> getMnbclfo() {
            return this.f3669a.getMnbclfo();
        }

        public Object getMpfo(int... iArr) {
            return this.f3669a.getMpfo(iArr);
        }

        public Object getMpfof(int... iArr) {
            return this.f3669a.getMpfof(iArr);
        }

        public Object getMpfos(int... iArr) {
            return this.f3669a.getMpfos(iArr);
        }

        public HashMap<String, Object> getMwfo() {
            return this.f3669a.getMwfo();
        }

        public HashMap<String, Object> getMwfoForce(int... iArr) {
            return this.f3669a.getMwfoForce(iArr);
        }

        public ArrayList<HashMap<String, Object>> getMwlfo() {
            return this.f3669a.getMwlfo();
        }

        public ArrayList<HashMap<String, Object>> getNeighboringCellInfo() {
            return this.f3669a.getNeighboringCellInfo();
        }

        public String getNetworkType() {
            return this.f3669a.getNetworkType();
        }

        public String getNetworkTypeForStatic() {
            return this.f3669a.getNetworkTypeForStatic();
        }

        public String getNetworkTypeForce(int... iArr) {
            return this.f3669a.getNetworkTypeForce(iArr);
        }

        public String getNetworkTypeNew() {
            return this.f3669a.getNetworkTypeNew();
        }

        public String getOD() {
            return this.f3669a.getOD();
        }

        public String getODH() {
            return this.f3669a.getODH();
        }

        public PackageInfo getPInfo(int... iArr) {
            return this.f3669a.getPInfo(iArr);
        }

        public PackageInfo getPInfoForce(int... iArr) {
            return this.f3669a.getPInfoForce(iArr);
        }

        public PackageInfo getPInfoStrategy(int... iArr) {
            return this.f3669a.getPInfoStrategy(iArr);
        }

        public Set<String> getPPL(int... iArr) {
            return this.f3669a.getPPL(iArr);
        }

        public List<HashMap<String, Object>> getPosCommForce(int... iArr) {
            return this.f3669a.getPosCommForce(iArr);
        }

        public String getQemuKernel() {
            return this.f3669a.getQemuKernel();
        }

        public String getRd() {
            return this.f3669a.getRd();
        }

        public ArrayList<HashMap<String, String>> getSA() {
            return this.f3669a.getSA();
        }

        public String getSSID() {
            return this.f3669a.getSSID();
        }

        public String getSSIDForce(int... iArr) {
            return this.f3669a.getSSIDForce(iArr);
        }

        public double getScreenInch() {
            return this.f3669a.getScreenInch();
        }

        public int getScreenPpi() {
            return this.f3669a.getScreenPpi();
        }

        public String getScreenSize() {
            return this.f3669a.getScreenSize();
        }

        public boolean getSdcardState() {
            return false;
        }

        public String getSecurePch() {
            return this.f3669a.getSecurePch();
        }

        public String getSerialno() {
            return null;
        }

        public String getSignMD5() {
            return this.f3669a.getSignMD5();
        }

        public String getSignMD5ForPkg(int... iArr) {
            return this.f3669a.getSignMD5ForPkg(iArr);
        }

        public String getSimSerialNumber() {
            return null;
        }

        public HashMap<String, HashMap<String, Long>> getSizeInfo() {
            return this.f3669a.getSizeInfo();
        }

        public String getSystemProperties(int... iArr) {
            return this.f3669a.getSystemProperties(iArr);
        }

        public ArrayList<ArrayList<String>> getTTYDriversInfo() {
            return this.f3669a.getTTYDriversInfo();
        }

        public Activity getTopActivity() {
            return null;
        }

        public String getUpM() {
            return this.f3669a.getUpM();
        }

        public boolean isHmOs() {
            return this.f3669a.isHmOs();
        }

        public boolean isMwpy() {
            return this.f3669a.isMwpy();
        }

        public boolean isPackageInstalled(int... iArr) {
            return this.f3669a.isPackageInstalled(iArr);
        }

        public boolean isRooted() {
            return this.f3669a.isRooted();
        }

        public boolean isWifiProxy() {
            return this.f3669a.isWifiProxy();
        }

        public String[] queryIMEI() {
            return null;
        }

        public String[] queryIMSI() {
            return null;
        }

        public List<ResolveInfo> queryIntentServices(int... iArr) {
            return this.f3669a.queryIntentServices(iArr);
        }

        public ResolveInfo resolveActivity(int... iArr) {
            return this.f3669a.resolveActivity(iArr);
        }

        public boolean usbEnable() {
            return this.f3669a.usbEnable();
        }

        public boolean vpn() {
            return this.f3669a.vpn();
        }

        private DHResponse(cn.fly.tools.utils.DH.DHResponse dHResponse) {
            this.f3669a = dHResponse;
        }
    }
}
