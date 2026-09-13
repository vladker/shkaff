package org.apache.commons.math3.exception.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ExceptionContext implements Serializable {
    private static final long serialVersionUID = -6024911025449780478L;
    private Throwable throwable;
    private List<Localizable> msgPatterns = new ArrayList();
    private List<Object[]> msgArguments = new ArrayList();
    private Map<String, Object> context = new HashMap();

    public ExceptionContext(Throwable th) {
        this.throwable = th;
    }

    private String buildMessage(Locale locale, String str) {
        StringBuilder sb = new StringBuilder();
        int size = this.msgPatterns.size();
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            sb.append(new MessageFormat(this.msgPatterns.get(i6).getLocalizedString(locale), locale).format(this.msgArguments.get(i6)));
            i5++;
            if (i5 < size) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    private void deSerializeContext(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        int i5 = objectInputStream.readInt();
        this.context = new HashMap();
        for (int i6 = 0; i6 < i5; i6++) {
            this.context.put((String) objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    private void deSerializeMessages(ObjectInputStream objectInputStream) throws IOException {
        int i5 = objectInputStream.readInt();
        this.msgPatterns = new ArrayList(i5);
        this.msgArguments = new ArrayList(i5);
        for (int i6 = 0; i6 < i5; i6++) {
            this.msgPatterns.add((Localizable) objectInputStream.readObject());
            int i7 = objectInputStream.readInt();
            Object[] objArr = new Object[i7];
            for (int i8 = 0; i8 < i7; i8++) {
                objArr[i8] = objectInputStream.readObject();
            }
            this.msgArguments.add(objArr);
        }
    }

    private String nonSerializableReplacement(Object obj) {
        return "[Object could not be serialized: " + obj.getClass().getName() + "]";
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.throwable = (Throwable) objectInputStream.readObject();
        deSerializeMessages(objectInputStream);
        deSerializeContext(objectInputStream);
    }

    private void serializeContext(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.context.size());
        for (Map.Entry<String, Object> entry : this.context.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            Object value = entry.getValue();
            if (value instanceof Serializable) {
                objectOutputStream.writeObject(value);
            } else {
                objectOutputStream.writeObject(nonSerializableReplacement(value));
            }
        }
    }

    private void serializeMessages(ObjectOutputStream objectOutputStream) throws IOException {
        int size = this.msgPatterns.size();
        objectOutputStream.writeInt(size);
        for (int i5 = 0; i5 < size; i5++) {
            objectOutputStream.writeObject(this.msgPatterns.get(i5));
            Object[] objArr = this.msgArguments.get(i5);
            objectOutputStream.writeInt(objArr.length);
            for (Object obj : objArr) {
                if (obj instanceof Serializable) {
                    objectOutputStream.writeObject(obj);
                } else {
                    objectOutputStream.writeObject(nonSerializableReplacement(obj));
                }
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.throwable);
        serializeMessages(objectOutputStream);
        serializeContext(objectOutputStream);
    }

    public void addMessage(Localizable localizable, Object... objArr) {
        this.msgPatterns.add(localizable);
        this.msgArguments.add(ArgUtils.flatten(objArr));
    }

    public Set<String> getKeys() {
        return this.context.keySet();
    }

    public String getLocalizedMessage() {
        return getMessage(Locale.getDefault());
    }

    public String getMessage() {
        return getMessage(Locale.US);
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public Object getValue(String str) {
        return this.context.get(str);
    }

    public void setValue(String str, Object obj) {
        this.context.put(str, obj);
    }

    public String getMessage(Locale locale) {
        return buildMessage(locale, ": ");
    }

    public String getMessage(Locale locale, String str) {
        return buildMessage(locale, str);
    }
}
