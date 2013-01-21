package us.digitalasylum.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import us.digitalasylum.repository.entities.Item;

public interface ItemRepository extends PagingAndSortingRepository<Item,Long> {
    public Item findByLink(@Param("link") String link);
    public Item findByGuid(@Param("guid") String guid);
}
