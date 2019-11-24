/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.xtec.ioc.service.impl;

import cat.xtec.ioc.domain.Article;
import cat.xtec.ioc.repository.ArticleRepository;
import cat.xtec.ioc.repository.impl.inMemoryArticleRepository;
import cat.xtec.ioc.service.ArticleService;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mari
 */
@Service
public class ArticleServiceImpl implements ArticleService{
    
    @Autowired 
   private  ArticleRepository imar;
/**
 * Heu de desenvolupar els  mètodes de ArticleService.
 * En realitat, només són una crida als de InMemoryArticleRepository.
 * @param article 
 */
    @Override
    public void addArticle(Article article) {
       imar.addArticle(article);
    }

    @Override
    public Article getArticleByCodi(String codi) {
      return  imar.getArticleByCodi(codi);
    }

    @Override
    public Set<Article> getArticleByFilter(Map<String, List<String>> filterParams) {
    return imar.getArticlebyFilter(filterParams);
    }
    
}
