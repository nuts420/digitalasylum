package us.digitalasylum.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import us.digitalasylum.repository.entities.Feed;

public interface FeedRepository extends PagingAndSortingRepository<Feed,Long> {
}
