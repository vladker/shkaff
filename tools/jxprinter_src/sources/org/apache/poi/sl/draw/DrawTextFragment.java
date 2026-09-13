package org.apache.poi.sl.draw;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DrawTextFragment implements Drawable {
    final TextLayout layout;
    final AttributedString str;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    double f7165x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    double f7166y;

    public DrawTextFragment(TextLayout textLayout, AttributedString attributedString) {
        this.layout = textLayout;
        this.str = attributedString;
    }

    private void replaceForgroundPaintWithBlack(AttributedString attributedString) {
        AttributedCharacterIterator iterator = attributedString.getIterator(new TextAttribute[]{TextAttribute.FOREGROUND});
        for (char cFirst = iterator.first(); cFirst != 65535; cFirst = iterator.next()) {
            attributedString.addAttribute(TextAttribute.FOREGROUND, Color.BLACK, iterator.getBeginIndex(), iterator.getEndIndex());
        }
    }

    @Override // org.apache.poi.sl.draw.Drawable
    public void draw(Graphics2D graphics2D) {
        if (this.str == null) {
            return;
        }
        double ascent = this.f7166y + ((double) this.layout.getAscent());
        Integer num = (Integer) graphics2D.getRenderingHint(Drawable.TEXT_RENDERING_MODE);
        if (num != null && num.intValue() == 2) {
            this.layout.draw(graphics2D, (float) this.f7165x, (float) ascent);
            return;
        }
        try {
            graphics2D.drawString(this.str.getIterator(), (float) this.f7165x, (float) ascent);
        } catch (ClassCastException unused) {
            replaceForgroundPaintWithBlack(this.str);
            graphics2D.drawString(this.str.getIterator(), (float) this.f7165x, (float) ascent);
        }
    }

    public AttributedString getAttributedString() {
        return this.str;
    }

    public float getHeight() {
        return this.layout.getAscent() + this.layout.getDescent();
    }

    public TextLayout getLayout() {
        return this.layout;
    }

    public float getLeading() {
        double leading = this.layout.getLeading();
        if (leading == 0.0d) {
            leading = ((double) (this.layout.getAscent() + this.layout.getDescent())) * 0.15d;
        }
        return (float) leading;
    }

    public String getString() {
        AttributedString attributedString = this.str;
        if (attributedString == null) {
            return "";
        }
        AttributedCharacterIterator iterator = attributedString.getIterator();
        StringBuilder sb = new StringBuilder();
        for (char cFirst = iterator.first(); cFirst != 65535; cFirst = iterator.next()) {
            sb.append(cFirst);
        }
        return sb.toString();
    }

    public float getWidth() {
        return this.layout.getAdvance();
    }

    public void setPosition(double d, double d6) {
        this.f7165x = d;
        this.f7166y = d6;
    }

    public String toString() {
        return "[" + getClass().getSimpleName() + "] " + getString();
    }

    @Override // org.apache.poi.sl.draw.Drawable
    public void applyTransform(Graphics2D graphics2D) {
    }

    @Override // org.apache.poi.sl.draw.Drawable
    public void drawContent(Graphics2D graphics2D) {
    }
}
