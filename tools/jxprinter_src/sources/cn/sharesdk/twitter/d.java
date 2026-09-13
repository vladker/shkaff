package cn.sharesdk.twitter;

import A3.AbstractC0157z;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.authorize.SSOAuthorizeActivity;
import cn.sharesdk.framework.authorize.SSOListener;
import cn.sharesdk.framework.network.SSDKNetworkHelper;
import cn.sharesdk.framework.utils.SSDKLog;
import com.google.common.net.HttpHeaders;
import com.mob.tools.network.KVPair;
import com.mob.tools.utils.Hashon;
import java.util.ArrayList;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class d extends cn.sharesdk.framework.authorize.c {
    private String d;
    private String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f2343f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private SSOAuthorizeActivity f2344g;

    public d(SSOAuthorizeActivity sSOAuthorizeActivity) {
        super(sSOAuthorizeActivity);
        this.f2344g = sSOAuthorizeActivity;
    }

    private void c(Intent intent) {
        SSOListener sSOListener = this.c;
        if (sSOListener == null) {
            return;
        }
        if (intent == null) {
            try {
                sSOListener.onCancel();
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        Throwable th = new Throwable(intent.getStringExtra("error") + " (" + intent.getIntExtra("error_code", -1) + ")");
        SSOListener sSOListener2 = this.c;
        if (sSOListener2 != null) {
            sSOListener2.onFailed(th);
        }
    }

    public void b(String str) {
        this.e = str;
    }

    private void b() {
        try {
            Intent component = new Intent().setComponent(new ComponentName(a(this.f2344g.getContext().getPackageManager()), "com.twitter.android.SingleSignOnActivity"));
            a.a(this.f2344g.getContext(), component);
            component.putExtra("ck", this.d).putExtra("cs", this.e);
            this.f2344g.startActivityForResult(component, 140);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(String str) {
        this.d = str;
    }

    @Override // cn.sharesdk.framework.authorize.c
    public void a() {
        try {
            if (a(this.f2344g.getContext())) {
                b();
                return;
            }
            this.f2344g.finish();
            SSOListener sSOListener = this.c;
            if (sSOListener != null) {
                sSOListener.onFailed(new Throwable(" You may not have installed Twitter client "));
            }
        } catch (Throwable th) {
            this.f2344g.finish();
            SSOListener sSOListener2 = this.c;
            if (sSOListener2 != null) {
                sSOListener2.onFailed(th);
            }
        }
    }

    private void b(final Intent intent) {
        SSOListener sSOListener = this.c;
        if (sSOListener == null) {
            return;
        }
        try {
            if (this.f2343f) {
                new Thread() { // from class: cn.sharesdk.twitter.d.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        super.run();
                        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
                        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
                        arrayList.add(new KVPair<>("grant_type", "client_credentials"));
                        arrayList2.add(new KVPair<>(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=UTF-8"));
                        arrayList2.add(new KVPair<>(HttpHeaders.AUTHORIZATION, AbstractC0157z.n("Basic ", Base64.encodeToString((d.this.d + ParameterizedMessage.ERROR_MSG_SEPARATOR + d.this.e).getBytes(), 2))));
                        try {
                            String str = (String) new Hashon().fromJson(SSDKNetworkHelper.getInstance().httpPost("https://api.twitter.com/oauth2/token", arrayList, null, arrayList2, "/oauth2/token", 11)).get("access_token");
                            if (!TextUtils.isEmpty(str)) {
                                intent.putExtra("access_token", str);
                            }
                            d dVar = d.this;
                            dVar.a(intent, ((cn.sharesdk.framework.authorize.c) dVar).c);
                        } catch (Throwable th) {
                            SSDKLog.b().a("twitter get token error" + th.getMessage());
                        }
                    }
                }.start();
            } else {
                a(intent, sSOListener);
            }
        } catch (Throwable th) {
            SSDKLog.b().a(th.getMessage());
        }
    }

    @Override // cn.sharesdk.framework.authorize.c
    public void a(int i5, int i6, Intent intent) {
        try {
            this.f2344g.finish();
            if (i5 == 140) {
                if (i6 == -1) {
                    SSOAuthorizeActivity sSOAuthorizeActivity = this.f2344g;
                    if (sSOAuthorizeActivity != null) {
                        sSOAuthorizeActivity.finish();
                    }
                    b(intent);
                    return;
                }
                if (i6 != 0) {
                    return;
                }
                SSOAuthorizeActivity sSOAuthorizeActivity2 = this.f2344g;
                if (sSOAuthorizeActivity2 != null) {
                    sSOAuthorizeActivity2.finish();
                }
                c(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent, SSOListener sSOListener) {
        String stringExtra = intent.getStringExtra("error");
        if (stringExtra == null) {
            sSOListener.onComplete(intent.getExtras());
            return;
        }
        if (stringExtra.equals("access_denied")) {
            if (sSOListener != null) {
                sSOListener.onCancel();
            }
        } else {
            String stringExtra2 = intent.getStringExtra("error_description");
            if (stringExtra2 != null) {
                stringExtra = androidx.collection.a.o(stringExtra, ": ", stringExtra2);
            }
            if (sSOListener != null) {
                sSOListener.onFailed(new Throwable(stringExtra));
            }
        }
    }

    private static boolean a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        return a(packageManager, "com.twitter.android", "3082025d308201c6a00302010202044bd76cce300d06092a864886f70d01010505003073310b3009060355040613025553310b3009060355040813024341311630140603550407130d53616e204672616e636973636f31163014060355040a130d547769747465722c20496e632e310f300d060355040b13064d6f62696c65311630140603550403130d4c656c616e6420526563686973301e170d3130303432373233303133345a170d3438303832353233303133345a3073310b3009060355040613025553310b3009060355040813024341311630140603550407130d53616e204672616e636973636f31163014060355040a130d547769747465722c20496e632e310f300d060355040b13064d6f62696c65311630140603550403130d4c656c616e642052656368697330819f300d06092a864886f70d010101050003818d003081890281810086233c2e51c62232d49cc932e470713d63a6a1106b38f9e442e01bc79ca4f95c72b2cb3f1369ef7dea6036bff7c4b2828cb3787e7657ad83986751ced5b131fcc6f413efb7334e32ed9787f9e9a249ae108fa66009ac7a7932c25d37e1e07d4f9f66aa494c270dbac87d261c9668d321c2fba4ef2800e46671a597ff2eac5d7f0203010001300d06092a864886f70d0101050500038181003e1f01cb6ea8be8d2cecef5cd2a64c97ba8728aa5f08f8275d00508d64d139b6a72c5716b40a040df0eeeda04de9361107e123ee8d3dc05e70c8a355f46dbadf1235443b0b214c57211afd4edd147451c443d49498d2a7ff27e45a99c39b9e47429a1dae843ba233bf8ca81296dbe1dc5c5434514d995b0279246809392a219b") || a(packageManager, "com.twitter.android.beta", "308203523082023aa00302010202044fd0006b300d06092a864886f70d0101050500306b310b3009060355040613025553310b3009060355040813024341311630140603550407130d53616e204672616e636973636f3110300e060355040a130754776974746572310f300d060355040b13064d6f62696c65311430120603550403130b4a6f6e617468616e204c65301e170d3132303630373031313431395a170d3339313032343031313431395a306b310b3009060355040613025553310b3009060355040813024341311630140603550407130d53616e204672616e636973636f3110300e060355040a130754776974746572310f300d060355040b13064d6f62696c65311430120603550403130b4a6f6e617468616e204c6530820122300d06092a864886f70d01010105000382010f003082010a028201010089e6cbdfed4288a9c0a215d33d4fa978a5bdd20be426ef4b497d358a9fd1c6efec9684f059f6955e60e5fda1b5910bb2d097e7421a78f9c81e95cd8ef3bf50add7f8d9f073c0478736a6c7fd38c5871559783a76420d37f3f874f2114ec02532e85587791d24037485b1b95ec8cbc75b52042867988b51c7c3589d5b5972fd20a2e8a7c9ced986873f5008a418b2921daa7cfb78afc174eecdb8a79dc0961bea9740d09c4656ac9b8c86263a788e35af1d4a3f86ce053a1aefb5369def91614a390219f896f378712376baa05934a341798950e229f4f735b86004952b259f23cc9fc3b8c1bc8171984884dc92940e91f2e9a78a84a78f0c2946b7e37bbf3b9b0203010001300d06092a864886f70d010105050003820101001cf15250365e66cc87bb5054de1661266cf87907841016b20dfa1f9f59842020cbc33f9b4d41717db0428d11696a0bade6a4950a48cc4fa8ae56c850647379a5c2d977436b644162c453dd36b7745ccb9ff0b5fc070125024de73dab6dcda5c69372e978a49865f569927199ed0f61d7cbee1839079a7da2e83f8c90f7421a8c81b3f17f1cc05d52aedac9acd6e092ffd9ad572960e779a5b91a78e1aeb2b3c7b24464bd223c745e40abd74fc586310809520d183443fcca3c6ade3be458afedbd3325df9c0e552636e35bb55b240eb8c0ba3973c4fb81213f22363be2d70e85014650c2f4fc679747a7ec31ea7b08da7dd9b9ba279a7fbbc1bd440fbe831bf4");
    }

    public static String a(PackageManager packageManager) {
        if (a(packageManager, "com.twitter.android", "3082025d308201c6a00302010202044bd76cce300d06092a864886f70d01010505003073310b3009060355040613025553310b3009060355040813024341311630140603550407130d53616e204672616e636973636f31163014060355040a130d547769747465722c20496e632e310f300d060355040b13064d6f62696c65311630140603550403130d4c656c616e6420526563686973301e170d3130303432373233303133345a170d3438303832353233303133345a3073310b3009060355040613025553310b3009060355040813024341311630140603550407130d53616e204672616e636973636f31163014060355040a130d547769747465722c20496e632e310f300d060355040b13064d6f62696c65311630140603550403130d4c656c616e642052656368697330819f300d06092a864886f70d010101050003818d003081890281810086233c2e51c62232d49cc932e470713d63a6a1106b38f9e442e01bc79ca4f95c72b2cb3f1369ef7dea6036bff7c4b2828cb3787e7657ad83986751ced5b131fcc6f413efb7334e32ed9787f9e9a249ae108fa66009ac7a7932c25d37e1e07d4f9f66aa494c270dbac87d261c9668d321c2fba4ef2800e46671a597ff2eac5d7f0203010001300d06092a864886f70d0101050500038181003e1f01cb6ea8be8d2cecef5cd2a64c97ba8728aa5f08f8275d00508d64d139b6a72c5716b40a040df0eeeda04de9361107e123ee8d3dc05e70c8a355f46dbadf1235443b0b214c57211afd4edd147451c443d49498d2a7ff27e45a99c39b9e47429a1dae843ba233bf8ca81296dbe1dc5c5434514d995b0279246809392a219b")) {
            return "com.twitter.android";
        }
        if (a(packageManager, "com.twitter.android.beta", "308203523082023aa00302010202044fd0006b300d06092a864886f70d0101050500306b310b3009060355040613025553310b3009060355040813024341311630140603550407130d53616e204672616e636973636f3110300e060355040a130754776974746572310f300d060355040b13064d6f62696c65311430120603550403130b4a6f6e617468616e204c65301e170d3132303630373031313431395a170d3339313032343031313431395a306b310b3009060355040613025553310b3009060355040813024341311630140603550407130d53616e204672616e636973636f3110300e060355040a130754776974746572310f300d060355040b13064d6f62696c65311430120603550403130b4a6f6e617468616e204c6530820122300d06092a864886f70d01010105000382010f003082010a028201010089e6cbdfed4288a9c0a215d33d4fa978a5bdd20be426ef4b497d358a9fd1c6efec9684f059f6955e60e5fda1b5910bb2d097e7421a78f9c81e95cd8ef3bf50add7f8d9f073c0478736a6c7fd38c5871559783a76420d37f3f874f2114ec02532e85587791d24037485b1b95ec8cbc75b52042867988b51c7c3589d5b5972fd20a2e8a7c9ced986873f5008a418b2921daa7cfb78afc174eecdb8a79dc0961bea9740d09c4656ac9b8c86263a788e35af1d4a3f86ce053a1aefb5369def91614a390219f896f378712376baa05934a341798950e229f4f735b86004952b259f23cc9fc3b8c1bc8171984884dc92940e91f2e9a78a84a78f0c2946b7e37bbf3b9b0203010001300d06092a864886f70d010105050003820101001cf15250365e66cc87bb5054de1661266cf87907841016b20dfa1f9f59842020cbc33f9b4d41717db0428d11696a0bade6a4950a48cc4fa8ae56c850647379a5c2d977436b644162c453dd36b7745ccb9ff0b5fc070125024de73dab6dcda5c69372e978a49865f569927199ed0f61d7cbee1839079a7da2e83f8c90f7421a8c81b3f17f1cc05d52aedac9acd6e092ffd9ad572960e779a5b91a78e1aeb2b3c7b24464bd223c745e40abd74fc586310809520d183443fcca3c6ade3be458afedbd3325df9c0e552636e35bb55b240eb8c0ba3973c4fb81213f22363be2d70e85014650c2f4fc679747a7ec31ea7b08da7dd9b9ba279a7fbbc1bd440fbe831bf4")) {
            return "com.twitter.android.beta";
        }
        return null;
    }

    private static boolean a(PackageManager packageManager, String str, String str2) {
        try {
            for (Signature signature : packageManager.getPackageInfo(str, 64).signatures) {
                if (!str2.equals(signature.toCharsString())) {
                    return false;
                }
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
