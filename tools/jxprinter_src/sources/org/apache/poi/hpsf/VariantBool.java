package org.apache.poi.hpsf;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndianByteArrayInputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class VariantBool {
    private static final Logger LOG = LogManager.getLogger((Class<?>) VariantBool.class);
    static final int SIZE = 2;
    private boolean _value;

    public boolean getValue() {
        return this._value;
    }

    public void read(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream) {
        short s6 = littleEndianByteArrayInputStream.readShort();
        if (s6 == -1) {
            this._value = true;
        } else if (s6 == 0) {
            this._value = false;
        } else {
            LOG.atWarn().log("VARIANT_BOOL value '{}' is incorrect", Unbox.box(s6));
            this._value = true;
        }
    }

    public void setValue(boolean z6) {
        this._value = z6;
    }
}
