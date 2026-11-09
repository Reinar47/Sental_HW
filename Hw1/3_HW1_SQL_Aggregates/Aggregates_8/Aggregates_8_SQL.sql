select b.facid, sum(b.slots) as "Total Slots"
from cd.bookings b
group by b.facid
having sum(b.slots) > 1000
order by b.facid;