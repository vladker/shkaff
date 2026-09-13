package androidx.constraintlayout.core.dsl;

import androidx.collection.a;
import java.util.Arrays;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class Keys {
    public void append(StringBuilder sb, String str, int i5) {
        if (i5 != Integer.MIN_VALUE) {
            sb.append(str);
            sb.append(":'");
            sb.append(i5);
            sb.append("',\n");
        }
    }

    public String unpack(String[] strArr) {
        StringBuilder sb = new StringBuilder("[");
        int i5 = 0;
        while (i5 < strArr.length) {
            sb.append(i5 == 0 ? "'" : ",'");
            sb.append(strArr[i5]);
            sb.append("'");
            i5++;
        }
        sb.append("]");
        return sb.toString();
    }

    public void append(StringBuilder sb, String str, String str2) {
        if (str2 != null) {
            a.y(sb, str, ":'", str2, "',\n");
        }
    }

    public void append(StringBuilder sb, String str, float f6) {
        if (Float.isNaN(f6)) {
            return;
        }
        sb.append(str);
        sb.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        sb.append(f6);
        sb.append(",\n");
    }

    public void append(StringBuilder sb, String str, String[] strArr) {
        if (strArr != null) {
            sb.append(str);
            sb.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            sb.append(unpack(strArr));
            sb.append(",\n");
        }
    }

    public void append(StringBuilder sb, String str, float[] fArr) {
        if (fArr != null) {
            sb.append(str);
            sb.append("percentWidth:");
            sb.append(Arrays.toString(fArr));
            sb.append(",\n");
        }
    }
}
