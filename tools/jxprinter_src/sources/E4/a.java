package E4;

import java.io.File;
import java.nio.file.Path;
import java.util.function.Predicate;
import javax.xml.namespace.QName;
import org.apache.commons.io.file.PathFilter;
import org.apache.commons.io.file.PathUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.poi.ddf.AbstractEscherOptRecord;
import org.apache.poi.ddf.EscherProperty;
import org.apache.poi.ddf.EscherPropertyTypes;
import org.apache.poi.extractor.ExtractorFactory;
import org.apache.poi.extractor.ExtractorProvider;
import org.apache.poi.poifs.crypt.dsig.services.RevocationData;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.QNameSetSpecification;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f232a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Object obj, int i5) {
        this.f232a = i5;
        this.b = obj;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f232a) {
            case 0:
                return ((IOFileFilter) this.b).accept((File) obj);
            case 1:
                return PathUtils.lambda$filterPaths$0((PathFilter) this.b, (Path) obj);
            case 2:
                return AbstractEscherOptRecord.lambda$setEscherProperty$1((EscherProperty) this.b, (EscherProperty) obj);
            case 3:
                return AbstractEscherOptRecord.lambda$removeEscherProperty$2((EscherPropertyTypes) this.b, (EscherProperty) obj);
            case 4:
                return ExtractorFactory.lambda$removeProvider$8((Class) this.b, (ExtractorProvider) obj);
            case 5:
                return RevocationData.lambda$addCRL$0((byte[]) this.b, (byte[]) obj);
            case 6:
                return XWPFParagraph.lambda$isTheOnlyCTFieldInRuns$4((CTSimpleField) this.b, (XWPFRun) obj);
            case 7:
                return XWPFParagraph.lambda$isTheOnlyCTHyperlinkInRuns$3((CTHyperlink) this.b, (XWPFRun) obj);
            default:
                return ((QNameSetSpecification) this.b).contains((QName) obj);
        }
    }
}
