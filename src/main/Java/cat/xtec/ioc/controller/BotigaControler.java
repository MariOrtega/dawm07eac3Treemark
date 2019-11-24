/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.xtec.ioc.controller;

import cat.xtec.ioc.service.ArticleService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @Autowired
    ArticleService articleService;
    
    

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
        consultar.put(url, "/get");
        consultar.put(icon, gly+"search");

        filtrar.put(title, "Filtrar");
        filtrar.put(desc, "Permet filtrar un article al catàleg");
        filtrar.put(url, "/filter");
        filtrar.put(icon, gly+"filter");

        comprar.put(title, "Comprar");
        comprar.put(desc, "Permet comprar un article al catàleg");
        comprar.put(url, "/venda");
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
    
    /**
     * Volem implementar la funcionalitat Consultar
     * @param request
     * @param response
     * @return 
     */
    @RequestMapping(value="/get", method=RequestMethod.GET)
    public ModelAndView getArticleForm(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mav= new ModelAndView("getArticleForm");
        mav.getModelMap().addAttribute(banner,"Articles de Nadal!!!");
       
        return mav;
    }

    /**
     * Funció que rep la informació del formulari.
     * @param codi
     * @param request
     * @param response
     * @return 
     */
    
    @RequestMapping(value="/get", method=RequestMethod.POST)
    public ModelAndView getArticleByCodiRequest(@RequestParam String codi, HttpServletRequest request, HttpServletResponse response){
        ModelAndView mav =new ModelAndView("infoArticle");
        mav.getModelMap().addAttribute(banner, "Articles de Nadal!!!");
        mav.getModelMap().addAttribute(tagline, "Dades d'un article");
       mav.getModelMap().addAttribute("article", this.articleService.getArticleByCodi(codi));
       return mav;
    }
    
    @RequestMapping(value="/filter", method=RequestMethod.GET)
    public ModelAndView getArticleByFilter (HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv= new ModelAndView("helpFilter");
        mv.getModelMap().addAttribute(banner, "Articles de Nadal!!!");
        mv.getModelMap().addAttribute(tagline,"Ajuda per la creació d'un Filtre");
        mv.getModelMap().addAttribute(title, "Creació d'un filtre tipus ByCriteria"); 
        mv.getModelMap().addAttribute(desc, "Heu de canviar la url d'aquest patró:");
        mv.getModelMap().addAttribute("desc1","tipus=Arbre,Decoracio;title=titol,3");
        mv.getModelMap().addAttribute("desc2","On Tipus pot ser el nom de les classes de domini(exactament igual);Arbre,Decoracio o Llum");
        mv.getModelMap().addAttribute("desc3","Per exemple si el tipus és Arbre o Decoracio i el title es titol i 3 la URL seria la que conté aquest botó:");
        return mv;
    }
    @RequestMapping(value="/filter/{ByCriteria}", method=RequestMethod.GET)
    public ModelAndView listArticleByFilter(@MatrixVariable(pathVar="ByCriteria") Map<String, List<String>> filterParams, HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv= new ModelAndView("listArticleByFilter");
         mv.getModelMap().addAttribute(banner, "Articles de Nadal!!!");
        mv.getModelMap().addAttribute(tagline,"Llista d'articles que compleixen els requisits");
        mv.getModelMap().addAttribute("article", this.articleService.getArticleByFilter(filterParams));
        return mv;
    }
    @RequestMapping(value="/venda", method=RequestMethod.GET)
    public ModelAndView getVenda (HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv=new ModelAndView("helpVendes");
        mv.getModelMap().addAttribute(banner, "Articles de Nadal!!!");
        mv.getModelMap().addAttribute(tagline, "Ajuda per la venda d'un article");
        mv.getModelMap().addAttribute(title, "Venda");
        mv.getModelMap().addAttribute(desc, "Heu de canviar la URL per aquest patró");
        mv.getModelMap().addAttribute("desc1", "/vendaArticle/codi");
        mv.getModelMap().addAttribute("desc2", "Per exemple si voleu fer una venda per l'arbre:0 seria venda/Article/0");
        return mv;
    }
    
    @RequestMapping(value="/getArticle/{codi}", method=RequestMethod.GET)
    public ModelAndView getArticleByCodiVendaRequest(@PathVariable String codi){
        ModelAndView mv= new ModelAndView("infoArticle");
         mv.getModelMap().addAttribute(banner, "Articles de Nadal!!!");
        mv.getModelMap().addAttribute(tagline, "Dades d'un article");
        mv.getModelMap().addAttribute("article", this.articleService.getArticleByCodi(codi));
        return mv;
    }
}
