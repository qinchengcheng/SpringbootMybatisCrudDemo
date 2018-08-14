package com.giveu.common.validate;

import com.giveu.entity.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnnotationDealUtil {

    @SuppressWarnings("unchecked")
    public static Map<String, Object> validate(Object bean) {
        Map<String, Object> result = new HashMap<String, Object>();
        Class<?> cls = bean.getClass();

        // 检测field是否存在
        try {
            // 获取实体字段集合
            Field[] fields = cls.getDeclaredFields();
            int i=0;
            for (Field f : fields) {
                // 通过反射获取该属性对应的值
                f.setAccessible(true);
                // 获取字段值
                Object value = f.get(bean);
                // 获取字段上的注解集合
                Annotation[] arrayAno = f.getAnnotations();
                for (Annotation annotation : arrayAno) {
                    // 获取注解类型（注解类的Class）
                    Class<?> clazz = annotation.annotationType();
                    // 获取注解类中的方法集合
                    Method[] methodArray = clazz.getDeclaredMethods();
                    for (Method method : methodArray) {
                        // 获取方法名
                        String methodName = method.getName();
                        // 过滤错误提示方法的调用
                        if(methodName.equals("message")) {
                            continue;
                        }
                        // 初始化注解验证的方法处理类 （我的处理方法卸载本类中）
                        Object obj = AnnotationDealUtil.class.newInstance();
                        // 获取方法
                        try {
                            // 根据方法名获取该方法
                            Method m = obj.getClass().getDeclaredMethod(methodName, Object.class, Field.class);
                            // 调用该方法
                            Map<String, Object> item = (Map<String, Object>)m.invoke(obj, value, f);
                            /* 验证结果 有一处失败则退出 */
                            if(item.get("result").equals(false)) {
                               result.put(String.valueOf(i),item.get("message"));
                                i++;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 验证是否空值
     *
     * @author zhy
     * @param value 参数值
     * @param field 字段
     * @return
     */
    public Map<String, Object> isEmpty(Object value, Field field) {
        Map<String, Object> validateResult = new HashMap<String, Object>();
        IsEmptyAnnotation annotation = field.getAnnotation(IsEmptyAnnotation.class);
        if(value == null || value.equals("")) {
            validateResult.put("message", annotation.message());
            validateResult.put("result", false);
        } else {
            validateResult.put("message", "验证通过");
            validateResult.put("result", true);
        }
        return validateResult;
    }

    /**
     * 验证最小值
     *
     * @author zhy
     * @param value 参数值
     * @param field 字段
     * @return
     */
    public Map<String, Object> min(Object value, Field field) {
        Map<String, Object> validateResult = new HashMap<String, Object>();
        MinSize annotation = field.getAnnotation(MinSize.class);
        if(value != null && value.toString().length() < annotation.min()) {
            validateResult.put("message", annotation.message());
            validateResult.put("result", false);
        } else {
            validateResult.put("message", "验证通过");
            validateResult.put("result", true);
        }
        return validateResult;
    }

    /**
     * 验证最大值
     *
     * @author zhy
     * @param value 参数值
     * @param field 字段
     * @return
     */
    public Map<String, Object> max(Object value, Field field) {
        Map<String, Object> validateResult = new HashMap<String, Object>();
        MaxSize annotation = field.getAnnotation(MaxSize.class);
        if(value != null && value.toString().length() > annotation.max()) {
            validateResult.put("message", annotation.message());
            validateResult.put("result", false);
        } else {
            validateResult.put("message", "验证通过");
            validateResult.put("result", true);
        }
        return validateResult;
    }

    /**
     * 验证手机
     *
     * @author zhy
     * @param value 参数值
     * @param field 字段
     * @return
     */
    public Map<String, Object> phone(Object value, Field field) {
        Map<String, Object> validateResult = new HashMap<String, Object>();
        Phone annotation = field.getAnnotation(Phone.class);
        if(value==null||value.toString().isEmpty())
        {
            validateResult.put("message", "员工电话不能为空");
            validateResult.put("result", false);
        }
        else
        {
            if(value != null && regexmatch(value.toString(),"^((1[3,4,5,6,7,8,9][0-9])|(14[5,7])|(17[0,6,7,8])|(19[7]))\\d{8}$")) {
                validateResult.put("message", "验证通过");
                validateResult.put("result", true);
            } else {
                validateResult.put("message", annotation.message());
                validateResult.put("result", false);
            }
        }
        return validateResult;
    }

    /**
     * 验证邮箱
     *
     * @author zhy
     * @param value 参数值
     * @param field 字段
     * @return
     */
    public Map<String, Object> mail(Object value, Field field) {
        /**
         * 正则表达式：验证邮箱
         */
        String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Map<String, Object> validateResult = new HashMap<String, Object>();
        Email annotation = field.getAnnotation(Email.class);
        if(value==null||value.toString().isEmpty())
        {
            validateResult.put("message", "员工邮箱不能为空");
            validateResult.put("result", false);
        }
        else
        {
            if(value != null && regexmatch(value.toString(),REGEX_EMAIL)) {
                validateResult.put("message", "验证通过");
                validateResult.put("result", true);
            } else {
                validateResult.put("message", annotation.message());
                validateResult.put("result", false);
            }
        }
        return validateResult;
    }

    /**
     * QQ邮箱
     *
     * @author zhy
     * @param value 参数值
     * @param field 字段
     * @return
     */
    public Map<String, Object> qq(Object value, Field field) {
        /**
         * 正则表达式：验证邮箱
         */
        String qqRegex = "^\\d{5,12}@[qQ][qQ]\\.(com|cn)$";
        Map<String, Object> validateResult = new HashMap<String, Object>();
        Qq annotation = field.getAnnotation(Qq.class);
        if(value==null||value.toString().isEmpty())
        {
            validateResult.put("message", "员工QQ不能为空");
            validateResult.put("result", false);
        }
        else
        {
            if(value != null && regexmatch(value.toString(),qqRegex)) {
                validateResult.put("message", "验证通过");
                validateResult.put("result", true);
            } else {
                validateResult.put("message", annotation.message());
                validateResult.put("result", false);
            }
        }
        return validateResult;
    }

    public boolean regexmatch(String str,String regEx)
    {
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        // 字符串是否与正则表达式相匹配
        boolean rs = matcher.matches();
        return rs;
    }
}
