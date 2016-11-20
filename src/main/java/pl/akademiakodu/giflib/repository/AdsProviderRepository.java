package pl.akademiakodu.giflib.repository;

import pl.akademiakodu.giflib.model.AdvertismentProvider;

import java.util.List;

/**
 * Created by Jaremina on 2016-11-19.
 */
public interface AdsProviderRepository {

    List<AdvertismentProvider> findAll();
}
