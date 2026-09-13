package cn.sharesdk.loopshare;

import com.mob.tools.proguard.PublicMemberKeeper;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class Scene implements PublicMemberKeeper, Serializable {
    public HashMap<String, Object> params;
    public String path;

    public HashMap<String, Object> getParams() {
        return this.params;
    }

    public String getPath() {
        return this.path;
    }

    public void setParams(HashMap<String, Object> map) {
        this.params = map;
    }

    public void setPath(String str) {
        this.path = str;
    }
}
