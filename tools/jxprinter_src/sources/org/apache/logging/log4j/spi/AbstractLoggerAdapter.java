package org.apache.logging.log4j.spi;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.util.LoaderUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractLoggerAdapter<L> implements LoggerAdapter<L>, LoggerContextShutdownAware {
    protected final Map<LoggerContext, ConcurrentMap<String, L>> registry = new ConcurrentHashMap();
    private final ReadWriteLock lock = new ReentrantReadWriteLock(true);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.lock.writeLock().lock();
        try {
            this.registry.clear();
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    @Override // org.apache.logging.log4j.spi.LoggerContextShutdownAware
    public void contextShutdown(LoggerContext loggerContext) {
        this.registry.remove(loggerContext);
    }

    public abstract LoggerContext getContext();

    public LoggerContext getContext(Class<?> cls) {
        ClassLoader classLoader = cls != null ? cls.getClassLoader() : null;
        if (classLoader == null) {
            classLoader = LoaderUtil.getThreadContextClassLoader();
        }
        return LogManager.getContext(classLoader, false);
    }

    @Override // org.apache.logging.log4j.spi.LoggerAdapter
    public L getLogger(String str) {
        LoggerContext context = getContext();
        ConcurrentMap<String, L> loggersInContext = getLoggersInContext(context);
        L l6 = loggersInContext.get(str);
        if (l6 != null) {
            return l6;
        }
        loggersInContext.putIfAbsent(str, newLogger(str, context));
        return loggersInContext.get(str);
    }

    public Set<LoggerContext> getLoggerContexts() {
        return new HashSet(this.registry.keySet());
    }

    public ConcurrentMap<String, L> getLoggersInContext(LoggerContext loggerContext) {
        this.lock.readLock().lock();
        try {
            ConcurrentMap<String, L> concurrentMap = this.registry.get(loggerContext);
            this.lock.readLock().unlock();
            if (concurrentMap != null) {
                return concurrentMap;
            }
            this.lock.writeLock().lock();
            try {
                ConcurrentMap<String, L> concurrentHashMap = this.registry.get(loggerContext);
                if (concurrentHashMap == null) {
                    concurrentHashMap = new ConcurrentHashMap<>();
                    this.registry.put(loggerContext, concurrentHashMap);
                    if (loggerContext instanceof LoggerContextShutdownEnabled) {
                        ((LoggerContextShutdownEnabled) loggerContext).addShutdownListener(this);
                    }
                }
                return concurrentHashMap;
            } finally {
                this.lock.writeLock().unlock();
            }
        } catch (Throwable th) {
            this.lock.readLock().unlock();
            throw th;
        }
    }

    public abstract L newLogger(String str, LoggerContext loggerContext);
}
