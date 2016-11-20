package pl.akademiakodu.giflib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.akademiakodu.giflib.model.AdvertismentProvider;
import pl.akademiakodu.giflib.repository.AdsProviderRepository;

import java.util.List;

/**
 * Created by Jaremina on 2016-11-19.
 */
@Service
public class AdvertismentServiceImpl implements AdvertismentService {

    @Autowired
    private AdsProviderRepository adsProviderRepository;

    @Override
    public List<AdvertismentProvider> findAll() {
        return adsProviderRepository.findAll();
    }
}
