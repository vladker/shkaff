package org.apache.poi.xwpf.usermodel;

import java.util.function.Function;
import org.apache.xmlbeans.XmlCursor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7345a;
    public final /* synthetic */ XWPFParagraph b;

    public /* synthetic */ a(XWPFParagraph xWPFParagraph, int i5) {
        this.f7345a = i5;
        this.b = xWPFParagraph;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f7345a) {
            case 0:
                return this.b.lambda$insertNewFieldRun$2((XmlCursor) obj);
            case 1:
                return this.b.lambda$insertNewHyperlinkRun$1((XmlCursor) obj);
            default:
                return this.b.lambda$insertNewRun$0((XmlCursor) obj);
        }
    }
}
