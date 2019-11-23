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

    public static String tagline = "tagline";
    public static String banner = "banner";
    public static String title = "title";
    public static String desc = "desc";
    public static String url = "url";
    public static String icon = "icon";
    public static String gly="glyphicon glyphicon-";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView homeRequest(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelview = new ModelAndView("home");
        modelview.getModelMap().addAttribute(banner, "Articles de Nadal!!!");
        modelview.getModelMap().addAttribute(tagline, "");
        List<HashMap> options = new ArrayList();
        HashMap<String, String> afegir = new HashMap();
        HashMap<String, String> consultar = new HashMap();
        HashMap<String, String> filtrar = new HashMap();
        HashMap<String, String> comprar = new HashMap();

        afegir.put(title, "Afegir");
        afegir.put(desc, "Permet afegir un article al catàleg");
        afegir.put(url, "/add");
        afegir.put(icon, gly+"plus-sign");

        consultar.put(title, "Consultar");
        consultar.put(desc, "Permet consultar un article al catàleg");
        consultar.put(url, "/consultar");
        consultar.put(icon, gly+"search");

        filtrar.put(title, "Filtrar");
        filtrar.put(desc, "Permet filtrar un article al catàleg");
        filtrar.put(url, "/filtrar");
        filtrar.put(icon, gly+"filter");

        comprar.put(title, "Comprar");
        comprar.put(desc, "Permet comprar un article al catàleg");
        comprar.put(url, "/comprar");
        comprar.put(icon, gly+"shopping-cart");

        options.add(afegir);
        options.add(consultar);
        options.add(filtrar);
        options.add(comprar);

        modelview.getModelMap().addAttribute("options", options);
        return modelview;

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addArticleRequest(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView mav = new ModelAndView("home");
        mav.getModelMap().addAttribute(banner, "Articles de Nadal!!");
        mav.getModelMap().addAttribute(tagline, "Afegir un article al catàleg");
        List<HashMap> options = new ArrayList();
        HashMap<String, String> arbre = new HashMap();
        HashMap<String, String> decoracio = new HashMap();
        HashMap<String, String> llums = new HashMap();
        // arbre
        arbre.put(title,"Arbres");
        arbre.put(desc, "Permet afegir un arbre al catàleg de la botiga");
        arbre.put(url, "/add/arbre");
        arbre.put(icon,gly+"tree-conifer");
        
        //decoracio
        decoracio.put(title, "Decoració");
        decoracio.put(desc, "Permet afegir una decoració al catáleg de la botiga");
        decoracio.put(url, "/add/decoracio");
        decoracio.put(icon, gly+"certificate");
        
        //Iluminacio
        llums.put(title, "Il.luminació");
        llums.put(desc, "Permet afegir una iluminació al catáleg de la botiga");
        llums.put(url, "/add/llums");
        llums.put(icon, gly+"lamp");
        
        
        
        options.add(arbre);
        options.add(decoracio);
        options.add(llums);
        
        mav.getModelMap().addAttribute("options", options);

        return mav;

    }

}
