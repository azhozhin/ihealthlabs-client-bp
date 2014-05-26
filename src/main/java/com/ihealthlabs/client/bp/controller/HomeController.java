package com.ihealthlabs.client.bp.controller;

import com.ihealthlabs.client.bp.ApiUtils;
import com.ihealthlabs.client.bp.beans.User;
import com.ihealthlabs.client.bp.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Scope("request")
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private User user;

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("user", user);
        return mav;
    }

    @RequestMapping("/auth")
    public ModelAndView hello(@RequestParam(value = "code", required = false) String code,
                              @RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "error_description", required = false) String errorDescription) {
        if (error == null) {
            if (code != null && !code.isEmpty()) {
                user.setCode(code);
                AccessTokenResponse accessTokenResponse = ApiUtils.requestAccessToken(user);
                return new ModelAndView(new RedirectView("/bp/"));
            } else {
                ModelAndView mav = new ModelAndView("error");
                mav.addObject("error", new com.ihealthlabs.client.bp.entity.Error(-1, error, errorDescription));
                return mav;
            }
        }
        return new ModelAndView(new RedirectView("/"));
    }

    @RequestMapping("/login")
    public ModelAndView login() {
        return new ModelAndView(new RedirectView(ApiUtils.loginUrl()));
    }

}
