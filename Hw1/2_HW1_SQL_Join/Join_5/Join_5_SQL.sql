select distinct m.firstname || ' ' || m.surname as member, f.name as facility
from cd.members m
join cd.bookings b on m.memid = b.memid
join cd.facilities f on b.facid = f.facid
where f.name like '%Tennis Court%'
order by member, facility