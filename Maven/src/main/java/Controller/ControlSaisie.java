package Controller;

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
		return email.contains("@")&& !(ProducteurService.exitProducteurWithEmail(email));
	}
	
	public static boolean validEmailutilisateur(String email) {
		return email.contains("@")&& !(UtilisateurService.exitUtilisateurWithEmail(email));
	}
	public static boolean Existe(String champ) {
		return UtilisateurService.exitUtilisateurWithEmail(champ);
	}
	
	
	
	public static boolean validMdp(String mdp) {
		return !(mdp==null) && mdp.length()>=8;
	}


}
