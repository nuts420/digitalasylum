package us.digitalasylum.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import us.digitalasylum.repository.entities.Post;

public interface PostRepository extends PagingAndSortingRepository<Post,Long> {
}
