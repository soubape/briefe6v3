import java.util.List;

import daoImpl.DaoCategorieImpl;
import daoImpl.DaoProduitImpl;
import entites.Categories;
import entites.Produits;
public class Test {

	public static void main(String[] args) {
		
		DaoCategorieImpl daoCategorieImpl = new DaoCategorieImpl();
		DaoProduitImpl daoProduitImpl = new DaoProduitImpl();
        //Création des categories
		
		Categories cat1 = new Categories("Informatique", "Soubapé");
		Categories cat2 = new Categories("Smartphone", "Ibtihal");
		Categories cat3 = new Categories("Lecteur-Photos-Video", "Nawal");
		System.out.println("La liste des categories : ");
		
		/* for(Categories cl : daoCategorieImpl.findAll())
            System.out.println(cl.getId()+ " - "+cl.getNom()+ " | "+cl.getCreateur());
        
        
      //Supprimer le client dont id = 3
        daoCategorieImpl.delete(daoCategorieImpl.findById(3));
         
       */ 
      //Afficher la categorie dont id = 2
        Categories cat = daoCategorieImpl.findById(2);
        System.out.println(cat.getId()+" - "+cat.getNom()+" | "+cat.getCreateur());
        
      //Modifier le client dont id = 1
       /* Categories cats = daoCategorieImpl.findById(1);
        cats.setNom("nouvelle categorie");
        cats.setCreateur("nouveau createur");
        daoCategorieImpl.update(cats);
       
        for(Produits prods : daoProduitImpl.findAll()) {
            System.out.println(prods.getId()+ " - "+prods.getNom()+ " | "+prods.getQuantite()
            + " | "+prods.getPrix()+ " | "+prods.getDateCreation()+ " | "+prods.getIdCategorie());
		}
        
      //Supprimer le client dont id = 3
        daoProduitImpl.delete(daoProduitImpl.findById(3));
      */ 
		// creation des produits 
		System.out.println("===================================================");
		Produits prod5 = new Produits("Iphone", 200, 10500, "12/03/2022",2);
		Produits prod6 = new Produits("Samsung A12", 50, 5500, "06/05/2012",2);
		Produits prod7= new Produits("Iphone Pro", 200, 10500, "10/02/2022",2);
		Produits prod8 = new Produits("ISamsung S4", 200, 10500, "08/04/2021",2);
		
		System.out.println("La liste des produits :");
		for(Produits prod : daoProduitImpl.findAll())
            System.out.println(prod.getId()+ " - "+prod.getNom()+ " | "+
            		prod.getQuantite()+" | "+prod.getPrix()+" | "+prod.getDateCreation()+" | "+prod.getIdCategorie());
		/*daoProduitImpl.create(prod5);
		daoProduitImpl.create(prod6);
		daoProduitImpl.create(prod7);
		daoProduitImpl.create(prod8);
		*/
		System.out.println("======Mise a jour d'un produit==============");
      //Modifier le produit dont id = 1
        Produits prods = daoProduitImpl.findById(5);
        prods.setNom("Ipad");
        prods.setQuantite(100);
        prods.setPrix(450);
        prods.setDateCreation("03/02/2020");
        prods.setIdCategorie(2);
        daoProduitImpl.update(prods);
        
        
        //Recherche des produits par categorie
        List<Produits> produits = daoProduitImpl.getProduitParCat(1);
        for (Produits p : produits) {
        	System.out.println("IdProduit : "+p.getId());
        	System.out.println("Nom : "+p.getNom());
        	System.out.println("Quantite : "+p.getQuantite());
        	System.out.println("Prix : "+p.getPrix());
        	System.out.println("Date creation : "+p.getDateCreation());
        }
		/*
		//daoCategorieImpl.create(cat1);
		//daoCategorieImpl.create(cat2);
		//daoCategorieImpl.create(cat3);       
		
		
		//Supprimer la categorie dont id = 3
        /*daoCategorieImpl.delete(daoCategorieImpl.findById(3));
        
        daoProduitImpl.delete(daoProduitImpl.findById(2));
        Produits prod = daoProduitImpl.findById(1);
        System.out.println(prod.getId()+" - "+prod.getNom()+
        		" | "+prod.getQuantite()+" | "+prod.getPrix()+
        		" | "+prod.getDateCreation()+" | "+prod.getIdCategorie());
       
		
      //Afficher la categorie dont id = 2
        Categories cat = daoCategorieImpl.findById(2);
        System.out.println(catId.getId());
        System.out.println(cat.getId()+" - "+cat.getNom()+" | "+cat.getCreateur());
        
        
      //Modifier la categorie dont id = 1
        Categories cats = daoCategorieImpl.findById(1);
        cats.setNom("nouvelle categorie");
        cats.setCreateur("nouveau createur");
        daoCategorieImpl.update(cats);
        
	
	}
	*/
	}
}
