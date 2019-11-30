/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.xtec.ioc.repository.impl;

import cat.xtec.ioc.domain.Arbre;
import cat.xtec.ioc.domain.Article;
import cat.xtec.ioc.domain.Decoracio;
import cat.xtec.ioc.domain.Llum;
import cat.xtec.ioc.repository.ArticleRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mari
 */
@Repository
public class inMemoryArticleRepository implements ArticleRepository {

    private List<Article> llista = new ArrayList<Article>();

    /**
     * S'ha de crear Articles en el constructor d'aquesta classe. S'ha
     * d'inicialitzar la llista amb 3 Articles de cadascun dels tipus.
     */
    public inMemoryArticleRepository() {

        Arbre arbre1 = new Arbre("1", "ArbreTitol1", "Arbre de la Estepa", 1, 2, "1,50", "Fusta", "verd");
        Arbre arbre2 = new Arbre("2", "Arbre3", "Arbre de bosc", 20, 3, "1,70", "Fusta", "verd");
        Arbre arbre3 = new Arbre("3", "ArbreTitol3", "Arbre de plàstic", 34, 5, "1", "Plàstic", "Blanc");
        Decoracio dec1 = new Decoracio("4", "DecoracioTitol1", "Figureta d'adorn", 40, 2, "Figura", "Vermell", "10");
        Decoracio dec2 = new Decoracio("5", "Decoraciotit2", "Figureta d'adorn", 4, 2, "Figura", "Blanc", "10");
        Decoracio dec3 = new Decoracio("6", "DecoracioTit3", "Estrella de nadal", 56, 0, "Figura", "Platejat", "15");
        Llum llum1 = new Llum("7", "LLums1", "Llumetes petites  d'adorn", 40, 2, "llumetes", true, "1");
        Llum llum2 = new Llum("8", "LLumsTitol2", "Llumetes mitjanes d'adorn", 40, 2, "Figura", true, "2");
        Llum llum3 = new Llum("9", "LLumsTitol3", "Llumetes grans", 40, 2, "Figura", false, "3");

        llista.add(arbre1);
        llista.add(arbre2);
        llista.add(arbre3);
        llista.add(dec1);
        llista.add(dec2);
        llista.add(dec3);
        llista.add(llum1);
        llista.add(llum2);
        llista.add(llum3);

    }

    /**
     * Afegeix un article al llistat de d'Articles de la botiga
     *
     * @param article
     */
    @Override
    public void addArticle(Article article) {
        llista.add(article);
    }

    /**
     * Retorna l’article que coincideixi el seu codi amb el Codi enviat per
     * paràmetre. En el       cas que no es trobi la correspondència, es llança
     * una exepció que indiqui que no s'ha trobat.
     *
     * @param codi
     * @return
     */
    @Override
    public Article getArticleByCodi(String codi) {
        Article trobat = null;
        for (Article article : this.llista) {
            if (article.codi.equals(codi)) {
                trobat = article;
                break;
            }
        }
        if (trobat == null) {
            throw new NullPointerException("No s'ha trobat el article amb aquest codi");
        }
        return trobat;
    }

    /**
     * Ha de respondre a la consulta de filtres que s'ha definit als casos
     * d'ús.  Els criteris són: El tipus de          Article (Arbre, Decoracio o
     * Llum) i el títol de l’Article. → Per realitzar aquest mètode podeu
     * ajudar-vos de la funció:
     *      Class.forName(“nomPaquet.nomClasse).isInstance(Object)      Aquesta
     * funció comproba que l’objecte Object sigui de la classe
     * “nomPaquet.nomClasse”
     *
     * @param filterParams
     * @return
     */
    @Override
    public Set<Article> getArticlebyFilter(Map<String, List<String>> filterParams) {
        Set<Article> articlePerTipus = new HashSet<Article>();
        Set<Article> articlePerTitol = new HashSet<Article>();
        Set<String> criterias = filterParams.keySet();
        if (criterias.contains("tipus")) {
            for (String t : filterParams.get("tipus")) {
                for (Article article : this.llista) {
                    try {
                        if (Class.forName("cat.xtec.ioc.domain." + t).isInstance(article)) {
                            articlePerTipus.add(article);
                        }
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(inMemoryArticleRepository.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        if (criterias.contains("title")) {
            String titol1 = filterParams.get("title").get(0);
            String titol2 = filterParams.get("title").get(1);

            for (Article article : llista) {
                if (article.getTitol().toLowerCase().indexOf(titol1.toLowerCase()) != -1
                        || article.getTitol().toLowerCase().indexOf(titol2.toLowerCase()) != -1) {

                    articlePerTitol.add(article);

                }

            }
        }
        articlePerTipus.retainAll(articlePerTitol);
        return articlePerTipus;
    }
}
