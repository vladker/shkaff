package org.apache.logging.log4j.message;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.util.StringBuilderFormattable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class StructuredDataCollectionMessage implements StringBuilderFormattable, MessageCollectionMessage<StructuredDataMessage> {
    private static final long serialVersionUID = 5725337076388822924L;
    private final List<StructuredDataMessage> structuredDataMessageList;

    public StructuredDataCollectionMessage(List<StructuredDataMessage> list) {
        this.structuredDataMessageList = list;
    }

    @Override // org.apache.logging.log4j.util.StringBuilderFormattable
    public void formatTo(StringBuilder sb) {
        Iterator<StructuredDataMessage> it = this.structuredDataMessageList.iterator();
        while (it.hasNext()) {
            it.next().formatTo(sb);
        }
    }

    @Override // org.apache.logging.log4j.message.Message
    public String getFormat() {
        StringBuilder sb = new StringBuilder();
        for (StructuredDataMessage structuredDataMessage : this.structuredDataMessageList) {
            if (structuredDataMessage.getFormat() != null) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(structuredDataMessage.getFormat());
            }
        }
        return sb.toString();
    }

    @Override // org.apache.logging.log4j.message.Message
    public String getFormattedMessage() {
        StringBuilder sb = new StringBuilder();
        formatTo(sb);
        return sb.toString();
    }

    @Override // org.apache.logging.log4j.message.Message
    public Object[] getParameters() {
        ArrayList arrayList = new ArrayList();
        Iterator<StructuredDataMessage> it = this.structuredDataMessageList.iterator();
        int length = 0;
        while (it.hasNext()) {
            Object[] parameters = it.next().getParameters();
            if (parameters != null) {
                arrayList.add(parameters);
                length += parameters.length;
            }
        }
        Object[] objArr = new Object[length];
        int size = arrayList.size();
        int i5 = 0;
        int i6 = 0;
        while (i6 < size) {
            Object obj = arrayList.get(i6);
            i6++;
            Object[] objArr2 = (Object[]) obj;
            int length2 = objArr2.length;
            int i7 = 0;
            while (i7 < length2) {
                objArr[i5] = objArr2[i7];
                i7++;
                i5++;
            }
        }
        return objArr;
    }

    @Override // org.apache.logging.log4j.message.Message
    public Throwable getThrowable() {
        Iterator<StructuredDataMessage> it = this.structuredDataMessageList.iterator();
        while (it.hasNext()) {
            Throwable throwable = it.next().getThrowable();
            if (throwable != null) {
                return throwable;
            }
        }
        return null;
    }

    @Override // java.lang.Iterable
    public Iterator<StructuredDataMessage> iterator() {
        return this.structuredDataMessageList.iterator();
    }
}
