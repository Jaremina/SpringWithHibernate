package pl.akademiakodu.giflib.repository;

import pl.akademiakodu.giflib.model.Gif;

import java.util.List;

/**
 * Created by Jaremina on 2016-11-20.
 */
public interface GifRepository {
    List<Gif> findAll();
    Gif findByID(Long id);
    void save(Gif gif);
    void delete(Gif gif);
}
