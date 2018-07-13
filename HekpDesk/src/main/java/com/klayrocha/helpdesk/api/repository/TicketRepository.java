package com.klayrocha.helpdesk.api.repository;


import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.klayrocha.helpdesk.api.entity.Ticket;

public interface TicketRepository extends MongoRepository<Ticket, String> {
	
	public Page<Ticket> findByUserIdOrderByDate(Pageable pages, String userId);

	public Page<Ticket> findTitleIgnoreCaseContainingAndStatusAndPriorityOrderByDate(
			String title, String status, String priority, Pageable pages);
	
	public Page<Ticket> findTitleIgnoreCaseContainingAndStatusAndPriorityAndUserIdOrderByDate(
			String title, String status, String priority, String userId, Pageable pages);
	
	public Page<Ticket> findTitleIgnoreCaseContainingAndStatusAndPriorityAndAssignedUserIdOrderByDate(
			String title, String status, String priority, String userId, Pageable pages);
	
	public Page<Ticket> findByNumber(Integer number, Pageable pages);
	
	@Query(value="{title:{'$regex': ?0}, status:{'$regex': ?1}, priority:{'$regex': ?2}, user: {'$ref': 'user','$id': ?3 }}")
	public Page<Ticket> filterRoleCustumer(String title, String status, String priority, ObjectId userId, Pageable pageable);
}
//, user:{'$ref': 'user','$id': ObjectId(?3)} 