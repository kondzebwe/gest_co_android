package fr.doranco.flash.database;

import android.content.Context;
import android.util.Log;

import fr.doranco.flash.dao.SpecialiteDao;
import fr.doranco.flash.entity.Specialite;

public class SpecialiteDatabaseTest extends Thread {
    private final DaoFactory daoFactory;
    private final SpecialiteDao specialiteDao;

    public SpecialiteDatabaseTest(Context context){
        daoFactory = DaoFactory.getInstance(context);
        specialiteDao = daoFactory.getSpecialiteDao();
    }

    @Override
    public void run() {
        super.run();
        // creation des objets
        Specialite specialite1 = new Specialite("Securite informatique");
        Specialite specialite2 = new Specialite("Systeme informatique");
        Specialite specialite3 = new Specialite("Dev Web Java");
        Specialite specialite4 = new Specialite("DevOps");
        Specialite specialite5 = new Specialite("Machine Learning");
        // enreigistrement en BD
        specialiteDao.create(specialite1);
        specialiteDao.create(specialite2);
        specialiteDao.create(specialite3);
        specialiteDao.create(specialite4);
        specialiteDao.create(specialite5);
        Log.i("log-bd", "<---- Creation des Specialites avec success ---->");
        // lister specialites
        Log.i("log-bd", specialiteDao.findByAll().toString());
        //update specialite avec id = 3
        specialite3 = specialiteDao.findById(3);
        specialite3.setNom("Dev Fullstack Java");
        specialiteDao.update(specialite3);
        // delete specialite id = 5
        specialite5 = specialiteDao.findById(5);
        specialiteDao.delete(specialite5);
        // lister
        Log.i("log-bd", specialiteDao.findByAll().toString());
    }
}
