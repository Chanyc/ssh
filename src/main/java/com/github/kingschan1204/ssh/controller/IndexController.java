package com.github.kingschan1204.ssh.controller;

import com.github.kingschan1204.ssh.model.vo.UserVo;
import com.github.kingschan1204.ssh.services.UserService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kingschan on 2017/4/14.
 *
 */
@Controller
public class IndexController {

    private Logger log = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private UserService userServ;

    @RequestMapping("/")
    public String index(Model mo,Integer page,String username,String email) {
        log.debug("test");
        try {
          Page<UserVo> p= userServ.getUsers(null==page?1:page,10,username,email);
            mo.addAttribute("page",p);
            mo.addAttribute("username",username);
            mo.addAttribute("email",email);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "/font/index/index";
    }
}
