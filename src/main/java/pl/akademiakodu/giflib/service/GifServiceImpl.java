package pl.akademiakodu.giflib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.akademiakodu.giflib.model.Gif;
import pl.akademiakodu.giflib.repository.GifRepository;

import java.util.List;

/**
 * Created by Jaremina on 2016-11-20.
 */
@Service
public class GifServiceImpl implements GifService {

    @Autowired
    private GifRepository gifRepository;

    @Override
    public List<Gif> findAll() {
        return gifRepository.findAll();
    }

    @Override
    public Gif findByID(Long id) {
        return null;
    }

    @Override
    public void save(Gif gif) {
        gifRepository.save(gif);
    }

    @Override
    public void delete(Gif gif) {

    }
}
