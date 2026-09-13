package p102s;

import com.orhanobut.hawk.Hawk;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.E;
import p108t.InterfaceC1789v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements InterfaceC1789v {
    @Override // p108t.InterfaceC1789v
    public String getBaseUrl() {
        String str = (String) Hawk.get("base_server_url", null);
        E.c(str);
        return str;
    }

    @Override // p108t.InterfaceC1789v
    public Map<String, String> getHeaders() {
        Object obj = Hawk.get("base_header_map", new HashMap());
        E.e(obj, "get(...)");
        return (Map) obj;
    }
}
