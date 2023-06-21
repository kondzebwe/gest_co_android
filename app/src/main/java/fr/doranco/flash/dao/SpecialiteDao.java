package fr.doranco.flash.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import fr.doranco.flash.entity.Specialite;

@Dao
public interface SpecialiteDao {

    /**
     *
     * @param specialite
     */
    @Insert
    void create(Specialite specialite);

    /**
     *
     * @param id
     * @return
     */
    @Query("SELECT * FROM specialites WHERE id = :id")
    Specialite findById(int id);

    /**
     *
     * @return
     */
    @Query("SELECT * FROM specialites")
    List<Specialite> findByAll();

    /**
     *
     * @param specialite
     */
    @Update
    void update(Specialite specialite);

    /**
     *
     * @param specialite
     */
    @Delete
    void delete(Specialite specialite);
}
