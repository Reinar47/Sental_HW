select dategen.date,
	(select sum(case
		when memid = 0 then slots * f.guestcost
		else slots * f.membercost
		end) as rev

		from cd.bookings b
		inner join cd.facilities f on b.facid = f.facid
		where b.starttime > dategen.date - interval '14 days'
		          and b.starttime < dategen.date + interval '1 day'
	 )/15 as revenue
	from
	(select cast(generate_series(timestamp '2012-08-01',
			'2012-08-31','1 day') as date) as date
	) as dategen
order by dategen.date  