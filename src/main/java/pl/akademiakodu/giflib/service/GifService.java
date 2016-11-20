package pl.akademiakodu.giflib.service;

import org.springframework.web.multipart.MultipartFile;
import pl.akademiakodu.giflib.model.Gif;

import java.util.List;

/**
 * Created by Jaremina on 2016-11-20.
 */
public interface GifService {
    List<Gif> findAll();
    Gif findByID(Long id);
    void save(Gif gif, MultipartFile file);
    void delete(Gif gif);
}
