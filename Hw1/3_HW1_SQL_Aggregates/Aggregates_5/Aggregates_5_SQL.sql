select b.facid as facid, sum(b.slots) as "Total Slots"
from cd.bookings b
where b.starttime >= '2012-09-01'
  and b.starttime < '2012-10-01'
group by b.facid 
order by "Total Slots"