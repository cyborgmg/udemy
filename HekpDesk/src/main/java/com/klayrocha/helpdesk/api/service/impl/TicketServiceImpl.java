package com.klayrocha.helpdesk.api.service.impl;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.klayrocha.helpdesk.api.entity.ChangeStatus;
import com.klayrocha.helpdesk.api.entity.Ticket;
import com.klayrocha.helpdesk.api.repository.ChangeStatusRepository;
import com.klayrocha.helpdesk.api.repository.TicketRepository;
import com.klayrocha.helpdesk.api.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private ChangeStatusRepository changeStatusRepository;

	@Override
	public Ticket createOrUpdate(Ticket ticket) {
		// TODO Auto-generated method stub
		return ticketRepository.save(ticket);
	}

	@Override
	public Ticket findById(String id) {
		// TODO Auto-generated method stub
		return ticketRepository.findById(id).get();
	}

	@Override
	public void delete(String id) {
		ticketRepository.deleteById(id);
	}

	@Override
	public Page<Ticket> listTicket(int page, int cont) {

		return ticketRepository.findAll(new PageRequest(page, cont));
	}

	@Override
	public ChangeStatus createChangeStatus(ChangeStatus changeStatus) {

		return changeStatusRepository.save(changeStatus);
	}

	@Override
	public Iterable<ChangeStatus> listChangeStatus(String tikectId) {
		// TODO Auto-generated method stub
		return changeStatusRepository.findByTicketIdOrderByDateChangeStatusDesc(tikectId);
	}

	@Override
	public Page<Ticket> findByCurrUser(int page, int cont, String userId) {
		Pageable pages = new PageRequest(page, cont);
		return ticketRepository.findByUserIdOrderByDate(pages, userId);
	}

	@Override
	public Page<Ticket> findByParameters(int page, int cont, String title, String status, String priority) {
		Pageable pages = new PageRequest(page, cont);
		return ticketRepository.findTitleIgnoreCaseContainingAndStatusAndPriorityOrderByDate(title, status, priority, pages);
	}

	@Override
	public Page<Ticket> findByParametersAndCurrUser(int page, int cont, String title, String status, String priority,
			String userId) {
		Pageable pages = new PageRequest(page, cont);
		return ticketRepository.findTitleIgnoreCaseContainingAndStatusAndPriorityAndUserIdOrderByDate(title, status, priority, userId, pages);
	}

	@Override
	public Page<Ticket> findByNumber(int page, int cont, Integer number) {
		Pageable pages = new PageRequest(page, cont);
		return ticketRepository.findByNumber(number, pages);
	}

	@Override
	public Iterable<Ticket> findAll() {
		// TODO Auto-generated method stub
		return ticketRepository.findAll();
	}

	@Override
	public Page<Ticket> findByParametersAndAssignedUser(int page, int cont, String title, String status,
			String priority, String assignedUserId) {
		Pageable pages = new PageRequest(page, cont);
		return ticketRepository.findTitleIgnoreCaseContainingAndStatusAndPriorityAndAssignedUserIdOrderByDate(title, status, priority, assignedUserId, pages);
	}

	@Override
	public Page<Ticket> filterRoleCustumer(int page, int cont, String title, String status, String priority, String userId) {
		Pageable pages = new PageRequest(page, cont);
		return ticketRepository.filterRoleCustumer(title, status, priority, new ObjectId(userId), pages);
	}
	
}
