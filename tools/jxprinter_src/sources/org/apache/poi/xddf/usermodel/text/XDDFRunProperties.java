package org.apache.poi.xddf.usermodel.text;

import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.fonts.FontGroup;
import org.apache.poi.util.Internal;
import org.apache.poi.xddf.usermodel.XDDFColor;
import org.apache.poi.xddf.usermodel.XDDFEffectContainer;
import org.apache.poi.xddf.usermodel.XDDFEffectList;
import org.apache.poi.xddf.usermodel.XDDFExtensionList;
import org.apache.poi.xddf.usermodel.XDDFFillProperties;
import org.apache.poi.xddf.usermodel.XDDFGradientFillProperties;
import org.apache.poi.xddf.usermodel.XDDFGroupFillProperties;
import org.apache.poi.xddf.usermodel.XDDFLineProperties;
import org.apache.poi.xddf.usermodel.XDDFNoFillProperties;
import org.apache.poi.xddf.usermodel.XDDFPatternFillProperties;
import org.apache.poi.xddf.usermodel.XDDFPictureFillProperties;
import org.apache.poi.xddf.usermodel.XDDFSolidFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFRunProperties {
    private CTTextCharacterProperties props;

    /* JADX INFO: renamed from: org.apache.poi.xddf.usermodel.text.XDDFRunProperties$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$common$usermodel$fonts$FontGroup;

        static {
            int[] iArr = new int[FontGroup.values().length];
            $SwitchMap$org$apache$poi$common$usermodel$fonts$FontGroup = iArr;
            try {
                iArr[FontGroup.COMPLEX_SCRIPT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$fonts$FontGroup[FontGroup.EAST_ASIAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$fonts$FontGroup[FontGroup.LATIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$fonts$FontGroup[FontGroup.SYMBOL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public XDDFRunProperties() {
        this(CTTextCharacterProperties.Factory.newInstance());
    }

    private static <T> void update(Supplier<Boolean> supplier, Runnable runnable, Consumer<T> consumer, T t6) {
        if (t6 != null) {
            consumer.accept(t6);
        } else if (supplier.get().booleanValue()) {
            runnable.run();
        }
    }

    public XDDFEffectContainer getEffectContainer() {
        if (this.props.isSetEffectDag()) {
            return new XDDFEffectContainer(this.props.getEffectDag());
        }
        return null;
    }

    public XDDFEffectList getEffectList() {
        if (this.props.isSetEffectLst()) {
            return new XDDFEffectList(this.props.getEffectLst());
        }
        return null;
    }

    public XDDFExtensionList getExtensionList() {
        if (this.props.isSetExtLst()) {
            return new XDDFExtensionList(this.props.getExtLst());
        }
        return null;
    }

    @Internal
    public CTTextCharacterProperties getXmlObject() {
        return this.props;
    }

    public void setAlternativeLanguage(Locale locale) {
        CTTextCharacterProperties cTTextCharacterProperties = this.props;
        cTTextCharacterProperties.getClass();
        a aVar = new a(cTTextCharacterProperties, 11);
        CTTextCharacterProperties cTTextCharacterProperties2 = this.props;
        cTTextCharacterProperties2.getClass();
        b bVar = new b(cTTextCharacterProperties2, 15);
        CTTextCharacterProperties cTTextCharacterProperties3 = this.props;
        cTTextCharacterProperties3.getClass();
        update(aVar, bVar, new c(cTTextCharacterProperties3, 18), locale == null ? null : locale.toLanguageTag());
    }

    public void setBaseline(Integer num) {
        CTTextCharacterProperties cTTextCharacterProperties = this.props;
        cTTextCharacterProperties.getClass();
        a aVar = new a(cTTextCharacterProperties, 6);
        CTTextCharacterProperties cTTextCharacterProperties2 = this.props;
        cTTextCharacterProperties2.getClass();
        b bVar = new b(cTTextCharacterProperties2, 7);
        CTTextCharacterProperties cTTextCharacterProperties3 = this.props;
        cTTextCharacterProperties3.getClass();
        update(aVar, bVar, new c(cTTextCharacterProperties3, 6), num);
    }

    public void setBold(Boolean bool) {
        CTTextCharacterProperties cTTextCharacterProperties = this.props;
        cTTextCharacterProperties.getClass();
        a aVar = new a(cTTextCharacterProperties, 7);
        CTTextCharacterProperties cTTextCharacterProperties2 = this.props;
        cTTextCharacterProperties2.getClass();
        b bVar = new b(cTTextCharacterProperties2, 8);
        CTTextCharacterProperties cTTextCharacterProperties3 = this.props;
        cTTextCharacterProperties3.getClass();
        update(aVar, bVar, new c(cTTextCharacterProperties3, 8), bool);
    }

    public void setBookmark(String str) {
        CTTextCharacterProperties cTTextCharacterProperties = this.props;
        cTTextCharacterProperties.getClass();
        a aVar = new a(cTTextCharacterProperties, 16);
        CTTextCharacterProperties cTTextCharacterProperties2 = this.props;
        cTTextCharacterProperties2.getClass();
        b bVar = new b(cTTextCharacterProperties2, 17);
        CTTextCharacterProperties cTTextCharacterProperties3 = this.props;
        cTTextCharacterProperties3.getClass();
        update(aVar, bVar, new c(cTTextCharacterProperties3, 16), str);
    }

    public void setCapitals(CapsType capsType) {
        CTTextCharacterProperties cTTextCharacterProperties = this.props;
        cTTextCharacterProperties.getClass();
        a aVar = new a(cTTextCharacterProperties, 2);
        CTTextCharacterProperties cTTextCharacterProperties2 = this.props;
        cTTextCharacterProperties2.getClass();
        b bVar = new b(cTTextCharacterProperties2, 2);
        CTTextCharacterProperties cTTextCharacterProperties3 = this.props;
        cTTextCharacterProperties3.getClass();
        update(aVar, bVar, new c(cTTextCharacterProperties3, 2), capsType == null ? null : capsType.underlying);
    }

    public void setCharacterKerning(Double d) {
        if (d != null && (d.doubleValue() < 0.0d || 4000.0d < d.doubleValue())) {
            throw new IllegalArgumentException("Minimum inclusive = 0. Maximum inclusive = 4000.");
        }
        CTTextCharacterProperties cTTextCharacterProperties = this.props;
        cTTextCharacterProperties.getClass();
        a aVar = new a(cTTextCharacterProperties, 9);
        CTTextCharacterProperties cTTextCharacterProperties2 = this.props;
        cTTextCharacterProperties2.getClass();
        b bVar = new b(cTTextCharacterProperties2, 10);
        CTTextCharacterProperties cTTextCharacterProperties3 = this.props;
        cTTextCharacterProperties3.getClass();
        update(aVar, bVar, new c(cTTextCharacterProperties3, 10), d == null ? null : Integer.valueOf((int) (d.doubleValue() * 100.0d)));
    }

    public void setCharacterSpacing(Double d) {
        if (d != null && (d.doubleValue() < -4000.0d || 4000.0d < d.doubleValue())) {
            throw new IllegalArgumentException("Minimum inclusive = -4000. Maximum inclusive = 4000.");
        }
        CTTextCharacterProperties cTTextCharacterProperties = this.props;
        cTTextCharacterProperties.getClass();
        a aVar = new a(cTTextCharacterProperties, 13);
        CTTextCharacterProperties cTTextCharacterProperties2 = this.props;
        cTTextCharacterProperties2.getClass();
        b bVar = new b(cTTextCharacterProperties2, 13);
        CTTextCharacterProperties cTTextCharacterProperties3 = this.props;
        cTTextCharacterProperties3.getClass();
        update(aVar, bVar, new c(cTTextCharacterProperties3, 13), d == null ? null : Integer.valueOf((int) (d.doubleValue() * 100.0d)));
    }

    public void setDirty(Boolean bool) {
        CTTextCharacterProperties cTTextCharacterProperties = this.props;
        cTTextCharacterProperties.getClass();
        a aVar = new a(cTTextCharacterProperties, 10);
        CTTextCharacterProperties cTTextCharacterProperties2 = this.props;
        cTTextCharacterProperties2.getClass();
        b bVar = new b(cTTextCharacterProperties2, 11);
        CTTextCharacterProperties cTTextCharacterProperties3 = this.props;
        cTTextCharacterProperties3.getClass();
        update(aVar, bVar, new c(cTTextCharacterProperties3, 11), bool);
    }

    public void setEffectContainer(XDDFEffectContainer xDDFEffectContainer) {
        CTTextCharacterProperties cTTextCharacterProperties = this.props;
        cTTextCharacterProperties.getClass();
        a aVar = new a(cTTextCharacterProperties, 15);
        CTTextCharacterProperties cTTextCharacterProperties2 = this.props;
        cTTextCharacterProperties2.getClass();
        b bVar = new b(cTTextCharacterProperties2, 16);
        CTTextCharacterProperties cTTextCharacterProperties3 = this.props;
        cTTextCharacterProperties3.getClass();
        update(aVar, bVar, new c(cTTextCharacterProperties3, 15), xDDFEffectContainer == null ? null : xDDFEffectContainer.getXmlObject());
    }

    public void setEffectList(XDDFEffectList xDDFEffectList) {
        CTTextCharacterProperties cTTextCharacterProperties = this.props;
        cTTextCharacterProperties.getClass();
        a aVar = new a(cTTextCharacterProperties, 12);
        CTTextCharacterProperties cTTextCharacterProperties2 = this.props;
        cTTextCharacterProperties2.getClass();
        b bVar = new b(cTTextCharacterProperties2, 12);
        CTTextCharacterProperties cTTextCharacterProperties3 = this.props;
        cTTextCharacterProperties3.getClass();
        update(aVar, bVar, new c(cTTextCharacterProperties3, 12), xDDFEffectList == null ? null : xDDFEffectList.getXmlObject());
    }

    public void setExtensionList(XDDFExtensionList xDDFExtensionList) {
        CTTextCharacterProperties cTTextCharacterProperties = this.props;
        cTTextCharacterProperties.getClass();
        a aVar = new a(cTTextCharacterProperties, 1);
        CTTextCharacterProperties cTTextCharacterProperties2 = this.props;
        cTTextCharacterProperties2.getClass();
        b bVar = new b(cTTextCharacterProperties2, 1);
        CTTextCharacterProperties cTTextCharacterProperties3 = this.props;
        cTTextCharacterProperties3.getClass();
        update(aVar, bVar, new c(cTTextCharacterProperties3, 1), xDDFExtensionList == null ? null : xDDFExtensionList.getXmlObject());
    }

    public void setFillProperties(XDDFFillProperties xDDFFillProperties) {
        if (this.props.isSetBlipFill()) {
            this.props.unsetBlipFill();
        }
        if (this.props.isSetGradFill()) {
            this.props.unsetGradFill();
        }
        if (this.props.isSetGrpFill()) {
            this.props.unsetGrpFill();
        }
        if (this.props.isSetNoFill()) {
            this.props.unsetNoFill();
        }
        if (this.props.isSetPattFill()) {
            this.props.unsetPattFill();
        }
        if (this.props.isSetSolidFill()) {
            this.props.unsetSolidFill();
        }
        if (xDDFFillProperties == null) {
            return;
        }
        if (xDDFFillProperties instanceof XDDFGradientFillProperties) {
            this.props.setGradFill(((XDDFGradientFillProperties) xDDFFillProperties).getXmlObject());
            return;
        }
        if (xDDFFillProperties instanceof XDDFGroupFillProperties) {
            this.props.setGrpFill(((XDDFGroupFillProperties) xDDFFillProperties).getXmlObject());
            return;
        }
        if (xDDFFillProperties instanceof XDDFNoFillProperties) {
            this.props.setNoFill(((XDDFNoFillProperties) xDDFFillProperties).getXmlObject());
            return;
        }
        if (xDDFFillProperties instanceof XDDFPatternFillProperties) {
            this.props.setPattFill(((XDDFPatternFillProperties) xDDFFillProperties).getXmlObject());
        } else if (xDDFFillProperties instanceof XDDFPictureFillProperties) {
            this.props.setBlipFill(((XDDFPictureFillProperties) xDDFFillProperties).getXmlObject());
        } else if (xDDFFillProperties instanceof XDDFSolidFillProperties) {
            this.props.setSolidFill(((XDDFSolidFillProperties) xDDFFillProperties).getXmlObject());
        }
    }

    public void setFontSize(Double d) {
        if (d != null && (d.doubleValue() < 1.0d || 400.0d < d.doubleValue())) {
            throw new IllegalArgumentException("Minimum inclusive = 1. Maximum inclusive = 400.");
        }
        CTTextCharacterProperties cTTextCharacterProperties = this.props;
        cTTextCharacterProperties.getClass();
        a aVar = new a(cTTextCharacterProperties, 17);
        CTTextCharacterProperties cTTextCharacterProperties2 = this.props;
        cTTextCharacterProperties2.getClass();
        b bVar = new b(cTTextCharacterProperties2, 18);
        CTTextCharacterProperties cTTextCharacterProperties3 = this.props;
        cTTextCharacterProperties3.getClass();
        update(aVar, bVar, new c(cTTextCharacterProperties3, 17), d == null ? null : Integer.valueOf((int) (d.doubleValue() * 100.0d)));
    }

    public void setFonts(XDDFFont[] xDDFFontArr) {
        for (XDDFFont xDDFFont : xDDFFontArr) {
            CTTextFont xmlObject = xDDFFont.getXmlObject();
            int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$common$usermodel$fonts$FontGroup[xDDFFont.getGroup().ordinal()];
            if (i5 == 1) {
                CTTextCharacterProperties cTTextCharacterProperties = this.props;
                cTTextCharacterProperties.getClass();
                a aVar = new a(cTTextCharacterProperties, 19);
                CTTextCharacterProperties cTTextCharacterProperties2 = this.props;
                cTTextCharacterProperties2.getClass();
                b bVar = new b(cTTextCharacterProperties2, 21);
                CTTextCharacterProperties cTTextCharacterProperties3 = this.props;
                cTTextCharacterProperties3.getClass();
                update(aVar, bVar, new c(cTTextCharacterProperties3, 21), xmlObject);
            } else if (i5 == 2) {
                CTTextCharacterProperties cTTextCharacterProperties4 = this.props;
                cTTextCharacterProperties4.getClass();
                a aVar2 = new a(cTTextCharacterProperties4, 20);
                CTTextCharacterProperties cTTextCharacterProperties5 = this.props;
                cTTextCharacterProperties5.getClass();
                b bVar2 = new b(cTTextCharacterProperties5, 22);
                CTTextCharacterProperties cTTextCharacterProperties6 = this.props;
                cTTextCharacterProperties6.getClass();
                update(aVar2, bVar2, new c(cTTextCharacterProperties6, 22), xmlObject);
            } else if (i5 == 3) {
                CTTextCharacterProperties cTTextCharacterProperties7 = this.props;
                cTTextCharacterProperties7.getClass();
                a aVar3 = new a(cTTextCharacterProperties7, 22);
                CTTextCharacterProperties cTTextCharacterProperties8 = this.props;
                cTTextCharacterProperties8.getClass();
                b bVar3 = new b(cTTextCharacterProperties8, 23);
                CTTextCharacterProperties cTTextCharacterProperties9 = this.props;
                cTTextCharacterProperties9.getClass();
                update(aVar3, bVar3, new c(cTTextCharacterProperties9, 23), xmlObject);
            } else if (i5 == 4) {
                CTTextCharacterProperties cTTextCharacterProperties10 = this.props;
                cTTextCharacterProperties10.getClass();
                a aVar4 = new a(cTTextCharacterProperties10, 23);
                CTTextCharacterProperties cTTextCharacterProperties11 = this.props;
                cTTextCharacterProperties11.getClass();
                b bVar4 = new b(cTTextCharacterProperties11, 20);
                CTTextCharacterProperties cTTextCharacterProperties12 = this.props;
                cTTextCharacterProperties12.getClass();
                update(aVar4, bVar4, new c(cTTextCharacterProperties12, 20), xmlObject);
            }
        }
    }

    public void setHighlight(XDDFColor xDDFColor) {
        CTTextCharacterProperties cTTextCharacterProperties = this.props;
        cTTextCharacterProperties.getClass();
        a aVar = new a(cTTextCharacterProperties, 8);
        CTTextCharacterProperties cTTextCharacterProperties2 = this.props;
        cTTextCharacterProperties2.getClass();
        b bVar = new b(cTTextCharacterProperties2, 9);
        CTTextCharacterProperties cTTextCharacterProperties3 = this.props;
        cTTextCharacterProperties3.getClass();
        update(aVar, bVar, new c(cTTextCharacterProperties3, 9), xDDFColor == null ? null : xDDFColor.getColorContainer());
    }

    public void setHyperlink(XDDFHyperlink xDDFHyperlink) {
        CTTextCharacterProperties cTTextCharacterProperties = this.props;
        cTTextCharacterProperties.getClass();
        a aVar = new a(cTTextCharacterProperties, 18);
        CTTextCharacterProperties cTTextCharacterProperties2 = this.props;
        cTTextCharacterProperties2.getClass();
        b bVar = new b(cTTextCharacterProperties2, 19);
        CTTextCharacterProperties cTTextCharacterProperties3 = this.props;
        cTTextCharacterProperties3.getClass();
        update(aVar, bVar, new c(cTTextCharacterProperties3, 19), xDDFHyperlink == null ? null : xDDFHyperlink.getXmlObject());
    }

    public void setItalic(Boolean bool) {
        CTTextCharacterProperties cTTextCharacterProperties = this.props;
        cTTextCharacterProperties.getClass();
        a aVar = new a(cTTextCharacterProperties, 24);
        CTTextCharacterProperties cTTextCharacterProperties2 = this.props;
        cTTextCharacterProperties2.getClass();
        b bVar = new b(cTTextCharacterProperties2, 24);
        CTTextCharacterProperties cTTextCharacterProperties3 = this.props;
        cTTextCharacterProperties3.getClass();
        update(aVar, bVar, new c(cTTextCharacterProperties3, 24), bool);
    }

    public void setKumimoji(Boolean bool) {
        CTTextCharacterProperties cTTextCharacterProperties = this.props;
        cTTextCharacterProperties.getClass();
        a aVar = new a(cTTextCharacterProperties, 5);
        CTTextCharacterProperties cTTextCharacterProperties2 = this.props;
        cTTextCharacterProperties2.getClass();
        b bVar = new b(cTTextCharacterProperties2, 6);
        CTTextCharacterProperties cTTextCharacterProperties3 = this.props;
        cTTextCharacterProperties3.getClass();
        update(aVar, bVar, new c(cTTextCharacterProperties3, 5), bool);
    }

    public void setLanguage(Locale locale) {
        CTTextCharacterProperties cTTextCharacterProperties = this.props;
        cTTextCharacterProperties.getClass();
        a aVar = new a(cTTextCharacterProperties, 3);
        CTTextCharacterProperties cTTextCharacterProperties2 = this.props;
        cTTextCharacterProperties2.getClass();
        b bVar = new b(cTTextCharacterProperties2, 3);
        CTTextCharacterProperties cTTextCharacterProperties3 = this.props;
        cTTextCharacterProperties3.getClass();
        update(aVar, bVar, new c(cTTextCharacterProperties3, 3), locale == null ? null : locale.toLanguageTag());
    }

    public void setLineProperties(XDDFLineProperties xDDFLineProperties) {
        CTTextCharacterProperties cTTextCharacterProperties = this.props;
        cTTextCharacterProperties.getClass();
        a aVar = new a(cTTextCharacterProperties, 27);
        CTTextCharacterProperties cTTextCharacterProperties2 = this.props;
        cTTextCharacterProperties2.getClass();
        b bVar = new b(cTTextCharacterProperties2, 0);
        CTTextCharacterProperties cTTextCharacterProperties3 = this.props;
        cTTextCharacterProperties3.getClass();
        update(aVar, bVar, new c(cTTextCharacterProperties3, 0), xDDFLineProperties == null ? null : xDDFLineProperties.getXmlObject());
    }

    public void setMouseOver(XDDFHyperlink xDDFHyperlink) {
        CTTextCharacterProperties cTTextCharacterProperties = this.props;
        cTTextCharacterProperties.getClass();
        a aVar = new a(cTTextCharacterProperties, 4);
        CTTextCharacterProperties cTTextCharacterProperties2 = this.props;
        cTTextCharacterProperties2.getClass();
        b bVar = new b(cTTextCharacterProperties2, 5);
        CTTextCharacterProperties cTTextCharacterProperties3 = this.props;
        cTTextCharacterProperties3.getClass();
        update(aVar, bVar, new c(cTTextCharacterProperties3, 4), xDDFHyperlink == null ? null : xDDFHyperlink.getXmlObject());
    }

    public void setNoProof(Boolean bool) {
        CTTextCharacterProperties cTTextCharacterProperties = this.props;
        cTTextCharacterProperties.getClass();
        a aVar = new a(cTTextCharacterProperties, 21);
        CTTextCharacterProperties cTTextCharacterProperties2 = this.props;
        cTTextCharacterProperties2.getClass();
        b bVar = new b(cTTextCharacterProperties2, 26);
        CTTextCharacterProperties cTTextCharacterProperties3 = this.props;
        cTTextCharacterProperties3.getClass();
        update(aVar, bVar, new c(cTTextCharacterProperties3, 27), bool);
    }

    public void setNormalizeHeights(Boolean bool) {
        CTTextCharacterProperties cTTextCharacterProperties = this.props;
        cTTextCharacterProperties.getClass();
        a aVar = new a(cTTextCharacterProperties, 25);
        CTTextCharacterProperties cTTextCharacterProperties2 = this.props;
        cTTextCharacterProperties2.getClass();
        b bVar = new b(cTTextCharacterProperties2, 25);
        CTTextCharacterProperties cTTextCharacterProperties3 = this.props;
        cTTextCharacterProperties3.getClass();
        update(aVar, bVar, new c(cTTextCharacterProperties3, 25), bool);
    }

    public void setSpellError(Boolean bool) {
        CTTextCharacterProperties cTTextCharacterProperties = this.props;
        cTTextCharacterProperties.getClass();
        a aVar = new a(cTTextCharacterProperties, 26);
        CTTextCharacterProperties cTTextCharacterProperties2 = this.props;
        cTTextCharacterProperties2.getClass();
        b bVar = new b(cTTextCharacterProperties2, 27);
        CTTextCharacterProperties cTTextCharacterProperties3 = this.props;
        cTTextCharacterProperties3.getClass();
        update(aVar, bVar, new c(cTTextCharacterProperties3, 26), bool);
    }

    public void setStrikeThrough(StrikeType strikeType) {
        CTTextCharacterProperties cTTextCharacterProperties = this.props;
        cTTextCharacterProperties.getClass();
        a aVar = new a(cTTextCharacterProperties, 14);
        CTTextCharacterProperties cTTextCharacterProperties2 = this.props;
        cTTextCharacterProperties2.getClass();
        b bVar = new b(cTTextCharacterProperties2, 14);
        CTTextCharacterProperties cTTextCharacterProperties3 = this.props;
        cTTextCharacterProperties3.getClass();
        update(aVar, bVar, new c(cTTextCharacterProperties3, 14), strikeType == null ? null : strikeType.underlying);
    }

    public void setUnderline(UnderlineType underlineType) {
        CTTextCharacterProperties cTTextCharacterProperties = this.props;
        cTTextCharacterProperties.getClass();
        a aVar = new a(cTTextCharacterProperties, 0);
        CTTextCharacterProperties cTTextCharacterProperties2 = this.props;
        cTTextCharacterProperties2.getClass();
        b bVar = new b(cTTextCharacterProperties2, 4);
        CTTextCharacterProperties cTTextCharacterProperties3 = this.props;
        cTTextCharacterProperties3.getClass();
        update(aVar, bVar, new c(cTTextCharacterProperties3, 7), underlineType == null ? null : underlineType.underlying);
    }

    @Internal
    public XDDFRunProperties(CTTextCharacterProperties cTTextCharacterProperties) {
        this.props = cTTextCharacterProperties;
    }
}
