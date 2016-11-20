package pl.akademiakodu.giflib.service;

import pl.akademiakodu.giflib.model.Gif;

import java.util.List;

/**
 * Created by Jaremina on 2016-11-20.
 */
public interface GifService {
    List<Gif> findAll();
    Gif findByID(Long id);
    void save(Gif gif);
    void delete(Gif gif);
}
