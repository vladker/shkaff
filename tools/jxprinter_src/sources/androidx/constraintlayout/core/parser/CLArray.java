package androidx.constraintlayout.core.parser;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class CLArray extends CLContainer {
    public CLArray(char[] cArr) {
        super(cArr);
    }

    public static CLElement allocate(char[] cArr) {
        return new CLArray(cArr);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i5, int i6) {
        StringBuilder sb = new StringBuilder();
        String json = toJSON();
        if (i6 > 0 || json.length() + i5 >= CLElement.sMaxLine) {
            sb.append("[\n");
            ArrayList<CLElement> arrayList = this.mElements;
            int size = arrayList.size();
            int i7 = 0;
            boolean z6 = true;
            while (i7 < size) {
                CLElement cLElement = arrayList.get(i7);
                i7++;
                CLElement cLElement2 = cLElement;
                if (z6) {
                    z6 = false;
                } else {
                    sb.append(",\n");
                }
                addIndent(sb, CLElement.sBaseIndent + i5);
                sb.append(cLElement2.toFormattedJSON(CLElement.sBaseIndent + i5, i6 - 1));
            }
            sb.append("\n");
            addIndent(sb, i5);
            sb.append("]");
        } else {
            sb.append(json);
        }
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        StringBuilder sb = new StringBuilder(getDebugName() + "[");
        boolean z6 = true;
        for (int i5 = 0; i5 < this.mElements.size(); i5++) {
            if (z6) {
                z6 = false;
            } else {
                sb.append(", ");
            }
            sb.append(this.mElements.get(i5).toJSON());
        }
        return ((Object) sb) + "]";
    }
}
