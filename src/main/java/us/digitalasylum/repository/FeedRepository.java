package us.digitalasylum.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import us.digitalasylum.repository.entities.Feed;

import java.util.List;

public interface FeedRepository extends PagingAndSortingRepository<Feed,Long> {
    public List<Feed> findByCategory_Id(@Param("categoryId") Long id);
}
