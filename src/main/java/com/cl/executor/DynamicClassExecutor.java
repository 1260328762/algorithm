package com.cl.executor;

import org.springframework.stereotype.Service;

/**
 * @author chenliang
 * @since 2023/9/22 16:23
 */
@Service
public class DynamicClassExecutor {


    public String execute(byte[] classBytes) throws Exception {
        DynamicClassLoader dynamicClassLoader = new DynamicClassLoader();
        Class<?> aClass = dynamicClassLoader.loadByte(classBytes);

        Object newInstance = aClass.newInstance();
        if (!(newInstance instanceof DynamicClass)) {
            throw new RuntimeException("Class类型错误");
        }
        DynamicClass dynamicClass = (DynamicClass) newInstance;

        LogUtils logUtils = new LogUtils();
        dynamicClass.execute(logUtils);

        return logUtils.getResult();
    }
}
