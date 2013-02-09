package us.digitalasylum.repository;


import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import us.digitalasylum.repository.entities.Item;

import java.util.List;

public interface ItemRepository extends PagingAndSortingRepository<Item,Long> {
    public Item findByLink(@Param("link") String link);
    public Item findByGuid(@Param("guid") String guid);

    public List<Item> findByChannel_Feed_Category_IdOrderByPubDateDesc(@Param("categoryId") Long id);
    public List<Item> findByChannel_Feed_Category_Id(@Param("categoryId") Long id);
    public List<Item> findByChannel_Feed_Category_Id(@Param("categoryId") Long id, Sort sort);
}
