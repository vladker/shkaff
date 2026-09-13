package org.apache.poi.xslf.extractor;

import org.apache.poi.ooxml.extractor.POIXMLPropertiesTextExtractor;
import org.apache.poi.ooxml.extractor.POIXMLTextExtractor;
import org.apache.poi.sl.extractor.SlideShowExtractor;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSLFExtractor extends SlideShowExtractor<XSLFShape, XSLFTextParagraph> implements POIXMLTextExtractor {
    public XSLFExtractor(XMLSlideShow xMLSlideShow) {
        super(xMLSlideShow);
    }

    @Override // org.apache.poi.sl.extractor.SlideShowExtractor, org.apache.poi.extractor.POITextExtractor
    public POIXMLPropertiesTextExtractor getMetadataTextExtractor() {
        return super.getMetadataTextExtractor();
    }

    @Override // org.apache.poi.sl.extractor.SlideShowExtractor, org.apache.poi.extractor.POITextExtractor
    public XMLSlideShow getDocument() {
        return (XMLSlideShow) this.slideshow;
    }
}
