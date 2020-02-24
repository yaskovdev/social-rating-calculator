package com.yaskovdev.calculator;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SocialRatingRepository extends CrudRepository<SocialRating, String> {

}
