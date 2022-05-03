package com.rusetskiy.boxOffice;

import com.rusetskiy.boxOffice.DAO.EventDAO;
import com.rusetskiy.boxOffice.DAO.PerformanceDAO;
import com.rusetskiy.boxOffice.DAO.TheatreDAO;
import com.rusetskiy.boxOffice.DAO.TicketDAO;
import com.rusetskiy.boxOffice.MyTypes.MyJson;
import com.rusetskiy.boxOffice.models.Event;
import com.rusetskiy.boxOffice.models.Performance;
import com.rusetskiy.boxOffice.models.Theatre;
import com.rusetskiy.boxOffice.models.Ticket;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;


@SpringBootTest
class BoxOfficeApplicationTests {

	@Test
	public void TheatreDAOTest(){
		TheatreDAO theatreDAO = new TheatreDAO("BoxOffice");

		MyJson seats_inf = new MyJson();
		seats_inf.add("За дверью", "Мест неогрничены");
		Theatre put_theatre = new Theatre("Театр", "Адрес", "Режиссеры", "Актеры", seats_inf, null, null, "Описания нет!");
		int testing_record_id = theatreDAO.putRecord(put_theatre);
		put_theatre.setTheatre_id(testing_record_id);

		Theatre get_theatre = theatreDAO.getRecordByID(testing_record_id);
		System.out.println(get_theatre);
		System.out.println(put_theatre);
		assert(put_theatre == get_theatre);

		List<Theatre> theatresList= theatreDAO.getTheatresList();
		assert(theatresList.get(theatresList.size() - 1) == get_theatre);

		Theatre deleted_theatre = theatreDAO.deleteRecordByID(testing_record_id);
		assert(deleted_theatre != null);

		Theatre get_after_delete_theatre = theatreDAO.getRecordByID(testing_record_id);
		assert(get_after_delete_theatre == null);
	}

	@Test
	public void EventDAOTest(){
		EventDAO eventDAO = new EventDAO("BoxOffice");

		Date date = Date.valueOf("2022-09-18");
		MyJson roles = new MyJson();
		roles.add("Парацельс", "Сергей Маковецкий");
		Event put_event = new Event(date, 1, roles);
		int testing_record_id = eventDAO.putRecord(put_event);
		put_event.setEv_id(testing_record_id);

		Event get_event = eventDAO.getRecordByID(testing_record_id);
		System.out.println(get_event);
		System.out.println(put_event);
		assert(put_event == get_event);

		List<Event> eventsList= eventDAO.getEventsList();
		assert(eventsList.get(eventsList.size() - 1) == get_event);

		Event deleted_event = eventDAO.deleteRecordByID(testing_record_id);
		assert(deleted_event != null);

		Event get_after_delete_event = eventDAO.getRecordByID(testing_record_id);
		assert(get_after_delete_event == null);
	}

	@Test
	public void TicketDAOTest(){
		TicketDAO ticketDAO = new TicketDAO("BoxOffice");


		Ticket put_ticket = new Ticket(1, 4, "На потолке", "8", false);
		int testing_record_id = ticketDAO.putRecord(put_ticket);
		put_ticket.setTick_id(testing_record_id);

		Ticket get_ticket = ticketDAO.getRecordByID(testing_record_id);
		System.out.println(get_ticket);
		System.out.println(put_ticket);
		assert(put_ticket == get_ticket);

		List<Ticket> ticketsList= ticketDAO.getTicketsList();
		assert(ticketsList.get(ticketsList.size() - 1) == get_ticket);

		Ticket deleted_ticket = ticketDAO.deleteRecordByID(testing_record_id);
		assert(deleted_ticket != null);

		Ticket get_after_delete_ticket = ticketDAO.getRecordByID(testing_record_id);
		assert(get_after_delete_ticket == null);
	}

	@Test
	public void PerformanceDAOTest(){
		PerformanceDAO performanceDAO = new PerformanceDAO("BoxOffice");

		Performance put_performance = new Performance(1, null, null, null, null, null, null);
		int testing_record_id = performanceDAO.putRecord(put_performance);
		put_performance.setPerf_id(testing_record_id);

		Performance get_performance = performanceDAO.getRecordByID(testing_record_id);
		System.out.println(get_performance);
		System.out.println(put_performance);
		assert(put_performance == get_performance);

		List<Performance> performancesList= performanceDAO.getPerformancesList();
		assert(performancesList.get(performancesList.size() - 1) == get_performance);

		Performance deleted_performance = performanceDAO.deleteRecordByID(testing_record_id);
		assert(deleted_performance != null);

		Performance get_after_delete_performance = performanceDAO.getRecordByID(testing_record_id);
		assert(get_after_delete_performance == null);
	}



}