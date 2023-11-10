package com.cl.executor;

/**
 * @author chenliang
 * @since 2023/9/22 16:28
 */
public class DynamicClassLoader extends ClassLoader {

    public DynamicClassLoader() {
        super(DynamicClassLoader.class.getClassLoader());
    }

    public Class<?> loadByte(byte[] bytes) {
        return defineClass(null, bytes, 0, bytes.length);
    }
}
