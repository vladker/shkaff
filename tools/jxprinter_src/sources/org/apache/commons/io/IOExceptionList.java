package org.apache.commons.io;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class IOExceptionList extends IOException {
    private static final long serialVersionUID = 1;
    private final List<? extends Throwable> causeList;

    public IOExceptionList(List<? extends Throwable> list) {
        this(String.format("%,d exceptions: %s", Integer.valueOf(list == null ? 0 : list.size()), list), list);
    }

    public <T extends Throwable> T getCause(int i5) {
        return (T) this.causeList.get(i5);
    }

    public <T extends Throwable> List<T> getCauseList() {
        return (List<T>) this.causeList;
    }

    public IOExceptionList(String str, List<? extends Throwable> list) {
        super(str, (list == null || list.isEmpty()) ? null : list.get(0));
        this.causeList = list == null ? Collections.EMPTY_LIST : list;
    }

    public <T extends Throwable> T getCause(int i5, Class<T> cls) {
        return cls.cast(this.causeList.get(i5));
    }

    public <T extends Throwable> List<T> getCauseList(Class<T> cls) {
        return (List<T>) this.causeList;
    }
}
