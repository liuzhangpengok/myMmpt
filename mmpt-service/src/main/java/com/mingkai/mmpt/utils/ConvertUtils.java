package com.mingkai.mmpt.utils;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 转换工具类
 *
 * @author 李洋 就变成了明凯的了。嘿嘿
 */
public class ConvertUtils {

    public static <T> T sourceToTarget(Object source, Class<T> target) {
        if (source == null) {
            return null;
        }
        T targetObject = null;
        try {
            targetObject = target.newInstance();
            BeanUtils.copyProperties(source, targetObject);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return targetObject;
    }


    public static <T> List<T> sourceToTarget(Collection<?> sourceList, Class<T> target) {
        if (sourceList == null) {
            return null;
        }

        List<T> targetList = new ArrayList<>(sourceList.size());
        try {
            for (Object source : sourceList) {
                T targetObject = target.newInstance();
                if (source != null) {
                    BeanUtils.copyProperties(source, targetObject);
                }
                targetList.add(targetObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return targetList;
    }
}
