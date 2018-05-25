package net.golovach.eshop.inject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by BELSHINA on 13.02.2017.
 */

// todo: ссылки на IoC материалы

public class DependencyInjectionServlet extends HttpServlet {
    private static final String APP_CTX_PATH = "contextConfigLocation";

    @Override
    public final void init() throws ServletException {
        String appCtxPath = this.getServletContext().getInitParameter(APP_CTX_PATH);
        System.out.println("load " + APP_CTX_PATH + " -> " + appCtxPath);

        if (appCtxPath == null) {
            System.err.println("I need init param " + APP_CTX_PATH);
            throw new ServletException(APP_CTX_PATH + " init param == null");
        }
        try {
            //load AppContext
            ApplicationContext appCtx = new ClassPathXmlApplicationContext(appCtxPath);
            //than inject from AppContext to all marked by @Inject field
            List<Field> allFields = FieldReflector.collectUpTo(this.getClass(), DependencyInjectionServlet.class);
            List<Field> injectFields = FieldReflector.filterInject(allFields);
            for (Field field : injectFields) {
                field.setAccessible(true); // открываем private и final поля
                Inject annotation = field.getAnnotation(Inject.class); // даем Inject.class т.к. поле может иметь другие анотации
                System.out.println("I find method marked by @Inject: " + field);
                String beanName = annotation.value(); // берем поле анотации
                System.out.println("I must instantiate and inject '" + beanName + "'");
                Object bean = appCtx.getBean(beanName);
                System.out.println("Instantiation - OK: '" + beanName + "'");
                if (bean == null) {
                    throw new ServletException("Theare isn't bean with name '" + beanName + "'");
                }
                field.set(this, bean); //устанавливаю в поле самому себе, которое нашел экземпляр бина
            }
        } catch (Exception e) {
            throw new ServletException("Can't inject from " + APP_CTX_PATH, e);
        }
    }
}
