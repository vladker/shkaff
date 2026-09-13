package cn.sharesdk.framework.a.b;

import A3.AbstractC0157z;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class j extends e {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static int f2149q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static long f2150r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2151a;
    public String b;
    public String c;
    public a d = new a();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f2152o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String[] f2153p;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class a {
        public String b;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public HashMap<String, Object> f2156g;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f2154a = "";
        public ArrayList<String> c = new ArrayList<>();
        public ArrayList<String> d = new ArrayList<>();
        public ArrayList<String> e = new ArrayList<>();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ArrayList<Bitmap> f2155f = new ArrayList<>();

        public String toString() {
            HashMap map = new HashMap();
            if (!TextUtils.isEmpty(this.b)) {
                String strReplaceAll = this.b.trim().replaceAll("\r", "");
                this.b = strReplaceAll;
                String strReplaceAll2 = strReplaceAll.trim().replaceAll("\n", "");
                this.b = strReplaceAll2;
                this.b = strReplaceAll2.trim().replaceAll("\r\n", "");
            }
            map.put("text", this.b);
            map.put("url", this.c);
            ArrayList<String> arrayList = this.d;
            if (arrayList != null && arrayList.size() > 0) {
                map.put("imgs", this.d);
            }
            if (this.f2156g != null) {
                map.put("attch", new Hashon().fromHashMap(this.f2156g));
            }
            return new Hashon().fromHashMap(map);
        }
    }

    @Override // cn.sharesdk.framework.a.b.e
    public String a() {
        return "[SHR]";
    }

    @Override // cn.sharesdk.framework.a.b.e
    public int b() {
        return 5000;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public int c() {
        return 30;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public long d() {
        return f2149q;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public long e() {
        return f2150r;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public void f() {
        f2149q++;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append('|');
        sb.append(this.f2151a);
        sb.append('|');
        sb.append(this.b);
        sb.append('|');
        sb.append(TextUtils.isEmpty(this.c) ? "" : this.c);
        String[] strArr = this.f2153p;
        String strS = (strArr == null || strArr.length <= 0) ? "" : AbstractC0157z.s(new StringBuilder("[\""), TextUtils.join("\",\"", this.f2153p), "\"]");
        sb.append('|');
        sb.append(strS);
        sb.append('|');
        a aVar = this.d;
        if (aVar != null) {
            try {
                String strEncodeToString = Base64.encodeToString(Data.AES128Encode(this.f2137f.substring(0, 16), aVar.toString()), 0);
                if (strEncodeToString.contains("\n")) {
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
        if (!TextUtils.isEmpty(this.f2152o)) {
            try {
                String strEncodeToString2 = Base64.encodeToString(Data.AES128Encode(this.f2137f.substring(0, 16), this.f2152o), 0);
                if (!TextUtils.isEmpty(strEncodeToString2) && strEncodeToString2.contains("\n")) {
                    strEncodeToString2 = strEncodeToString2.replace("\n", "");
                }
                sb.append(strEncodeToString2);
            } catch (Throwable th2) {
                SSDKLog.b().b(th2);
            }
        }
        return sb.toString();
    }

    @Override // cn.sharesdk.framework.a.b.e
    public void a(long j6) {
        f2150r = j6;
    }
}
