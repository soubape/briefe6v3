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

public class DaoCategorieImpl implements IDao<Categories> {
	
	@Override
	public boolean create(Categories cat) {
		try {
            
            String req = "insert into categories (nom, createur_produit) values ('" + cat.getNom() + "', '" + cat.getCreateur() + "')";
            Statement st = Connexion.getConnection().createStatement();
            if (st.executeUpdate(req) == 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Erreur SQL");
        }
        return false;
	}

	@Override
	public boolean update(Categories cat) {
		try {
            String req = "update categories set "
            		+ "nom ='"+cat.getNom()+"', createur_produit ='"
            		+cat.getCreateur()+"' where idcategorie = "+cat.getId();
            Statement st = Connexion.getConnection().createStatement();
            
            if( st.executeUpdate(req)==1)
            	System.out.println(cat.getId()+" "+cat.getNom()+" "+cat.getCreateur());
            	System.out.println("La catégorie ayant l'id "+cat.getId() +" a ete bien mise a jour !");
            	
        } 
		catch (SQLException ex) {
            System.out.println("Erreur SQL"+ex);
        }
        return false;
	}

	@Override
	public boolean delete(Categories cat) {
		try {
            String req = "delete from categories where idcategorie="+cat.getId();
            //System.out.println("id = "+cat.getId());
            Statement st = Connexion.getConnection().createStatement();
            //System.out.println(st);
            st.executeUpdate(req);
            if(st.executeUpdate(req)==1)
            	System.out.println("Suppression reussie");
            
        } catch (SQLException ex) {
            System.out.println("Erreur SQL"+ex);
        }
        return false;

	}

	@Override
	public Categories findById(int id) {

		try {
            String req = "select * from categories where idcategorie="+id;
            //System.out.println(id);
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(req);
            //System.out.println(rs);
           if(rs.next()) {
        	   	//System.out.println(rs.getString("nom"));
                return new Categories(rs.getInt("idcategorie"), rs.getString("nom"), rs.getString("createur_produit"));
                
            }
        } catch (SQLException ex) {
            System.out.println("Erreur SQL "+ex);
        }
       
		return null;
		
	}

	@Override
	public List<Categories> findAll() {
		List<Categories> categories = new ArrayList<>();
        try {
            String req = "select * from categories";
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
            	categories.add(new Categories(rs.getInt("idcategorie"), rs.getString("nom"), rs.getString("createur_produit")));
            }
 
        } catch (SQLException ex) {
            System.out.println("Erreur SQL");
        }
        return categories;
	}

	@Override
	public List<Categories> getProduitParCat(int idcat) {
		return null;
	}

}
