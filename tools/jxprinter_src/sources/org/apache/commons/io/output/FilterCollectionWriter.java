package org.apache.commons.io.output;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.apache.commons.io.IOExceptionList;
import org.apache.commons.io.IOIndexedException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FilterCollectionWriter extends Writer {
    protected final Collection<Writer> EMPTY_WRITERS;
    protected final Collection<Writer> writers;

    public FilterCollectionWriter(Collection<Writer> collection) {
        List list = Collections.EMPTY_LIST;
        this.EMPTY_WRITERS = list;
        this.writers = collection == null ? list : collection;
    }

    private List<Exception> add(List<Exception> list, int i5, IOException iOException) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(new IOIndexedException(i5, iOException));
        return list;
    }

    private boolean notEmpty(List<Exception> list) {
        return (list == null || list.isEmpty()) ? false : true;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOExceptionList {
        List<Exception> listAdd = null;
        int i5 = 0;
        for (Writer writer : this.writers) {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    listAdd = add(listAdd, i5, e);
                }
            }
            i5++;
        }
        if (notEmpty(listAdd)) {
            throw new IOExceptionList("close", listAdd);
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOExceptionList {
        List<Exception> listAdd = null;
        int i5 = 0;
        for (Writer writer : this.writers) {
            if (writer != null) {
                try {
                    writer.flush();
                } catch (IOException e) {
                    listAdd = add(listAdd, i5, e);
                }
            }
            i5++;
        }
        if (notEmpty(listAdd)) {
            throw new IOExceptionList("flush", listAdd);
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr) throws IOExceptionList {
        List<Exception> listAdd = null;
        int i5 = 0;
        for (Writer writer : this.writers) {
            if (writer != null) {
                try {
                    writer.write(cArr);
                } catch (IOException e) {
                    listAdd = add(listAdd, i5, e);
                }
            }
            i5++;
        }
        if (notEmpty(listAdd)) {
            throw new IOExceptionList("write", listAdd);
        }
    }

    public FilterCollectionWriter(Writer... writerArr) {
        List list = Collections.EMPTY_LIST;
        this.EMPTY_WRITERS = list;
        this.writers = writerArr != null ? Arrays.asList(writerArr) : list;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c) throws IOExceptionList {
        List<Exception> listAdd = null;
        int i5 = 0;
        for (Writer writer : this.writers) {
            if (writer != null) {
                try {
                    writer.append(c);
                } catch (IOException e) {
                    listAdd = add(listAdd, i5, e);
                }
            }
            i5++;
        }
        if (notEmpty(listAdd)) {
            throw new IOExceptionList("append", listAdd);
        }
        return this;
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i5, int i6) throws IOExceptionList {
        List<Exception> listAdd = null;
        int i7 = 0;
        for (Writer writer : this.writers) {
            if (writer != null) {
                try {
                    writer.write(cArr, i5, i6);
                } catch (IOException e) {
                    listAdd = add(listAdd, i7, e);
                }
            }
            i7++;
        }
        if (notEmpty(listAdd)) {
            throw new IOExceptionList("write", listAdd);
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) throws IOExceptionList {
        List<Exception> listAdd = null;
        int i5 = 0;
        for (Writer writer : this.writers) {
            if (writer != null) {
                try {
                    writer.append(charSequence);
                } catch (IOException e) {
                    listAdd = add(listAdd, i5, e);
                }
            }
            i5++;
        }
        if (notEmpty(listAdd)) {
            throw new IOExceptionList("append", listAdd);
        }
        return this;
    }

    @Override // java.io.Writer
    public void write(int i5) throws IOExceptionList {
        List<Exception> listAdd = null;
        int i6 = 0;
        for (Writer writer : this.writers) {
            if (writer != null) {
                try {
                    writer.write(i5);
                } catch (IOException e) {
                    listAdd = add(listAdd, i6, e);
                }
            }
            i6++;
        }
        if (notEmpty(listAdd)) {
            throw new IOExceptionList("write", listAdd);
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i5, int i6) throws IOExceptionList {
        List<Exception> listAdd = null;
        int i7 = 0;
        for (Writer writer : this.writers) {
            if (writer != null) {
                try {
                    writer.append(charSequence, i5, i6);
                } catch (IOException e) {
                    listAdd = add(listAdd, i7, e);
                }
            }
            i7++;
        }
        if (notEmpty(listAdd)) {
            throw new IOExceptionList("append", listAdd);
        }
        return this;
    }

    @Override // java.io.Writer
    public void write(String str) throws IOExceptionList {
        List<Exception> listAdd = null;
        int i5 = 0;
        for (Writer writer : this.writers) {
            if (writer != null) {
                try {
                    writer.write(str);
                } catch (IOException e) {
                    listAdd = add(listAdd, i5, e);
                }
            }
            i5++;
        }
        if (notEmpty(listAdd)) {
            throw new IOExceptionList("write", listAdd);
        }
    }

    @Override // java.io.Writer
    public void write(String str, int i5, int i6) throws IOExceptionList {
        List<Exception> listAdd = null;
        int i7 = 0;
        for (Writer writer : this.writers) {
            if (writer != null) {
                try {
                    writer.write(str, i5, i6);
                } catch (IOException e) {
                    listAdd = add(listAdd, i7, e);
                }
            }
            i7++;
        }
        if (notEmpty(listAdd)) {
            throw new IOExceptionList("write", listAdd);
        }
    }
}
