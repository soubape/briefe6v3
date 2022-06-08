package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	private static Connection connection;
	
	 static {
	        try {
	            //Étape 1 : Charger le driver de la base de données
	            // cible
	            Class.forName("org.postgresql.Driver");
	            //Étape 2 : Authentification auprès de la base de données
	            // et sélectionner le schéma
	            connection=DriverManager.getConnection
						("jdbc:postgresql://localhost:5432/db_briefe6","postgres","nawan");
	        } catch (ClassNotFoundException ex) {
	            System.out.println("Impossible de charger le driver");
	        } catch (SQLException ex) {
	            System.out.println("Erreur de connexion");
	        }
	    }
	 
	    public static Connection getConnection() {
	        return connection;
	    }

}
