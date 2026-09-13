package com.mob;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import cn.fly.FlySDK;
import cn.fly.commons.InternationalDomain;
import com.alibaba.android.arouter.utils.Consts;
import com.mob.commons.CSCenter;
import com.mob.commons.MobProduct;
import com.mob.tools.network.NetCommunicator;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.UIHandler;
import org.apache.logging.log4j.util.ProcessIdUtil;

/* JADX INFO: loaded from: classes3.dex */
public class MobSDK implements PublicMemberKeeper {
    public static final int CHANNEL_APICLOUD = 5;
    public static final int CHANNEL_COCOS = 1;
    public static final int CHANNEL_FLUTTER = 4;
    public static final int CHANNEL_JS = 3;
    public static final int CHANNEL_NATIVE = 0;
    public static final int CHANNEL_QUICKSDK = 6;
    public static final int CHANNEL_REACT_NATIVE = 8;
    public static final int CHANNEL_UNIAPP = 7;
    public static final int CHANNEL_UNITY = 2;
    public static final int SDK_VERSION_CODE;
    public static final String SDK_VERSION_NAME;

    /* JADX INFO: renamed from: com.mob.MobSDK$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3616a;

        static {
            int[] iArr = new int[InternationalDomain.values().length];
            f3616a = iArr;
            try {
                iArr[InternationalDomain.JP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3616a[InternationalDomain.US.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        int i5;
        String strReplace = "1.0.0";
        try {
            strReplace = "2026-07-23".replace(ProcessIdUtil.DEFAULT_PROCESSID, Consts.DOT);
            i5 = Integer.parseInt("2026-07-23".replace(ProcessIdUtil.DEFAULT_PROCESSID, ""));
        } catch (Throwable unused) {
            i5 = 1;
        }
        SDK_VERSION_CODE = i5;
        SDK_VERSION_NAME = strReplace;
    }

    @Deprecated
    public static void canIContinueBusiness(final MobProduct mobProduct, Object obj, final Object obj2) {
        if (obj2 == null) {
            throw new IllegalArgumentException("callback can not be null");
        }
        new Thread(new Runnable() { // from class: com.mob.MobSDK.3
            @Override // java.lang.Runnable
            public void run() {
                if (mobProduct == null) {
                    ReflectHelper.invokeInstanceMethodNoThrow(obj2, "onFailure", null, new Throwable("Product can not be null"));
                } else {
                    ReflectHelper.invokeInstanceMethodNoThrow(obj2, "onComplete", null, Boolean.TRUE);
                }
            }
        }).start();
    }

    public static boolean checkForceHttps() {
        return FlySDK.checkFH(true);
    }

    @Deprecated
    public static String checkRequestUrl(String str) {
        return NetCommunicator.dynamicModifyUrl(str);
    }

    public static boolean checkV6() {
        return FlySDK.checkV6();
    }

    @Deprecated
    public static String dynamicModifyUrl(String str) {
        return NetCommunicator.dynamicModifyUrl(str);
    }

    public static String getAppSecret() {
        return FlySDK.getAppSecret();
    }

    public static String getAppkey() {
        return FlySDK.getAppkey();
    }

    public static Context getContext() {
        return FlySDK.getContext();
    }

    public static Context getContextSafely() {
        return FlySDK.getContextSafely();
    }

    public static boolean getDefaultPrivacy() {
        return true;
    }

    public static com.mob.commons.InternationalDomain getDomain() {
        InternationalDomain dmn = FlySDK.getDmn();
        if (dmn == null) {
            return com.mob.commons.InternationalDomain.DEFAULT;
        }
        int i5 = AnonymousClass4.f3616a[dmn.ordinal()];
        if (i5 != 1) {
            return i5 != 2 ? com.mob.commons.InternationalDomain.DEFAULT : com.mob.commons.InternationalDomain.US;
        }
        return com.mob.commons.InternationalDomain.JP;
    }

    public static int getPrivacyGrantedStatus() {
        return FlySDK.getPrivacyGrantedStatus();
    }

    public static synchronized void init(Context context) {
        FlySDK.init(context, null, null);
    }

    public static final int isAuth() {
        return FlySDK.isAuth();
    }

    public static final boolean isForb() {
        return FlySDK.isForb();
    }

    public static final boolean isGppVer() {
        return FlySDK.isGppVer();
    }

    public static final boolean isMob() {
        return FlySDK.isFly();
    }

    public static void setChannel(MobProduct mobProduct, int i5) {
        FlySDK.setChannel(mobProduct, i5);
    }

    public static void submitPolicyGrantResult(boolean z6) {
        FlySDK.submitPolicyGrantResult(z6);
    }

    public static String syncGetBSDM(String str, String str2, String str3, boolean z6) {
        return FlySDK.syncGetBSDM(str, str2, str3, z6);
    }

    public static void updateMobCustomController(MobCustomController mobCustomController) {
        CSCenter.getInstance().updateCustomController(mobCustomController);
    }

    public static void submitPolicyGrantResult(MobCustomController mobCustomController, boolean z6) {
        submitPolicyGrantResult(z6);
        updateMobCustomController(mobCustomController);
    }

    public static synchronized void init(Context context, String str) {
        FlySDK.init(context, str, null);
    }

    @Deprecated
    public static void submitPolicyGrantResult(boolean z6, final OperationCallback<Void> operationCallback) {
        submitPolicyGrantResult(z6);
        if (operationCallback != null) {
            if (z6) {
                UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: com.mob.MobSDK.1
                    @Override // android.os.Handler.Callback
                    public boolean handleMessage(Message message) {
                        UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: com.mob.MobSDK.1.1
                            @Override // android.os.Handler.Callback
                            public boolean handleMessage(Message message2) {
                                operationCallback.onComplete(null);
                                return false;
                            }
                        });
                        return false;
                    }
                });
            } else {
                UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: com.mob.MobSDK.2
                    @Override // android.os.Handler.Callback
                    public boolean handleMessage(Message message) {
                        operationCallback.onComplete(null);
                        return false;
                    }
                });
            }
        }
    }

    public static synchronized void init(Context context, String str, String str2) {
        FlySDK.init(context, str, str2);
    }
}
