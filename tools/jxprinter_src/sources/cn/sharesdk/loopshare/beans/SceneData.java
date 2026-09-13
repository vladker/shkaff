package cn.sharesdk.loopshare.beans;

import cn.sharesdk.loopshare.Scene;
import com.mob.tools.proguard.PrivateMemberKeeper;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class SceneData extends ServerData {
    private Res res;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Res extends Scene implements PrivateMemberKeeper {
        private String action;
        private HashMap<String, Object> browser;
        private String link;

        public String getAction() {
            return this.action;
        }

        public String getLink() {
            return this.link;
        }
    }

    public Res a() {
        return this.res;
    }

    @Override // cn.sharesdk.loopshare.beans.ServerData
    public boolean a_() {
        boolean zA_ = super.a_();
        if (!zA_) {
            return zA_;
        }
        Res resA = a();
        return (resA == null || resA.getPath() == null) ? false : true;
    }
}
