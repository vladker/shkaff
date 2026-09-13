package org.apache.poi.sl.draw;

import java.util.function.Predicate;
import javax.imageio.ImageTypeSpecifier;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class b implements Predicate {
    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return BitmapImageRenderer.lambda$loadGrayScaled$1((ImageTypeSpecifier) obj);
    }
}
