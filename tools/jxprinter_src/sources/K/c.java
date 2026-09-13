package K;

import com.appdev.standard.api.MineApi;
import com.orhanobut.hawk.Hawk;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends p038g2.a {
    public MineApi d;

    public final void a(int i5, String str) {
        this.d.getHelpCenterList(i5, 10, str, ((String) Hawk.get("appType")).equals("sanduOverseas") ? 3 : 1).b(new b(this, i5));
    }
}
