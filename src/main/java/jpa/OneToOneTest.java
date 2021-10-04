package jpa;

import fr.didi.classesOneToOneSansTableAssociation.User;
import fr.didi.classesOneToOneSansTableAssociation.UserInformations;

import javax.persistence.*;
import java.util.List;

public class OneToOneTest {
    public static void main(String[] args) throws Exception {
        EntityManagerFactory entityManagerFactory;
        EntityManager entityManager;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("dev");
            entityManager = entityManagerFactory.createEntityManager();


            //Liste des informations des utilsateurs


            UserInformations info1 = new UserInformations();
            info1.setAddress("10 rue");
            info1.setCity("Rennes");
            info1.setEmail("dconfe@");
            info1.setPhoneNumber(809000);


            UserInformations info2 = new UserInformations();
            info2.setAddress("11 rue");
            info2.setCity("Poitiers");
            info2.setEmail("dvalerie@");
            info2.setPhoneNumber(0000000001);

            UserInformations info3 = new UserInformations();
            info3.setAddress("12 rue");
            info3.setCity("Rouen");
            info3.setEmail("dbertille@");
            info3.setPhoneNumber(0000000002);

            UserInformations info4= new UserInformations();
            info4.setAddress("13 rue");
            info4.setCity("Paris");
            info4.setEmail("dmarie@");
            info4.setPhoneNumber(0000000003);




            //Liste des users

            User user1= new User();
            user1.setLogin("dconfe");
            user1.setPassword("sfdfffffffffffso");
            user1.setConnectionNumber(1);

            System.out.println("cest ce code qui permet de lier User à UserInformations !!très important à ne pas oublier!!");
            user1.setUserInformations(info1);


            User user2= new User();
            user2.setLogin("dvalerie");
            user2.setPassword("jwdodp");
            user2.setConnectionNumber(2);

            user2.setUserInformations(info2);

            User user3= new User();
            user3.setLogin("dbertille");
            user3.setPassword("sfjso");
            user3.setConnectionNumber(3);

            user3.setUserInformations(info3);


            User user4= new User();
            user4.setLogin("dmarie");
            user4.setPassword("pdgj");
            user4.setConnectionNumber(4);

            user4.setUserInformations(info4);

            // on utilise trans.begin et commit si on veut manipuler les éléments de la BD (insert, delete, update..)
            EntityTransaction trans = entityManager.getTransaction();

            trans.begin();

//            System.out.println("mettre un élément en BD à travers la méthode persist");

            entityManager.persist(info1);
            entityManager.persist(info2);
            entityManager.persist(info3);
            entityManager.persist(info4);

            entityManager.persist(user1);
            entityManager.persist(user2);
            entityManager.persist(user3);
            entityManager.persist(user4);


            User user_recherche1 = entityManager.find(User.class, 1);

            System.out.println("l'utilisateur recherché");
            System.out.println(user_recherche1.toString());

            System.out.println("les infos de l'utilisateur recherché");
            System.out.println(user_recherche1.getUserInformations().toString());


            System.out.println("les infos de tous les utilisateurs");
           List <User> allusers = entityManager.createQuery("select e from User as e").getResultList();
            for (User users : allusers
                 ) {
                System.out.println(users.toString());
                System.out.println(users.getUserInformations().toString());
            }




            trans.commit();

        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
