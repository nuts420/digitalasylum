package us.digitalasylum.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import us.digitalasylum.repository.entities.Item;

public interface ItemRepository extends PagingAndSortingRepository<Item,Long> {
}
