package com.mob;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import cn.fly.tools.FlyLog;
import cn.fly.tools.utils.DH;
import cn.fly.tools.utils.Data;
import cn.fly.tools.utils.UIHandler;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mob.tools.proguard.ClassKeeper;
import com.mob.tools.proguard.PublicMemberKeeper;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.Serializable;
import java.util.Locale;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class PrivacyPolicy implements ClassKeeper, PublicMemberKeeper, Serializable {
    public static final int POLICY_TYPE_TXT = 2;
    public static final int POLICY_TYPE_URL = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3617a;
    private String b;
    private int c;
    private long d;

    public interface OnPolicyListener extends ClassKeeper, PublicMemberKeeper {
        void onComplete(PrivacyPolicy privacyPolicy);

        void onFailure(Throwable th);
    }

    public PrivacyPolicy() {
    }

    private String a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new String(Data.AES128Decode(Data.rawMD5(MobSDK.getAppkey() + ParameterizedMessage.ERROR_MSG_SEPARATOR + DH.SyncMtd.getPackageName() + ParameterizedMessage.ERROR_MSG_SEPARATOR + getTimestamp()), Base64.decode(str, 0)), "UTF-8");
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return null;
        }
    }

    public static PrivacyPolicy getPrivacyPolicy(int i5, Locale locale) {
        return null;
    }

    @Deprecated
    public static void getPrivacyPolicyAsync(int i5, OnPolicyListener onPolicyListener) {
        getPrivacyPolicyAsync(i5, null, onPolicyListener);
    }

    public String getContent() {
        return this.b;
    }

    public int getPpVersion() {
        return this.c;
    }

    public long getTimestamp() {
        return this.d;
    }

    public String getTitle() {
        return this.f3617a;
    }

    public void setContent(String str) {
        this.b = str;
    }

    public void setPpVersion(int i5) {
        this.c = i5;
    }

    public void setTimestamp(long j6) {
        this.d = j6;
    }

    public void setTitle(String str) {
        this.f3617a = str;
    }

    public PrivacyPolicy(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            setTimestamp(jSONObject.optLong(Constants.TIMESTAMP));
            setTitle(a(jSONObject.optString("title")));
            setContent(a(jSONObject.optString(FirebaseAnalytics.Param.CONTENT)));
            String strA = a(jSONObject.optString("ppVersion"));
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            setPpVersion(Integer.parseInt(strA.trim()));
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
        }
    }

    @Deprecated
    public static void getPrivacyPolicyAsync(int i5, Locale locale, final OnPolicyListener onPolicyListener) {
        if (onPolicyListener != null) {
            final Throwable th = new Throwable("This api is Deprecated, please do not call it");
            UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: com.mob.PrivacyPolicy.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    onPolicyListener.onFailure(th);
                    return false;
                }
            });
        }
    }
}
