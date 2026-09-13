package cn.sharesdk.framework.a.b;

import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.utils.Data;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class d extends e {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static int f2134o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static long f2135p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2136a;
    public String b;
    public String c;
    public String d;

    @Override // cn.sharesdk.framework.a.b.e
    public String a() {
        return "[AUT]";
    }

    @Override // cn.sharesdk.framework.a.b.e
    public int b() {
        return 5000;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public int c() {
        return 5;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public long d() {
        return f2134o;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public long e() {
        return f2135p;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public void f() {
        f2134o++;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append('|');
        sb.append(this.f2136a);
        sb.append('|');
        sb.append(this.b);
        sb.append('|');
        if (!TextUtils.isEmpty(this.d)) {
            try {
                String strEncodeToString = Base64.encodeToString(Data.AES128Encode(this.f2137f.substring(0, 16), this.d), 0);
                if (!TextUtils.isEmpty(strEncodeToString) && strEncodeToString.contains("\n")) {
                    strEncodeToString = strEncodeToString.replace("\n", "");
                }
                sb.append(strEncodeToString);
            } catch (Throwable th) {
                SSDKLog.b().a(th);
            }
        }
        sb.append('|');
        if (!TextUtils.isEmpty(this.f2143l)) {
            sb.append(this.f2143l);
        }
        sb.append('|');
        if (!TextUtils.isEmpty(this.c)) {
            sb.append(this.c);
        }
        return sb.toString();
    }

    @Override // cn.sharesdk.framework.a.b.e
    public void a(long j6) {
        f2135p = j6;
    }
}
