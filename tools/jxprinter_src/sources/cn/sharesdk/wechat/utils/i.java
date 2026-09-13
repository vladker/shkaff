package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.utils.SSDKLog;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class b extends WechatResp {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f2374a;

        public b(Bundle bundle) {
            a(bundle);
        }

        @Override // cn.sharesdk.wechat.utils.WechatResp
        public final int a() {
            return 19;
        }

        @Override // cn.sharesdk.wechat.utils.WechatResp
        public final void b(Bundle bundle) {
            super.b(bundle);
            bundle.putString("_launch_wxminiprogram_ext_msg", this.f2374a);
        }

        @Override // cn.sharesdk.wechat.utils.WechatResp
        public final void a(Bundle bundle) {
            super.a(bundle);
            this.f2374a = bundle.getString("_launch_wxminiprogram_ext_msg");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class a extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f2373a;
        public String b = "";
        public int c = 0;
        public String d = "";

        @Override // cn.sharesdk.wechat.utils.m
        public final int a() {
            return 19;
        }

        @Override // cn.sharesdk.wechat.utils.m
        public final boolean b() {
            String str = this.f2373a;
            if (str == null || str.length() == 0 || this.f2373a.length() > 10240) {
                SSDKLog.b().a("checkArgs fail, userName is invalid", new Object[0]);
                return false;
            }
            int i5 = this.c;
            if (i5 >= 0 && i5 <= 2) {
                return true;
            }
            SSDKLog.b().a("checkArgs fail", "miniprogram type should between MINIPTOGRAM_TYPE_RELEASE and MINIPROGRAM_TYPE_PREVIEW");
            return false;
        }

        @Override // cn.sharesdk.wechat.utils.m
        public final void b(Bundle bundle) {
            super.b(bundle);
            bundle.putString("_launch_wxminiprogram_username", this.f2373a);
            bundle.putString("_launch_wxminiprogram_path", this.b);
            bundle.putInt("_launch_wxminiprogram_type", this.c);
            bundle.putString("_launch_wxminiprogram_extData", this.d);
        }
    }
}
