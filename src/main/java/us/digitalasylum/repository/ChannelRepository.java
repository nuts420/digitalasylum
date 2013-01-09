package us.digitalasylum.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import us.digitalasylum.repository.entities.Channel;

public interface ChannelRepository extends PagingAndSortingRepository<Channel,Long> {
}
