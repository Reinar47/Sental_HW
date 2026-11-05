select b.starttime 
from cd.bookings b
inner join cd.members m on 
b.memid = m.memid
where firstname = 'David' and surname = 'Farrell'