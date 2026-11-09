select distinct m.firstname || ' ' || m.surname as member, 
		   (select r.firstname || ' ' || r.surname as recommender
		    from cd.members r
			where r.memid = m.recommendedby)
		 	as recommender
from cd.members m
order by member

	   