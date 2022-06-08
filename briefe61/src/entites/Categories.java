package entites;

public class Categories {
	private int id;
	private String nom;
	private String createur;
	/**
	 * @param nom
	 * @param createur
	 */
	
	public Categories() {
		
	}

	public Categories(String nom, String createur) {
		this.nom = nom;
		this.createur = createur;
	}

	public Categories(int id, String nom, String createur) {
		this.id = id;
		this.nom = nom;
		this.createur = createur;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the createur
	 */
	public String getCreateur() {
		return createur;
	}
	/**
	 * @param createur the createur to set
	 */
	public void setCreateur(String createur) {
		this.createur = createur;
	}
	/*public static void add(Categories cat) {
		System.out.println("Catégorie ajoutée avec succès !");
		
	}*/

	
	

}
