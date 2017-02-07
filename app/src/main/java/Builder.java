
import android.app.Application;
import android.content.Context;

import com.example.florian.aubergine.Model.UtilisateurModel;

/**
 * Created by Florian on 06/02/2017.
 */

public class Builder extends Application{
    UtilisateurModel uModel;
    @Override
    public void onCreate() {
        super.onCreate();
        // On passe le contexte de l'application et non d'une activité
        // sa durée de vie est donc garantie (normalement)
        uModel = new UtilisateurModel();
    }

    public UtilisateurModel getModel(){
        // TODO test si le truc ne devient pas null quand la mémoire est récupérée
        // voir http://www.developerphil.com/dont-store-data-in-the-application-object/
        return uModel;
    }

    public Context getContext(){
        return this;
    }
}