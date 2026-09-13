package com.google.android.material.color.utilities;

import java.nio.file.Path;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.poi.ddf.EscherDggRecord;
import org.apache.poi.ddf.EscherPropertyTypes;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.EscherRecordTypes;
import org.apache.poi.hssf.record.CFRuleBase;
import org.apache.poi.hssf.record.ColumnInfoRecord;
import org.apache.poi.hssf.record.common.FormatRun;
import org.apache.poi.hssf.record.common.PhRun;
import org.apache.poi.openxml4j.opc.internal.PackagePropertiesPart;
import org.apache.poi.poifs.crypt.dsig.SignatureConfig;
import org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet;
import org.apache.poi.sl.extractor.SlideShowExtractor;
import org.apache.poi.sl.usermodel.Comment;
import org.apache.poi.sl.usermodel.TextRun;
import org.apache.poi.ss.format.CellFormat;
import org.apache.poi.ss.formula.eval.forked.ForkedEvaluator;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.xmlbeans.SimpleValue;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class g implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3338a;

    public /* synthetic */ g(int i5) {
        this.f3338a = i5;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f3338a) {
            case 0:
                return MaterialDynamicColors.lambda$surfaceContainerHighest$30((DynamicScheme) obj);
            case 1:
                return ((DynamicScheme) obj).primaryPalette;
            case 2:
                return MaterialDynamicColors.lambda$primaryFixed$104((DynamicScheme) obj);
            case 3:
                return ((DynamicScheme) obj).primaryPalette;
            case 4:
                return MaterialDynamicColors.lambda$primaryFixedDim$107((DynamicScheme) obj);
            case 5:
                return ((DynamicScheme) obj).tertiaryPalette;
            case 6:
                return MaterialDynamicColors.lambda$tertiaryContainer$86((DynamicScheme) obj);
            case 7:
                return ((SimpleValue) obj).getCalendarValue();
            case 8:
                return ZipFile.lambda$fillNameMap$0((String) obj);
            case 9:
                return ((Path) obj).toFile();
            case 10:
                return ((EscherRecord) obj).copy();
            case 11:
                return new EscherDggRecord.FileIdCluster((EscherDggRecord.FileIdCluster) obj);
            case 12:
                return Short.valueOf(((EscherPropertyTypes) obj).getPropertyId());
            case 13:
                return ((EscherRecordTypes) obj).getTypeId();
            case 14:
                return ((CFRuleBase) obj).copy();
            case 15:
                return ((ColumnInfoRecord) obj).copy();
            case 16:
                return new PhRun((PhRun) obj);
            case 17:
                return new FormatRun((FormatRun) obj);
            case 18:
                return PackagePropertiesPart.getDateValue((Date) obj);
            case 19:
                return Stream.of((Object[]) obj);
            case 20:
                return (X509Certificate) X509Certificate.class.cast((Certificate) obj);
            case 21:
                return (SignatureFacet) ((Supplier) obj).get();
            case 22:
                return ((SignatureConfig.CRLEntry) obj).getCrlBytes();
            case 23:
                return SlideShowExtractor.replaceSlideNumber((TextRun) obj);
            case 24:
                return SlideShowExtractor.replaceTextCap((TextRun) obj);
            case 25:
                return SlideShowExtractor.lambda$printComments$1((Comment) obj);
            case 26:
                return CellFormat.lambda$getInstance$0((Locale) obj);
            case 27:
                return ((ForkedEvaluator) obj)._evaluator;
            case 28:
                return (GenericRecordJsonWriter.GenericRecordHandler) ((Map.Entry) obj).getValue();
            default:
                return (String) ((Map.Entry) obj).getValue();
        }
    }
}
