package com.kaluzny.nasdaq.company;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

@Logged
@Interceptor
public class LoggedInterceptor implements Serializable {

    @AroundInvoke
    public Object logMethodEntry(InvocationContext invocationContext) throws Exception {
        Logger.getAnonymousLogger().log(Level.INFO, "{0} called with {1} parameters",
                new Object[]{
                        invocationContext.getMethod().getName(),
                        Arrays.deepToString(invocationContext.getParameters())
                }
        );
        return invocationContext.proceed();
    }
}