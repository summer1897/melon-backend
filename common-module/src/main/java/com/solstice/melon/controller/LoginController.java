package com.solstice.melon.controller;
import com.solstice.melon.domain.AccountCredentials;
import com.solstice.melon.enums.AccountSatus;
import com.solstice.melon.service.IAccountCredentialsService;
import com.solstice.melon.utils.EncryptionUtils;
import com.solstice.melon.utils.SecurityUtil;
import com.summer.base.utils.ObjectUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by solstice on 2018/05/11.
 */
@Controller
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    private static final String LOGIN = "login";
    private static final String LOGIN_SUCCESS_OR_LOGOUT_PAGE = "index";

    @Autowired
    private IAccountCredentialsService accountCredentialsService;

    @GetMapping("/login.html")
    public String login() {
        log.info("method:GET;path:/login.html");
        return LOGIN;
    }

    @PostMapping("/login.html")
    public String loginHandler(@RequestParam(name = "username",required = true) String username,
                                 @RequestParam(name = "password",required = true) String password) {
        log.info("method:POST;path:/login.html======>LoginController.loginHandler({},{})",
                username,password);

        AccountCredentials account = accountCredentialsService.queryByUserName(username);

        if (ObjectUtils.isNull(account)) {
            log.info("has no user");
            throw new UnknownAccountException("用户不存在");
        } else {
            Byte locked = account.getLocked();
            if (locked == AccountSatus.UN_ACTIVATION_STATUS.getStatus()) {
                throw new UnknownAccountException("用户未激活");
            } else if (locked == AccountSatus.FORBIDDEN_STATUS.getStatus()) {
                throw new UnknownAccountException("用户被禁用");
            }
        }

        log.warn("secret password:{},{},{}", EncryptionUtils.encrypt(password,account.getCredentialSalt()),password,account.getCredentialSalt());

        UsernamePasswordToken token = new UsernamePasswordToken(username, EncryptionUtils.encrypt(password,account.getCredentialSalt()));
//        obtain the current subject
        Subject currentUser = SecurityUtil.getSubject();

        try {
//            token.setRememberMe(true);
            currentUser.login(token);

            return "redirect:" + LOGIN_SUCCESS_OR_LOGOUT_PAGE + ".html";
        } catch (UnknownAccountException uae) {
            log.error("对用户[" + username + "]进行登录验证..验证未通过,未知账户");
        } catch (IncorrectCredentialsException ice) {
            log.error("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");
        } catch (LockedAccountException lae) {
            log.error("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");
        } catch (ExcessiveAttemptsException eae) {
            log.error("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");
        } catch (AuthenticationException ae) {
            log.error("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");
            ae.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new UnknownAccountException("用户密码错误");
    }

    @GetMapping("/logout.html")
    public String logout() {
        Subject subject = SecurityUtil.getSubject();
        log.info("Get method /logout.html: {}用户退出",subject.getSession().getId());
        subject.logout();
        return "redirect:" + LOGIN_SUCCESS_OR_LOGOUT_PAGE;
    }
}
