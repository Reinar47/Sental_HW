with recursive recommendation_chain(recommender) as (
    select recommendedby
    from cd.members m
    where m.memid = 27

    union all

    select m.recommendedby
    from recommendation_chain r
    inner join cd.members m on r.recommender = m.memid
)
select r.recommender, m.firstname, m.surname
from recommendation_chain r
inner join cd.members m on r.recommender = m.memid
order by m.memid desc