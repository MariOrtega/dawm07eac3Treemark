/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.xtec.ioc.service.impl;

import cat.xtec.ioc.domain.Article;
import cat.xtec.ioc.repository.ArticleRepository;
import cat.xtec.ioc.repository.impl.inMemoryArticleRepository;
import cat.xtec.ioc.service.VendaService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mari
 */
@Service
public class VendaServiceImpl implements VendaService {

    /**
     * Obtè l’article com codi codiArticle. Si té unitats disponibles, llavors
     * s'incrementa el nombre de vendes en 1. Llença una Excepció si no hi ha
     * prou unitats.
     *
     * @param codiArticle
     */
    
    @Autowired
  ArticleRepository AR;
    
    @Override
    public void processVenda(String codiArticle) {
      Article article= this.AR.getArticleByCodi(codiArticle);
     
     
      article.setNumeroUnitats(article.getNumeroUnitats()-1);
      
        
      }
    

}
