package org.apache.xmlbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class StringEnumAbstractBase implements Serializable {
    private static final long serialVersionUID = 1;
    private int _int;
    private String _string;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Table {
        private List<StringEnumAbstractBase> _list;
        private Map<String, StringEnumAbstractBase> _map;

        public Table(StringEnumAbstractBase[] stringEnumAbstractBaseArr) {
            this._map = new HashMap(stringEnumAbstractBaseArr.length);
            this._list = new ArrayList(stringEnumAbstractBaseArr.length + 1);
            for (int i5 = 0; i5 < stringEnumAbstractBaseArr.length; i5++) {
                this._map.put(stringEnumAbstractBaseArr[i5].toString(), stringEnumAbstractBaseArr[i5]);
                int iIntValue = stringEnumAbstractBaseArr[i5].intValue();
                while (this._list.size() <= iIntValue) {
                    this._list.add(null);
                }
                this._list.set(iIntValue, stringEnumAbstractBaseArr[i5]);
            }
        }

        public StringEnumAbstractBase forInt(int i5) {
            if (i5 < 0 || i5 > this._list.size()) {
                return null;
            }
            return this._list.get(i5);
        }

        public StringEnumAbstractBase forString(String str) {
            return this._map.get(str);
        }

        public int lastInt() {
            return this._list.size() - 1;
        }
    }

    public StringEnumAbstractBase(String str, int i5) {
        this._string = str;
        this._int = i5;
    }

    public final int hashCode() {
        return this._string.hashCode();
    }

    public final int intValue() {
        return this._int;
    }

    public final String toString() {
        return this._string;
    }
}
