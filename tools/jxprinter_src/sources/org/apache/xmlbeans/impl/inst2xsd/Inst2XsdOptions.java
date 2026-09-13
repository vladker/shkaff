package org.apache.xmlbeans.impl.inst2xsd;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Inst2XsdOptions {
    public static final int DESIGN_RUSSIAN_DOLL = 1;
    public static final int DESIGN_SALAMI_SLICE = 2;
    public static final int DESIGN_VENETIAN_BLIND = 3;
    public static final int ENUMERATION_NEVER = 1;
    public static final int ENUMERATION_NOT_MORE_THAN_DEFAULT = 10;
    public static final int SIMPLE_CONTENT_TYPES_SMART = 1;
    public static final int SIMPLE_CONTENT_TYPES_STRING = 2;
    private int _design = 3;
    private int _simpleContentTypes = 1;
    private int _enumerations = 10;
    private boolean _verbose = false;

    public int getDesign() {
        return this._design;
    }

    public int getSimpleContentTypes() {
        return this._simpleContentTypes;
    }

    public int getUseEnumerations() {
        return this._enumerations;
    }

    public boolean isUseEnumerations() {
        return this._enumerations > 1;
    }

    public boolean isVerbose() {
        return this._verbose;
    }

    public void setDesign(int i5) {
        if (i5 != 1 && i5 != 2 && i5 != 3) {
            throw new IllegalArgumentException("Unknown value for design type.");
        }
        this._design = i5;
    }

    public void setSimpleContentTypes(int i5) {
        if (i5 != 1 && i5 != 2) {
            throw new IllegalArgumentException("Unknown value for simpleContentTypes.");
        }
        this._simpleContentTypes = i5;
    }

    public void setUseEnumerations(int i5) {
        if (i5 < 1) {
            throw new IllegalArgumentException("UseEnumerations must be set to a value bigger than 1");
        }
        this._enumerations = i5;
    }

    public void setVerbose(boolean z6) {
        this._verbose = z6;
    }
}
