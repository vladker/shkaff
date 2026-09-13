package org.apache.poi.xslf.usermodel;

import java.util.function.Consumer;
import javax.xml.namespace.QName;
import org.apache.poi.ooxml.util.XPathHelper;
import org.apache.poi.sl.usermodel.MasterSheet;
import org.apache.poi.sl.usermodel.Placeholder;
import org.apache.poi.sl.usermodel.PlaceholderDetails;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps;
import org.openxmlformats.schemas.presentationml.x2006.main.CTHeaderFooter;
import org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster;
import org.openxmlformats.schemas.presentationml.x2006.main.STPlaceholderSize;
import org.openxmlformats.schemas.presentationml.x2006.main.STPlaceholderType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSLFPlaceholderDetails implements PlaceholderDetails {
    private static final QName[] NV_CONTAINER = {new QName(XSSFRelation.NS_PRESENTATIONML, "nvSpPr"), new QName(XSSFRelation.NS_PRESENTATIONML, "nvCxnSpPr"), new QName(XSSFRelation.NS_PRESENTATIONML, "nvGrpSpPr"), new QName(XSSFRelation.NS_PRESENTATIONML, "nvPicPr"), new QName(XSSFRelation.NS_PRESENTATIONML, "nvGraphicFramePr")};
    private static final QName[] NV_PROPS = {new QName(XSSFRelation.NS_PRESENTATIONML, "nvPr")};
    private CTPlaceholder _ph;
    private final XSLFShape shape;

    /* JADX INFO: renamed from: org.apache.poi.xslf.usermodel.XSLFPlaceholderDetails$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$Placeholder;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$PlaceholderDetails$PlaceholderSize;

        static {
            int[] iArr = new int[PlaceholderDetails.PlaceholderSize.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$PlaceholderDetails$PlaceholderSize = iArr;
            try {
                iArr[PlaceholderDetails.PlaceholderSize.full.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$PlaceholderDetails$PlaceholderSize[PlaceholderDetails.PlaceholderSize.half.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$PlaceholderDetails$PlaceholderSize[PlaceholderDetails.PlaceholderSize.quarter.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[Placeholder.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$Placeholder = iArr2;
            try {
                iArr2[Placeholder.DATETIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$Placeholder[Placeholder.FOOTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$Placeholder[Placeholder.HEADER.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$Placeholder[Placeholder.SLIDE_NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public XSLFPlaceholderDetails(XSLFShape xSLFShape) {
        this.shape = xSLFShape;
    }

    private CTHeaderFooter getHeaderFooter(boolean z6) {
        XSLFSheet sheet = this.shape.getSheet();
        if (!(sheet instanceof MasterSheet) || (sheet instanceof XSLFSlideLayout)) {
            sheet = (XSLFSheet) sheet.getMasterSheet();
        }
        if (sheet instanceof XSLFSlideMaster) {
            CTSlideMaster xmlObject = ((XSLFSlideMaster) sheet).getXmlObject();
            return (xmlObject.isSetHf() || !z6) ? xmlObject.getHf() : xmlObject.addNewHf();
        }
        if (!(sheet instanceof XSLFNotesMaster)) {
            return null;
        }
        CTNotesMaster xmlObject2 = ((XSLFNotesMaster) sheet).getXmlObject();
        return (xmlObject2.isSetHf() || !z6) ? xmlObject2.getHf() : xmlObject2.addNewHf();
    }

    private CTApplicationNonVisualDrawingProps getNvProps() {
        try {
            return (CTApplicationNonVisualDrawingProps) XPathHelper.selectProperty(this.shape.getXmlObject(), CTApplicationNonVisualDrawingProps.class, null, NV_CONTAINER, NV_PROPS);
        } catch (XmlException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Consumer lambda$setVisible$0(CTHeaderFooter cTHeaderFooter) {
        cTHeaderFooter.getClass();
        return new d(cTHeaderFooter, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Consumer lambda$setVisible$1(CTHeaderFooter cTHeaderFooter) {
        cTHeaderFooter.getClass();
        return new d(cTHeaderFooter, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Consumer lambda$setVisible$2(CTHeaderFooter cTHeaderFooter) {
        cTHeaderFooter.getClass();
        return new d(cTHeaderFooter, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Consumer lambda$setVisible$3(CTHeaderFooter cTHeaderFooter) {
        cTHeaderFooter.getClass();
        return new d(cTHeaderFooter, 3);
    }

    public CTPlaceholder getCTPlaceholder(boolean z6) {
        CTPlaceholder cTPlaceholder = this._ph;
        if (cTPlaceholder != null) {
            return cTPlaceholder;
        }
        CTApplicationNonVisualDrawingProps nvProps = getNvProps();
        if (nvProps == null) {
            return null;
        }
        CTPlaceholder ph = (nvProps.isSetPh() || !z6) ? nvProps.getPh() : nvProps.addNewPh();
        this._ph = ph;
        return ph;
    }

    @Override // org.apache.poi.sl.usermodel.PlaceholderDetails
    public Placeholder getPlaceholder() {
        CTPlaceholder cTPlaceholder = getCTPlaceholder(false);
        if (cTPlaceholder == null) {
            return null;
        }
        if (cTPlaceholder.isSetType() || cTPlaceholder.isSetIdx()) {
            return Placeholder.lookupOoxml(cTPlaceholder.getType().intValue());
        }
        return null;
    }

    public XSLFSimpleShape getPlaceholderShape() {
        CTPlaceholder cTPlaceholder = getCTPlaceholder(false);
        if (cTPlaceholder == null) {
            return null;
        }
        return ((XSLFSheet) this.shape.getSheet().getMasterSheet()).getPlaceholder(cTPlaceholder);
    }

    @Override // org.apache.poi.sl.usermodel.PlaceholderDetails
    public PlaceholderDetails.PlaceholderSize getSize() {
        CTPlaceholder cTPlaceholder = getCTPlaceholder(false);
        if (cTPlaceholder == null || !cTPlaceholder.isSetSz()) {
            return null;
        }
        int iIntValue = cTPlaceholder.getSz().intValue();
        if (iIntValue == 1) {
            return PlaceholderDetails.PlaceholderSize.full;
        }
        if (iIntValue == 2) {
            return PlaceholderDetails.PlaceholderSize.half;
        }
        if (iIntValue != 3) {
            return null;
        }
        return PlaceholderDetails.PlaceholderSize.quarter;
    }

    @Override // org.apache.poi.sl.usermodel.PlaceholderDetails
    public String getText() {
        return null;
    }

    @Override // org.apache.poi.sl.usermodel.PlaceholderDetails
    public boolean isVisible() {
        CTPlaceholder cTPlaceholder = getCTPlaceholder(false);
        if (cTPlaceholder != null && cTPlaceholder.isSetType()) {
            CTHeaderFooter headerFooter = getHeaderFooter(false);
            if (headerFooter == null) {
                return false;
            }
            Placeholder placeholderLookupOoxml = Placeholder.lookupOoxml(cTPlaceholder.getType().intValue());
            if (placeholderLookupOoxml == null) {
                return true;
            }
            int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$sl$usermodel$Placeholder[placeholderLookupOoxml.ordinal()];
            if (i5 != 1) {
                if (i5 == 2) {
                    return !headerFooter.isSetFtr() || headerFooter.getFtr();
                }
                if (i5 != 3) {
                    return (i5 == 4 && headerFooter.isSetSldNum() && !headerFooter.getSldNum()) ? false : true;
                }
                return !headerFooter.isSetHdr() || headerFooter.getHdr();
            }
            if (headerFooter.isSetDt() && !headerFooter.getDt()) {
                return false;
            }
        }
        return true;
    }

    @Override // org.apache.poi.sl.usermodel.PlaceholderDetails
    public void setPlaceholder(Placeholder placeholder) {
        CTPlaceholder cTPlaceholder = getCTPlaceholder(placeholder != null);
        if (cTPlaceholder != null) {
            if (placeholder != null) {
                cTPlaceholder.setType(STPlaceholderType.Enum.forInt(placeholder.ooxmlId));
                return;
            }
            CTApplicationNonVisualDrawingProps nvProps = getNvProps();
            if (nvProps != null) {
                nvProps.unsetPh();
            }
        }
    }

    @Override // org.apache.poi.sl.usermodel.PlaceholderDetails
    public void setSize(PlaceholderDetails.PlaceholderSize placeholderSize) {
        CTPlaceholder cTPlaceholder = getCTPlaceholder(false);
        if (cTPlaceholder == null) {
            return;
        }
        if (placeholderSize == null) {
            cTPlaceholder.unsetSz();
            return;
        }
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$sl$usermodel$PlaceholderDetails$PlaceholderSize[placeholderSize.ordinal()];
        if (i5 == 1) {
            cTPlaceholder.setSz(STPlaceholderSize.FULL);
        } else if (i5 == 2) {
            cTPlaceholder.setSz(STPlaceholderSize.HALF);
        } else {
            if (i5 != 3) {
                return;
            }
            cTPlaceholder.setSz(STPlaceholderSize.QUARTER);
        }
    }

    @Override // org.apache.poi.sl.usermodel.PlaceholderDetails
    public void setVisible(boolean z6) {
        org.apache.poi.xddf.usermodel.text.f fVar;
        Placeholder placeholder = getPlaceholder();
        if (placeholder == null) {
            return;
        }
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$sl$usermodel$Placeholder[placeholder.ordinal()];
        if (i5 == 1) {
            fVar = new org.apache.poi.xddf.usermodel.text.f(22);
        } else if (i5 == 2) {
            fVar = new org.apache.poi.xddf.usermodel.text.f(23);
        } else if (i5 == 3) {
            fVar = new org.apache.poi.xddf.usermodel.text.f(24);
        } else if (i5 != 4) {
            return;
        } else {
            fVar = new org.apache.poi.xddf.usermodel.text.f(25);
        }
        CTHeaderFooter headerFooter = getHeaderFooter(true);
        if (headerFooter == null) {
            return;
        }
        ((Consumer) fVar.apply(headerFooter)).accept(Boolean.valueOf(z6));
    }

    @Override // org.apache.poi.sl.usermodel.PlaceholderDetails
    public void setText(String str) {
    }
}
