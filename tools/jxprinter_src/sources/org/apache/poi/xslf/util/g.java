package org.apache.poi.xslf.util;

import java.io.File;
import java.util.function.Predicate;
import org.apache.poi.sl.usermodel.Shape;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class g implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7337a;

    public /* synthetic */ g(int i5) {
        this.f7337a = i5;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f7337a) {
            case 0:
                return PPTHandler.lambda$null$1((Shape) obj);
            default:
                return ((File) obj).isDirectory();
        }
    }
}
