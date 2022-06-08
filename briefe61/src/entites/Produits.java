package entites;

public class Produits {
	private int id;
	private String nom;
	private int quantite;
	private int prix;
	private String dateCreation;
	private int idCategorie;
	
	
	/**
	 * @param id
	 * @param nom
	 * @param quantite
	 * @param prix
	 * @param dateCreation
	 * @param idCategorie
	 */
	public Produits(int id, String nom, int quantite, int prix, String dateCreation, int idCategorie) {
		this.id = id;
		this.nom = nom;
		this.quantite = quantite;
		this.prix = prix;
		this.dateCreation = dateCreation;
		this.idCategorie = idCategorie;
	}
	
	public Produits(String nom, int quantite, int prix, String dateCreation, int idCategorie) {
		this.nom = nom;
		this.quantite = quantite;
		this.prix = prix;
		this.dateCreation = dateCreation;
		this.idCategorie = idCategorie;
	}

	public Produits() {
		
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
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
	 * @return the quantite
	 */
	public int getQuantite() {
		return quantite;
	}

	/**
	 * @param quantite the quantite to set
	 */
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	/**
	 * @return the prix
	 */
	public int getPrix() {
		return prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(int prix) {
		this.prix = prix;
	}

	/**
	 * @return the dateCreation
	 */
	public String getDateCreation() {
		return dateCreation;
	}

	/**
	 * @param dateCreation the dateCreation to set
	 */
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	/**
	 * @return the idCategorie
	 */
	public int getIdCategorie() {
		return idCategorie;
	}

	/**
	 * @param idCategorie the idCategorie to set
	 */
	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public void setCategorie(Categories cats) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
