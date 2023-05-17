package com.myfirstWebApp.myTodoListBySpringBoot.sayHello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayingHelloBySpringBoot {

    @RequestMapping("/say_hello")
    @ResponseBody
    public String sayHello1(){
        return "Hi Samirul, how your SpringBoor Learning Going?";
    }

//    run HTML code in Spring boot
    @RequestMapping("say_hello_html")
    @ResponseBody
    public String sayHelloByHtml(){
        StringBuffer sb=new StringBuffer();
//        sb.append("<html>");
//        sb.append("<head>");
//        sb.append("<title> welcome Samirul</title>");
//        sb.append("</head>");
//        sb.append("<body>");
//        sb.append("My first HTML page by Spring boot");
//        sb.append("</body>");
//        sb.append("</html>");
        sb.append("<html><head><title> welcome Samirul</title></head><body>My first HTML page by Spring boot1</body></html>");

        return sb.toString();
    }

//    eti JSP diye html call kora hobe
    @RequestMapping("/say_hello_html_JSP")
//    @ResponseBody
    public String htmlViewJsp(){
        return "myHtmlJsp";
    }
}
