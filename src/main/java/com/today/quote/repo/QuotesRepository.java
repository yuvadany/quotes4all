package com.today.quote.repo;

import com.today.quote.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuotesRepository extends JpaRepository<Quote, Integer> {

    List<Quote> findAllByTag(String tag);

}
