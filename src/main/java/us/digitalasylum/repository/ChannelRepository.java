package us.digitalasylum.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import us.digitalasylum.repository.entities.Channel;

public interface ChannelRepository extends PagingAndSortingRepository<Channel,Long> {
    public Channel findByLink(@Param("link") String link);
}
