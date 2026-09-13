package org.apache.xmlbeans.impl.common;

import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class XmlObjectList {
    private final XmlObject[] _objects;

    public XmlObjectList(int i5) {
        this._objects = new XmlObject[i5];
    }

    private static String prettytrim(String str) {
        int length = str.length();
        while (length > 0 && XMLChar.isSpace(str.charAt(length - 1))) {
            length--;
        }
        int i5 = 0;
        while (i5 < length && XMLChar.isSpace(str.charAt(i5))) {
            i5++;
        }
        return str.substring(i5, length);
    }

    public boolean equals(Object obj) {
        XmlObject xmlObject;
        if (!(obj instanceof XmlObjectList)) {
            return false;
        }
        XmlObjectList xmlObjectList = (XmlObjectList) obj;
        if (xmlObjectList._objects.length != this._objects.length) {
            return false;
        }
        int i5 = 0;
        while (true) {
            XmlObject[] xmlObjectArr = this._objects;
            if (i5 >= xmlObjectArr.length) {
                return true;
            }
            XmlObject xmlObject2 = xmlObjectArr[i5];
            if (xmlObject2 == null || (xmlObject = xmlObjectList._objects[i5]) == null || !xmlObject2.valueEquals(xmlObject)) {
                return false;
            }
            i5++;
        }
    }

    public boolean filled() {
        int i5 = 0;
        while (true) {
            XmlObject[] xmlObjectArr = this._objects;
            if (i5 >= xmlObjectArr.length) {
                return true;
            }
            if (xmlObjectArr[i5] == null) {
                return false;
            }
            i5++;
        }
    }

    public int hashCode() {
        int i5 = 0;
        int iValueHashCode = 0;
        while (true) {
            XmlObject[] xmlObjectArr = this._objects;
            if (i5 >= xmlObjectArr.length) {
                return iValueHashCode;
            }
            XmlObject xmlObject = xmlObjectArr[i5];
            if (xmlObject != null) {
                iValueHashCode = xmlObject.valueHashCode() + (iValueHashCode * 31);
            }
            i5++;
        }
    }

    public boolean set(XmlObject xmlObject, int i5) {
        XmlObject[] xmlObjectArr = this._objects;
        if (xmlObjectArr[i5] != null) {
            return false;
        }
        xmlObjectArr[i5] = xmlObject;
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < this._objects.length; i5++) {
            if (i5 != 0) {
                sb.append(" ");
            }
            sb.append(prettytrim(((SimpleValue) this._objects[i5]).getStringValue()));
        }
        return sb.toString();
    }

    public int unfilled() {
        int i5 = 0;
        while (true) {
            XmlObject[] xmlObjectArr = this._objects;
            if (i5 >= xmlObjectArr.length) {
                return -1;
            }
            if (xmlObjectArr[i5] == null) {
                return i5;
            }
            i5++;
        }
    }
}
