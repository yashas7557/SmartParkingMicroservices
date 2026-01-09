package com.shanInfotech.Smartparking.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.shanInfotech.Smartparking.entity.Ticket;


public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
