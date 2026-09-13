package org.apache.poi.ss.formula;

import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class NameIdentifier {
    private final boolean _isQuoted;
    private final String _name;

    public NameIdentifier(String str, boolean z6) {
        this._name = str;
        this._isQuoted = z6;
    }

    public String getName() {
        return this._name;
    }

    public boolean isQuoted() {
        return this._isQuoted;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(getClass().getName());
        sb.append(" [");
        if (this._isQuoted) {
            sb.append(Chars.QUOTE);
            sb.append(this._name);
            sb.append("'");
        } else {
            sb.append(this._name);
        }
        sb.append(']');
        return sb.toString();
    }
}
