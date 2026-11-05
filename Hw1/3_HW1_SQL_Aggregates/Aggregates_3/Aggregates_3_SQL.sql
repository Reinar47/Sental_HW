select recommendedby, count(m.memid) as count
from cd.members m
where recommendedby is not null
group by m.recommendedby
order by m.recommendedby