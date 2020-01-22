package com.architecture.controller;

import com.architecture.Service.PictureService;
import com.architecture.entitiy.PictureEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

@Controller
    public class MainController {
    @Autowired
    PictureService pictureService;


    @RequestMapping("/")
    public ModelAndView page() {

        ModelAndView modelAndView = new ModelAndView("index");

        return modelAndView;
    }

    @RequestMapping("/about.html")
    public ModelAndView about() {

        ModelAndView modelAndView = new ModelAndView("about");

        return modelAndView;
    }

    @RequestMapping("/portfolio.html")
    public ModelAndView port(Model model) {
        PictureEntity pictureEntity=pictureService.findPicture(1);
        model.addAttribute("picture",pictureEntity);

        ModelAndView modelAndView = new ModelAndView("portfolio");

        return modelAndView;
    }

    @RequestMapping("/contact.html")
    public ModelAndView contact() {

        ModelAndView modelAndView = new ModelAndView("contact");

        return modelAndView;
    }

/*    @Autowired
    public JavaMailSender javaMailSender;*/


/*    @PostMapping("/")
    public String sendMail(@RequestParam("name") String name, @RequestParam("subject") String subject, @RequestParam("email") String email, @RequestParam("phone") String phone, @RequestParam("text") String text)
            throws MessagingException, IOException {


        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo("eyyup.guzel@ozu.edu.tr");


        helper.setSubject("Subject");


        // true = text/html
        helper.setText(name + "\n" + email + "\n" + phone + "\n" + text, false);


        javaMailSender.send(msg);


        return "index";


    }*/

}

