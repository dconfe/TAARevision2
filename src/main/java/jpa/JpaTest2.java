package jpa;

import fr.didi.classesjpa.Article;

import javax.persistence.*;
import java.util.List;

public class JpaTest2 {
    public static void main(String[] args) throws Exception {
        EntityManagerFactory entityManagerFactory;
        EntityManager entityManager;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("dev");
            entityManager = entityManagerFactory.createEntityManager();


            //Liste des articles

            Article article1 = new Article();
            article1.setMarque("Zara");
            article1.setDescription("bonne qualité");
            article1.setPrice(29.99);


           // Article article2 = new Article(,"Boohoo","pantalon",35);
            Article article2 = new Article();
            article2.setMarque("Boohoo");
            article2.setDescription("pantalon");
            article2.setPrice(35);

            Article article3 = new Article();
            article3.setMarque("Jennyfer");
            article3.setDescription("t-shirt");
            article3.setPrice(4.99);


            Article article4 = new Article();
            article4.setMarque("Undiz");
            article4.setDescription("culotte");
            article4.setPrice(9.99);

            Article article5 = new Article();
            article5.setMarque("Mango");
            article5.setDescription("trench");
            article5.setPrice(66.35);


            Article article6 = new Article();
            article6.setMarque("Zara");
            article6.setDescription("BoyFriend");
            article6.setPrice(29.99);



            // on utilise trans.begin et commit si on veut manipuler les éléments de la BD (insert, delete, update..)
            EntityTransaction trans = entityManager.getTransaction();

            trans.begin();

            System.out.println("mettre un élément en BD à travers la méthode persist");
            entityManager.persist(article1);
            entityManager.persist(article2);
            entityManager.persist(article3);
            entityManager.persist(article4);
            entityManager.persist(article5);
            entityManager.persist(article6);

            System.out.println("supprimer le premier article");
            System.out.println("en supprimant l'article , les id des autres articles ne sont pas modifiés");
            entityManager.remove(article1);


            System.out.println(" rechercher un élément précis en BD par la méthode find");
            Article article_recherche2 =  entityManager.find(Article.class, 2);
            System.out.println("l'article recherché est : " + article_recherche2.getId() + " " + article_recherche2.getDescription() + " " + article_recherche2.getMarque() + " " + article_recherche2.getPrice());


            System.out.println( "- Lecture de tous les articles -----------" );
            System.out.println("création d'une requête simple");
            Query query1 = entityManager.createQuery("select e from Article as e");
            System.out.println("récupérer la liste des résultats de la requête dans une liste à travers la méthode getResultList()");
            List<Article> allarticles= query1.getResultList();
            for ( Article article: allarticles)
            {
                System.out.println(article.toString());
            }





            trans.commit();

        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

}