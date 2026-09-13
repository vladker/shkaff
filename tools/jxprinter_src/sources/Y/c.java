package Y;

import com.appdev.standard.api.SceneApi;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends p038g2.a {
    public SceneApi d;

    public final void a(int i5, String str, String str2, String str3, String str4) {
        if ("0".equals(str4)) {
            str4 = null;
        }
        this.d.industryTemplateList(str, str2, str3, str4, i5, 10, 1).b(new b(this));
    }
}
