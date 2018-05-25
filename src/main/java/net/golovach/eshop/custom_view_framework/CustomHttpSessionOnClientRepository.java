package net.golovach.eshop.custom_view_framework;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by BELSHINA on 12.02.2017.
 */

//todo: realize old session clearing functionality
//todo: realize session listeners functionality
//todo: realize storage session in cookies
//todo: rewrite product bucket to this session implementation (Base64 or "session"->{paper=1, breaf=2}
public class CustomHttpSessionOnClientRepository {

    public static CustomHttpSession getSession(HttpServletRequest request) {
        throw new UnsupportedOperationException();
    }

    public static void saveSession(HttpServletResponse response, CustomHttpSession session) {
        throw new UnsupportedOperationException();
    }
}
