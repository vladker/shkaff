package org.apache.logging.log4j;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CloseableThreadContext {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Instance implements AutoCloseable {
        private final Map<String, String> originalValues;
        private int pushCount;

        private void closeMap() {
            Iterator<Map.Entry<String, String>> it = this.originalValues.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                String key = next.getKey();
                String value = next.getValue();
                if (value == null) {
                    ThreadContext.remove(key);
                } else {
                    ThreadContext.put(key, value);
                }
                it.remove();
            }
        }

        private void closeStack() {
            for (int i5 = 0; i5 < this.pushCount; i5++) {
                ThreadContext.pop();
            }
            this.pushCount = 0;
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            closeStack();
            closeMap();
        }

        public Instance push(String str) {
            ThreadContext.push(str);
            this.pushCount++;
            return this;
        }

        public Instance pushAll(List<String> list) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                push(it.next());
            }
            return this;
        }

        public Instance put(String str, String str2) {
            if (!this.originalValues.containsKey(str)) {
                this.originalValues.put(str, ThreadContext.get(str));
            }
            ThreadContext.put(str, str2);
            return this;
        }

        public Instance putAll(Map<String, String> map) {
            Map<String, String> context = ThreadContext.getContext();
            ThreadContext.putAll(map);
            for (String str : map.keySet()) {
                if (!this.originalValues.containsKey(str)) {
                    this.originalValues.put(str, context.get(str));
                }
            }
            return this;
        }

        private Instance() {
            this.pushCount = 0;
            this.originalValues = new HashMap();
        }

        public Instance push(String str, Object[] objArr) {
            ThreadContext.push(str, objArr);
            this.pushCount++;
            return this;
        }
    }

    private CloseableThreadContext() {
    }

    public static Instance push(String str) {
        return new Instance().push(str);
    }

    public static Instance pushAll(List<String> list) {
        return new Instance().pushAll(list);
    }

    public static Instance put(String str, String str2) {
        return new Instance().put(str, str2);
    }

    public static Instance putAll(Map<String, String> map) {
        return new Instance().putAll(map);
    }

    public static Instance push(String str, Object... objArr) {
        return new Instance().push(str, objArr);
    }
}
