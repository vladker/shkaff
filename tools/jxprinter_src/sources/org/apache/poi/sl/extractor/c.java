package org.apache.poi.sl.extractor;

import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class c implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7186a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Boolean c;
    public final /* synthetic */ Boolean d;

    public /* synthetic */ c(Boolean bool, int i5, Boolean bool2, String str) {
        this.f7186a = i5;
        this.b = str;
        this.c = bool;
        this.d = bool2;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f7186a) {
            case 0:
                return SlideShowExtractor.lambda$getCodepoints$2(this.b, this.c, this.d, obj);
            default:
                return SlideShowExtractor.lambda$getCodepointsInSparseBitSet$5(this.b, this.c, this.d, obj);
        }
    }
}
