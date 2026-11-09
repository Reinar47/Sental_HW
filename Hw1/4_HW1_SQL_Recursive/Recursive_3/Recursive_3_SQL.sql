with recursive recommendation_chain(member, recommender) as (
    select memid, recommendedby
    from cd.members

    union all

    select r.member, m.recommendedby
    from recommendation_chain r
    inner join cd.members m on r.recommender = m.memid 
)
select r.member, r.recommender, m.firstname, m.surname
from recommendation_chain r
inner join cd.members m on r.recommender = m.memid
where r.member = 22 or r.member = 12
order by r.member asc, r.recommender desc;