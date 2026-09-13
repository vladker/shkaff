package org.apache.poi.sl.draw;

import androidx.webkit.ProxyConfig;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.apache.poi.common.usermodel.fonts.FontCharset;
import org.apache.poi.common.usermodel.fonts.FontInfo;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DrawFontManagerDefault implements DrawFontManager {
    protected final Set<String> knownSymbolFonts;

    public DrawFontManagerDefault() {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        this.knownSymbolFonts = treeSet;
        treeSet.add("Wingdings");
        treeSet.add("Symbol");
    }

    private FontInfo getFontWithFallback(Graphics2D graphics2D, Drawable.DrawableHint drawableHint, FontInfo fontInfo) {
        Map map = (Map) graphics2D.getRenderingHint(drawableHint);
        if (map != null) {
            String str = null;
            String typeface = fontInfo != null ? fontInfo.getTypeface() : null;
            if (map.containsKey(typeface)) {
                str = (String) map.get(typeface);
            } else if (map.containsKey(ProxyConfig.MATCH_ALL_SCHEMES)) {
                str = (String) map.get(ProxyConfig.MATCH_ALL_SCHEMES);
            }
            if (str != null) {
                return new DrawFontInfo(str);
            }
        }
        return fontInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int mapSymbolChar(int i5) {
        return ((32 > i5 || i5 > 127) && (160 > i5 || i5 > 255)) ? i5 : i5 | 61440;
    }

    @Override // org.apache.poi.sl.draw.DrawFontManager
    public Font createAWTFont(Graphics2D graphics2D, FontInfo fontInfo, double d, boolean z6, boolean z7) {
        int i5 = (z7 ? 2 : 0) | (z6 ? 1 : 0);
        Font font = new Font(fontInfo.getTypeface(), i5, 12);
        if ("Dialog".equals(font.getFamily())) {
            font = new Font("SansSerif", i5, 12);
        }
        return font.deriveFont((float) d);
    }

    @Override // org.apache.poi.sl.draw.DrawFontManager
    public FontInfo getFallbackFont(Graphics2D graphics2D, FontInfo fontInfo) {
        FontInfo fontWithFallback = getFontWithFallback(graphics2D, Drawable.FONT_FALLBACK, fontInfo);
        return fontWithFallback == null ? new DrawFontInfo("SansSerif") : fontWithFallback;
    }

    @Override // org.apache.poi.sl.draw.DrawFontManager
    public FontInfo getMappedFont(Graphics2D graphics2D, FontInfo fontInfo) {
        return getFontWithFallback(graphics2D, Drawable.FONT_MAP, fontInfo);
    }

    @Override // org.apache.poi.sl.draw.DrawFontManager
    public String mapFontCharset(Graphics2D graphics2D, FontInfo fontInfo, String str) {
        if (fontInfo == null || str == null || str.isEmpty()) {
            return str;
        }
        String typeface = fontInfo.getTypeface();
        if (fontInfo.getCharset() != FontCharset.SYMBOL && !this.knownSymbolFonts.contains(typeface)) {
            return str;
        }
        int[] array = str.codePoints().map(new e()).toArray();
        String str2 = new String(array, 0, array.length);
        return Arrays.asList(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames()).contains(typeface) ? str2 : StringUtil.mapMsCodepointString(str2);
    }
}
