select m.firstname as memfname,
       m.surname   as memsname,
       r.firstname as recfname,
       r.surname   as recsname
from cd.members m
left join cd.members r on m.recommendedby = r.memid
order by m.surname, m.firstname   


