package pl.akademiakodu.giflib.service;

import pl.akademiakodu.giflib.model.AdvertismentProvider;

import java.util.List;

/**
 * Created by Jaremina on 2016-11-19.
 */
public interface AdvertismentService {
     List<AdvertismentProvider> findAll();
}
