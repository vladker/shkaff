package org.apache.poi.sl.draw;

import A3.AbstractC0157z;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.io.InvalidObjectException;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.function.BiConsumer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Chars;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.common.usermodel.fonts.FontGroup;
import org.apache.poi.common.usermodel.fonts.FontInfo;
import org.apache.poi.sl.usermodel.AutoNumberingScheme;
import org.apache.poi.sl.usermodel.Hyperlink;
import org.apache.poi.sl.usermodel.Insets2D;
import org.apache.poi.sl.usermodel.PaintStyle;
import org.apache.poi.sl.usermodel.PlaceableShape;
import org.apache.poi.sl.usermodel.PlaceholderDetails;
import org.apache.poi.sl.usermodel.SimpleShape;
import org.apache.poi.sl.usermodel.Slide;
import org.apache.poi.sl.usermodel.TextParagraph;
import org.apache.poi.sl.usermodel.TextRun;
import org.apache.poi.sl.usermodel.TextShape;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.util.StringUtil;
import org.apache.poi.util.Units;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DrawTextParagraph implements Drawable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected int autoNbrIdx;
    protected DrawTextFragment bullet;
    protected TextParagraph<?, ?, ?> paragraph;
    protected String rawText;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    double f7167x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    double f7168y;
    private static final Logger LOG = LogManager.getLogger((Class<?>) DrawTextParagraph.class);
    public static final XlinkAttribute HYPERLINK_HREF = new XlinkAttribute("href");
    public static final XlinkAttribute HYPERLINK_LABEL = new XlinkAttribute("label");
    protected List<DrawTextFragment> lines = new ArrayList();
    protected boolean firstParagraph = true;

    /* JADX INFO: renamed from: org.apache.poi.sl.draw.DrawTextParagraph$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$TextParagraph$TextAlign;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$TextRun$FieldType;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$TextRun$TextCap;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextDirection;

        static {
            int[] iArr = new int[TextShape.TextDirection.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextDirection = iArr;
            try {
                iArr[TextShape.TextDirection.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextDirection[TextShape.TextDirection.VERTICAL_270.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[TextRun.TextCap.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$TextRun$TextCap = iArr2;
            try {
                iArr2[TextRun.TextCap.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TextRun$TextCap[TextRun.TextCap.SMALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr3 = new int[TextRun.FieldType.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$TextRun$FieldType = iArr3;
            try {
                iArr3[TextRun.FieldType.SLIDE_NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TextRun$FieldType[TextRun.FieldType.DATE_TIME.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr4 = new int[TextParagraph.TextAlign.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$TextParagraph$TextAlign = iArr4;
            try {
                iArr4[TextParagraph.TextAlign.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TextParagraph$TextAlign[TextParagraph.TextAlign.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class AttributedStringData {
        AttributedCharacterIterator.Attribute attribute;
        int beginIndex;
        int endIndex;
        Object value;

        public AttributedStringData(AttributedCharacterIterator.Attribute attribute, Object obj, int i5, int i6) {
            this.attribute = attribute;
            this.value = obj;
            this.beginIndex = i5;
            this.endIndex = i6;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class XlinkAttribute extends AttributedCharacterIterator.Attribute {
        public XlinkAttribute(String str) {
            super(str);
        }

        @Override // java.text.AttributedCharacterIterator.Attribute
        public Object readResolve() throws InvalidObjectException {
            XlinkAttribute xlinkAttribute = DrawTextParagraph.HYPERLINK_HREF;
            if (xlinkAttribute.getName().equals(getName())) {
                return xlinkAttribute;
            }
            XlinkAttribute xlinkAttribute2 = DrawTextParagraph.HYPERLINK_LABEL;
            if (xlinkAttribute2.getName().equals(getName())) {
                return xlinkAttribute2;
            }
            throw new InvalidObjectException("unknown attribute name");
        }
    }

    public DrawTextParagraph(TextParagraph<?, ?, ?> textParagraph) {
        this.paragraph = textParagraph;
    }

    private PlaceableShape<?, ?> getParagraphShape() {
        return this.paragraph.getParentShape();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getAttributedString$0(List list, int i5, int i6, AttributedCharacterIterator.Attribute attribute, Object obj) {
        list.add(new AttributedStringData(attribute, obj, i5, i6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getAttributedString$1(List list, AttributedCharacterIterator.Attribute attribute, Object obj) {
        list.add(new AttributedStringData(attribute, obj, 0, 1));
    }

    private static int nextPart(Font font, String str, int i5, int i6, boolean z6) {
        while (i5 < i6) {
            int iCodePointAt = str.codePointAt(i5);
            if (font.canDisplay(iCodePointAt) != z6) {
                break;
            }
            i5 += Character.charCount(iCodePointAt);
        }
        return i5;
    }

    private void processGlyphs(Graphics2D graphics2D, DrawFontManager drawFontManager, List<AttributedStringData> list, int i5, TextRun textRun, String str) {
        int i6;
        int i7 = 0;
        for (FontGroup.FontGroupRange fontGroupRange : FontGroup.getFontGroupRanges(str)) {
            FontInfo fontInfo = textRun.getFontInfo(fontGroupRange.getFontGroup());
            if (fontInfo == null) {
                fontInfo = textRun.getFontInfo(FontGroup.LATIN);
            }
            FontInfo mappedFont = drawFontManager.getMappedFont(graphics2D, fontInfo);
            FontInfo fallbackFont = drawFontManager.getFallbackFont(graphics2D, fontInfo);
            if (mappedFont == null) {
                mappedFont = drawFontManager.getMappedFont(graphics2D, new DrawFontInfo(this.paragraph.getDefaultFontFamily()));
            }
            Font fontCreateAWTFont = drawFontManager.createAWTFont(graphics2D, mappedFont == null ? fallbackFont : mappedFont, 10.0d, textRun.isBold(), textRun.isItalic());
            Font fontCreateAWTFont2 = drawFontManager.createAWTFont(graphics2D, fallbackFont, 10.0d, textRun.isBold(), textRun.isItalic());
            int length = fontGroupRange.getLength();
            int iNextPart = i7;
            while (true) {
                i6 = i7 + length;
                if (iNextPart < i6) {
                    int iNextPart2 = nextPart(fontCreateAWTFont, str, iNextPart, i6, true);
                    if (iNextPart < iNextPart2) {
                        String fontName = fontCreateAWTFont.getFontName(Locale.ROOT);
                        int i8 = i5 + iNextPart;
                        int i9 = i5 + iNextPart2;
                        list.add(new AttributedStringData(TextAttribute.FAMILY, fontName, i8, i9));
                        LOG.atDebug().log("mapped: {} {} {} - {}", fontName, Unbox.box(i8), Unbox.box(i9), str.substring(iNextPart, iNextPart2));
                    }
                    iNextPart = nextPart(fontCreateAWTFont, str, iNextPart2, i6, false);
                    if (iNextPart2 < iNextPart) {
                        String fontName2 = fontCreateAWTFont2.getFontName(Locale.ROOT);
                        int i10 = i5 + iNextPart2;
                        int i11 = i5 + iNextPart;
                        list.add(new AttributedStringData(TextAttribute.FAMILY, fontName2, i10, i11));
                        LOG.atDebug().log("fallback: {} {} {} - {}", fontName2, Unbox.box(i10), Unbox.box(i11), str.substring(iNextPart2, iNextPart));
                    }
                    length = length;
                }
            }
            i7 = i6;
        }
    }

    private String tab2space(TextRun textRun) {
        int iMin;
        AttributedString attributedString = new AttributedString(" ");
        String fontFamily = textRun.getFontFamily();
        if (fontFamily == null) {
            fontFamily = "Lucida Sans";
        }
        attributedString.addAttribute(TextAttribute.FAMILY, fontFamily);
        Double fontSize = textRun.getFontSize();
        if (fontSize == null) {
            fontSize = Double.valueOf(12.0d);
        }
        attributedString.addAttribute(TextAttribute.SIZE, Float.valueOf(fontSize.floatValue()));
        double advance = new TextLayout(attributedString.getIterator(), new FontRenderContext((AffineTransform) null, true, true)).getAdvance();
        Double defaultTabSize = this.paragraph.getDefaultTabSize();
        if (advance <= 0.0d) {
            iMin = 4;
        } else {
            if (defaultTabSize == null) {
                defaultTabSize = Double.valueOf(4.0d * advance);
            }
            iMin = (int) Math.min(Math.ceil(defaultTabSize.doubleValue() / advance), 20.0d);
        }
        char[] cArr = new char[iMin];
        Arrays.fill(cArr, Chars.SPACE);
        return new String(cArr);
    }

    public void breakText(Graphics2D graphics2D) {
        int position;
        TextLayout textLayoutNextLayout;
        this.lines.clear();
        DrawFactory drawFactory = DrawFactory.getInstance(graphics2D);
        StringBuilder sb = new StringBuilder();
        List<AttributedStringData> attributedString = getAttributedString(graphics2D, sb);
        AttributedString attributedString2 = new AttributedString(sb.toString());
        AttributedString attributedString3 = new AttributedString(sb.toString().replaceAll("[\\r\\n]", " "));
        for (AttributedStringData attributedStringData : attributedString) {
            attributedString2.addAttribute(attributedStringData.attribute, attributedStringData.value, attributedStringData.beginIndex, attributedStringData.endIndex);
            attributedString3.addAttribute(attributedStringData.attribute, attributedStringData.value, attributedStringData.beginIndex, attributedStringData.endIndex);
        }
        AttributedCharacterIterator iterator = attributedString2.getIterator();
        AttributedCharacterIterator iterator2 = attributedString3.getIterator();
        LineBreakMeasurer lineBreakMeasurer = new LineBreakMeasurer(iterator, graphics2D.getFontRenderContext());
        do {
            int position2 = lineBreakMeasurer.getPosition();
            double wrappingWidth = getWrappingWidth(this.lines.isEmpty(), graphics2D) + 1.0d;
            double d = wrappingWidth >= 0.0d ? wrappingWidth : 1.0d;
            position = 1;
            if (position2 == 0 && sb.toString().startsWith("\n")) {
                textLayoutNextLayout = lineBreakMeasurer.nextLayout((float) d, 1, false);
            } else {
                int iIndexOf = sb.indexOf("\n", position2 + 1);
                if (iIndexOf == -1) {
                    iIndexOf = iterator.getEndIndex();
                }
                float f6 = (float) d;
                TextLayout textLayoutNextLayout2 = lineBreakMeasurer.nextLayout(f6, iIndexOf, true);
                textLayoutNextLayout = textLayoutNextLayout2 == null ? lineBreakMeasurer.nextLayout(f6, iIndexOf, false) : textLayoutNextLayout2;
                if (textLayoutNextLayout == null) {
                    break;
                }
                position = lineBreakMeasurer.getPosition();
                if (position < iterator.getEndIndex() && sb.charAt(position) == '\n') {
                    lineBreakMeasurer.setPosition(position + 1);
                }
                TextParagraph.TextAlign textAlign = this.paragraph.getTextAlign();
                if (textAlign == TextParagraph.TextAlign.JUSTIFY || textAlign == TextParagraph.TextAlign.JUSTIFY_LOW) {
                    textLayoutNextLayout = textLayoutNextLayout.getJustifiedLayout(f6);
                }
            }
            this.lines.add(drawFactory.getTextFragment(textLayoutNextLayout, new AttributedString(iterator2, position2, position)));
        } while (position != iterator.getEndIndex());
        this.rawText = sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:45:0x0117  */
    @Override // org.apache.poi.sl.draw.Drawable
    public void draw(Graphics2D graphics2D) {
        Double d;
        double width;
        double dMax;
        if (this.lines.isEmpty()) {
            return;
        }
        boolean zIsHSLF = isHSLF();
        double dDoubleValue = this.f7168y;
        int indentLevel = this.paragraph.getIndentLevel();
        Double leftMargin = this.paragraph.getLeftMargin();
        if (leftMargin == null) {
            leftMargin = Double.valueOf(Units.toPoints(((long) indentLevel) * 347663));
        }
        Double indent = this.paragraph.getIndent();
        if (indent == null) {
            indent = Double.valueOf(Units.toPoints(((long) indentLevel) * 347663));
        }
        Double lineSpacing = this.paragraph.getLineSpacing();
        if (lineSpacing == null) {
            lineSpacing = Double.valueOf(100.0d);
        }
        DrawTextFragment drawTextFragment = null;
        for (DrawTextFragment drawTextFragment2 : this.lines) {
            if (!isFirstParagraph() || drawTextFragment != null) {
                double leading = dDoubleValue - ((double) (drawTextFragment2.getLeading() + (drawTextFragment == null ? 0.0f : drawTextFragment.getLayout().getDescent())));
                dDoubleValue = (lineSpacing.doubleValue() > 0.0d ? ((lineSpacing.doubleValue() * 0.01d) * ((double) drawTextFragment2.getHeight())) + leading : (-lineSpacing.doubleValue()) + leading) - ((double) drawTextFragment2.getLayout().getAscent());
            }
            double dDoubleValue2 = leftMargin.doubleValue() + this.f7167x;
            if (drawTextFragment != null) {
                lineSpacing = lineSpacing;
                d = leftMargin;
            } else {
                if (!isEmptyParagraph()) {
                    this.bullet = getBullet(graphics2D, drawTextFragment2.getAttributedString().getIterator());
                }
                DrawTextFragment drawTextFragment3 = this.bullet;
                if (drawTextFragment3 != null) {
                    double d6 = this.f7167x;
                    drawTextFragment3.setPosition(zIsHSLF ? indent.doubleValue() + d6 : leftMargin.doubleValue() + d6 + indent.doubleValue(), dDoubleValue);
                    this.bullet.draw(graphics2D);
                    double advance = this.bullet.getLayout().getAdvance() + 1.0f;
                    double d7 = this.f7167x;
                    if (zIsHSLF) {
                        dMax = leftMargin.doubleValue();
                        d = leftMargin;
                    } else {
                        d = leftMargin;
                        dMax = Math.max(d.doubleValue(), indent.doubleValue() + d.doubleValue() + advance);
                    }
                    dDoubleValue2 = d7 + dMax;
                } else {
                    lineSpacing = lineSpacing;
                    d = leftMargin;
                }
            }
            Rectangle2D anchor = DrawShape.getAnchor(graphics2D, this.paragraph.getParentShape());
            Insets2D insets = this.paragraph.getParentShape().getInsets();
            double d8 = insets.left;
            double d9 = insets.right;
            boolean z6 = zIsHSLF;
            TextParagraph.TextAlign textAlign = this.paragraph.getTextAlign();
            if (textAlign == null) {
                textAlign = TextParagraph.TextAlign.LEFT;
            }
            int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$sl$usermodel$TextParagraph$TextAlign[textAlign.ordinal()];
            if (i5 != 1) {
                if (i5 == 2) {
                    width = ((anchor.getWidth() - ((double) drawTextFragment2.getWidth())) - d8) - d9;
                }
                drawTextFragment2.setPosition(dDoubleValue2, dDoubleValue);
                drawTextFragment2.draw(graphics2D);
                dDoubleValue += (double) drawTextFragment2.getHeight();
                leftMargin = d;
                drawTextFragment = drawTextFragment2;
                lineSpacing = lineSpacing;
                zIsHSLF = z6;
            } else {
                width = ((((anchor.getWidth() - ((double) drawTextFragment2.getWidth())) - d8) - d9) - d.doubleValue()) / 2.0d;
            }
            dDoubleValue2 += width;
            drawTextFragment2.setPosition(dDoubleValue2, dDoubleValue);
            drawTextFragment2.draw(graphics2D);
            dDoubleValue += (double) drawTextFragment2.getHeight();
            leftMargin = d;
            drawTextFragment = drawTextFragment2;
            lineSpacing = lineSpacing;
            zIsHSLF = z6;
        }
        this.f7168y = dDoubleValue - this.f7168y;
    }

    public List<AttributedStringData> getAttributedString(Graphics2D graphics2D, StringBuilder sb) {
        if (sb == null) {
            sb = new StringBuilder();
        }
        DrawPaint drawPaint = new DrawPaint(getParagraphShape());
        DrawFontManager fontManager = DrawFactory.getInstance(graphics2D).getFontManager(graphics2D);
        HashMap map = new HashMap();
        final ArrayList arrayList = new ArrayList();
        Iterator<?> it = this.paragraph.iterator();
        while (it.hasNext()) {
            TextRun textRun = (TextRun) it.next();
            String renderableText = getRenderableText(graphics2D, textRun);
            if (!renderableText.isEmpty()) {
                map.clear();
                FontInfo fontInfo = textRun.getFontInfo(null);
                String strMapFontCharset = fontManager.mapFontCharset(graphics2D, fontInfo, renderableText);
                final int length = sb.length();
                sb.append(strMapFontCharset);
                final int length2 = sb.length();
                map.put(TextAttribute.FOREGROUND, drawPaint.getPaint(graphics2D, textRun.getFontColor()));
                Double fontSize = textRun.getFontSize();
                if (fontSize == null) {
                    fontSize = this.paragraph.getDefaultFontSize();
                }
                map.put(TextAttribute.SIZE, Float.valueOf(fontSize.floatValue()));
                if (textRun.isBold()) {
                    map.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD);
                }
                if (textRun.isItalic()) {
                    map.put(TextAttribute.POSTURE, TextAttribute.POSTURE_OBLIQUE);
                }
                if (textRun.isUnderlined()) {
                    map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                    map.put(TextAttribute.INPUT_METHOD_UNDERLINE, TextAttribute.UNDERLINE_LOW_TWO_PIXEL);
                }
                if (textRun.isStrikethrough()) {
                    map.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
                }
                if (textRun.isSubscript()) {
                    map.put(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUB);
                }
                if (textRun.isSuperscript()) {
                    map.put(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUPER);
                }
                Hyperlink<?, ?> hyperlink = textRun.getHyperlink();
                if (hyperlink != null) {
                    map.put(HYPERLINK_HREF, hyperlink.getAddress());
                    map.put(HYPERLINK_LABEL, hyperlink.getLabel());
                }
                if (fontInfo != null) {
                    map.put(TextAttribute.FAMILY, fontInfo.getTypeface());
                } else {
                    map.put(TextAttribute.FAMILY, this.paragraph.getDefaultFontFamily());
                }
                map.put(TextAttribute.FONT, new Font(map));
                map.forEach(new BiConsumer() { // from class: org.apache.poi.sl.draw.l
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) {
                        DrawTextParagraph.lambda$getAttributedString$0(arrayList, length, length2, (AttributedCharacterIterator.Attribute) obj, obj2);
                    }
                });
                processGlyphs(graphics2D, fontManager, arrayList, length, textRun, strMapFontCharset);
            }
        }
        if (sb.length() == 0) {
            sb.append(" ");
            map.put(TextAttribute.SIZE, Float.valueOf(this.paragraph.getDefaultFontSize().floatValue()));
            map.put(TextAttribute.FAMILY, this.paragraph.getDefaultFontFamily());
            map.put(TextAttribute.FONT, new Font(map));
            map.forEach(new m(arrayList, 0));
        }
        return arrayList;
    }

    public DrawTextFragment getBullet(Graphics2D graphics2D, AttributedCharacterIterator attributedCharacterIterator) {
        TextParagraph.BulletStyle bulletStyle = this.paragraph.getBulletStyle();
        if (bulletStyle == null) {
            return null;
        }
        AutoNumberingScheme autoNumberingScheme = bulletStyle.getAutoNumberingScheme();
        String bulletCharacter = autoNumberingScheme != null ? autoNumberingScheme.format(this.autoNbrIdx) : bulletStyle.getBulletCharacter();
        if (bulletCharacter == null) {
            return null;
        }
        PlaceableShape<?, ?> paragraphShape = getParagraphShape();
        PaintStyle bulletFontColor = bulletStyle.getBulletFontColor();
        Paint paint = bulletFontColor == null ? (Paint) attributedCharacterIterator.getAttribute(TextAttribute.FOREGROUND) : new DrawPaint(paragraphShape).getPaint(graphics2D, bulletFontColor);
        TextAttribute textAttribute = TextAttribute.SIZE;
        float fFloatValue = ((Float) attributedCharacterIterator.getAttribute(textAttribute)).floatValue();
        Double bulletFontSize = bulletStyle.getBulletFontSize();
        if (bulletFontSize == null) {
            bulletFontSize = Double.valueOf(100.0d);
        }
        float fDoubleValue = bulletFontSize.doubleValue() > 0.0d ? fFloatValue * ((float) (bulletFontSize.doubleValue() * 0.01d)) : (float) (-bulletFontSize.doubleValue());
        String bulletFont = bulletStyle.getBulletFont();
        if (bulletFont == null) {
            bulletFont = this.paragraph.getDefaultFontFamily();
        }
        DrawFontInfo drawFontInfo = new DrawFontInfo(bulletFont);
        DrawFontManager fontManager = DrawFactory.getInstance(graphics2D).getFontManager(graphics2D);
        FontInfo mappedFont = fontManager.getMappedFont(graphics2D, drawFontInfo);
        HashMap map = new HashMap();
        map.put(TextAttribute.FOREGROUND, paint);
        map.put(TextAttribute.FAMILY, mappedFont.getTypeface());
        map.put(textAttribute, Float.valueOf(fDoubleValue));
        map.put(TextAttribute.FONT, new Font(map));
        AttributedString attributedString = new AttributedString(fontManager.mapFontCharset(graphics2D, mappedFont, bulletCharacter));
        map.forEach(new m(attributedString, 1));
        return DrawFactory.getInstance(graphics2D).getTextFragment(new TextLayout(attributedString.getIterator(), graphics2D.getFontRenderContext()), attributedString);
    }

    public float getFirstLineHeight() {
        if (this.lines.isEmpty()) {
            return 0.0f;
        }
        return this.lines.get(0).getHeight();
    }

    public float getFirstLineLeading() {
        if (this.lines.isEmpty()) {
            return 0.0f;
        }
        return this.lines.get(0).getLeading();
    }

    public float getLastLineHeight() {
        if (this.lines.isEmpty()) {
            return 0.0f;
        }
        return ((DrawTextFragment) AbstractC0157z.f(1, this.lines)).getHeight();
    }

    public String getRenderableText(Graphics2D graphics2D, TextRun textRun) {
        TextRun.FieldType fieldType = textRun.getFieldType();
        if (fieldType == null) {
            return getRenderableText(textRun);
        }
        if (textRun.getRawText() != null && !textRun.getRawText().isEmpty()) {
            int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$sl$usermodel$TextRun$FieldType[fieldType.ordinal()];
            if (i5 == 1) {
                Slide slide = (Slide) graphics2D.getRenderingHint(Drawable.CURRENT_SLIDE);
                return slide == null ? "" : Integer.toString(slide.getSlideNumber());
            }
            if (i5 == 2) {
                PlaceholderDetails placeholderDetails = ((SimpleShape) getParagraphShape()).getPlaceholderDetails();
                placeholderDetails.getPlaceholder();
                String userDate = placeholderDetails.getUserDate();
                if (userDate != null) {
                    return userDate;
                }
                Calendar localeCalendar = LocaleUtil.getLocaleCalendar();
                return LocalDateTime.ofInstant(localeCalendar.toInstant(), localeCalendar.getTimeZone().toZoneId()).format(placeholderDetails.getDateFormat());
            }
        }
        return "";
    }

    public double getWrappingWidth(boolean z6, Graphics2D graphics2D) {
        double height;
        double dDoubleValue;
        double height2;
        double x6;
        Double dValueOf = Double.valueOf(0.0d);
        TextShape<S, P> parentShape = this.paragraph.getParentShape();
        Insets2D insets = parentShape.getInsets();
        double d = insets.left;
        double d6 = insets.right;
        int indentLevel = this.paragraph.getIndentLevel();
        if (indentLevel == -1) {
            indentLevel = 0;
        }
        Double leftMargin = this.paragraph.getLeftMargin();
        if (leftMargin == null) {
            leftMargin = Double.valueOf(Units.toPoints(((long) indentLevel) * 347663));
        }
        Double indent = this.paragraph.getIndent();
        if (indent == null) {
            indent = dValueOf;
        }
        Double rightMargin = this.paragraph.getRightMargin();
        if (rightMargin != null) {
            dValueOf = rightMargin;
        }
        Rectangle2D anchor = DrawShape.getAnchor(graphics2D, parentShape);
        TextShape.TextDirection textDirection = parentShape.getTextDirection();
        if (!parentShape.getWordWrap()) {
            Dimension pageSize = parentShape.getSheet().getSlideShow().getPageSize();
            int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextDirection[textDirection.ordinal()];
            if (i5 == 1) {
                height2 = pageSize.getHeight();
                x6 = anchor.getX();
            } else {
                if (i5 == 2) {
                    return anchor.getX();
                }
                height2 = pageSize.getWidth();
                x6 = anchor.getX();
            }
            return height2 - x6;
        }
        int i6 = AnonymousClass1.$SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextDirection[textDirection.ordinal()];
        if (i6 == 1 || i6 == 2) {
            height = ((anchor.getHeight() - d) - d6) - leftMargin.doubleValue();
            dDoubleValue = dValueOf.doubleValue();
        } else {
            height = ((anchor.getWidth() - d) - d6) - leftMargin.doubleValue();
            dDoubleValue = dValueOf.doubleValue();
        }
        double d7 = height - dDoubleValue;
        if (z6 && this.bullet == null) {
            return d7 + (isHSLF() ? leftMargin.doubleValue() - indent.doubleValue() : -indent.doubleValue());
        }
        return d7;
    }

    public double getY() {
        return this.f7168y;
    }

    public boolean isEmptyParagraph() {
        return this.lines.isEmpty() || StringUtil.isBlank(this.rawText);
    }

    public boolean isFirstParagraph() {
        return this.firstParagraph;
    }

    public boolean isHSLF() {
        return DrawShape.isHSLF(this.paragraph.getParentShape());
    }

    public void setAutoNumberingIdx(int i5) {
        this.autoNbrIdx = i5;
    }

    public void setFirstParagraph(boolean z6) {
        this.firstParagraph = z6;
    }

    public void setPosition(double d, double d6) {
        this.f7167x = d;
        this.f7168y = d6;
    }

    @Internal
    public String getRenderableText(TextRun textRun) {
        String rawText = textRun.getRawText();
        if (rawText == null) {
            return null;
        }
        if (rawText.contains("\t")) {
            rawText = rawText.replace("\t", tab2space(textRun));
        }
        String strReplace = rawText.replace((char) 11, '\n');
        Locale userLocale = LocaleUtil.getUserLocale();
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$sl$usermodel$TextRun$TextCap[textRun.getTextCap().ordinal()];
        if (i5 != 1) {
            return i5 != 2 ? strReplace : strReplace.toLowerCase(userLocale);
        }
        return strReplace.toUpperCase(userLocale);
    }

    @Override // org.apache.poi.sl.draw.Drawable
    public void applyTransform(Graphics2D graphics2D) {
    }

    @Override // org.apache.poi.sl.draw.Drawable
    public void drawContent(Graphics2D graphics2D) {
    }
}
