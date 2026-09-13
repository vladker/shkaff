package org.apache.poi.xslf.usermodel;

import java.util.function.Consumer;
import java.util.function.Function;
import org.apache.poi.sl.usermodel.FillStyle;
import org.apache.poi.sl.usermodel.PaintStyle;
import org.apache.poi.xslf.model.CharacterPropertyFetcher;
import org.apache.poi.xslf.model.ParagraphPropertyFetcher;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class k implements CharacterPropertyFetcher.CharPropFetcher, FillStyle, ParagraphPropertyFetcher.ParaPropFetcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7330a;
    public final /* synthetic */ Object b;

    public /* synthetic */ k(Object obj, int i5) {
        this.f7330a = i5;
        this.b = obj;
    }

    @Override // org.apache.poi.xslf.model.CharacterPropertyFetcher.CharPropFetcher
    public void fetch(CTTextCharacterProperties cTTextCharacterProperties, Consumer consumer) {
        ((XSLFTextRun.XSLFFontInfo) this.b).lambda$getXmlObject$0(cTTextCharacterProperties, consumer);
    }

    @Override // org.apache.poi.sl.usermodel.FillStyle
    public PaintStyle getPaint() {
        return ((XSLFSimpleShape) this.b).getFillPaint();
    }

    @Override // org.apache.poi.xslf.model.ParagraphPropertyFetcher.ParaPropFetcher
    public void fetch(CTTextParagraphProperties cTTextParagraphProperties, Consumer consumer) {
        switch (this.f7330a) {
            case 2:
                ((XSLFTextParagraph) this.b).fetchBulletFontColor(cTTextParagraphProperties, consumer);
                break;
            default:
                XSLFTextParagraph.fetchSpacing((Function) this.b, cTTextParagraphProperties, consumer);
                break;
        }
    }
}
