package cn.sharesdk.wechat.utils;

import A3.AbstractC0157z;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import cn.sharesdk.framework.ShareSDKCallback;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.onekeyshare.OnekeyShare;
import com.mob.MobSDK;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.ResHelper;
import java.security.MessageDigest;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2375a;

    private static void b(Context context, Intent intent) {
        Context context2;
        try {
            SSDKLog.b().a("launchWXUsingPendingIntent", new Object[0]);
            context2 = context;
            try {
                a(context, 1, intent, 134217728).send(context2, 2, null, new PendingIntent.OnFinished() { // from class: cn.sharesdk.wechat.utils.j.2
                    @Override // android.app.PendingIntent.OnFinished
                    public void onSendFinished(PendingIntent pendingIntent, Intent intent2, int i5, String str, Bundle bundle) {
                        SSDKLog.b().a("launchWXUsingPendingIntent onSendFinished resultCode: " + i5 + ", resultData: " + str, new Object[0]);
                    }
                }, null);
            } catch (Exception e) {
                e = e;
                Exception exc = e;
                SSDKLog.b().a("launchWXUsingPendingIntent pendingIntent send failed: " + exc.getMessage(), new Object[0]);
                context2.startActivity(intent);
            }
        } catch (Exception e6) {
            e = e6;
            context2 = context;
        }
    }

    private void c(final ShareSDKCallback<Boolean> shareSDKCallback) {
        SSDKLog.b().a("checking signature of wechat client...", new Object[0]);
        DH.requester(MobSDK.getContext()).getPInfoForce(true, "com.tencent.mm", 64).request(new DH.DHResponder() { // from class: cn.sharesdk.wechat.utils.j.4
            @Override // com.mob.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                try {
                    PackageInfo pInfoForce = dHResponse.getPInfoForce(new int[0]);
                    if (pInfoForce == null) {
                        pInfoForce = cn.sharesdk.framework.utils.i.a("com.tencent.mm", 64);
                    }
                    if (pInfoForce == null) {
                        ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                        if (shareSDKCallback2 != null) {
                            shareSDKCallback2.onCallback(Boolean.FALSE);
                            return;
                        }
                        return;
                    }
                    int length = pInfoForce.signatures.length;
                    for (int i5 = 0; i5 < length; i5++) {
                        String lowerCase = pInfoForce.signatures[i5].toCharsString().toLowerCase();
                        if (shareSDKCallback != null) {
                            SSDKLog.b().a("check" + "308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499".equals(lowerCase), new Object[0]);
                            shareSDKCallback.onCallback(Boolean.valueOf("308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499".equals(lowerCase)));
                        }
                    }
                } catch (Throwable unused) {
                    ShareSDKCallback shareSDKCallback3 = shareSDKCallback;
                    if (shareSDKCallback3 != null) {
                        shareSDKCallback3.onCallback(Boolean.FALSE);
                    }
                }
            }
        });
    }

    public boolean a(String str) {
        try {
            this.f2375a = str;
            String str2 = "weixin://registerapp?appid=" + str;
            String packageName = MobSDK.getContext().getPackageName();
            Intent intent = new Intent("com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_REGISTER");
            intent.putExtra("_mmessage_sdkVersion", 638058496);
            intent.putExtra("_mmessage_appPackage", packageName);
            intent.putExtra("_mmessage_content", str2);
            intent.putExtra("_mmessage_support_content_type", 0L);
            intent.putExtra("_mmessage_checksum", a(str2, packageName, 638058496));
            MobSDK.getContext().sendBroadcast(intent, "com.tencent.mm.permission.MM_MESSAGE");
            SSDKLog.b().a("sending broadcast, intent=com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_REGISTER, perm=com.tencent.mm.permission.MM_MESSAGE", new Object[0]);
            return true;
        } catch (Throwable th) {
            SSDKLog.b().d(androidx.exifinterface.media.a.t(th, new StringBuilder("WeChat registerApp catch ")), new Object[0]);
            return false;
        }
    }

    public void b(m mVar) {
        Intent launchIntentForPackage = MobSDK.getContext().getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
        if (Build.VERSION.SDK_INT < 29) {
            MobSDK.getContext().startActivity(launchIntentForPackage);
        } else {
            b(MobSDK.getContext(), launchIntentForPackage);
        }
        i.a aVar = (i.a) mVar;
        Cursor cursorQuery = MobSDK.getContext().getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram"), null, null, new String[]{this.f2375a, aVar.f2373a, aVar.b, AbstractC0157z.l("", aVar.c, new StringBuilder()), aVar.d}, null);
        if (cursorQuery != null) {
            cursorQuery.close();
        }
    }

    public void b(ShareSDKCallback<Boolean> shareSDKCallback) {
        c(shareSDKCallback);
    }

    public void a(m mVar, boolean z6) throws Throwable {
        if (mVar.b()) {
            String packageName = MobSDK.getContext().getPackageName();
            String str = "weixin://sendreq?appid=" + this.f2375a;
            Intent intent = new Intent();
            intent.setClassName("com.tencent.mm", "com.tencent.mm.plugin.base.stub.WXEntryActivity");
            Bundle bundle = new Bundle();
            mVar.b(bundle);
            intent.putExtras(bundle);
            intent.putExtra("_mmessage_sdkVersion", 638058496);
            intent.putExtra("_mmessage_appPackage", packageName);
            intent.putExtra("_mmessage_content", str);
            intent.putExtra("_mmessage_checksum", a(str, packageName, 638058496));
            if (mVar.a() == 2) {
                try {
                    String strA = a(MobSDK.getContext());
                    if (!TextUtils.isEmpty(strA)) {
                        intent.putExtra("_message_token", strA);
                        SSDKLog.b().a(OnekeyShare.SHARESDK_TAG, " _message_token " + strA);
                    }
                } catch (Exception e) {
                    SSDKLog.b().d(OnekeyShare.SHARESDK_TAG, " WechatCore that put token catch " + e);
                }
            }
            intent.addFlags(268435456);
            intent.addFlags(134217728);
            if (Build.VERSION.SDK_INT < 29) {
                MobSDK.getContext().startActivity(intent);
            } else if (z6) {
                b(MobSDK.getContext(), intent);
            } else {
                a(MobSDK.getContext(), intent);
            }
            SSDKLog.b().a("starting activity, packageName=com.tencent.mm, className=com.tencent.mm.plugin.base.stub.WXEntryActivity", new Object[0]);
            return;
        }
        throw new Throwable("sendReq checkArgs fail");
    }

    private static void a(Context context, Intent intent) {
        Context context2;
        try {
            SSDKLog.b().a("sendUsingPendingIntent", new Object[0]);
            context2 = context;
            try {
                a(context, 3, intent, 134217728).send(context2, 4, null, new PendingIntent.OnFinished() { // from class: cn.sharesdk.wechat.utils.j.1
                    @Override // android.app.PendingIntent.OnFinished
                    public void onSendFinished(PendingIntent pendingIntent, Intent intent2, int i5, String str, Bundle bundle) {
                        SSDKLog.b().a("sendUsingPendingIntent onSendFinished resultCode: " + i5 + ", resultData: " + str, new Object[0]);
                    }
                }, null);
            } catch (Exception e) {
                e = e;
                Exception exc = e;
                SSDKLog.b().a("sendUsingPendingIntent fail, ex = " + exc.getMessage(), new Object[0]);
                context2.startActivity(intent);
            }
        } catch (Exception e6) {
            e = e6;
            context2 = context;
        }
    }

    private static PendingIntent a(Context context, int i5, Intent intent, int i6) {
        return PendingIntent.getActivity(context, i5, intent, i6 | AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
    }

    private String a(Context context) {
        try {
            Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/genTokenForOpenSdk"), null, null, new String[]{this.f2375a, "621086720"}, null);
            if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                return null;
            }
            String string = cursorQuery.getString(0);
            SSDKLog.b().a(OnekeyShare.SHARESDK_TAG, "MicroMsg.SDK.WXApiImplV10(WechatCore) getTokenFromWX token is " + string);
            cursorQuery.close();
            return string;
        } catch (Throwable th) {
            SSDKLog.b().d(OnekeyShare.SHARESDK_TAG, androidx.exifinterface.media.a.n("WechatCore catch ", th));
            return null;
        }
    }

    public void a(m mVar) {
        g gVar = (g) mVar;
        Cursor cursorQuery = MobSDK.getContext().getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[]{this.f2375a, "1", String.valueOf(gVar.f2368a), gVar.b, gVar.c}, null);
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        Intent intent = new Intent();
        intent.setClassName("com.tencent.mm", "com.tencent.mm.plugin.base.stub.WXEntryActivity");
        intent.addFlags(268435456);
        intent.addFlags(134217728);
        MobSDK.getContext().startActivity(intent);
    }

    public void a(final ShareSDKCallback<Boolean> shareSDKCallback) {
        try {
            DH.requester(MobSDK.getContext()).getPInfoForce(true, "com.tencent.mm", 0).request(new DH.DHResponder() { // from class: cn.sharesdk.wechat.utils.j.3
                @Override // com.mob.tools.utils.DH.DHResponder
                public void onResponse(DH.DHResponse dHResponse) {
                    String str;
                    try {
                        str = dHResponse.getPInfoForce(new int[0]).versionName;
                        SSDKLog.b().b("wechat versionName ==>> " + str);
                    } catch (Throwable th) {
                        SSDKLog.b().a(th);
                        str = "0";
                    }
                    String[] strArrSplit = str.split("_")[0].split("\\.");
                    int length = strArrSplit.length;
                    int[] iArr = new int[length];
                    for (int i5 = 0; i5 < length; i5++) {
                        try {
                            iArr[i5] = ResHelper.parseInt(strArrSplit[i5]);
                        } catch (Throwable th2) {
                            SSDKLog.b().a(th2);
                            iArr[i5] = 0;
                        }
                    }
                    if (length < 4) {
                        ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                        if (shareSDKCallback2 != null) {
                            shareSDKCallback2.onCallback(Boolean.FALSE);
                            return;
                        }
                        return;
                    }
                    if (iArr[0] == 6 && iArr[1] == 0 && iArr[2] == 2 && iArr[3] <= 56) {
                        ShareSDKCallback shareSDKCallback3 = shareSDKCallback;
                        if (shareSDKCallback3 != null) {
                            shareSDKCallback3.onCallback(Boolean.TRUE);
                            return;
                        }
                        return;
                    }
                    ShareSDKCallback shareSDKCallback4 = shareSDKCallback;
                    if (shareSDKCallback4 != null) {
                        shareSDKCallback4.onCallback(Boolean.FALSE);
                    }
                }
            });
        } catch (Throwable th) {
            SSDKLog.b().a(th);
            if (shareSDKCallback != null) {
                shareSDKCallback.onCallback(Boolean.FALSE);
            }
        }
    }

    private byte[] a(String str, String str2, int i5) {
        String str3;
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(i5);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        byte[] bytes = stringBuffer.toString().substring(1, 9).getBytes();
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            messageDigest.update(bytes);
            byte[] bArrDigest = messageDigest.digest();
            char[] cArr2 = new char[bArrDigest.length * 2];
            int i6 = 0;
            for (byte b : bArrDigest) {
                cArr2[i6] = cArr[(b >>> 4) & 15];
                cArr2[i6 + 1] = cArr[b & 15];
                i6 += 2;
            }
            str3 = new String(cArr2);
        } catch (Throwable th) {
            SSDKLog.b().a(th);
            str3 = null;
        }
        if (str3 != null) {
            return str3.getBytes();
        }
        return null;
    }

    public boolean a(WechatHandlerActivity wechatHandlerActivity, k kVar) {
        Intent intent = wechatHandlerActivity.getIntent();
        if (intent == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra("wx_token_key");
        if (stringExtra != null && stringExtra.equals("com.tencent.mm.openapi.token")) {
            String stringExtra2 = intent.getStringExtra("_mmessage_appPackage");
            if (TextUtils.isEmpty(stringExtra2)) {
                SSDKLog.b().a("invalid argument, \"_mmessage_appPackage\" is empty", new Object[0]);
                return false;
            }
            if (!a(intent.getByteArrayExtra("_mmessage_checksum"), a(intent.getStringExtra("_mmessage_content"), stringExtra2, intent.getIntExtra("_mmessage_sdkVersion", 0)))) {
                SSDKLog.b().a("checksum fail", new Object[0]);
                return false;
            }
            Bundle extras = intent.getExtras();
            int i5 = extras.getInt("_wxapi_command_type", 0);
            if (i5 == 1) {
                SSDKLog.b().a("Wechat Auth CallBack", new Object[0]);
                kVar.a(new c(extras));
            } else if (i5 == 2) {
                SSDKLog.b().a("Wechat Share CallBack", new Object[0]);
                kVar.a(new e(extras));
            } else if (i5 == 3) {
                wechatHandlerActivity.onGetMessageFromWXReq(new d(extras).f2366a);
            } else if (i5 == 4) {
                wechatHandlerActivity.onShowMessageFromWXReq(new f(extras).f2367a);
            } else {
                if (i5 != 19) {
                    return false;
                }
                SSDKLog.b().a("Wechat MiniProgram CallBack", new Object[0]);
                i.b bVar = new i.b(extras);
                d dVar = new d(extras);
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                wXMediaMessage.wxminiprogram_ext_msg = bVar.f2374a;
                wXMediaMessage.openId = dVar.f2361j;
                wechatHandlerActivity.onGetMessageFromWXReq(wXMediaMessage);
            }
            return true;
        }
        SSDKLog.b().a("invalid argument, \"wx_token_key\" is empty or does not equals \"com.tencent.mm.openapi.token\"", new Object[0]);
        return false;
    }

    private boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr.length != 0) {
            if (bArr2 != null && bArr2.length != 0) {
                if (bArr.length != bArr2.length) {
                    SSDKLog.b().a("checkSumConsistent fail, length is different", new Object[0]);
                    return false;
                }
                for (int i5 = 0; i5 < bArr.length; i5++) {
                    if (bArr[i5] != bArr2[i5]) {
                        SSDKLog.b().a("checkSumConsistent fail, not match", new Object[0]);
                        return false;
                    }
                }
                return true;
            }
            SSDKLog.b().a("checkSumConsistent fail, invalid arguments, checksum is empty", new Object[0]);
            return false;
        }
        SSDKLog.b().a("checkSumConsistent fail, invalid arguments, \"_mmessage_checksum\" is empty", new Object[0]);
        return false;
    }
}
