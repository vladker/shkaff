package org.apache.poi.xslf.util;

import java.io.File;
import java.text.AttributedCharacterIterator;
import java.util.function.Function;
import org.apache.poi.sl.usermodel.Shape;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class h implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7338a;

    public /* synthetic */ h(int i5) {
        this.f7338a = i5;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f7338a) {
            case 0:
                return PPTHandler.fromObjectShape((Shape) obj);
            case 1:
                return DummyGraphics2d.lambda$null$0((AttributedCharacterIterator.Attribute) obj);
            case 2:
                return new File((String) obj);
            case 3:
                return PPTX2PNG.lambda$processFile$0((String) obj);
            case 4:
                return PPTX2PNG.lambda$processFile$1((String[]) obj);
            default:
                return PPTX2PNG.lambda$processFile$2((String[]) obj);
        }
    }
}
