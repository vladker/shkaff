package org.apache.logging.log4j.message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.apache.logging.log4j.util.StringBuilderFormattable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SimpleMessage implements Message, StringBuilderFormattable, CharSequence {
    private static final long serialVersionUID = -8398002534962715992L;
    private transient CharSequence charSequence;
    private String message;

    public SimpleMessage() {
        this((String) null);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.charSequence = this.message;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        getFormattedMessage();
        objectOutputStream.defaultWriteObject();
    }

    @Override // java.lang.CharSequence
    public char charAt(int i5) {
        return this.charSequence.charAt(i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            CharSequence charSequence = this.charSequence;
            CharSequence charSequence2 = ((SimpleMessage) obj).charSequence;
            if (charSequence == null ? charSequence2 == null : charSequence.equals(charSequence2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.logging.log4j.util.StringBuilderFormattable
    public void formatTo(StringBuilder sb) {
        CharSequence charSequence = this.message;
        if (charSequence == null) {
            charSequence = this.charSequence;
        }
        sb.append(charSequence);
    }

    @Override // org.apache.logging.log4j.message.Message
    public String getFormat() {
        return this.message;
    }

    @Override // org.apache.logging.log4j.message.Message
    public String getFormattedMessage() {
        String strValueOf = this.message;
        if (strValueOf == null) {
            strValueOf = String.valueOf(this.charSequence);
        }
        this.message = strValueOf;
        return strValueOf;
    }

    @Override // org.apache.logging.log4j.message.Message
    public Object[] getParameters() {
        return null;
    }

    @Override // org.apache.logging.log4j.message.Message
    public Throwable getThrowable() {
        return null;
    }

    public int hashCode() {
        CharSequence charSequence = this.charSequence;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    @Override // java.lang.CharSequence
    public int length() {
        CharSequence charSequence = this.charSequence;
        if (charSequence == null) {
            return 0;
        }
        return charSequence.length();
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i5, int i6) {
        return this.charSequence.subSequence(i5, i6);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return getFormattedMessage();
    }

    public SimpleMessage(String str) {
        this.message = str;
        this.charSequence = str;
    }

    public SimpleMessage(CharSequence charSequence) {
        this.charSequence = charSequence;
    }
}
