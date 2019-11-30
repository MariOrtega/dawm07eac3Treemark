/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.xtec.ioc.controller;
import cat.xtec.ioc.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author Mari
 */

@Controller
public class VendesController {
    @Autowired
    VendaService vendaService;
    
    @RequestMapping(value="/vendaArticle/{codi}", method=RequestMethod.GET)
    public String vendre(@PathVariable("codi") String codi){
       vendaService.processVenda(codi);
       return "redirect:/getArticle/"+codi;
    }
}
