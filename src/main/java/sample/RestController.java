/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author g
 */
@Controller
public class RestController {
    @RequestMapping("/exit")
    public void exit(){
        System.out.println("exiting");
        ServerApp.exit();
    }
}
