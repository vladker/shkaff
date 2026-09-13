package org.greenrobot.eventbus.android;

import P2.a;
import p050j.w;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class AndroidComponentsImpl {
    public static final AndroidComponentsImpl c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f7463a;
    public final a b;

    static {
        AndroidComponentsImpl androidComponentsImpl = null;
        if (w.d()) {
            try {
                androidComponentsImpl = (AndroidComponentsImpl) AndroidComponentsImpl.class.getConstructor(null).newInstance(null);
            } catch (Throwable unused) {
            }
        }
        c = androidComponentsImpl;
    }

    public AndroidComponentsImpl() {
        a aVar = new a(3);
        a aVar2 = new a(4);
        this.f7463a = aVar;
        this.b = aVar2;
    }
}
