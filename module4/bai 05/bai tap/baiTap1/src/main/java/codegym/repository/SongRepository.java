package codegym.repository;

import codegym.entity.Song;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SongRepository {
    @PersistenceContext
    EntityManager entityManager;

    public void createSong(Song song) {
        entityManager.persist(song);
    }

    public void updateSong(Song song) {
        entityManager.merge(song);
    }

    public List<Song> getList() {
        return entityManager.createQuery("select s from Song s").getResultList();
    }


    public void deleteSong(int id) {
        Song song = entityManager.find(Song.class, id);
        entityManager.remove(song);
    }

    public Song findById(int id) {
        return entityManager.find(Song.class, id);
    }

}
