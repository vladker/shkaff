package org.apache.logging.log4j.util;

import java.util.Collection;
import java.util.Set;
import java.util.function.Consumer;
import org.apache.logging.log4j.spi.Provider;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class f implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6946a;
    public final /* synthetic */ Object b;

    public /* synthetic */ f(Object obj, int i5) {
        this.f6946a = i5;
        this.b = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f6946a) {
            case 0:
                ((PropertiesUtil.Environment) this.b).lambda$reload$3((String) obj);
                break;
            case 1:
                ((Set) this.b).add((PropertySource) obj);
                break;
            default:
                ((Collection) this.b).add((Provider) obj);
                break;
        }
    }
}
