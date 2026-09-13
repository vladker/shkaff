package cn.sharesdk.framework.a.b;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class c extends d {
    @Override // cn.sharesdk.framework.a.b.d, cn.sharesdk.framework.a.b.e
    public String a() {
        return "[AUE]";
    }

    @Override // cn.sharesdk.framework.a.b.d, cn.sharesdk.framework.a.b.e
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append('|');
        if (!TextUtils.isEmpty(this.f2144m)) {
            sb.append(this.f2144m);
        }
        sb.append('|');
        if (!TextUtils.isEmpty(this.f2145n)) {
            sb.append(this.f2145n);
        }
        return sb.toString();
    }
}
