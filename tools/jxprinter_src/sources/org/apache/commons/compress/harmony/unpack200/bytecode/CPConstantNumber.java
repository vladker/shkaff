package org.apache.commons.compress.harmony.unpack200.bytecode;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class CPConstantNumber extends CPConstant {
    public CPConstantNumber(byte b, Object obj, int i5) {
        super(b, obj, i5);
    }

    public Number getNumber() {
        return (Number) getValue();
    }
}
