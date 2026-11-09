select name, 
       rank
from (
    select f.name,
           rank() over (order by sum(
               case 
                   when b.memid = 0 then b.slots * f.guestcost
                   else b.slots * f.membercost
               end
           ) desc) as rank
    from cd.bookings b
    join cd.facilities f on b.facid = f.facid
    group by f.facid, f.name
) as ranked_facilities
where rank <= 3
order by rank, name;