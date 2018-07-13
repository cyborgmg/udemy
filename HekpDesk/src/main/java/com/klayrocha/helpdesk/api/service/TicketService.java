package com.klayrocha.helpdesk.api.service;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.klayrocha.helpdesk.api.entity.ChangeStatus;
import com.klayrocha.helpdesk.api.entity.Ticket;

@Component
public interface TicketService {

	Ticket createOrUpdate(Ticket ticket);
	
	Ticket findById(String id);
	
	void delete(String id);
	
	Page<Ticket> listTicket(int page, int cont);
	
	ChangeStatus createChangeStatus(ChangeStatus changeStatus);
	
	Iterable<ChangeStatus> listChangeStatus(String tikectId);
	
	Page<Ticket> findByCurrUser(int page, int cont, String userId);
	
	Page<Ticket> findByParameters(int page, int cont, String title, String status, String priority);
	
	Page<Ticket> findByParametersAndCurrUser(int page, int cont, String title, String status, String priority, String userId);
	
	Page<Ticket> findByNumber(int page, int cont, Integer number);
	
	Iterable<Ticket> findAll();
	
	Page<Ticket> findByParametersAndAssignedUser(int page, int cont, String title, String status, String priority, String assignedUserId);

	Page<Ticket> filterRoleCustumer(int page, int cont, String title, String status, String priority, String userId);
}
