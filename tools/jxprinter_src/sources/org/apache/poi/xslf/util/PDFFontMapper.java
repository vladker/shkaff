package org.apache.poi.xslf.util;

import de.rototor.pdfbox.graphics2d.IPdfBoxGraphics2DFontTextDrawer;
import de.rototor.pdfbox.graphics2d.PdfBoxGraphics2DFontTextDrawer;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import org.apache.pdfbox.pdmodel.font.PDFont;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class PDFFontMapper extends PdfBoxGraphics2DFontTextDrawer {
    private static final String DEFAULT_TTF_PATTERN = ".*\\.tt[fc]";
    private static final String FONTDIRS_MAC = "$HOME/Library/Fonts;/Library/Fonts;/Network/Library/Fonts;/System/Library/Fonts;/System Folder/Fonts";
    private static final String FONTDIRS_UNX = "/usr/share/fonts;/usr/local/share/fonts;$HOME/.fonts";
    private static final String FONTDIRS_WIN = "C:\\Windows\\Fonts";
    private final Map<String, File> fonts = new HashMap();
    private final Set<String> registered = new HashSet();

    public PDFFontMapper(String str, String str2) {
        registerFonts(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$registerFonts$0(LinkedList linkedList, Pattern pattern, File file, String str) {
        File file2 = new File(file, str);
        if (!file2.isDirectory()) {
            return pattern.matcher(str).matches();
        }
        linkedList.add(file2);
        return false;
    }

    private void registerFonts(String str, String str2) {
        if (str == null) {
            String lowerCase = System.getProperty("os.name", "generic").toLowerCase(Locale.ROOT);
            str = (lowerCase.contains("mac") || lowerCase.contains("darwin")) ? FONTDIRS_MAC : lowerCase.contains("win") ? FONTDIRS_WIN : FONTDIRS_UNX;
        }
        String strReplace = str.replace("$HOME", System.getProperty("user.home"));
        final LinkedList linkedList = new LinkedList();
        Stream.of((Object[]) strReplace.split(";")).map(new h(2)).filter(new g(1)).forEach(new Consumer() { // from class: org.apache.poi.xslf.util.b
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                linkedList.add((File) obj);
            }
        });
        if (str2 == null) {
            str2 = DEFAULT_TTF_PATTERN;
        }
        final Pattern patternCompile = Pattern.compile(str2);
        while (!linkedList.isEmpty()) {
            File[] fileArrListFiles = ((File) linkedList.removeFirst()).listFiles(new FilenameFilter() { // from class: org.apache.poi.xslf.util.c
                @Override // java.io.FilenameFilter
                public final boolean accept(File file, String str3) {
                    return PDFFontMapper.lambda$registerFonts$0(linkedList, patternCompile, file, str3);
                }
            });
            if (fileArrListFiles != null) {
                for (File file : fileArrListFiles) {
                    try {
                        this.fonts.put(Font.createFont(0, file).getFontName(Locale.ROOT), file);
                    } catch (IOException | FontFormatException unused) {
                    }
                }
            }
        }
    }

    public PDFont mapFont(Font font, IPdfBoxGraphics2DFontTextDrawer.IFontTextDrawerEnv iFontTextDrawerEnv) {
        String fontName = font.getFontName(Locale.ROOT);
        if (!this.registered.contains(fontName)) {
            this.registered.add(fontName);
            File file = this.fonts.get(fontName);
            if (file != null) {
                super.registerFont(fontName, file);
            }
        }
        return super.mapFont(font, iFontTextDrawerEnv);
    }
}
