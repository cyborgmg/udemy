package com.klayrocha.helpdesk.api.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

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
}