package org.apache.poi.ddf;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.logging.log4j.util.Chars;
import org.apache.poi.common.Duplicatable;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.GenericRecordXmlWriter;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class EscherRecord implements Duplicatable, GenericRecord {
    private static final BitField fInstance = BitFieldFactory.getInstance(65520);
    private static final BitField fVersion = BitFieldFactory.getInstance(15);
    private short _options;
    private short _recordId;

    public EscherRecord() {
    }

    public static short readInstance(byte[] bArr, int i5) {
        return fInstance.getShortValue(LittleEndian.getShort(bArr, i5));
    }

    @Override // org.apache.poi.common.Duplicatable
    public abstract EscherRecord copy();

    public void display(PrintWriter printWriter, int i5) {
        for (int i6 = 0; i6 < i5 * 4; i6++) {
            printWriter.print(Chars.SPACE);
        }
        printWriter.println(getRecordName());
    }

    public abstract int fillFields(byte[] bArr, int i5, EscherRecordFactory escherRecordFactory);

    public int fillFields(byte[] bArr, EscherRecordFactory escherRecordFactory) {
        return fillFields(bArr, 0, escherRecordFactory);
    }

    public EscherRecord getChild(int i5) {
        return getChildRecords().get(i5);
    }

    public List<EscherRecord> getChildRecords() {
        return Collections.EMPTY_LIST;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public List<? extends GenericRecord> getGenericChildren() {
        return getChildRecords();
    }

    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.ddf.t
            public final /* synthetic */ EscherRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Short.valueOf(this.b.getRecordId());
                    case 1:
                        return Short.valueOf(this.b.getVersion());
                    case 2:
                        return Short.valueOf(this.b.getInstance());
                    case 3:
                        return Short.valueOf(this.b.getOptions());
                    default:
                        return Integer.valueOf(this.b.getRecordSize());
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.ddf.t
            public final /* synthetic */ EscherRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Short.valueOf(this.b.getRecordId());
                    case 1:
                        return Short.valueOf(this.b.getVersion());
                    case 2:
                        return Short.valueOf(this.b.getInstance());
                    case 3:
                        return Short.valueOf(this.b.getOptions());
                    default:
                        return Integer.valueOf(this.b.getRecordSize());
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.ddf.t
            public final /* synthetic */ EscherRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Short.valueOf(this.b.getRecordId());
                    case 1:
                        return Short.valueOf(this.b.getVersion());
                    case 2:
                        return Short.valueOf(this.b.getInstance());
                    case 3:
                        return Short.valueOf(this.b.getOptions());
                    default:
                        return Integer.valueOf(this.b.getRecordSize());
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.ddf.t
            public final /* synthetic */ EscherRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Short.valueOf(this.b.getRecordId());
                    case 1:
                        return Short.valueOf(this.b.getVersion());
                    case 2:
                        return Short.valueOf(this.b.getInstance());
                    case 3:
                        return Short.valueOf(this.b.getOptions());
                    default:
                        return Integer.valueOf(this.b.getRecordSize());
                }
            }
        };
        final int i9 = 4;
        return GenericRecordUtil.getGenericProperties("recordId", supplier, "version", supplier2, "instance", supplier3, "options", supplier4, "recordSize", new Supplier(this) { // from class: org.apache.poi.ddf.t
            public final /* synthetic */ EscherRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Short.valueOf(this.b.getRecordId());
                    case 1:
                        return Short.valueOf(this.b.getVersion());
                    case 2:
                        return Short.valueOf(this.b.getInstance());
                    case 3:
                        return Short.valueOf(this.b.getOptions());
                    default:
                        return Integer.valueOf(this.b.getRecordSize());
                }
            }
        });
    }

    public short getInstance() {
        return fInstance.getShortValue(this._options);
    }

    @Internal
    public short getOptions() {
        return this._options;
    }

    public short getRecordId() {
        return this._recordId;
    }

    public abstract String getRecordName();

    public abstract int getRecordSize();

    public short getVersion() {
        return fVersion.getShortValue(this._options);
    }

    public boolean isContainerRecord() {
        return getVersion() == 15;
    }

    public int readHeader(byte[] bArr, int i5) {
        this._options = LittleEndian.getShort(bArr, i5);
        this._recordId = LittleEndian.getShort(bArr, i5 + 2);
        return LittleEndian.getInt(bArr, i5 + 4);
    }

    public abstract int serialize(int i5, byte[] bArr, EscherSerializationListener escherSerializationListener);

    public byte[] serialize() {
        byte[] bArr = new byte[getRecordSize()];
        serialize(0, bArr);
        return bArr;
    }

    public void setChildRecords(List<EscherRecord> list) {
        throw new UnsupportedOperationException("This record does not support child records.");
    }

    public void setInstance(short s6) {
        this._options = fInstance.setShortValue(this._options, s6);
    }

    @Internal
    public void setOptions(short s6) {
        setVersion(fVersion.getShortValue(s6));
        setInstance(fInstance.getShortValue(s6));
        this._options = s6;
    }

    public void setRecordId(short s6) {
        this._recordId = s6;
    }

    public void setVersion(short s6) {
        this._options = fVersion.setShortValue(this._options, s6);
    }

    public final String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }

    public String toXml() {
        return toXml("");
    }

    public EscherRecord(EscherRecord escherRecord) {
        this._options = escherRecord._options;
        this._recordId = escherRecord._recordId;
    }

    public final String toXml(String str) {
        return GenericRecordXmlWriter.marshal(this);
    }

    public int serialize(int i5, byte[] bArr) {
        return serialize(i5, bArr, new NullEscherSerializationListener());
    }
}
