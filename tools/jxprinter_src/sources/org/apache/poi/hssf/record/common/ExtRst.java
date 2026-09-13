package org.apache.poi.hssf.record.common;

import com.google.android.material.color.utilities.g;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;
import o5.i;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.hssf.record.cont.ContinuableRecordOutput;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class ExtRst implements Comparable<ExtRst>, GenericRecord {
    private static final Logger LOG = LogManager.getLogger((Class<?>) ExtRst.class);
    private byte[] extraData;
    private short formattingFontIndex;
    private short formattingOptions;
    private int numberOfRuns;
    private PhRun[] phRuns;
    private String phoneticText;
    private short reserved;

    public ExtRst() {
        populateEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return Short.valueOf(this.reserved);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$2() {
        return this.extraData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ PhRun[] lambda$new$0(int i5) {
        return new PhRun[i5];
    }

    private void populateEmpty() {
        this.reserved = (short) 1;
        this.phoneticText = "";
        this.phRuns = new PhRun[0];
        this.extraData = new byte[0];
    }

    public ExtRst copy() {
        return new ExtRst(this);
    }

    public boolean equals(Object obj) {
        return (obj instanceof ExtRst) && compareTo((ExtRst) obj) == 0;
    }

    public int getDataSize() {
        return (this.phRuns.length * 6) + (this.phoneticText.length() * 2) + 10 + this.extraData.length;
    }

    public short getFormattingFontIndex() {
        return this.formattingFontIndex;
    }

    public short getFormattingOptions() {
        return this.formattingOptions;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.common.a
            public final /* synthetic */ ExtRst b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$1();
                    case 1:
                        return Short.valueOf(this.b.getFormattingFontIndex());
                    case 2:
                        return Short.valueOf(this.b.getFormattingOptions());
                    case 3:
                        return Integer.valueOf(this.b.getNumberOfRuns());
                    case 4:
                        return this.b.getPhoneticText();
                    case 5:
                        return this.b.getPhRuns();
                    default:
                        return this.b.lambda$getGenericProperties$2();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.common.a
            public final /* synthetic */ ExtRst b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$1();
                    case 1:
                        return Short.valueOf(this.b.getFormattingFontIndex());
                    case 2:
                        return Short.valueOf(this.b.getFormattingOptions());
                    case 3:
                        return Integer.valueOf(this.b.getNumberOfRuns());
                    case 4:
                        return this.b.getPhoneticText();
                    case 5:
                        return this.b.getPhRuns();
                    default:
                        return this.b.lambda$getGenericProperties$2();
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.common.a
            public final /* synthetic */ ExtRst b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return this.b.lambda$getGenericProperties$1();
                    case 1:
                        return Short.valueOf(this.b.getFormattingFontIndex());
                    case 2:
                        return Short.valueOf(this.b.getFormattingOptions());
                    case 3:
                        return Integer.valueOf(this.b.getNumberOfRuns());
                    case 4:
                        return this.b.getPhoneticText();
                    case 5:
                        return this.b.getPhRuns();
                    default:
                        return this.b.lambda$getGenericProperties$2();
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.common.a
            public final /* synthetic */ ExtRst b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return this.b.lambda$getGenericProperties$1();
                    case 1:
                        return Short.valueOf(this.b.getFormattingFontIndex());
                    case 2:
                        return Short.valueOf(this.b.getFormattingOptions());
                    case 3:
                        return Integer.valueOf(this.b.getNumberOfRuns());
                    case 4:
                        return this.b.getPhoneticText();
                    case 5:
                        return this.b.getPhRuns();
                    default:
                        return this.b.lambda$getGenericProperties$2();
                }
            }
        };
        final int i9 = 4;
        Supplier supplier5 = new Supplier(this) { // from class: org.apache.poi.hssf.record.common.a
            public final /* synthetic */ ExtRst b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return this.b.lambda$getGenericProperties$1();
                    case 1:
                        return Short.valueOf(this.b.getFormattingFontIndex());
                    case 2:
                        return Short.valueOf(this.b.getFormattingOptions());
                    case 3:
                        return Integer.valueOf(this.b.getNumberOfRuns());
                    case 4:
                        return this.b.getPhoneticText();
                    case 5:
                        return this.b.getPhRuns();
                    default:
                        return this.b.lambda$getGenericProperties$2();
                }
            }
        };
        final int i10 = 5;
        Supplier supplier6 = new Supplier(this) { // from class: org.apache.poi.hssf.record.common.a
            public final /* synthetic */ ExtRst b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return this.b.lambda$getGenericProperties$1();
                    case 1:
                        return Short.valueOf(this.b.getFormattingFontIndex());
                    case 2:
                        return Short.valueOf(this.b.getFormattingOptions());
                    case 3:
                        return Integer.valueOf(this.b.getNumberOfRuns());
                    case 4:
                        return this.b.getPhoneticText();
                    case 5:
                        return this.b.getPhRuns();
                    default:
                        return this.b.lambda$getGenericProperties$2();
                }
            }
        };
        final int i11 = 6;
        return GenericRecordUtil.getGenericProperties("reserved", supplier, "formattingFontIndex", supplier2, "formattingOptions", supplier3, "numberOfRuns", supplier4, "phoneticText", supplier5, "phRuns", supplier6, "extraData", new Supplier(this) { // from class: org.apache.poi.hssf.record.common.a
            public final /* synthetic */ ExtRst b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i11) {
                    case 0:
                        return this.b.lambda$getGenericProperties$1();
                    case 1:
                        return Short.valueOf(this.b.getFormattingFontIndex());
                    case 2:
                        return Short.valueOf(this.b.getFormattingOptions());
                    case 3:
                        return Integer.valueOf(this.b.getNumberOfRuns());
                    case 4:
                        return this.b.getPhoneticText();
                    case 5:
                        return this.b.getPhRuns();
                    default:
                        return this.b.lambda$getGenericProperties$2();
                }
            }
        });
    }

    public int getNumberOfRuns() {
        return this.numberOfRuns;
    }

    public PhRun[] getPhRuns() {
        return this.phRuns;
    }

    public String getPhoneticText() {
        return this.phoneticText;
    }

    public int hashCode() {
        return Arrays.deepHashCode(new Object[]{Short.valueOf(this.reserved), Short.valueOf(this.formattingFontIndex), Short.valueOf(this.formattingOptions), Integer.valueOf(this.numberOfRuns), this.phoneticText, this.phRuns});
    }

    public void serialize(ContinuableRecordOutput continuableRecordOutput) {
        int dataSize = getDataSize();
        continuableRecordOutput.writeContinueIfRequired(8);
        continuableRecordOutput.writeShort(this.reserved);
        continuableRecordOutput.writeShort(dataSize);
        continuableRecordOutput.writeShort(this.formattingFontIndex);
        continuableRecordOutput.writeShort(this.formattingOptions);
        continuableRecordOutput.writeContinueIfRequired(6);
        continuableRecordOutput.writeShort(this.numberOfRuns);
        continuableRecordOutput.writeShort(this.phoneticText.length());
        continuableRecordOutput.writeShort(this.phoneticText.length());
        continuableRecordOutput.writeContinueIfRequired(this.phoneticText.length() * 2);
        StringUtil.putUnicodeLE(this.phoneticText, continuableRecordOutput);
        for (PhRun phRun : this.phRuns) {
            phRun.serialize(continuableRecordOutput);
        }
        continuableRecordOutput.write(this.extraData);
    }

    @Override // java.lang.Comparable
    public int compareTo(ExtRst extRst) {
        int i5 = this.reserved - extRst.reserved;
        if (i5 != 0) {
            return i5;
        }
        int i6 = this.formattingFontIndex - extRst.formattingFontIndex;
        if (i6 != 0) {
            return i6;
        }
        int i7 = this.formattingOptions - extRst.formattingOptions;
        if (i7 != 0) {
            return i7;
        }
        int i8 = this.numberOfRuns - extRst.numberOfRuns;
        if (i8 != 0) {
            return i8;
        }
        int iCompareTo = this.phoneticText.compareTo(extRst.phoneticText);
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        int length = this.phRuns.length - extRst.phRuns.length;
        if (length != 0) {
            return length;
        }
        int i9 = 0;
        while (true) {
            PhRun[] phRunArr = this.phRuns;
            if (i9 >= phRunArr.length) {
                return Arrays.hashCode(this.extraData) - Arrays.hashCode(extRst.extraData);
            }
            PhRun phRun = phRunArr[i9];
            int i10 = phRun.phoneticTextFirstCharacterOffset;
            PhRun phRun2 = extRst.phRuns[i9];
            int i11 = i10 - phRun2.phoneticTextFirstCharacterOffset;
            if (i11 != 0) {
                return i11;
            }
            int i12 = phRun.realTextFirstCharacterOffset - phRun2.realTextFirstCharacterOffset;
            if (i12 != 0) {
                return i12;
            }
            int i13 = phRun.realTextLength - phRun2.realTextLength;
            if (i13 != 0) {
                return i13;
            }
            i9++;
        }
    }

    public ExtRst(ExtRst extRst) {
        this();
        this.reserved = extRst.reserved;
        this.formattingFontIndex = extRst.formattingFontIndex;
        this.formattingOptions = extRst.formattingOptions;
        this.numberOfRuns = extRst.numberOfRuns;
        this.phoneticText = extRst.phoneticText;
        PhRun[] phRunArr = extRst.phRuns;
        this.phRuns = phRunArr == null ? null : (PhRun[]) Stream.of((Object[]) phRunArr).map(new g(16)).toArray(new i(5));
    }

    public ExtRst(LittleEndianInput littleEndianInput, int i5) {
        short s6 = littleEndianInput.readShort();
        this.reserved = s6;
        if (s6 == -1) {
            populateEmpty();
            return;
        }
        int i6 = 0;
        if (s6 != 1) {
            LOG.atWarn().log("ExtRst has wrong magic marker, expecting 1 but found {} - ignoring", Unbox.box(this.reserved));
            while (i6 < i5 - 2) {
                littleEndianInput.readByte();
                i6++;
            }
            populateEmpty();
            return;
        }
        short s7 = littleEndianInput.readShort();
        this.formattingFontIndex = littleEndianInput.readShort();
        this.formattingOptions = littleEndianInput.readShort();
        this.numberOfRuns = littleEndianInput.readUShort();
        short s8 = littleEndianInput.readShort();
        short s9 = littleEndianInput.readShort();
        if (s8 == 0 && s9 > 0) {
            s9 = 0;
        }
        if (s8 == s9) {
            String unicodeLE = StringUtil.readUnicodeLE(littleEndianInput, s8);
            this.phoneticText = unicodeLE;
            int length = (s7 - 10) - (unicodeLE.length() * 2);
            int i7 = length / 6;
            this.phRuns = new PhRun[i7];
            int i8 = 0;
            while (true) {
                PhRun[] phRunArr = this.phRuns;
                if (i8 >= phRunArr.length) {
                    break;
                }
                phRunArr[i8] = new PhRun(littleEndianInput);
                i8++;
            }
            int i9 = length - (i7 * 6);
            if (i9 < 0) {
                LOG.atWarn().log("ExtRst overran by {} bytes", Unbox.box(-i9));
                i9 = 0;
            }
            this.extraData = IOUtils.safelyAllocate(i9, HSSFWorkbook.getMaxRecordLength());
            while (true) {
                byte[] bArr = this.extraData;
                if (i6 >= bArr.length) {
                    return;
                }
                bArr[i6] = littleEndianInput.readByte();
                i6++;
            }
        } else {
            throw new IllegalStateException(androidx.collection.a.h(s8, s9, "The two length fields of the Phonetic Text don't agree! ", " vs "));
        }
    }
}
