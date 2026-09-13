package org.apache.poi.xslf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.poi.common.usermodel.fonts.FontCharset;
import org.apache.poi.common.usermodel.fonts.FontFacet;
import org.apache.poi.common.usermodel.fonts.FontFamily;
import org.apache.poi.common.usermodel.fonts.FontHeader;
import org.apache.poi.common.usermodel.fonts.FontInfo;
import org.apache.poi.common.usermodel.fonts.FontPitch;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.IOUtils;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont;
import org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontDataId;
import org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontListEntry;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSLFFontInfo implements FontInfo {
    final CTEmbeddedFontListEntry fontListEntry;
    final XMLSlideShow ppt;
    final String typeface;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public final class XSLFFontFacet implements FontFacet {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final CTEmbeddedFontDataId fontEntry;
        private final FontHeader header;

        private void init() {
            if (this.header.getFamilyName() == null) {
                try {
                    InputStream inputStream = getFontData().getInputStream();
                    try {
                        byte[] byteArray = IOUtils.toByteArray(inputStream, 1000);
                        this.header.init(byteArray, 0, byteArray.length);
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                }
                            }
                            throw th2;
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        @Override // org.apache.poi.common.usermodel.fonts.FontFacet
        public int getWeight() {
            init();
            return this.header.getWeight();
        }

        @Override // org.apache.poi.common.usermodel.fonts.FontFacet
        public boolean isItalic() {
            init();
            return this.header.isItalic();
        }

        public void setFontData(InputStream inputStream) throws IOException {
            XSLFFontData xSLFFontData;
            XSLFRelation xSLFRelation = XSLFRelation.FONT;
            String id = this.fontEntry.getId();
            if (id == null || id.isEmpty()) {
                try {
                    POIXMLDocumentPart.RelationPart relationPartCreateRelationship = XSLFFontInfo.this.ppt.createRelationship(xSLFRelation, XSLFFactory.getInstance(), XSLFFontInfo.this.ppt.getPackage().getUnusedPartIndex(xSLFRelation.getDefaultFileName()), false);
                    XSLFFontData xSLFFontData2 = (XSLFFontData) relationPartCreateRelationship.getDocumentPart();
                    this.fontEntry.setId(relationPartCreateRelationship.getRelationship().getId());
                    xSLFFontData = xSLFFontData2;
                } catch (InvalidFormatException e) {
                    throw new RuntimeException(e);
                }
            } else {
                xSLFFontData = (XSLFFontData) XSLFFontInfo.this.ppt.getRelationById(id);
            }
            OutputStream outputStream = xSLFFontData.getOutputStream();
            try {
                IOUtils.copy(inputStream, outputStream);
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }

        private XSLFFontFacet(CTEmbeddedFontDataId cTEmbeddedFontDataId) {
            this.header = new FontHeader();
            this.fontEntry = cTEmbeddedFontDataId;
        }

        @Override // org.apache.poi.common.usermodel.fonts.FontFacet
        public XSLFFontData getFontData() {
            return (XSLFFontData) XSLFFontInfo.this.ppt.getRelationPartById(this.fontEntry.getId()).getDocumentPart();
        }
    }

    public XSLFFontInfo(XMLSlideShow xMLSlideShow, String str) {
        this.ppt = xMLSlideShow;
        this.typeface = str;
        CTPresentation cTPresentation = xMLSlideShow.getCTPresentation();
        CTEmbeddedFontList embeddedFontLst = cTPresentation.isSetEmbeddedFontLst() ? cTPresentation.getEmbeddedFontLst() : cTPresentation.addNewEmbeddedFontLst();
        for (CTEmbeddedFontListEntry cTEmbeddedFontListEntry : embeddedFontLst.getEmbeddedFontArray()) {
            if (str.equalsIgnoreCase(cTEmbeddedFontListEntry.getFont().getTypeface())) {
                this.fontListEntry = cTEmbeddedFontListEntry;
                return;
            }
        }
        CTEmbeddedFontListEntry cTEmbeddedFontListEntryAddNewEmbeddedFont = embeddedFontLst.addNewEmbeddedFont();
        this.fontListEntry = cTEmbeddedFontListEntryAddNewEmbeddedFont;
        cTEmbeddedFontListEntryAddNewEmbeddedFont.addNewFont().setTypeface(str);
    }

    public static XSLFFontInfo addFontToSlideShow(XMLSlideShow xMLSlideShow, InputStream inputStream) throws IOException {
        FontHeader fontHeader = new FontHeader();
        InputStream inputStreamBufferInit = fontHeader.bufferInit(inputStream);
        XSLFFontInfo xSLFFontInfo = new XSLFFontInfo(xMLSlideShow, fontHeader.getFamilyName());
        xSLFFontInfo.addFacet(inputStreamBufferInit);
        return xSLFFontInfo;
    }

    private CTTextFont getFont() {
        return this.fontListEntry.getFont();
    }

    public static List<XSLFFontInfo> getFonts(final XMLSlideShow xMLSlideShow) {
        CTPresentation cTPresentation = xMLSlideShow.getCTPresentation();
        return cTPresentation.isSetEmbeddedFontLst() ? (List) Stream.of((Object[]) cTPresentation.getEmbeddedFontLst().getEmbeddedFontArray()).map(new Function() { // from class: org.apache.poi.xslf.usermodel.c
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return XSLFFontInfo.lambda$getFonts$0(xMLSlideShow, (CTEmbeddedFontListEntry) obj);
            }
        }).collect(Collectors.toList()) : Collections.EMPTY_LIST;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XSLFFontInfo lambda$getFonts$0(XMLSlideShow xMLSlideShow, CTEmbeddedFontListEntry cTEmbeddedFontListEntry) {
        return new XSLFFontInfo(xMLSlideShow, cTEmbeddedFontListEntry);
    }

    public FontFacet addFacet(InputStream inputStream) throws IOException {
        CTEmbeddedFontDataId regular;
        FontHeader fontHeader = new FontHeader();
        InputStream inputStreamBufferInit = fontHeader.bufferInit(inputStream);
        CTPresentation cTPresentation = this.ppt.getCTPresentation();
        cTPresentation.setEmbedTrueTypeFonts(true);
        cTPresentation.setSaveSubsetFonts(true);
        int i5 = (fontHeader.getWeight() > 400 ? (char) 1 : (char) 0) | (fontHeader.isItalic() ? (char) 2 : (char) 0);
        if (i5 == 0) {
            regular = this.fontListEntry.isSetRegular() ? this.fontListEntry.getRegular() : this.fontListEntry.addNewRegular();
        } else if (i5 == 1) {
            regular = this.fontListEntry.isSetBold() ? this.fontListEntry.getBold() : this.fontListEntry.addNewBold();
        } else if (i5 != 2) {
            regular = this.fontListEntry.isSetBoldItalic() ? this.fontListEntry.getBoldItalic() : this.fontListEntry.addNewBoldItalic();
        } else {
            regular = this.fontListEntry.isSetItalic() ? this.fontListEntry.getItalic() : this.fontListEntry.addNewItalic();
        }
        XSLFFontFacet xSLFFontFacet = new XSLFFontFacet(regular);
        xSLFFontFacet.setFontData(inputStreamBufferInit);
        return xSLFFontFacet;
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public FontCharset getCharset() {
        return FontCharset.valueOf(getFont().getCharset());
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public List<FontFacet> getFacets() {
        ArrayList arrayList = new ArrayList();
        if (this.fontListEntry.isSetRegular()) {
            arrayList.add(new XSLFFontFacet(this.fontListEntry.getRegular()));
        }
        if (this.fontListEntry.isSetItalic()) {
            arrayList.add(new XSLFFontFacet(this.fontListEntry.getItalic()));
        }
        if (this.fontListEntry.isSetBold()) {
            arrayList.add(new XSLFFontFacet(this.fontListEntry.getBold()));
        }
        if (this.fontListEntry.isSetBoldItalic()) {
            arrayList.add(new XSLFFontFacet(this.fontListEntry.getBoldItalic()));
        }
        return arrayList;
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public FontFamily getFamily() {
        return FontFamily.valueOfPitchFamily(getFont().getPitchFamily());
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public byte[] getPanose() {
        return getFont().getPanose();
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public FontPitch getPitch() {
        return FontPitch.valueOfPitchFamily(getFont().getPitchFamily());
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public String getTypeface() {
        return getFont().getTypeface();
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public void setCharset(FontCharset fontCharset) {
        getFont().setCharset((byte) fontCharset.getNativeId());
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public void setFamily(FontFamily fontFamily) {
        getFont().setPitchFamily(FontPitch.getNativeId(FontPitch.valueOfPitchFamily(getFont().getPitchFamily()), fontFamily));
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public void setPitch(FontPitch fontPitch) {
        getFont().setPitchFamily(FontPitch.getNativeId(fontPitch, FontFamily.valueOfPitchFamily(getFont().getPitchFamily())));
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public void setTypeface(String str) {
        getFont().setTypeface(str);
    }

    public XSLFFontInfo(XMLSlideShow xMLSlideShow, CTEmbeddedFontListEntry cTEmbeddedFontListEntry) {
        this.ppt = xMLSlideShow;
        this.typeface = cTEmbeddedFontListEntry.getFont().getTypeface();
        this.fontListEntry = cTEmbeddedFontListEntry;
    }
}
