package com.cl.algorithm.util;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenliang
 * @date 2020-07-01
 */
public class IKSUtil {

    public static List<String> cutString(String text) {
        StringReader re = new StringReader(text);
        IKSegmenter ik = new IKSegmenter(re, true);
        Lexeme lex;
        List<String> s = new ArrayList<>();
        try {
            while ((lex = ik.next()) != null) {
                s.add(lex.getLexemeText());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return s;
    }
}
