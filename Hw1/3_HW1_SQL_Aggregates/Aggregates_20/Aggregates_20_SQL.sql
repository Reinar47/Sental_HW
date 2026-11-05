select name, 
       case 
           when revenue_group = 1 then 'high'
           when revenue_group = 2 then 'average'
           else 'low'
       end as revenue
from (
    select f.name, ntile(3) over (
               order by sum(
                   case 
                       when b.memid = 0 then b.slots * f.guestcost
                       else b.slots * f.membercost
                   end
               ) desc
           ) as revenue_group
    from cd.bookings b
    join cd.facilities f on b.facid = f.facid
    group by f.name
) as ranked_facilities
order by revenue_group, name;