package jcp.com.exiyou.base.util;

import java.lang.reflect.ParameterizedType;


public class TypeUtil {

    public static <T> T getObject(Object object, int index) {

        try {
            T t = ((Class<T>) ((ParameterizedType) object.getClass().getGenericSuperclass()).getActualTypeArguments()[index]).newInstance();
            return t;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
