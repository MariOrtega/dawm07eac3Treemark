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
import java.util.List;
import java.util.Map;
import java.util.Set;
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

        Arbre arbre1 = new Arbre("1","Avet","Arbre de la Estepa",6,2,"1,50","Fusta","verd");
        Arbre arbre2 = new Arbre("2","Pi","Arbre de bosc",20,3,"1,70","Fusta","verd");
        Arbre arbre3 = new Arbre("3","Artificial","Arbre de plàstic",34,5,"1","Plàstic","Blanc");
        Decoracio dec1 = new Decoracio("4","Papa Noel","Figureta d'adorn",40,2,"Figura","Vermell","10");
        Decoracio dec2 = new Decoracio("5","Reno","Figureta d'adorn",4,2,"Figura","Blanc","10");
        Decoracio dec3 = new Decoracio("6","Estrella","Estrella de nadal",56,0,"Figura","Platejat","15");
        Llum llum1 = new Llum("7","LLumetes petites","Llumetes petites  d'adorn",40,2,"llumetes",true,"1");
        Llum llum2 = new Llum("8","LLumetes mitjanes","Llumetes mitjanes d'adorn",40,2,"Figura",true,"2");
        Llum llum3 = new Llum("9","LLumetes grans","Llumetes grans",40,2,"Figura",false,"3");
        
        
        
        
        

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
