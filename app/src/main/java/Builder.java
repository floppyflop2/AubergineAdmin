
import android.app.Application;
import android.content.Context;

import com.example.florian.aubergine.Model.UtilisateurModel;

/**
 * Created by Florian on 06/02/2017.
 */

public class Builder extends Application{
    UtilisateurModel mModel;
    @Override
    public void onCreate() {
        super.onCreate();
        // On passe le contexte de l'application et non d'une activité
        // sa durée de vie est donc garantie (normalement)
        mModel = new UtilisateurModel(this);
    }

    public UtilisateurModel getModel(){
        // TODO test si le truc ne devient pas null quand la mémoire est récupérée
        // voir http://www.developerphil.com/dont-store-data-in-the-application-object/
        return mModel;
    }

    public Context getContext(){
        return this;
    }
}