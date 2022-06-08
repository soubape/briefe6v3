package daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDao;
import entites.Categories;
import entites.Produits;

public class DaoProduitImpl implements IDao<Produits> {
	
	@Override
	public boolean create(Produits prod) {
		try {
            //String req = "insert into produits(idproduit,nom, quantite, prix, date_reation,idcategorie) values(?,?,?,?,?)";
			String req = "insert into produits(nom, quantite,prix,date_creation,idcategorie) values "
					+ "('" + prod.getNom() + "', " + prod.getQuantite() +", " + prod.getPrix()
					+",'"+prod.getDateCreation()+"',"+prod.getIdCategorie()+ ")";
            Statement st = Connexion.getConnection().createStatement();
            st.executeUpdate(req);
            System.out.println( st.executeUpdate(req));
            if (st.executeUpdate(req) == 1) {
            	System.out.println("Nouveau produit ajoute avec succes !");
                //return true;
            }
        } catch (SQLException ex) {
            System.out.println("Erreur SQL : "+ex);
        }
        return false;
	}
	@Override
	public boolean update(Produits prod) {
		try {
            String req = "update produits set nom ='"+prod.getNom()+"', "
            		+ "quantite ="+prod.getQuantite()
            		+", "+ "prix ="+prod.getPrix()
            		+", "+ "date_creation ='"+prod.getDateCreation()
            		+"', "+ "idcategorie ="+prod.getIdCategorie()
    	           +" where idproduit = "+prod.getId();
    	            /*+ "date_creation ='"+prod.getDateCreation()
            		+ "idcategorie ='"+prod.getIdCategorie()
            		+" where idproduit = "+prod.getId();*/
            //System.out.println(prod.getId());
            Statement st = Connexion.getConnection().createStatement();
            //System.out.println(st);
            st.executeUpdate(req);
            //System.out.println( st.executeUpdate(req));
            if(st.executeUpdate(req) == 1)
                System.out.println("Mise a jour du produit ayant l'id " +prod.getId()+" effectuee !");
        } catch (SQLException ex) {
            System.out.println("Erreur SQL"+ex);
        }
        return false;
	}
	
	@Override
	public Produits findById(int id) {
		try {
			String req = "select * from produits where idproduit ="+id;
            //System.out.println("id = "+id);
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(req);
            if (rs.next()) 
            	return new Produits(rs.getInt("idproduit"),
            			rs.getString("nom"), rs.getInt("quantite"),
            			rs.getInt("prix"), rs.getString("date_creation"),
            			rs.getInt("idcategorie"));
                //return new Categories(rs.getInt("idcategorie"), rs.getString("nom"), rs.getString("createur_produit"));
            
        } catch (SQLException ex) {
            System.out.println("Erreur SQL"+ex);
        }
        return null;
		
	}
	
	@Override
	public boolean delete(Produits prod) {
		try {
			String req = "delete from produits where idproduit="+prod.getId();
		    //System.out.println("id = "+prod.getId());
		    Statement st = Connexion.getConnection().createStatement();
		    //System.out.println(st);
		    st.executeUpdate(req);
		    if(st.executeUpdate(req)==1)
		    	System.out.println("Suppression du produit reussie");
		} catch (SQLException ex) {
		    System.out.println("Erreur SQL"+ex);
		}
		return false;
	
	}

	@Override
	public List<Produits> findAll() {
		List<Produits> produits = new ArrayList<Produits>();
		 try {
	            String req = "select * from produits";
	            Statement st = Connexion.getConnection().createStatement();
	            ResultSet rs = st.executeQuery(req);
	            while (rs.next()) {
	            	produits.add(new Produits(rs.getInt("idproduit"),
	                		rs.getString("nom"), rs.getInt("quantite"),
	                		rs.getInt("prix"), rs.getString("date_creation"),
	                		rs.getInt("idcategorie")));
	            }
	 
	        } catch (SQLException ex) {
	            System.out.println("Erreur SQL");
	        }
	        return produits;
	}
	@Override
	public List<Produits> getProduitParCat(int idcat) {
		List<Produits> prods = new ArrayList<Produits>();
		try {
			String req = "select * from produits where idcategorie = "+idcat;
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(req);
			while(rs.next()){
				Produits p = new Produits();
				p.setId(rs.getInt("idproduit"));
				p.setNom(rs.getString("nom"));
				p.setQuantite(rs.getInt("quantite"));
				p.setPrix(rs.getInt("prix"));
				p.setDateCreation(rs.getString("date_creation"));
				p.setIdCategorie(rs.getInt("idcategorie"));
				String req1 = "select * from Categories where idcategorie ="+idcat;
				Statement stmt = Connexion.getConnection().createStatement();
				ResultSet rs2 = stmt.executeQuery(req1);
				if(rs2.next()) {
					Categories cats = new Categories();
					cats.setId(rs2.getInt("idcategorie"));
					cats.setNom(rs2.getString("nom"));
					cats.setCreateur(rs2.getString("createur_produit"));
					p.setCategorie(cats);
					System.out.println("La liste des produits de la categorie "+idcat +" est :");
				}
				else
					System.out.println("Aucun produit trouve pour l'id "+idcat);
				prods.add(p);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return prods;
		
	}

}
