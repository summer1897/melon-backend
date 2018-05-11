package com.solstice.melon.annotations;

import java.lang.annotation.*;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/05/11
 * @Time 09:48
 * @Description 获取当前用户注释,只要被该注释标识的实体对象，会自动填充有用户信息的数据
 * 就可以获取当前登录用户信息，将其注入{@link com.solstice.melon.vo.Principal}
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {
}
