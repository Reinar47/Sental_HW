select facid, 
       month, 
       sum(slots) as slots
from (select facid, extract(month from starttime) as month, 
           slots
       from cd.bookings
       where starttime >= '2012-01-01' 
       and starttime < '2013-01-01'
      ) as sub
group by rollup(facid, month)
order by facid, month;