select distinct m.firstname, m.surname
from cd.members m
join cd.members r on m.memid = r.recommendedby
order by m.surname, m.firstname