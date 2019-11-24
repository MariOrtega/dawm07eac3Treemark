/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.xtec.ioc.service;

import cat.xtec.ioc.domain.Article;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Mari
 */
public interface ArticleService {
    public void addArticle(Article article);
    public Article getArticleByCodi(String codi);
    public Set<Article> getArticleByFilter(Map<String, List<String>> filterParams);
    
}
