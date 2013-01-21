package us.digitalasylum.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import us.digitalasylum.repository.entities.Category;

public interface CategoryRepository extends PagingAndSortingRepository<Category,Long> {
}
