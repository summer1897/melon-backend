package com.solstice.melon.resolver;
import com.solstice.melon.annotations.CurrentUser;
import com.solstice.melon.utils.SecurityUtil;
import com.solstice.melon.vo.Principal;
import com.summer.base.utils.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/05/11
 * @Time 09:51
 * @Description
 */
public class CurrentUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    private static final Logger log = LoggerFactory.getLogger(CurrentUserHandlerMethodArgumentResolver.class);

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
//        log.info("解析CurrentUser注释接口");
        Class<?> clazz = methodParameter.getParameterType();
        /**
         * @CurrentUser注释支持的参数类型,仅支持 {@see Principal}或{@link Integer}
         */
        if (clazz.isAssignableFrom(Principal.class) || clazz.isAssignableFrom(Long.class)) {
            log.info("if has CurrentUser annotation: {}", methodParameter.hasParameterAnnotation(CurrentUser.class));
//            Annotation[] annotations = methodParameter.getParameterAnnotations();
            return methodParameter.hasParameterAnnotation(CurrentUser.class);
            /*log.error("annotations: {}",annotations);
            for (Annotation annotation : annotations) {
                log.error("in for cycle {},{}",annotation.getClass(),CurrentUser.class);
                if (annotation.getClass().isAssignableFrom(CurrentUser.class)) {
                    log.info("解析CurrentUser注释接口");
                    return true;
                }
            }*/
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory){
        log.info("为com.solstice.melon.vo.Principal实体对象注入当前登录用户信息");
        Object result = null;

        try {
            /**
             * 当为{@link Principal}的时候，表示将当前登录用户信息注入参数中，
             * 当为{@link Long}，表示将当前用户id注入参数中。
             */
            if (SecurityUtil.isAuthenticated() || SecurityUtil.isRemembered()) {
                Class<?> clazz = parameter.getParameterType();
                Principal principal = SecurityUtil.getPrincipal();

                /**
                 * 只有被认证过，才会将用户数据填充到有{@link CurrentUser}注释的方法参数 {
                 * @link Principal}实体对象中
                 */
                if (clazz.isAssignableFrom(Principal.class)) {
                    result = principal;
                }

                if (clazz.isAssignableFrom(Long.class)) {
                    result = ObjectUtils.isNotNull(principal) ? principal.getId() : null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
