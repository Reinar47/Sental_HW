select f.facid, 
          f.name, 
          round(sum(b.slots) * 0.5, 2) as "Total Hours"
from cd.facilities f
left join cd.bookings b on f.facid = b.facid
group by f.facid, f.name
order by f.facid;