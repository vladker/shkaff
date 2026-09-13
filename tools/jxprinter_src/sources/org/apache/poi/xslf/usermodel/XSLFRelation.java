package org.apache.poi.xslf.usermodel;

import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.ooxml.POIXMLRelation;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.poi.sl.usermodel.PictureData;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class XSLFRelation extends POIXMLRelation {
    public static final XSLFRelation FONT;
    public static final XSLFRelation HDPHOTO_WDP;
    public static final XSLFRelation IMAGES;
    public static final XSLFRelation IMAGE_SVG;
    public static final XSLFRelation IMAGE_WDP;
    static final String NS_DRAWINGML = "http://schemas.openxmlformats.org/drawingml/2006/main";
    public static final XSLFRelation OLE_OBJECT;
    public static final XSLFRelation TABLE_STYLES;
    private static final Map<String, XSLFRelation> _table = new HashMap();
    public static final XSLFRelation MAIN = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.presentation.main+xml");
    public static final XSLFRelation MACRO = new XSLFRelation("application/vnd.ms-powerpoint.slideshow.macroEnabled.main+xml");
    public static final XSLFRelation MACRO_TEMPLATE = new XSLFRelation("application/vnd.ms-powerpoint.template.macroEnabled.main+xml");
    public static final XSLFRelation PRESENTATIONML = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.slideshow.main+xml");
    public static final XSLFRelation PRESENTATIONML_TEMPLATE = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.template.main+xml");
    public static final XSLFRelation PRESENTATION_MACRO = new XSLFRelation("application/vnd.ms-powerpoint.presentation.macroEnabled.main+xml");
    public static final XSLFRelation THEME_MANAGER = new XSLFRelation("application/vnd.openxmlformats-officedocument.themeManager+xml");
    public static final XSLFRelation NOTES = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.notesSlide+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/notesSlide", "/ppt/notesSlides/notesSlide#.xml", new org.apache.poi.xdgf.usermodel.a(8), new org.apache.poi.xdgf.usermodel.a(10));
    public static final XSLFRelation SLIDE = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.slide+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/slide", "/ppt/slides/slide#.xml", new org.apache.poi.xdgf.usermodel.a(13), new org.apache.poi.xdgf.usermodel.a(14));
    public static final XSLFRelation SLIDE_LAYOUT = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.slideLayout+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/slideLayout", "/ppt/slideLayouts/slideLayout#.xml", null, new org.apache.poi.xdgf.usermodel.a(15));
    public static final XSLFRelation SLIDE_MASTER = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.slideMaster+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/slideMaster", "/ppt/slideMasters/slideMaster#.xml", null, new org.apache.poi.xdgf.usermodel.a(23));
    public static final XSLFRelation NOTES_MASTER = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.notesMaster+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/notesMaster", "/ppt/notesMasters/notesMaster#.xml", new org.apache.poi.xdgf.usermodel.a(24), new org.apache.poi.xdgf.usermodel.a(25));
    public static final XSLFRelation COMMENTS = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.comments+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/comments", "/ppt/comments/comment#.xml", new org.apache.poi.xdgf.usermodel.a(26), new org.apache.poi.xdgf.usermodel.a(27));
    public static final XSLFRelation COMMENT_AUTHORS = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.commentAuthors+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/commentAuthors", "/ppt/commentAuthors.xml", new org.apache.poi.xdgf.usermodel.a(19), new org.apache.poi.xdgf.usermodel.a(28));
    public static final XSLFRelation HYPERLINK = new XSLFRelation(null, PackageRelationshipTypes.HYPERLINK_PART, null);
    public static final XSLFRelation THEME = new XSLFRelation("application/vnd.openxmlformats-officedocument.theme+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/theme", "/ppt/theme/theme#.xml", new org.apache.poi.xdgf.usermodel.a(29), new e(0));
    public static final XSLFRelation VML_DRAWING = new XSLFRelation("application/vnd.openxmlformats-officedocument.vmlDrawing", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/vmlDrawing", "/ppt/drawings/vmlDrawing#.vml");
    public static final XSLFRelation WORKBOOK = new XSLFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", POIXMLDocument.PACK_OBJECT_REL_TYPE, "/ppt/embeddings/Microsoft_Excel_Worksheet#.xlsx", new e(1), new e(2));
    public static final XSLFRelation CHART = new XSLFRelation("application/vnd.openxmlformats-officedocument.drawingml.chart+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/chart", "/ppt/charts/chart#.xml", new e(3), new e(4));
    public static final XSLFRelation DIAGRAM_DRAWING = new XSLFRelation("application/vnd.ms-office.drawingml.diagramDrawing+xml", "http://schemas.microsoft.com/office/2007/relationships/diagramDrawing", "/ppt/diagrams/drawing#.xml", new e(5), new org.apache.poi.xdgf.usermodel.a(9));
    public static final XSLFRelation IMAGE_EMF = new XSLFRelation(PictureData.PictureType.EMF.contentType, PackageRelationshipTypes.IMAGE_PART, "/ppt/media/image#.emf", new org.apache.poi.xdgf.usermodel.a(11), new org.apache.poi.xdgf.usermodel.a(12));
    public static final XSLFRelation IMAGE_WMF = new XSLFRelation(PictureData.PictureType.WMF.contentType, PackageRelationshipTypes.IMAGE_PART, "/ppt/media/image#.wmf", new org.apache.poi.xdgf.usermodel.a(11), new org.apache.poi.xdgf.usermodel.a(12));
    public static final XSLFRelation IMAGE_PICT = new XSLFRelation(PictureData.PictureType.PICT.contentType, PackageRelationshipTypes.IMAGE_PART, "/ppt/media/image#.pict", new org.apache.poi.xdgf.usermodel.a(11), new org.apache.poi.xdgf.usermodel.a(12));
    public static final XSLFRelation IMAGE_JPEG = new XSLFRelation(PictureData.PictureType.JPEG.contentType, PackageRelationshipTypes.IMAGE_PART, "/ppt/media/image#.jpeg", new org.apache.poi.xdgf.usermodel.a(11), new org.apache.poi.xdgf.usermodel.a(12));
    public static final XSLFRelation IMAGE_PNG = new XSLFRelation(PictureData.PictureType.PNG.contentType, PackageRelationshipTypes.IMAGE_PART, "/ppt/media/image#.png", new org.apache.poi.xdgf.usermodel.a(11), new org.apache.poi.xdgf.usermodel.a(12));
    public static final XSLFRelation IMAGE_DIB = new XSLFRelation(PictureData.PictureType.DIB.contentType, PackageRelationshipTypes.IMAGE_PART, "/ppt/media/image#.dib", new org.apache.poi.xdgf.usermodel.a(11), new org.apache.poi.xdgf.usermodel.a(12));
    public static final XSLFRelation IMAGE_GIF = new XSLFRelation(PictureData.PictureType.GIF.contentType, PackageRelationshipTypes.IMAGE_PART, "/ppt/media/image#.gif", new org.apache.poi.xdgf.usermodel.a(11), new org.apache.poi.xdgf.usermodel.a(12));
    public static final XSLFRelation IMAGE_TIFF = new XSLFRelation(PictureData.PictureType.TIFF.contentType, PackageRelationshipTypes.IMAGE_PART, "/ppt/media/image#.tiff", new org.apache.poi.xdgf.usermodel.a(11), new org.apache.poi.xdgf.usermodel.a(12));
    public static final XSLFRelation IMAGE_EPS = new XSLFRelation(PictureData.PictureType.EPS.contentType, PackageRelationshipTypes.IMAGE_PART, "/ppt/media/image#.eps", new org.apache.poi.xdgf.usermodel.a(11), new org.apache.poi.xdgf.usermodel.a(12));
    public static final XSLFRelation IMAGE_BMP = new XSLFRelation(PictureData.PictureType.BMP.contentType, PackageRelationshipTypes.IMAGE_PART, "/ppt/media/image#.bmp", new org.apache.poi.xdgf.usermodel.a(11), new org.apache.poi.xdgf.usermodel.a(12));
    public static final XSLFRelation IMAGE_WPG = new XSLFRelation(PictureData.PictureType.WPG.contentType, PackageRelationshipTypes.IMAGE_PART, "/ppt/media/image#.wpg", new org.apache.poi.xdgf.usermodel.a(11), new org.apache.poi.xdgf.usermodel.a(12));

    static {
        PictureData.PictureType pictureType = PictureData.PictureType.WDP;
        IMAGE_WDP = new XSLFRelation(pictureType.contentType, PackageRelationshipTypes.IMAGE_PART, "/ppt/media/image#.wdp", new org.apache.poi.xdgf.usermodel.a(11), new org.apache.poi.xdgf.usermodel.a(12));
        HDPHOTO_WDP = new XSLFRelation(pictureType.contentType, PackageRelationshipTypes.HDPHOTO_PART, "/ppt/media/hdphoto#.wdp", new org.apache.poi.xdgf.usermodel.a(11), new org.apache.poi.xdgf.usermodel.a(12));
        IMAGE_SVG = new XSLFRelation(PictureData.PictureType.SVG.contentType, PackageRelationshipTypes.IMAGE_PART, "/ppt/media/image#.svg", new org.apache.poi.xdgf.usermodel.a(11), new org.apache.poi.xdgf.usermodel.a(12));
        IMAGES = new XSLFRelation(null, PackageRelationshipTypes.IMAGE_PART, null, new org.apache.poi.xdgf.usermodel.a(11), new org.apache.poi.xdgf.usermodel.a(12));
        TABLE_STYLES = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.tableStyles+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/tableStyles", "/ppt/tableStyles.xml", new org.apache.poi.xdgf.usermodel.a(16), new org.apache.poi.xdgf.usermodel.a(17));
        OLE_OBJECT = new XSLFRelation("application/vnd.openxmlformats-officedocument.oleObject", POIXMLDocument.OLE_OBJECT_REL_TYPE, "/ppt/embeddings/oleObject#.bin", new org.apache.poi.xdgf.usermodel.a(18), new org.apache.poi.xdgf.usermodel.a(20));
        FONT = new XSLFRelation("application/x-fontdata", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/font", "/ppt/fonts/font#.fntdata", new org.apache.poi.xdgf.usermodel.a(21), new org.apache.poi.xdgf.usermodel.a(22));
    }

    private XSLFRelation(String str) {
        this(str, null, null, null, null);
    }

    public static XSLFRelation getInstance(String str) {
        return _table.get(str);
    }

    private XSLFRelation(String str, String str2, String str3) {
        this(str, str2, str3, null, null);
    }

    private XSLFRelation(String str, String str2, String str3, POIXMLRelation.NoArgConstructor noArgConstructor, POIXMLRelation.PackagePartConstructor packagePartConstructor) {
        super(str, str2, str3, noArgConstructor, packagePartConstructor, null);
        _table.put(str2, this);
    }
}
