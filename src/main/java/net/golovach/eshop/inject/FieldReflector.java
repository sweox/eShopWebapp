package net.golovach.eshop.inject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by BELSHINA on 13.02.2017.
 */
public class FieldReflector {

    public static List<Field> collectUpTo(Class<?> clazz, Class<?> upperBound) {
        ArrayList<Field> result = new ArrayList<>();
        Class<?> current = clazz;   //беру текущий класс (clazz)
        while (current != upperBound) {     // пока он не равен текущей границе (upperBound)
            result.addAll(asList(current.getDeclaredFields())); // у рекущего класса выковыриваю все поля
            current = current.getSuperclass();  // заменяю текущий класс на предок и с ним повторяю тоже самое
        }
        return result;
    }
    /**
     * 1) Non static
     * 2) all scopes
     * 3) from all parents
     * 4) clazz fields - include
     * 5) upperBound fields - exclude
     */
//    public static List<Field> collectUpTo(Class<?> clazz, Class<?> upperBound) {
//        if(clazz == upperBound) {
//            throw new IllegalArgumentException();
//        }
    // todo: разобраться чем отличается метод getDeclaredFields() от getFields()
//        return Arrays.asList(clazz.getDeclaredFields());
//        return Arrays.asList(clazz.getFields());


    public static List<Field> filterInject(List<Field> allFields) {
        ArrayList<Field> result = new ArrayList<>();
        for (Field field : allFields) {
            Inject annotation = field.getAnnotation(Inject.class);
            if (annotation != null) {
                result.add(field);
            }
        }
        return result;
    }
}
