package org.reservation_backend.dto;

public class UtilisateurDto {
        private String uuid;
        private String prenom;
	    private  String nom;
	    private  String telephone;
	    private  String  adresse;
	    
		public String getUuid() {
			return uuid;
		}
		public void setUuid(String uuid) {
			this.uuid = uuid;
		}
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getTelephone() {
			return telephone;
		}
		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}
		public String getAdresse() {
			return adresse;
		}
		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}
		public UtilisateurDto() {
			super();
		}
		public UtilisateurDto(String uuid, String prenom, String nom, String telephone, String adresse) {
			super();
			this.uuid = uuid;
			this.prenom = prenom;
			this.nom = nom;
			this.telephone = telephone;
			this.adresse = adresse;
		}
		
        
}
