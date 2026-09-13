package p102s;

import S2.q;
import java.util.List;
import kotlin.jvm.internal.E;
import p007a4.AbstractC0272e;
import p007a4.C0276f0;
import p007a4.C0315z0;
import p108t.InterfaceC1792y;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class o implements InterfaceC1792y {
    @Override // p108t.InterfaceC1792y
    public void openFromQQ(String requestId, String fileType) {
        E.f(requestId, "requestId");
        E.f(fileType, "fileType");
        AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getMain(), 2, new m(fileType, requestId, null));
    }

    @Override // p108t.InterfaceC1792y
    public void openFromWechat(String requestId, String fileType) {
        E.f(requestId, "requestId");
        E.f(fileType, "fileType");
        AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getMain(), 2, new n(fileType, requestId, null));
    }

    /* JADX WARN: Type inference failed for: r7v2, types: [java.io.Serializable, java.lang.String[]] */
    @Override // p108t.InterfaceC1792y
    public void pickFile(String requestId, List<String> fileTypes) {
        E.f(requestId, "requestId");
        E.f(fileTypes, "fileTypes");
        AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getMain(), 2, new q(requestId, (String[]) fileTypes.toArray(new String[0]), null, 5));
    }
}
