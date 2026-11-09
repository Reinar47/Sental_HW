with recursive recommendation_chain(memid) as (
    select m.memid
    from cd.members m
    where recommendedby = 1

    union all

    select m.memid
    from recommendation_chain r
    inner join cd.members m on m.recommendedby = r.memid
)
select r.memid, m.firstname, m.surname
from recommendation_chain r
inner join cd.members m on r.memid = m.memid
order by memid;