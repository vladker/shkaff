package org.apache.xmlbeans.impl.config;

import java.util.Map;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class b implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7352a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ String c;

    public /* synthetic */ b(Map map, String str, int i5) {
        this.f7352a = i5;
        this.b = map;
        this.c = str;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f7352a) {
            case 0:
                BindingConfigImpl.lambda$recordNamespaceSetting$0(this.b, this.c, obj);
                break;
            default:
                BindingConfigImpl.lambda$recordNamespacePrefixSetting$1(this.b, this.c, obj);
                break;
        }
    }
}
