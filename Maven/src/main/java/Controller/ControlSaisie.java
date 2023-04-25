package Controller;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;

import Service.ActeurService;
import Service.AdminService;
import Service.ProducteurService;
import Service.UtilisateurService;

public class ControlSaisie {
	public static boolean isAlpha(String s){
        if (s == null)
            return false;
        for (int i=0; i<s.length();i++){
            char c = s.charAt(i);
            if ( !(c <= 'Z' && c >= 'A') && !(c <= 'z' && c >= 'a') )
                return false;
        }
        return true;
    }
	
	
	public static boolean validName(String name) {
        if (name.length() == 0)
            return false;
        else return isAlpha(name);
    }
	
	
	public static boolean validEmailproducteur(String email) {
		return email.contains("@")&& !(ProducteurService.exitProWithEmail(email));
	}
	
	public static boolean validEmailutilisateur(String email) {
		return email.contains("@")&& !(UtilisateurService.exitUtilisateurWithEmail(email));
	}
	
	public static boolean validEmailAdmin(String email) {
		return email.contains("@")&& !(AdminService.exitAdminWithEmail(email));
	}
	
	public static boolean validEmailActeur(String email) {
		return email.contains("@")&& !(ActeurService.exitActeurWithEmail(email));
	}
	public static boolean ExisteEmaiUS(String champ) {
		return UtilisateurService.exitUtilisateurWithEmail(champ);
	}
	
	
	public static boolean ExisteEmailAc(String champ) {
		return ActeurService.exitActeurWithEmail(champ);
	}
	
	

	public static boolean ExisteEmailPro(String champ) {
		return ProducteurService.exitProWithEmail(champ);
	}
	
	
	
	public static boolean ExisteEmailAd(String champ) {
		return AdminService.exitAdminWithEmail(champ);
	}
	public static boolean ExisteMdpAd(String champ) {
		return AdminService.exitAdminWithMdp(champ);
	}
	
	public static boolean ExisteMdp(String champ) {
		return UtilisateurService.exitUtilisateurWithMdp(champ);
	}
	
	public static boolean ExisteMdpPro(String champ) {
		return UtilisateurService.exitUtilisateurWithMdp(champ);
	}
	
	public static boolean ExisteMdpAc(String champ) {
		return ProducteurService.exitProWithMdp(champ);
	}
	public static boolean validMdp(String mdp) {
		return !(mdp==null) && mdp.length()>=8;
	}

	public static boolean validIdPro(int id) throws SQLException {
		return (Service.ProducteurService.verifId(id));
	}
	public static boolean validId(int id) throws SQLException {
		return (Service.ActeurService.verifId(id));
	}
	
	public static boolean validAncienMdp(int id,String mdp) {
		return  ActeurService.verifAncienMDP(id,mdp);
	}
	
	public static boolean validAncienMdpPro(int id,String mdp) {
		return  ProducteurService.verifAncienMDP(id,mdp);
	}
	
	public static boolean validAncienMdpUser(int id,String mdp) {
		return  UtilisateurService.verifAncienMDP(id,mdp);
	}
	
	
	public static boolean validNote(int number) {
	    return number >= 0 && number <= 10 && number == (int) number;
	}

	
	public static boolean validIdAdmin(int id) throws SQLException {
		return (Service.AdminService.verifId(id));
	}

	
	
	public static boolean validAncienMdpAdmin(int id,String mdp) {
		return  AdminService.verifAncienMDP(id,mdp);
	}
	
	
	
	
	
	
	   /*public static LocalDate convertToDateViaInstant(Date dateToConvert) {
	        return dateToConvert.toInstant()
	          .atZone(ZoneId.systemDefault())
	          .toLocalDate();
	    }
*/
}
