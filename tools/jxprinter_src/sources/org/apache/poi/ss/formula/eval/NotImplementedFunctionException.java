package org.apache.poi.ss.formula.eval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class NotImplementedFunctionException extends NotImplementedException {
    private static final long serialVersionUID = 1208119411557559057L;
    private String functionName;

    public NotImplementedFunctionException(String str) {
        super(str);
        this.functionName = str;
    }

    public String getFunctionName() {
        return this.functionName;
    }

    public NotImplementedFunctionException(String str, NotImplementedException notImplementedException) {
        super(str, notImplementedException);
        this.functionName = str;
    }
}
