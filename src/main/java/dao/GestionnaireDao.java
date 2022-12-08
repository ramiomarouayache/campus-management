package dao;

import model.Gestionnare;
import utils.Callback;

public interface GestionnaireDao {

	public void login(String email,String pass,Callback<Gestionnare> callback);
}
