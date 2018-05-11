package com.solstice.melon.utils;

import com.solstice.melon.vo.Principal;
import com.summer.base.utils.ObjectUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author solstice
 * @Date 2018/05/11
 * @Time 09:53
 * @Description 用户认证工具
 */
public class SecurityUtil {

    private static final Logger log = LoggerFactory.getLogger(SecurityUtil.class);

    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static Principal getPrincipal() {
//        log.error("Security utils: Principal: {}", JSON.toJSONString(SecurityUtils.getSubject().getPrincipal(),true));
        return (Principal) SecurityUtils.getSubject().getPrincipal();
    }

    public static boolean isAuthenticated() {
        return SecurityUtils.getSubject().isAuthenticated();
    }

    public static boolean isRemembered() {
        return SecurityUtils.getSubject().isRemembered();
    }

    public static boolean hasRole(String role) {
        return SecurityUtils.getSubject().hasRole(role);
    }

    /**
     * 同时具有多个角色
     * @param roles
     * @return
     */
    public static boolean hasRoles(List<String> roles) {
        return SecurityUtils.getSubject().hasAllRoles(roles);
    }

    public static boolean hasRoles(String...roles) {
        boolean hasRoles = false;
        if (ObjectUtils.isNotNull(roles)) {
            hasRoles = hasRoles(Arrays.asList(roles));
        }
        return hasRoles;
    }

    /**
     *  多个角色中，是否有一个
     * @param roles
     * @return boolean
     */
    public static boolean hasAnyRoles(List<String> roles) {
        if (ObjectUtils.isNotEmpty(roles)) {
            for (String role : roles) {
                if (hasRole(role)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasAnyRoles(String...roles) {
        boolean hasAnyRoles = false;
        if (ObjectUtils.isNotNull(roles)) {
            hasAnyRoles = hasAnyRoles(Arrays.asList(roles));
        }
        return hasAnyRoles;
    }

    public static boolean isPermitted(String permission) {
        return SecurityUtils.getSubject().isPermitted(permission);
    }

    public static boolean isPermittedAll(String...permissions) {
        return SecurityUtils.getSubject().isPermittedAll(permissions);
    }

    public static void logout() {
        SecurityUtils.getSubject().logout();
    }

}
