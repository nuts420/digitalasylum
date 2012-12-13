package us.digitalasylum.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import us.digitalasylum.repository.entities.Event;

public interface EventRepository  extends PagingAndSortingRepository<Event,Long> {
}
