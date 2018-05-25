package net.golovach.eshop.inject;

import java.lang.annotation.*;

/**
 * Created by BELSHINA on 13.02.2017.
 */

@Documented
// ElementType.FIELD Означает что данную анотацию можно вешать на поля
@Target(ElementType.FIELD /*{ElementType.FIELD, ElementType.CONSTRUCTOR}*/)

// RetentionPolicy.RUNTIME Анотация будет в сорцах, после компиляции в байт-кодах
// при загрузке она будет  загружена в виртуальную машину и ее можно увидеть по рефлексии
// (что мы будем использовать)
@Retention(RetentionPolicy.RUNTIME)

public @interface Inject {
    public String value();
//    public String name();
//    public int age() default 25;
//    public String[] autors();
}
