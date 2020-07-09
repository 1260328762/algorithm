package com.cl.algorithm.util;

import com.hankcs.hanlp.corpus.io.IOUtil;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static com.hankcs.hanlp.utility.Predefine.logger;

/**
 * @author chenliang
 * @date 2020-07-06
 */
public class IOUtils {

    public static boolean saveObject(Object o, String path) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(IOUtil.newOutputStream(path));
            oos.writeObject(o);
            oos.close();
        } catch (IOException e) {
            logger.warning("在保存对象" + o + "到" + path + "时发生异常" + e);
            return false;
        }
        return true;
    }

    public static Object readObject(String name) {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(IOUtils.class.getClassLoader().getResourceAsStream(name));
            Object o = ois.readObject();
            ois.close();
            return o;
        } catch (Exception e) {
            logger.warning("读取对象时发生异常" + e);
        }
        return null;
    }

}
