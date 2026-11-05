select b.starttime as start, f.name as name
from cd.bookings b
join cd.facilities f on b.facid = f.facid
where f.name like '%Tennis Court%' 
and b.starttime >= '2012-09-21'
and b.starttime < '2012-09-22'
order by b.starttime 