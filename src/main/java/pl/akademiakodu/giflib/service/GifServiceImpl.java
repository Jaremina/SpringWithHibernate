package pl.akademiakodu.giflib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.akademiakodu.giflib.model.Gif;
import pl.akademiakodu.giflib.repository.GifRepository;

import java.io.IOException;
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
        return gifRepository.findByID(id);
    }

    @Override
    public void save(Gif gif, MultipartFile file) {
        try {
            gif.setBytes(file.getBytes());
            gifRepository.save(gif);
        }catch (IOException io){

        }
    }

    @Override
    public void delete(Gif gif) {
        gifRepository.delete(gif);
    }
}
