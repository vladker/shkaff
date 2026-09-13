package androidx.datastore.core;

import E3.g;
import O3.l;
import O3.p;
import p023d4.InterfaceC0612o;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public interface InterProcessCoordinator {
    InterfaceC0612o getUpdateNotifications();

    Object getVersion(g<? super Integer> gVar);

    Object incrementAndGetVersion(g<? super Integer> gVar);

    <T> Object lock(l lVar, g<? super T> gVar);

    <T> Object tryLock(p pVar, g<? super T> gVar);
}
