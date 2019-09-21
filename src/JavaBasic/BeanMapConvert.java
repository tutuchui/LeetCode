package JavaBasic;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BeanMapConvert {

    class Person{
        private String name;
        private Integer age;
        public Person(){};
        public Person(String name,int age){
            this.age = age;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }

    public static Map<String,Object> bean2Map(Object bean) throws Exception{
        Map<String,Object> map = new HashMap<>();
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class,Object.class);
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for(PropertyDescriptor pd : pds){
            String key = pd.getName();
            Method getter = pd.getReadMethod();
            Object value = getter.invoke(bean);
            map.put(key,value);
        }
        return map;
    }

    public static <T> T map2bean(Map<String,Object> map, Class<T> clz) throws Exception{
        T obj = clz.newInstance();
        BeanInfo beanInfo = Introspector.getBeanInfo(clz,Object.class);
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for(PropertyDescriptor pd: pds){
            Object value = map.get(pd.getName());
            Method setter = pd.getWriteMethod();
            setter.invoke(obj,value);
        }

        return obj;
    }
}
