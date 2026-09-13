package org.apache.poi.hssf.usermodel;

import java.util.Iterator;
import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.record.LabelSSTRecord;
import org.apache.poi.hssf.record.common.FormatRun;
import org.apache.poi.hssf.record.common.UnicodeString;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.RichTextString;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class HSSFRichTextString implements Comparable<HSSFRichTextString>, RichTextString {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final short NO_FONT = 0;
    private InternalWorkbook _book;
    private LabelSSTRecord _record;
    private UnicodeString _string;

    public HSSFRichTextString() {
        this("");
    }

    private void addToSSTIfRequired() {
        InternalWorkbook internalWorkbook = this._book;
        if (internalWorkbook != null) {
            int iAddSSTString = internalWorkbook.addSSTString(this._string);
            this._record.setSSTIndex(iAddSSTString);
            this._string = this._book.getSSTString(iAddSSTString);
        }
    }

    private UnicodeString cloneStringIfRequired() {
        return this._book == null ? this._string : this._string.copy();
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public void applyFont(int i5, int i6, short s6) {
        if (i5 > i6) {
            throw new IllegalArgumentException("Start index must be less than end index.");
        }
        if (i5 < 0 || i6 > length()) {
            throw new IllegalArgumentException("Start and end index not in range.");
        }
        if (i5 == i6) {
            return;
        }
        short fontAtIndex = i6 != length() ? getFontAtIndex(i6) : (short) 0;
        UnicodeString unicodeStringCloneStringIfRequired = cloneStringIfRequired();
        this._string = unicodeStringCloneStringIfRequired;
        Iterator<FormatRun> iterator = unicodeStringCloneStringIfRequired.formatIterator();
        if (iterator != null) {
            while (iterator.hasNext()) {
                FormatRun next = iterator.next();
                if (next.getCharacterPos() >= i5 && next.getCharacterPos() < i6) {
                    iterator.remove();
                }
            }
        }
        this._string.addFormatRun(new FormatRun((short) i5, s6));
        if (i6 != length()) {
            this._string.addFormatRun(new FormatRun((short) i6, fontAtIndex));
        }
        addToSSTIfRequired();
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public void clearFormatting() {
        UnicodeString unicodeStringCloneStringIfRequired = cloneStringIfRequired();
        this._string = unicodeStringCloneStringIfRequired;
        unicodeStringCloneStringIfRequired.clearFormatting();
        addToSSTIfRequired();
    }

    public boolean equals(Object obj) {
        if (obj instanceof HSSFRichTextString) {
            return this._string.equals(((HSSFRichTextString) obj)._string);
        }
        return false;
    }

    public short getFontAtIndex(int i5) {
        int formatRunCount = this._string.getFormatRunCount();
        FormatRun formatRun = null;
        int i6 = 0;
        while (i6 < formatRunCount) {
            FormatRun formatRun2 = this._string.getFormatRun(i6);
            if (formatRun2.getCharacterPos() > i5) {
                break;
            }
            i6++;
            formatRun = formatRun2;
        }
        if (formatRun == null) {
            return (short) 0;
        }
        return formatRun.getFontIndex();
    }

    public short getFontOfFormattingRun(int i5) {
        return this._string.getFormatRun(i5).getFontIndex();
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public int getIndexOfFormattingRun(int i5) {
        return this._string.getFormatRun(i5).getCharacterPos();
    }

    public UnicodeString getRawUnicodeString() {
        return this._string;
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public String getString() {
        return this._string.getString();
    }

    public UnicodeString getUnicodeString() {
        return cloneStringIfRequired();
    }

    public int hashCode() {
        return 42;
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public int length() {
        return this._string.getCharCount();
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public int numFormattingRuns() {
        return this._string.getFormatRunCount();
    }

    public void setUnicodeString(UnicodeString unicodeString) {
        this._string = unicodeString;
    }

    public void setWorkbookReferences(InternalWorkbook internalWorkbook, LabelSSTRecord labelSSTRecord) {
        this._book = internalWorkbook;
        this._record = labelSSTRecord;
    }

    public String toString() {
        return this._string.toString();
    }

    public HSSFRichTextString(String str) {
        if (str == null) {
            this._string = new UnicodeString("");
        } else {
            this._string = new UnicodeString(str);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(HSSFRichTextString hSSFRichTextString) {
        return this._string.compareTo(hSSFRichTextString._string);
    }

    public HSSFRichTextString(InternalWorkbook internalWorkbook, LabelSSTRecord labelSSTRecord) {
        setWorkbookReferences(internalWorkbook, labelSSTRecord);
        this._string = internalWorkbook.getSSTString(labelSSTRecord.getSSTIndex());
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public void applyFont(int i5, int i6, Font font) {
        applyFont(i5, i6, (short) font.getIndex());
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public void applyFont(Font font) {
        applyFont(0, this._string.getCharCount(), font);
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public void applyFont(short s6) {
        applyFont(0, this._string.getCharCount(), s6);
    }
}
