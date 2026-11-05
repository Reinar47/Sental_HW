select f.name,
       f.initialoutlay / (
           (sum(case 
                    when b.memid = 0 then b.slots * f.guestcost
                    else b.slots * f.membercost
                end) / 3) - f.monthlymaintenance
       ) as months
from cd.facilities f
join cd.bookings b on f.facid = b.facid
where b.starttime >= '2012-07-01' 
  and b.starttime < '2012-10-01'
group by f.facid, f.name, f.initialoutlay, f.monthlymaintenance
order by f.name;