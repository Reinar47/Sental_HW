select facid, total_slots
from (
    select facid, 
           sum(slots) as total_slots,
           rank() over (order by sum(slots) desc) as rnk
    from cd.bookings
    group by facid
) as ranked_facilities
where rnk = 1;