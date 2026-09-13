package org.apache.poi.hssf.record.common;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.material.color.utilities.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.common.Duplicatable;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.cont.ContinuableRecordInput;
import org.apache.poi.hssf.record.cont.ContinuableRecordOutput;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class UnicodeString implements Comparable<UnicodeString>, Duplicatable, GenericRecord {
    private short field_1_charCount;
    private byte field_2_optionflags;
    private String field_3_string;
    private List<FormatRun> field_4_format_runs;
    private ExtRst field_5_ext_rst;
    private static final Logger LOG = LogManager.getLogger((Class<?>) UnicodeString.class);
    private static final BitField highByte = BitFieldFactory.getInstance(1);
    private static final BitField extBit = BitFieldFactory.getInstance(4);
    private static final BitField richText = BitFieldFactory.getInstance(8);

    private UnicodeString(UnicodeString unicodeString) {
        this.field_1_charCount = unicodeString.field_1_charCount;
        this.field_2_optionflags = unicodeString.field_2_optionflags;
        this.field_3_string = unicodeString.field_3_string;
        List<FormatRun> list = unicodeString.field_4_format_runs;
        this.field_4_format_runs = list == null ? null : (List) list.stream().map(new g(17)).collect(Collectors.toList());
        ExtRst extRst = unicodeString.field_5_ext_rst;
        this.field_5_ext_rst = extRst != null ? extRst.copy() : null;
    }

    private int findFormatRunAt(int i5) {
        int size = this.field_4_format_runs.size();
        for (int i6 = 0; i6 < size; i6++) {
            short s6 = this.field_4_format_runs.get(i6)._character;
            if (s6 == i5) {
                return i6;
            }
            if (s6 > i5) {
                return -1;
            }
        }
        return -1;
    }

    private boolean isExtendedText() {
        return extBit.isSet(getOptionFlags());
    }

    private boolean isRichText() {
        return richText.isSet(getOptionFlags());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return this.field_4_format_runs;
    }

    public void addFormatRun(FormatRun formatRun) {
        if (this.field_4_format_runs == null) {
            this.field_4_format_runs = new ArrayList();
        }
        int iFindFormatRunAt = findFormatRunAt(formatRun._character);
        if (iFindFormatRunAt != -1) {
            this.field_4_format_runs.remove(iFindFormatRunAt);
        }
        this.field_4_format_runs.add(formatRun);
        Collections.sort(this.field_4_format_runs);
        this.field_2_optionflags = richText.setByte(this.field_2_optionflags);
    }

    public void clearFormatting() {
        this.field_4_format_runs = null;
        this.field_2_optionflags = richText.clearByte(this.field_2_optionflags);
    }

    public boolean equals(Object obj) {
        int size;
        if (!(obj instanceof UnicodeString)) {
            return false;
        }
        UnicodeString unicodeString = (UnicodeString) obj;
        if (this.field_1_charCount != unicodeString.field_1_charCount || this.field_2_optionflags != unicodeString.field_2_optionflags || !this.field_3_string.equals(unicodeString.field_3_string)) {
            return false;
        }
        List<FormatRun> list = this.field_4_format_runs;
        if (list == null) {
            return unicodeString.field_4_format_runs == null;
        }
        if (unicodeString.field_4_format_runs == null || (size = list.size()) != unicodeString.field_4_format_runs.size()) {
            return false;
        }
        for (int i5 = 0; i5 < size; i5++) {
            if (!this.field_4_format_runs.get(i5).equals(unicodeString.field_4_format_runs.get(i5))) {
                return false;
            }
        }
        ExtRst extRst = this.field_5_ext_rst;
        if (extRst == null) {
            return unicodeString.field_5_ext_rst == null;
        }
        ExtRst extRst2 = unicodeString.field_5_ext_rst;
        if (extRst2 == null) {
            return false;
        }
        return extRst.equals(extRst2);
    }

    public Iterator<FormatRun> formatIterator() {
        List<FormatRun> list = this.field_4_format_runs;
        if (list != null) {
            return list.iterator();
        }
        return null;
    }

    public Spliterator<FormatRun> formatSpliterator() {
        List<FormatRun> list = this.field_4_format_runs;
        if (list != null) {
            return list.spliterator();
        }
        return null;
    }

    public int getCharCount() {
        short s6 = this.field_1_charCount;
        return s6 < 0 ? s6 + 65536 : s6;
    }

    public short getCharCountShort() {
        return this.field_1_charCount;
    }

    public String getDebugInfo() {
        StringBuilder sb = new StringBuilder("[UNICODESTRING]\n    .charcount       = ");
        sb.append(Integer.toHexString(getCharCount()));
        sb.append("\n    .optionflags     = ");
        sb.append(Integer.toHexString(getOptionFlags()));
        sb.append("\n    .string          = ");
        sb.append(getString());
        sb.append("\n");
        if (this.field_4_format_runs != null) {
            for (int i5 = 0; i5 < this.field_4_format_runs.size(); i5++) {
                FormatRun formatRun = this.field_4_format_runs.get(i5);
                sb.append("      .format_run");
                sb.append(i5);
                sb.append("          = ");
                sb.append(formatRun);
                sb.append("\n");
            }
        }
        if (this.field_5_ext_rst != null) {
            sb.append("    .field_5_ext_rst          = \n");
            sb.append(this.field_5_ext_rst);
            sb.append("\n");
        }
        sb.append("[/UNICODESTRING]\n");
        return sb.toString();
    }

    public ExtRst getExtendedRst() {
        return this.field_5_ext_rst;
    }

    public FormatRun getFormatRun(int i5) {
        List<FormatRun> list = this.field_4_format_runs;
        if (list != null && i5 >= 0 && i5 < list.size()) {
            return this.field_4_format_runs.get(i5);
        }
        return null;
    }

    public int getFormatRunCount() {
        List<FormatRun> list = this.field_4_format_runs;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.common.f
            public final /* synthetic */ UnicodeString b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Integer.valueOf(this.b.getCharCount());
                    case 1:
                        return Byte.valueOf(this.b.getOptionFlags());
                    case 2:
                        return this.b.getString();
                    case 3:
                        return this.b.lambda$getGenericProperties$0();
                    default:
                        return this.b.getExtendedRst();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.common.f
            public final /* synthetic */ UnicodeString b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Integer.valueOf(this.b.getCharCount());
                    case 1:
                        return Byte.valueOf(this.b.getOptionFlags());
                    case 2:
                        return this.b.getString();
                    case 3:
                        return this.b.lambda$getGenericProperties$0();
                    default:
                        return this.b.getExtendedRst();
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.common.f
            public final /* synthetic */ UnicodeString b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Integer.valueOf(this.b.getCharCount());
                    case 1:
                        return Byte.valueOf(this.b.getOptionFlags());
                    case 2:
                        return this.b.getString();
                    case 3:
                        return this.b.lambda$getGenericProperties$0();
                    default:
                        return this.b.getExtendedRst();
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.common.f
            public final /* synthetic */ UnicodeString b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Integer.valueOf(this.b.getCharCount());
                    case 1:
                        return Byte.valueOf(this.b.getOptionFlags());
                    case 2:
                        return this.b.getString();
                    case 3:
                        return this.b.lambda$getGenericProperties$0();
                    default:
                        return this.b.getExtendedRst();
                }
            }
        };
        final int i9 = 4;
        return GenericRecordUtil.getGenericProperties("charCount", supplier, "optionFlags", supplier2, TypedValues.Custom.S_STRING, supplier3, "formatRuns", supplier4, "extendedRst", new Supplier(this) { // from class: org.apache.poi.hssf.record.common.f
            public final /* synthetic */ UnicodeString b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Integer.valueOf(this.b.getCharCount());
                    case 1:
                        return Byte.valueOf(this.b.getOptionFlags());
                    case 2:
                        return this.b.getString();
                    case 3:
                        return this.b.lambda$getGenericProperties$0();
                    default:
                        return this.b.getExtendedRst();
                }
            }
        });
    }

    public byte getOptionFlags() {
        return this.field_2_optionflags;
    }

    public String getString() {
        return this.field_3_string;
    }

    public int hashCode() {
        return Objects.hash(Short.valueOf(this.field_1_charCount), this.field_3_string);
    }

    public void removeFormatRun(FormatRun formatRun) {
        this.field_4_format_runs.remove(formatRun);
        if (this.field_4_format_runs.isEmpty()) {
            this.field_4_format_runs = null;
            this.field_2_optionflags = richText.clearByte(this.field_2_optionflags);
        }
    }

    public void serialize(ContinuableRecordOutput continuableRecordOutput) {
        ExtRst extRst;
        ExtRst extRst2;
        List<FormatRun> list;
        int size = (!isRichText() || (list = this.field_4_format_runs) == null) ? 0 : list.size();
        int dataSize = (!isExtendedText() || (extRst2 = this.field_5_ext_rst) == null) ? 0 : extRst2.getDataSize() + 4;
        continuableRecordOutput.writeString(this.field_3_string, size, dataSize);
        if (size > 0) {
            for (int i5 = 0; i5 < size; i5++) {
                if (continuableRecordOutput.getAvailableSpace() < 4) {
                    continuableRecordOutput.writeContinue();
                }
                this.field_4_format_runs.get(i5).serialize(continuableRecordOutput);
            }
        }
        if (dataSize <= 0 || (extRst = this.field_5_ext_rst) == null) {
            return;
        }
        extRst.serialize(continuableRecordOutput);
    }

    public void setCharCount(short s6) {
        this.field_1_charCount = s6;
    }

    public void setExtendedRst(ExtRst extRst) {
        if (extRst != null) {
            this.field_2_optionflags = extBit.setByte(this.field_2_optionflags);
        } else {
            this.field_2_optionflags = extBit.clearByte(this.field_2_optionflags);
        }
        this.field_5_ext_rst = extRst;
    }

    public void setOptionFlags(byte b) {
        this.field_2_optionflags = b;
    }

    public void setString(String str) {
        this.field_3_string = str;
        setCharCount((short) str.length());
        int length = str.length();
        for (int i5 = 0; i5 < length; i5++) {
            if (str.charAt(i5) > 255) {
                this.field_2_optionflags = highByte.setByte(this.field_2_optionflags);
                return;
            }
        }
        this.field_2_optionflags = highByte.clearByte(this.field_2_optionflags);
    }

    public void swapFontUse(short s6, short s7) {
        List<FormatRun> list = this.field_4_format_runs;
        if (list != null) {
            for (FormatRun formatRun : list) {
                if (formatRun._fontIndex == s6) {
                    formatRun._fontIndex = s7;
                }
            }
        }
    }

    public String toString() {
        return getString();
    }

    @Override // java.lang.Comparable
    public int compareTo(UnicodeString unicodeString) {
        int iCompareTo = getString().compareTo(unicodeString.getString());
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        List<FormatRun> list = this.field_4_format_runs;
        if (list == null) {
            return unicodeString.field_4_format_runs == null ? 0 : 1;
        }
        if (unicodeString.field_4_format_runs == null) {
            return -1;
        }
        int size = list.size();
        if (size != unicodeString.field_4_format_runs.size()) {
            return size - unicodeString.field_4_format_runs.size();
        }
        for (int i5 = 0; i5 < size; i5++) {
            int iCompareTo2 = this.field_4_format_runs.get(i5).compareTo(unicodeString.field_4_format_runs.get(i5));
            if (iCompareTo2 != 0) {
                return iCompareTo2;
            }
        }
        ExtRst extRst = this.field_5_ext_rst;
        if (extRst == null) {
            return unicodeString.field_5_ext_rst == null ? 0 : 1;
        }
        ExtRst extRst2 = unicodeString.field_5_ext_rst;
        if (extRst2 == null) {
            return -1;
        }
        return extRst.compareTo(extRst2);
    }

    @Override // org.apache.poi.common.Duplicatable
    public UnicodeString copy() {
        return new UnicodeString(this);
    }

    public UnicodeString(String str) {
        setString(str);
    }

    public UnicodeString(RecordInputStream recordInputStream) {
        this.field_1_charCount = recordInputStream.readShort();
        this.field_2_optionflags = recordInputStream.readByte();
        short s6 = isRichText() ? recordInputStream.readShort() : (short) 0;
        int i5 = isExtendedText() ? recordInputStream.readInt() : 0;
        boolean z6 = (this.field_2_optionflags & 1) == 0;
        int charCount = getCharCount();
        this.field_3_string = z6 ? recordInputStream.readCompressedUnicode(charCount) : recordInputStream.readUnicodeLEString(charCount);
        if (isRichText() && s6 > 0) {
            this.field_4_format_runs = new ArrayList(s6);
            for (int i6 = 0; i6 < s6; i6++) {
                this.field_4_format_runs.add(new FormatRun(recordInputStream));
            }
        }
        if (!isExtendedText() || i5 <= 0) {
            return;
        }
        ExtRst extRst = new ExtRst(new ContinuableRecordInput(recordInputStream), i5);
        this.field_5_ext_rst = extRst;
        if (extRst.getDataSize() + 4 != i5) {
            LOG.atWarn().log("ExtRst was supposed to be {} bytes long, but seems to actually be {}", Unbox.box(i5), Unbox.box(this.field_5_ext_rst.getDataSize() + 4));
        }
    }
}
