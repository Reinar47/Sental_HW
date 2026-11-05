select b.facid, sum(b.slots) as "Total Slots"
from cd.bookings b
group by b.facid
order by "Total Slots" desc
limit 1