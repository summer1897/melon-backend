package com.solstice.melon.aspects;

import com.solstice.melon.annotations.DbSource;
import com.summer.base.utils.ObjectUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**

/**
 * @ClassName DynamicDataSourceAspect
 * @Author solstice
 * @Date 2018/6/7 11:46
 * @Version 1.0
 * @Description
 **/
/*@Aspect
@Order(-1) //保证该注释在@Tansactional之前运行
@Component*/
public class DynamicDataSourceAspect {

    private static final Logger log = LoggerFactory.getLogger(DynamicDataSourceAspect.class);


    /*@Before("execution(* com.solstice.melon.dao..*.*(..))")
    public void switchDataSource(JoinPoint joinPoint) throws Throwable {
        log.info("DynamicDataSourceAspect.switchDataSource()");
        String sourceName = "";

        Class<?> clazz = joinPoint.getTarget().getClass();

        String methodName = joinPoint.getSignature().getName();

        //抽象类方法
        Method abstractMethod = ((MethodSignature)joinPoint.getSignature()).getMethod();
        if (abstractMethod.isAnnotationPresent(DbSource.class)) {
            sourceName = abstractMethod.getAnnotation(DbSource.class).name();
            log.info("切换数据源: ----{}",sourceName);
        }

        //接口方法参数
        Class<?>[] parameterTypes = abstractMethod.getParameterTypes();
        try {
            //实现类中该方法
            Method method = clazz.getMethod(methodName,parameterTypes);
            if (method.isAnnotationPresent(DbSource.class)) {
                sourceName = method.getAnnotation(DbSource.class).name();
                log.info("动态切换数据源: ------------------{}",sourceName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ObjectUtils.isNotNull(sourceName)) {
            DynamicDataSource.setDataSource(sourceName);
        }
    }

    @Pointcut("execution(* com.solstice.melon.dao..*.*(..))")
    public void pointCut() {
    }

    @After("pointCut()")
    public void after(JoinPoint point) {
        log.info("DynamicDataSourceAspect.after()");
        DynamicDataSource.clearDataSource();
    }*/

}
