/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.xtec.ioc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView hadleRequest(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelview = new ModelAndView("home");
        modelview.getModelMap().addAttribute("banner", "Articles de Nadal!!!");
        modelview.getModelMap().addAttribute("tagline", "");
        List<HashMap> options = new ArrayList();
        HashMap<String, String> afegir = new HashMap();
        HashMap<String, String> consultar = new HashMap();
        HashMap<String, String> filtrar = new HashMap();
        HashMap<String, String> comprar = new HashMap();

        afegir.put("title", "Afegir");
        afegir.put("desc", "Permet afegir un article al catàleg");
        afegir.put("url", "/add");
        afegir.put("icon", "glyphicon glyphicon-plus-sign");

        
         consultar.put("title", "Consultar");
        consultar.put("desc", "Permet consultar un article al catàleg");
        
        options.add(afegir);
        options.add(consultar);

        modelview.getModelMap().addAttribute("options", options);
        return modelview;

    }

}
