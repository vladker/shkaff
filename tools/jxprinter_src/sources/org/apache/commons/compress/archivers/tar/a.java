package org.apache.commons.compress.archivers.tar;

import java.security.Provider;
import java.util.Objects;
import java.util.function.Predicate;
import org.apache.commons.io.file.DeleteOption;
import org.apache.commons.io.file.PathUtils;
import org.apache.poi.extractor.ExtractorFactory;
import org.apache.poi.poifs.filesystem.Entry;
import org.apache.poi.sl.extractor.SlideShowExtractor;
import org.apache.poi.util.LocaleID;
import org.apache.poi.xddf.usermodel.text.XDDFTextParagraph;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6700a;

    public /* synthetic */ a(int i5) {
        this.f6700a = i5;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f6700a) {
            case 0:
                return TarArchiveEntry.lambda$getOrderedSparseHeaders$0((TarArchiveStructSparse) obj);
            case 1:
                return PathUtils.lambda$overrideReadOnly$1((DeleteOption) obj);
            case 2:
                return ExtractorFactory.lambda$getEmbeddedDocsTextExtractors$7((Entry) obj);
            case 3:
                return Objects.nonNull((Provider) obj);
            case 4:
                return Objects.nonNull((byte[]) obj);
            case 5:
                return SlideShowExtractor.lambda$new$0(obj);
            case 6:
                return ((LocaleID) obj).isValid();
            case 7:
                return XDDFTextParagraph.lambda$getBulletSize$4((CTTextParagraphProperties) obj);
            case 8:
                return ((CTTextParagraphProperties) obj).isSetMarL();
            case 9:
                return XDDFTextParagraph.lambda$getBulletColor$0((CTTextParagraphProperties) obj);
            case 10:
                return ((CTTextParagraphProperties) obj).isSetHangingPunct();
            case 11:
                return ((CTTextParagraphProperties) obj).isSetMarR();
            case 12:
                return ((CTTextParagraphProperties) obj).isSetEaLnBrk();
            case 13:
                return ((CTTextParagraphProperties) obj).isSetIndent();
            case 14:
                return XDDFTextParagraph.lambda$getBulletFont$2((CTTextParagraphProperties) obj);
            case 15:
                return ((CTTextParagraphProperties) obj).isSetAlgn();
            case 16:
                return ((CTTextParagraphProperties) obj).isSetSpcAft();
            case 17:
                return ((CTTextParagraphProperties) obj).isSetLnSpc();
            case 18:
                return XDDFTextParagraph.lambda$getBulletStyle$6((CTTextParagraphProperties) obj);
            case 19:
                return ((CTTextParagraphProperties) obj).isSetRtl();
            case 20:
                return ((CTTextParagraphProperties) obj).isSetLatinLnBrk();
            case 21:
                return ((CTTextParagraphProperties) obj).isSetSpcBef();
            case 22:
                return ((CTTextParagraphProperties) obj).isSetFontAlgn();
            case 23:
                return ((CTTextParagraphProperties) obj).isSetDefTabSz();
            case 24:
                return ((CTTextCharacterProperties) obj).isSetHighlight();
            case 25:
                return ((CTTextCharacterProperties) obj).isSetStrike();
            case 26:
                return ((CTTextCharacterProperties) obj).isSetNoProof();
            case 27:
                return ((CTTextCharacterProperties) obj).isSetKumimoji();
            case 28:
                return ((CTTextCharacterProperties) obj).isSetNormalizeH();
            default:
                return ((CTTextCharacterProperties) obj).isSetBmk();
        }
    }
}
