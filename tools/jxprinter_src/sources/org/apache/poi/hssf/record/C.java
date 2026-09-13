package org.apache.poi.hssf.record;

import java.util.BitSet;
import java.util.Iterator;
import java.util.function.Consumer;
import org.apache.poi.sl.extractor.SlideShowExtractor;
import org.apache.poi.sl.usermodel.Slide;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class C implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6987a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ C(Object obj, Object obj2, int i5) {
        this.f6987a = i5;
        this.b = obj;
        this.c = obj2;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f6987a) {
            case 0:
                EscherAggregate.lambda$createAggregate$0((EscherAggregate) this.b, (Iterator) this.c, (Record) obj);
                break;
            case 1:
                ((SlideShowExtractor) this.b).lambda$getCodepoints$4((BitSet) this.c, (Slide) obj);
                break;
            default:
                ((SlideShowExtractor) this.b).lambda$getCodepointsInSparseBitSet$7((V2.f) this.c, (Slide) obj);
                break;
        }
    }
}
