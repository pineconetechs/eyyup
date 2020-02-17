package com.architecture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

@Controller
    public class MainController {



    @RequestMapping("/index.html")
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
        /*PictureEntity pictureEntity=pictureService.findPicture(1);
        model.addAttribute("picture",pictureEntity);*/

        ModelAndView modelAndView = new ModelAndView("portfolio");

        return modelAndView;
    }
    @RequestMapping("/portfolio2.html")
    public ModelAndView port2(Model model) {
        /*PictureEntity pictureEntity=pictureService.findPicture(1);
        model.addAttribute("picture",pictureEntity);*/

        ModelAndView modelAndView = new ModelAndView("portfolio2");

        return modelAndView;
    }

    @RequestMapping("/contact.html")
    public ModelAndView contact() {

        ModelAndView modelAndView = new ModelAndView("contact");

        return modelAndView;
    }



    @RequestMapping("/service.html")
    public ModelAndView service() {

        ModelAndView modelAndView = new ModelAndView("service");

        return modelAndView;
    }

    @RequestMapping("/projectdetails.html")
    public ModelAndView projectdetails() {

        ModelAndView modelAndView = new ModelAndView("projectdetails");

        return modelAndView;
    }




   @Autowired
    public JavaMailSender javaMailSender;


  @PostMapping("/sendMail")
    public String sendMail( @RequestParam(required=false,name="name") String name, @RequestParam(required=false,name="subject") String subject, @RequestParam(required=false,name="mail") String mail, @RequestParam(required=false,name="phone") String phone, @RequestParam(required=false,name="text") String text)
            throws MessagingException, IOException {


        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo("eyyupguzel47@gmail.com");



        helper.setSubject(subject);


        // true = text/html
        helper.setText( name + "\n" + mail + "\n" + phone + "\n" + text, false);


        javaMailSender.send(msg);


        return "index";


    }

}

