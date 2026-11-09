select member, facility, cost
from (select 
        case 
            when b.memid = 0 then 'GUEST GUEST'
            else m.firstname || ' ' || m.surname
        end as member,
	  
        f.name as facility,
       
        case 
            when b.memid = 0 then b.slots * f.guestcost
            else b.slots * f.membercost
        end as cost
	  
from cd.members m                
    join cd.bookings b on m.memid = b.memid
    join cd.facilities f on b.facid = f.facid
    where b.starttime >= '2012-09-14' 
      and b.starttime < '2012-09-15'
   )

where cost > 30
order by cost desc;