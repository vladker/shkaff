package com.google.android.material.color.utilities;

import java.io.File;
import java.nio.file.Path;
import java.util.function.Function;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.poi.openxml4j.opc.ZipPackage;
import org.apache.poi.xddf.usermodel.text.XDDFTextBody;
import org.apache.poi.xddf.usermodel.text.XDDFTextParagraph;
import org.apache.poi.xssf.usermodel.XSSFEvaluationWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.tool.MavenPlugin;
import org.apache.xmlbeans.impl.values.XmlListImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacing;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3332a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Object obj, int i5) {
        this.f3332a = i5;
        this.b = obj;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f3332a) {
            case 0:
                return DynamicColor.lambda$fromArgb$0((TonalPalette) this.b, (DynamicScheme) obj);
            case 1:
                return DynamicColor.lambda$fromArgb$1((Hct) this.b, (DynamicScheme) obj);
            case 2:
                return ((TemperatureCache) this.b).lambda$getHctsByTemp$0((Hct) obj);
            case 3:
                return ((Path) this.b).relativize((Path) obj);
            case 4:
                return ((ZipPackage) this.b).lambda$getPartsImpl$1((ZipArchiveEntry) obj);
            case 5:
                return ((XDDFTextBody) this.b).lambda$getParagraphs$0((CTTextParagraph) obj);
            case 6:
                return ((XDDFTextParagraph) this.b).extractSpacing((CTTextSpacing) obj);
            case 7:
                return XSSFEvaluationWorkbook.lambda$getSheet$0((XSSFSheet) this.b, (XSSFSheet) obj);
            case 8:
                return MavenPlugin.lambda$execute$1((File) this.b, (String) obj);
            default:
                return XmlListImpl.lambda$set_list$1((SchemaType) this.b, obj);
        }
    }
}
