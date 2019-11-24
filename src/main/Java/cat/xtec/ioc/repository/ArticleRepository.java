/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.xtec.ioc.repository;

import cat.xtec.ioc.domain.Article;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Mari
 */

public interface ArticleRepository {
    public void addArticle(Article article);
    public Article getArticleByCodi(String codi);
    public Set <Article> getArticlebyFilter(Map<String, List<String> >filterParams);
}
