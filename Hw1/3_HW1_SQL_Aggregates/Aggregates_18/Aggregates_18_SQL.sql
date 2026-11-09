select m.firstname,
       m.surname,
       round(sum(b.slots) * 0.5 / 10) * 10 as hours,
       rank() over (order by round(sum(b.slots) * 0.5 / 10) * 10 desc) as rank
	   
from cd.bookings b
inner join cd.members m on b.memid = m.memid

group by m.memid, m.firstname, m.surname
order by rank, m.surname, m.firstname;