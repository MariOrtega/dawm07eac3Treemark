/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.xtec.ioc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Mari
 */

@Controller
public class BotigaControler {
    
   @RequestMapping(value="/",method=RequestMethod.GET)
   public ModelAndView hadleRequest(HttpServletRequest request, HttpServletResponse response){
       ModelAndView modelview=new ModelAndView("home");
       modelview.getModelMap().addAttribute("banner", "Articles de Nadal!");
       modelview.getModelMap().addAttribute("tagline", "");
       
       
       
       
       
      // modelview.getModelMap().addAttribute("options",options);
       
       return modelview;
       
   }
    
}
