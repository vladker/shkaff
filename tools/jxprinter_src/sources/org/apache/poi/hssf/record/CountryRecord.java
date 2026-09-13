package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class CountryRecord extends StandardRecord {
    public static final short sid = 140;
    private short field_1_default_country;
    private short field_2_current_country;

    public CountryRecord() {
    }

    public short getCurrentCountry() {
        return this.field_2_current_country;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 4;
    }

    public short getDefaultCountry() {
        return this.field_1_default_country;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        final int i6 = 1;
        return GenericRecordUtil.getGenericProperties("defaultCountry", new Supplier(this) { // from class: org.apache.poi.hssf.record.q
            public final /* synthetic */ CountryRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short defaultCountry;
                switch (i5) {
                    case 0:
                        defaultCountry = this.b.getDefaultCountry();
                        break;
                    default:
                        defaultCountry = this.b.getCurrentCountry();
                        break;
                }
                return Short.valueOf(defaultCountry);
            }
        }, "currentCountry", new Supplier(this) { // from class: org.apache.poi.hssf.record.q
            public final /* synthetic */ CountryRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short defaultCountry;
                switch (i6) {
                    case 0:
                        defaultCountry = this.b.getDefaultCountry();
                        break;
                    default:
                        defaultCountry = this.b.getCurrentCountry();
                        break;
                }
                return Short.valueOf(defaultCountry);
            }
        });
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 140;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getDefaultCountry());
        littleEndianOutput.writeShort(getCurrentCountry());
    }

    public void setCurrentCountry(short s6) {
        this.field_2_current_country = s6;
    }

    public void setDefaultCountry(short s6) {
        this.field_1_default_country = s6;
    }

    public CountryRecord(CountryRecord countryRecord) {
        super(countryRecord);
        this.field_1_default_country = countryRecord.field_1_default_country;
        this.field_2_current_country = countryRecord.field_2_current_country;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.COUNTRY;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public CountryRecord copy() {
        return new CountryRecord(this);
    }

    public CountryRecord(RecordInputStream recordInputStream) {
        this.field_1_default_country = recordInputStream.readShort();
        this.field_2_current_country = recordInputStream.readShort();
    }
}
