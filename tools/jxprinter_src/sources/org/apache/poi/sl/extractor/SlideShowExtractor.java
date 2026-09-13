package org.apache.poi.sl.extractor;

import V2.f;
import androidx.webkit.ProxyConfig;
import com.google.android.material.color.utilities.g;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import l5.d2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Chars;
import org.apache.poi.extractor.POITextExtractor;
import org.apache.poi.hssf.record.C;
import org.apache.poi.sl.usermodel.Comment;
import org.apache.poi.sl.usermodel.MasterSheet;
import org.apache.poi.sl.usermodel.Notes;
import org.apache.poi.sl.usermodel.ObjectShape;
import org.apache.poi.sl.usermodel.Placeholder;
import org.apache.poi.sl.usermodel.PlaceholderDetails;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.ShapeContainer;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.sl.usermodel.SimpleShape;
import org.apache.poi.sl.usermodel.Slide;
import org.apache.poi.sl.usermodel.SlideShow;
import org.apache.poi.sl.usermodel.TableCell;
import org.apache.poi.sl.usermodel.TableShape;
import org.apache.poi.sl.usermodel.TextParagraph;
import org.apache.poi.sl.usermodel.TextRun;
import org.apache.poi.sl.usermodel.TextShape;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.util.Removal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SlideShowExtractor<S extends Shape<S, P>, P extends TextParagraph<S, P, ? extends TextRun>> implements POITextExtractor {
    private static final Logger LOG = LogManager.getLogger((Class<?>) SlideShowExtractor.class);
    private static final String SLIDE_NUMBER_PH = "‹#›";
    private boolean commentsByDefault;
    private boolean masterByDefault;
    private boolean notesByDefault;
    protected final SlideShow<S, P> slideshow;
    private boolean slidesByDefault = true;
    private Predicate<Object> filter = new org.apache.commons.compress.archivers.tar.a(5);
    private boolean doCloseFilesystem = true;

    /* JADX INFO: renamed from: org.apache.poi.sl.extractor.SlideShowExtractor$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$Placeholder;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$TextRun$TextCap;

        static {
            int[] iArr = new int[TextRun.TextCap.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$TextRun$TextCap = iArr;
            try {
                iArr[TextRun.TextCap.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TextRun$TextCap[TextRun.TextCap.SMALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Placeholder.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$Placeholder = iArr2;
            try {
                iArr2[Placeholder.HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$Placeholder[Placeholder.FOOTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$Placeholder[Placeholder.SLIDE_NUMBER.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$Placeholder[Placeholder.DATETIME.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public SlideShowExtractor(SlideShow<S, P> slideShow) {
        this.slideshow = slideShow;
    }

    private void addOLEShapes(List<ObjectShape<S, P>> list, ShapeContainer<S, P> shapeContainer) {
        for (S s6 : shapeContainer) {
            if (s6 instanceof ShapeContainer) {
                addOLEShapes(list, (ShapeContainer) s6);
            } else if (s6 instanceof ObjectShape) {
                list.add((ObjectShape) s6);
            }
        }
    }

    private void addSheetPlaceholderDatails(Sheet<S, P> sheet, Placeholder placeholder, Consumer<String> consumer) {
        PlaceholderDetails placeholderDetails = sheet.getPlaceholderDetails(placeholder);
        String text = placeholderDetails != null ? placeholderDetails.getText() : null;
        if (text == null || !this.filter.test(placeholderDetails)) {
            return;
        }
        consumer.accept(text);
    }

    private static boolean filterFonts(Object obj, String str, Boolean bool, Boolean bool2) {
        if (!(obj instanceof TextRun)) {
            return false;
        }
        TextRun textRun = (TextRun) obj;
        return str.equalsIgnoreCase(textRun.getFontFamily()) && (bool == null || textRun.isItalic() == bool.booleanValue()) && (bool2 == null || textRun.isBold() == bool2.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getCodepoints$2(String str, Boolean bool, Boolean bool2, Object obj) {
        return filterFonts(obj, str, bool, bool2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getCodepoints$4(BitSet bitSet, Slide slide) {
        getText(slide, new d2(bitSet, 8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getCodepointsInSparseBitSet$5(String str, Boolean bool, Boolean bool2, Object obj) {
        return filterFonts(obj, str, bool, bool2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getCodepointsInSparseBitSet$7(f fVar, Slide slide) {
        getText(slide, new d2(fVar, 9));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$new$0(Object obj) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$null$3(BitSet bitSet, String str) {
        IntStream intStreamCodePoints = str.codePoints();
        bitSet.getClass();
        intStreamCodePoints.forEach(new a(bitSet, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$null$6(f fVar, String str) {
        IntStream intStreamCodePoints = str.codePoints();
        fVar.getClass();
        intStreamCodePoints.forEach(new a(fVar, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$printComments$1(Comment comment) {
        return comment.getAuthor() + " - " + comment.getText();
    }

    private void printComments(Slide<S, P> slide, Consumer<String> consumer) {
        slide.getComments().stream().filter(this.filter).map(new g(25)).forEach(consumer);
    }

    private void printHeaderFooter(Sheet<S, P> sheet, Consumer<String> consumer, Consumer<String> consumer2) {
        TextShape textShape;
        PlaceholderDetails placeholderDetails;
        Sheet<S, P> masterSheet = sheet instanceof Slide ? sheet.getMasterSheet() : sheet;
        addSheetPlaceholderDatails(sheet, Placeholder.HEADER, consumer);
        addSheetPlaceholderDatails(sheet, Placeholder.FOOTER, consumer2);
        if (this.masterByDefault) {
            for (S s6 : masterSheet) {
                if ((s6 instanceof TextShape) && (placeholderDetails = (textShape = (TextShape) s6).getPlaceholderDetails()) != null && placeholderDetails.isVisible() && placeholderDetails.getPlaceholder() != null) {
                    int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$sl$usermodel$Placeholder[placeholderDetails.getPlaceholder().ordinal()];
                    if (i5 == 1) {
                        printTextParagraphs(textShape.getTextParagraphs(), consumer);
                    } else if (i5 == 2) {
                        printTextParagraphs(textShape.getTextParagraphs(), consumer2);
                    } else if (i5 == 3) {
                        printTextParagraphs(textShape.getTextParagraphs(), consumer2, "\n", new g(23));
                    }
                }
            }
        }
    }

    private void printNotes(Slide<S, P> slide, Consumer<String> consumer) {
        Notes<S, P> notes = slide.getNotes();
        if (notes == null) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        printHeaderFooter(notes, consumer, new b(linkedList, 0));
        printShapeText((Sheet) notes, consumer);
        linkedList.forEach(consumer);
    }

    private void printShapeText(Sheet<S, P> sheet, Consumer<String> consumer) {
        LinkedList linkedList = new LinkedList();
        printHeaderFooter(sheet, consumer, new b(linkedList, 0));
        printShapeText((ShapeContainer) sheet, consumer);
        linkedList.forEach(consumer);
    }

    private void printSlideMaster(MasterSheet<S, P> masterSheet, Consumer<String> consumer) {
        TextShape textShape;
        String text;
        if (masterSheet == null) {
            return;
        }
        for (S s6 : masterSheet) {
            if ((s6 instanceof TextShape) && (text = (textShape = (TextShape) s6).getText()) != null && !text.isEmpty() && !ProxyConfig.MATCH_ALL_SCHEMES.equals(text)) {
                if (textShape.isPlaceholder()) {
                    LOG.atInfo().log("Ignoring boiler plate (placeholder) text on slide master: {}", text);
                } else {
                    printTextParagraphs(textShape.getTextParagraphs(), consumer);
                }
            }
        }
    }

    private void printTextParagraphs(List<P> list, Consumer<String> consumer) {
        printTextParagraphs(list, consumer, "\n");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String replaceSlideNumber(TextRun textRun) {
        String rawText = textRun.getRawText();
        if (!rawText.contains(SLIDE_NUMBER_PH)) {
            return rawText;
        }
        TextParagraph<?, ?, ?> paragraph = textRun.getParagraph();
        Shape parentShape = paragraph != null ? paragraph.getParentShape() : null;
        Sheet<S, P> sheet = parentShape != null ? parentShape.getSheet() : null;
        return rawText.replace(SLIDE_NUMBER_PH, sheet instanceof Slide ? Integer.toString(((Slide) sheet).getSlideNumber() + 1) : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String replaceTextCap(TextRun textRun) {
        TextParagraph<?, ?, ?> paragraph = textRun.getParagraph();
        SimpleShape parentShape = paragraph != null ? paragraph.getParentShape() : null;
        Placeholder placeholder = parentShape != null ? parentShape.getPlaceholder() : null;
        String strReplace = textRun.getRawText().replace(Chars.CR, '\n').replace((char) 11, (placeholder == Placeholder.TITLE || placeholder == Placeholder.CENTERED_TITLE || placeholder == Placeholder.SUBTITLE) ? '\n' : Chars.SPACE);
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$sl$usermodel$TextRun$TextCap[textRun.getTextCap().ordinal()];
        if (i5 != 1) {
            return i5 != 2 ? strReplace : strReplace.toLowerCase(LocaleUtil.getUserLocale());
        }
        return strReplace.toUpperCase(LocaleUtil.getUserLocale());
    }

    @Removal(version = "6.0.0")
    @Deprecated
    public BitSet getCodepoints(String str, Boolean bool, Boolean bool2) {
        BitSet bitSet = new BitSet();
        Predicate<Object> predicate = this.filter;
        try {
            this.filter = new c(bool, 0, bool2, str);
            this.slideshow.getSlides().forEach(new C(this, bitSet, 1));
            return bitSet;
        } finally {
            this.filter = predicate;
        }
    }

    @Internal
    public f getCodepointsInSparseBitSet(String str, Boolean bool, Boolean bool2) {
        f fVar = new f();
        Predicate<Object> predicate = this.filter;
        try {
            this.filter = new c(bool, 1, bool2, str);
            this.slideshow.getSlides().forEach(new C(this, fVar, 2));
            return fVar;
        } finally {
            this.filter = predicate;
        }
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public POITextExtractor getMetadataTextExtractor() {
        return this.slideshow.getMetadataTextExtractor();
    }

    public List<? extends ObjectShape<S, P>> getOLEShapes() {
        ArrayList arrayList = new ArrayList();
        Iterator<? extends Slide<S, P>> it = this.slideshow.getSlides().iterator();
        while (it.hasNext()) {
            addOLEShapes(arrayList, it.next());
        }
        return arrayList;
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public String getText() {
        StringBuilder sb = new StringBuilder();
        Iterator<? extends Slide<S, P>> it = this.slideshow.getSlides().iterator();
        while (it.hasNext()) {
            getText(it.next(), new com.idlefish.flutterboost.containers.a(sb, 1));
        }
        return sb.toString();
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public boolean isCloseFilesystem() {
        return this.doCloseFilesystem;
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public void setCloseFilesystem(boolean z6) {
        this.doCloseFilesystem = z6;
    }

    public void setCommentsByDefault(boolean z6) {
        this.commentsByDefault = z6;
    }

    public void setMasterByDefault(boolean z6) {
        this.masterByDefault = z6;
    }

    public void setNotesByDefault(boolean z6) {
        this.notesByDefault = z6;
    }

    public void setSlidesByDefault(boolean z6) {
        this.slidesByDefault = z6;
    }

    private void printTextParagraphs(List<P> list, Consumer<String> consumer, String str) {
        printTextParagraphs(list, consumer, str, new g(24));
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public SlideShow<S, P> getDocument() {
        return this.slideshow;
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public SlideShow<S, P> getFilesystem() {
        return getDocument();
    }

    private void printTextParagraphs(List<P> list, Consumer<String> consumer, String str, Function<TextRun, String> function) {
        Iterator<P> it = list.iterator();
        while (it.hasNext()) {
            for (TextRun textRun : it.next()) {
                if (this.filter.test(textRun)) {
                    consumer.accept(function.apply(textRun));
                }
            }
            if (!str.isEmpty() && this.filter.test(str)) {
                consumer.accept(str);
            }
        }
    }

    private void printShapeText(ShapeContainer<S, P> shapeContainer, Consumer<String> consumer) {
        for (S s6 : shapeContainer) {
            if (s6 instanceof TextShape) {
                printTextParagraphs(((TextShape) s6).getTextParagraphs(), consumer);
            } else if (s6 instanceof TableShape) {
                printShapeText((TableShape) s6, consumer);
            } else if (s6 instanceof ShapeContainer) {
                printShapeText((ShapeContainer) s6, consumer);
            }
        }
    }

    public String getText(Slide<S, P> slide) {
        StringBuilder sb = new StringBuilder();
        getText(slide, new com.idlefish.flutterboost.containers.a(sb, 1));
        return sb.toString();
    }

    private void getText(Slide<S, P> slide, Consumer<String> consumer) {
        if (this.slidesByDefault) {
            printShapeText((Sheet) slide, consumer);
        }
        if (this.masterByDefault) {
            MasterSheet<S, P> masterSheet = slide.getMasterSheet();
            printSlideMaster(masterSheet, consumer);
            MasterSheet<S, P> slideLayout = slide.getSlideLayout();
            if (slideLayout != masterSheet) {
                printSlideMaster(slideLayout, consumer);
            }
        }
        if (this.commentsByDefault) {
            printComments(slide, consumer);
        }
        if (this.notesByDefault) {
            printNotes(slide, consumer);
        }
    }

    private void printShapeText(TableShape<S, P> tableShape, Consumer<String> consumer) {
        int numberOfRows = tableShape.getNumberOfRows();
        int numberOfColumns = tableShape.getNumberOfColumns();
        for (int i5 = 0; i5 < numberOfRows; i5++) {
            String str = "";
            int i6 = 0;
            while (true) {
                if (i6 >= numberOfColumns) {
                    break;
                }
                TableCell<S, P> cell = tableShape.getCell(i5, i6);
                if (cell != null) {
                    String str2 = i6 < numberOfColumns + (-1) ? "\t" : "\n";
                    printTextParagraphs(cell.getTextParagraphs(), consumer, str2);
                    str = str2;
                }
                i6++;
            }
            if (!str.equals("\n") && this.filter.test("\n")) {
                consumer.accept("\n");
            }
        }
    }
}
