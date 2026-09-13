package org.apache.poi.xslf.usermodel;

import A3.AbstractC0157z;
import androidx.core.net.MailTo;
import java.net.URI;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.sl.usermodel.Hyperlink;
import org.apache.poi.sl.usermodel.Slide;
import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTHyperlink;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSLFHyperlink implements Hyperlink<XSLFShape, XSLFTextParagraph> {
    private final CTHyperlink _link;
    private final XSLFSheet _sheet;

    /* JADX INFO: renamed from: org.apache.poi.xslf.usermodel.XSLFHyperlink$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$common$usermodel$HyperlinkType;

        static {
            int[] iArr = new int[HyperlinkType.values().length];
            $SwitchMap$org$apache$poi$common$usermodel$HyperlinkType = iArr;
            try {
                iArr[HyperlinkType.EMAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$HyperlinkType[HyperlinkType.URL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$HyperlinkType[HyperlinkType.DOCUMENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$HyperlinkType[HyperlinkType.FILE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$HyperlinkType[HyperlinkType.NONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public XSLFHyperlink(CTHyperlink cTHyperlink, XSLFSheet xSLFSheet) {
        this._sheet = xSLFSheet;
        this._link = cTHyperlink;
    }

    private void linkToExternal(String str) {
        PackagePart packagePart = this._sheet.getPackagePart();
        if (this._link.isSetId() && !this._link.getId().isEmpty()) {
            packagePart.removeRelationship(this._link.getId());
        }
        this._link.setId(packagePart.addExternalRelationship(str, XSLFRelation.HYPERLINK.getRelation()).getId());
        if (this._link.isSetAction()) {
            this._link.unsetAction();
        }
    }

    private void linkToRelativeSlide(String str) {
        PackagePart packagePart = this._sheet.getPackagePart();
        if (this._link.isSetId() && !this._link.getId().isEmpty()) {
            packagePart.removeRelationship(this._link.getId());
        }
        this._link.setId("");
        this._link.setAction((str.startsWith("ppaction") ? "" : "ppaction://hlinkshowjump?jump=").concat(str));
    }

    public void copy(XSLFHyperlink xSLFHyperlink) {
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$common$usermodel$HyperlinkType[xSLFHyperlink.getType().ordinal()];
        if (i5 == 1 || i5 == 2) {
            linkToExternal(xSLFHyperlink.getAddress());
        } else {
            if (i5 != 3) {
                return;
            }
            String id = xSLFHyperlink._link.getId();
            if (id == null || id.isEmpty()) {
                linkToRelativeSlide(xSLFHyperlink.getAddress());
            } else {
                POIXMLDocumentPart relationById = xSLFHyperlink._sheet.getRelationById(id);
                if (relationById != null) {
                    this._link.setId(this._sheet.addRelation(null, XSLFRelation.SLIDE, relationById).getRelationship().getId());
                    this._link.setAction(xSLFHyperlink._link.getAction());
                }
            }
        }
        setLabel(xSLFHyperlink.getLabel());
    }

    @Override // org.apache.poi.common.usermodel.Hyperlink
    public String getAddress() {
        URI targetURI;
        String id = this._link.getId();
        if (id == null || id.isEmpty()) {
            return this._link.getAction();
        }
        PackageRelationship relationship = this._sheet.getPackagePart().getRelationship(id);
        if (relationship == null || (targetURI = relationship.getTargetURI()) == null) {
            return null;
        }
        return targetURI.toASCIIString();
    }

    @Override // org.apache.poi.common.usermodel.Hyperlink
    public String getLabel() {
        return this._link.getTooltip();
    }

    @Override // org.apache.poi.common.usermodel.Hyperlink
    public HyperlinkType getType() {
        String action = this._link.getAction();
        if (action == null) {
            action = "";
        }
        if (action.equals("ppaction://hlinksldjump") || action.startsWith("ppaction://hlinkshowjump")) {
            return HyperlinkType.DOCUMENT;
        }
        String address = getAddress();
        return (address != null ? address : "").startsWith(MailTo.MAILTO_SCHEME) ? HyperlinkType.EMAIL : HyperlinkType.URL;
    }

    @Internal
    public CTHyperlink getXmlObject() {
        return this._link;
    }

    @Override // org.apache.poi.sl.usermodel.Hyperlink
    public void linkToEmail(String str) {
        linkToExternal(AbstractC0157z.n(MailTo.MAILTO_SCHEME, str));
        setLabel(str);
    }

    @Override // org.apache.poi.sl.usermodel.Hyperlink
    public void linkToFirstSlide() {
        linkToRelativeSlide("firstslide");
    }

    @Override // org.apache.poi.sl.usermodel.Hyperlink
    public void linkToLastSlide() {
        linkToRelativeSlide("lastslide");
    }

    @Override // org.apache.poi.sl.usermodel.Hyperlink
    public void linkToNextSlide() {
        linkToRelativeSlide("nextslide");
    }

    @Override // org.apache.poi.sl.usermodel.Hyperlink
    public void linkToPreviousSlide() {
        linkToRelativeSlide("previousslide");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.poi.sl.usermodel.Hyperlink
    public void linkToSlide(Slide<XSLFShape, XSLFTextParagraph> slide) {
        if (this._link.isSetId() && !this._link.getId().isEmpty()) {
            this._sheet.getPackagePart().removeRelationship(this._link.getId());
        }
        this._link.setId(this._sheet.addRelation(null, XSLFRelation.SLIDE, (XSLFSheet) slide).getRelationship().getId());
        this._link.setAction("ppaction://hlinksldjump");
    }

    @Override // org.apache.poi.sl.usermodel.Hyperlink
    public void linkToUrl(String str) {
        linkToExternal(str);
        setLabel(str);
    }

    @Override // org.apache.poi.common.usermodel.Hyperlink
    public void setAddress(String str) {
        linkToUrl(str);
    }

    @Override // org.apache.poi.common.usermodel.Hyperlink
    public void setLabel(String str) {
        this._link.setTooltip(str);
    }
}
