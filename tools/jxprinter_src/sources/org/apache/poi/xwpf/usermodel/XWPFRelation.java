package org.apache.poi.xwpf.usermodel;

import java.util.HashMap;
import java.util.Map;
import org.apache.poi.common.usermodel.PictureType;
import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.ooxml.POIXMLRelation;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.poi.xslf.usermodel.e;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class XWPFRelation extends POIXMLRelation {
    private static final Map<String, XWPFRelation> _table = new HashMap();
    public static final XWPFRelation DOCUMENT = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.document.main+xml", PackageRelationshipTypes.CORE_DOCUMENT, "/word/document.xml");
    public static final XWPFRelation TEMPLATE = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.template.main+xml", PackageRelationshipTypes.CORE_DOCUMENT, "/word/document.xml");
    public static final XWPFRelation MACRO_DOCUMENT = new XWPFRelation("application/vnd.ms-word.document.macroEnabled.main+xml", PackageRelationshipTypes.CORE_DOCUMENT, "/word/document.xml");
    public static final XWPFRelation MACRO_TEMPLATE_DOCUMENT = new XWPFRelation("application/vnd.ms-word.template.macroEnabledTemplate.main+xml", PackageRelationshipTypes.CORE_DOCUMENT, "/word/document.xml");
    public static final XWPFRelation GLOSSARY_DOCUMENT = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.document.glossary+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/glossaryDocument", "/word/glossary/document.xml");
    public static final XWPFRelation NUMBERING = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.numbering+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/numbering", "/word/numbering.xml", (POIXMLRelation.NoArgConstructor) new org.apache.poi.xssf.usermodel.b(5), (POIXMLRelation.PackagePartConstructor) new org.apache.poi.xssf.usermodel.b(24));
    public static final XWPFRelation FONT_TABLE = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.fontTable+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/fontTable", "/word/fontTable.xml");
    public static final XWPFRelation SETTINGS = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.settings+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/settings", "/word/settings.xml", (POIXMLRelation.NoArgConstructor) new org.apache.poi.xssf.usermodel.b(8), (POIXMLRelation.PackagePartConstructor) new org.apache.poi.xssf.usermodel.b(9));
    public static final XWPFRelation STYLES = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.styles+xml", PackageRelationshipTypes.STYLE_PART, "/word/styles.xml", (POIXMLRelation.NoArgConstructor) new org.apache.poi.xssf.usermodel.b(10), (POIXMLRelation.PackagePartConstructor) new org.apache.poi.xssf.usermodel.b(11));
    public static final XWPFRelation WEB_SETTINGS = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.webSettings+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/webSettings", "/word/webSettings.xml");
    public static final XWPFRelation HEADER = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.header+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/header", "/word/header#.xml", (POIXMLRelation.NoArgConstructor) new org.apache.poi.xssf.usermodel.b(12), (POIXMLRelation.ParentPartConstructor) new org.apache.poi.xssf.usermodel.b(13));
    public static final XWPFRelation FOOTER = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.footer+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/footer", "/word/footer#.xml", (POIXMLRelation.NoArgConstructor) new org.apache.poi.xssf.usermodel.b(14), (POIXMLRelation.ParentPartConstructor) new org.apache.poi.xssf.usermodel.b(15));
    public static final XWPFRelation THEME = new XWPFRelation("application/vnd.openxmlformats-officedocument.theme+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/theme", "/word/theme/theme#.xml");
    public static final XWPFRelation WORKBOOK = new XWPFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", POIXMLDocument.PACK_OBJECT_REL_TYPE, "/word/embeddings/Microsoft_Excel_Worksheet#.xlsx", new e(1), new e(2));
    public static final XWPFRelation CHART = new XWPFRelation("application/vnd.openxmlformats-officedocument.drawingml.chart+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/chart", "/word/charts/chart#.xml", (POIXMLRelation.NoArgConstructor) new org.apache.poi.xssf.usermodel.b(16), (POIXMLRelation.PackagePartConstructor) new org.apache.poi.xssf.usermodel.b(17));
    public static final XWPFRelation HYPERLINK = new XWPFRelation(null, PackageRelationshipTypes.HYPERLINK_PART, null);
    public static final XWPFRelation COMMENT = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.comments+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/comments", "/word/comments.xml", (POIXMLRelation.NoArgConstructor) new org.apache.poi.xssf.usermodel.b(18), (POIXMLRelation.ParentPartConstructor) new org.apache.poi.xssf.usermodel.b(19));
    public static final XWPFRelation FOOTNOTE = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.footnotes+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/footnotes", "/word/footnotes.xml", (POIXMLRelation.NoArgConstructor) new org.apache.poi.xssf.usermodel.b(20), (POIXMLRelation.PackagePartConstructor) new org.apache.poi.xssf.usermodel.b(21));
    public static final XWPFRelation ENDNOTE = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.endnotes+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/endnotes", "/word/endnotes.xml", (POIXMLRelation.NoArgConstructor) new org.apache.poi.xssf.usermodel.b(22), (POIXMLRelation.PackagePartConstructor) new org.apache.poi.xssf.usermodel.b(23));
    public static final XWPFRelation IMAGE_EMF = new XWPFRelation(PictureType.EMF.contentType, PackageRelationshipTypes.IMAGE_PART, "/word/media/image#.emf", (POIXMLRelation.NoArgConstructor) new org.apache.poi.xssf.usermodel.b(6), (POIXMLRelation.PackagePartConstructor) new org.apache.poi.xssf.usermodel.b(7));
    public static final XWPFRelation IMAGE_WMF = new XWPFRelation(PictureType.WMF.contentType, PackageRelationshipTypes.IMAGE_PART, "/word/media/image#.wmf", (POIXMLRelation.NoArgConstructor) new org.apache.poi.xssf.usermodel.b(6), (POIXMLRelation.PackagePartConstructor) new org.apache.poi.xssf.usermodel.b(7));
    public static final XWPFRelation IMAGE_PICT = new XWPFRelation(PictureType.PICT.contentType, PackageRelationshipTypes.IMAGE_PART, "/word/media/image#.pict", (POIXMLRelation.NoArgConstructor) new org.apache.poi.xssf.usermodel.b(6), (POIXMLRelation.PackagePartConstructor) new org.apache.poi.xssf.usermodel.b(7));
    public static final XWPFRelation IMAGE_JPEG = new XWPFRelation(PictureType.JPEG.contentType, PackageRelationshipTypes.IMAGE_PART, "/word/media/image#.jpeg", (POIXMLRelation.NoArgConstructor) new org.apache.poi.xssf.usermodel.b(6), (POIXMLRelation.PackagePartConstructor) new org.apache.poi.xssf.usermodel.b(7));
    public static final XWPFRelation IMAGE_PNG = new XWPFRelation(PictureType.PNG.contentType, PackageRelationshipTypes.IMAGE_PART, "/word/media/image#.png", (POIXMLRelation.NoArgConstructor) new org.apache.poi.xssf.usermodel.b(6), (POIXMLRelation.PackagePartConstructor) new org.apache.poi.xssf.usermodel.b(7));
    public static final XWPFRelation IMAGE_DIB = new XWPFRelation(PictureType.DIB.contentType, PackageRelationshipTypes.IMAGE_PART, "/word/media/image#.dib", (POIXMLRelation.NoArgConstructor) new org.apache.poi.xssf.usermodel.b(6), (POIXMLRelation.PackagePartConstructor) new org.apache.poi.xssf.usermodel.b(7));
    public static final XWPFRelation IMAGE_GIF = new XWPFRelation(PictureType.GIF.contentType, PackageRelationshipTypes.IMAGE_PART, "/word/media/image#.gif", (POIXMLRelation.NoArgConstructor) new org.apache.poi.xssf.usermodel.b(6), (POIXMLRelation.PackagePartConstructor) new org.apache.poi.xssf.usermodel.b(7));
    public static final XWPFRelation IMAGE_TIFF = new XWPFRelation(PictureType.TIFF.contentType, PackageRelationshipTypes.IMAGE_PART, "/word/media/image#.tiff", (POIXMLRelation.NoArgConstructor) new org.apache.poi.xssf.usermodel.b(6), (POIXMLRelation.PackagePartConstructor) new org.apache.poi.xssf.usermodel.b(7));
    public static final XWPFRelation IMAGE_EPS = new XWPFRelation(PictureType.EPS.contentType, PackageRelationshipTypes.IMAGE_PART, "/word/media/image#.eps", (POIXMLRelation.NoArgConstructor) new org.apache.poi.xssf.usermodel.b(6), (POIXMLRelation.PackagePartConstructor) new org.apache.poi.xssf.usermodel.b(7));
    public static final XWPFRelation IMAGE_BMP = new XWPFRelation(PictureType.BMP.contentType, PackageRelationshipTypes.IMAGE_PART, "/word/media/image#.bmp", (POIXMLRelation.NoArgConstructor) new org.apache.poi.xssf.usermodel.b(6), (POIXMLRelation.PackagePartConstructor) new org.apache.poi.xssf.usermodel.b(7));
    public static final XWPFRelation IMAGE_WPG = new XWPFRelation(PictureType.WPG.contentType, PackageRelationshipTypes.IMAGE_PART, "/word/media/image#.wpg", (POIXMLRelation.NoArgConstructor) new org.apache.poi.xssf.usermodel.b(6), (POIXMLRelation.PackagePartConstructor) new org.apache.poi.xssf.usermodel.b(7));
    public static final XWPFRelation HDPHOTO_WDP = new XWPFRelation(PictureType.WDP.contentType, PackageRelationshipTypes.HDPHOTO_PART, "/ppt/media/hdphoto#.wdp", (POIXMLRelation.NoArgConstructor) new org.apache.poi.xssf.usermodel.b(6), (POIXMLRelation.PackagePartConstructor) new org.apache.poi.xssf.usermodel.b(7));
    public static final XWPFRelation IMAGES = new XWPFRelation((String) null, PackageRelationshipTypes.IMAGE_PART, (String) null, (POIXMLRelation.NoArgConstructor) new org.apache.poi.xssf.usermodel.b(6), (POIXMLRelation.PackagePartConstructor) new org.apache.poi.xssf.usermodel.b(7));

    private XWPFRelation(String str, String str2, String str3) {
        super(str, str2, str3);
        _table.put(str2, this);
    }

    public static XWPFRelation getInstance(String str) {
        return _table.get(str);
    }

    private XWPFRelation(String str, String str2, String str3, POIXMLRelation.NoArgConstructor noArgConstructor, POIXMLRelation.PackagePartConstructor packagePartConstructor) {
        super(str, str2, str3, noArgConstructor, packagePartConstructor, null);
        _table.put(str2, this);
    }

    private XWPFRelation(String str, String str2, String str3, POIXMLRelation.NoArgConstructor noArgConstructor, POIXMLRelation.ParentPartConstructor parentPartConstructor) {
        super(str, str2, str3, noArgConstructor, null, parentPartConstructor);
        _table.put(str2, this);
    }
}
